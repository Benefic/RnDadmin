package ru.runanddone.admin.cityes.repository;

import ru.runanddone.admin.cityes.model.CityDto;
import ru.runanddone.admin.utils.DatabaseDataMapper;
import ru.runanddone.admin.utils.GuidIdGenerator;
import ru.runanddone.admin.utils.MySqlDatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CityDataMapper implements DatabaseDataMapper<CityDto, String> {

    private final Map<String, CityDto> cityDtoMap = new HashMap<>();

    @Override
    public List<CityDto> getAll() {
        Connection connection = new MySqlDatabaseConnector().connect();
        if (connection == null) {
            return null;
        }
        List<CityDto> cityDtoList = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT id, code, office_id, name FROM rd_cities");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                CityDto cityDto = new CityDto();
                cityDto.setId(resultSet.getString("id"));
                cityDto.setCode(resultSet.getString("code"));
                cityDto.setName(resultSet.getString("name"));
                cityDto.setOfficeId(resultSet.getByte("office_id"));
                cityDtoList.add(cityDto);
            }
        } catch (SQLException throwables) {
            return null;
        }

        return cityDtoList;
    }

    @Override
    public CityDto getById(String id) {
        CityDto cityDto = cityDtoMap.get(id);
        if (cityDto == null) {
            Connection connection = new MySqlDatabaseConnector().connect();
            if (connection == null) {
                throw new RuntimeException("Couldn't connect to DB");
            }
            try {
                PreparedStatement statement = connection.prepareStatement(
                        "SELECT id, code, office_id, name FROM rd_cities WHERE id = ?");
                statement.setString(1, id);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    cityDto = new CityDto();
                    cityDto.setId(resultSet.getString("id"));
                    cityDto.setCode(resultSet.getString("code"));
                    cityDto.setName(resultSet.getString("name"));
                    cityDto.setOfficeId(resultSet.getByte("office_id"));
                    cityDtoMap.put(id, cityDto);
                }
            } catch (SQLException throwables) {
                return null;
            }
        }
        return cityDto;
    }

    @Override
    public boolean save(CityDto object) {
        Connection connection = new MySqlDatabaseConnector().connect();
        if (connection == null) {
            throw new RuntimeException("Couldn't connect to DB");
        }
        if (object.getId() == null) {
            object.setId(GuidIdGenerator.generate(object.getOfficeId()));
        }
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO rd_cities (id, code, office_id, name) VALUES (?,?,?,?)");
            statement.setString(1, object.getId());
            statement.setString(2, object.getCode());
            statement.setByte(3, object.getOfficeId());
            statement.setString(4, object.getName());
            statement.execute();
        } catch (SQLException ignored) {
            return false;
        }
        return true;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }
}
