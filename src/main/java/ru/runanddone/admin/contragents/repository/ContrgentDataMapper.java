package ru.runanddone.admin.contragents.repository;

import ru.runanddone.admin.contragents.model.ContragentDto;
import ru.runanddone.admin.utils.DatabaseDataMapper;
import ru.runanddone.admin.utils.MySqlDatabaseConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContrgentDataMapper implements DatabaseDataMapper<ContragentDto, String> {

    private final Map<String, ContragentDto> contragentDtoMap = new HashMap<>();

    @Override
    public List<ContragentDto> getAll() {
        Connection connection = new MySqlDatabaseConnector().connect();
        if (connection == null) {
            return null;
        }
        List<ContragentDto> contragentDtos = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT id, code, name, description, address, phone, phone_serv, uptime, isGroup, parent_id FROM rd_contragents");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                ContragentDto contragentDto = new ContragentDto();
                fillDtoFromResultSet(contragentDto, resultSet);
                contragentDtos.add(contragentDto);
            }
        } catch (SQLException throwables) {
            return null;
        }

        return contragentDtos;
    }

    @Override
    public ContragentDto getById(String id) {
        ContragentDto contragentDto = contragentDtoMap.get(id);
        if (contragentDto == null) {
            Connection connection = new MySqlDatabaseConnector().connect();
            if (connection == null) {
                throw new RuntimeException("Couldn't connect to DB");
            }
            try {
                PreparedStatement statement = connection.prepareStatement("""
                        SELECT id, code, name, description, address, phone, phone_serv, uptime, isGroup, parent_id \
                        FROM rd_contragents WHERE id = ?""");
                statement.setString(1, id);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    contragentDto = new ContragentDto();
                    fillDtoFromResultSet(contragentDto, resultSet);
                    contragentDtoMap.put(id, contragentDto);
                }
            } catch (SQLException throwables) {
                return null;
            }
        }
        return contragentDto;
    }

    private void fillDtoFromResultSet(ContragentDto contragentDto, ResultSet resultSet) throws SQLException {
        contragentDto.setId(resultSet.getString("id"));
        contragentDto.setCode(resultSet.getString("code"));
        contragentDto.setName(resultSet.getString("name"));
        contragentDto.setDescription(resultSet.getString("description"));
        contragentDto.setAddress(resultSet.getString("address"));
        contragentDto.setPhone(resultSet.getString("phone"));
        contragentDto.setPhone_serv(resultSet.getString("phone_serv"));
        contragentDto.setUptime(resultSet.getTimestamp("uptime").toLocalDateTime());
        contragentDto.setGroup(resultSet.getBoolean("isGroup"));
        contragentDto.setParent(getById(resultSet.getString("parent_id")));
    }

    @Override
    public ContragentDto save(ContragentDto object) {
        Connection connection = new MySqlDatabaseConnector().connect();
        if (connection == null) {
            throw new RuntimeException("Couldn't connect to DB");
        }

        try {
            PreparedStatement statement = connection.prepareStatement("""
                    INSERT INTO rd_contragents (id, code, name, description, address, phone, \
                    phone_serv, uptime, isGroup, parent_id, office_id) VALUES (?,?,?,?,?,?,?,?,?,?,?)
                    """);
            statement.setString(1, object.getId());
            statement.setString(2, object.getCode());
            statement.setString(3, object.getName());
            statement.setString(4, object.getDescription());
            statement.setString(5, object.getAddress());
            statement.setString(6, object.getPhone());
            statement.setString(7, object.getPhone_serv());
            statement.setTimestamp(8, Timestamp.valueOf(object.getUptime()));
            statement.setBoolean(9, object.isGroup());
            statement.setString(10, object.getParent().getId());
            statement.setByte(11, object.getOffice().getId());
            statement.execute();
        } catch (SQLException ignored) {
            return null;
        }
        return object;
    }

    @Override
    public boolean delete(String id) {
        Connection connection = new MySqlDatabaseConnector().connect();
        if (connection == null) {
            throw new RuntimeException("Couldn't connect to DB");
        }
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "DELETE FROM rd_contragents WHERE id = ?");
            statement.setString(1, id);
            statement.execute();
        } catch (SQLException ignored) {
            return false;
        }
        return true;
    }
}
