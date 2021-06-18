package ru.runanddone.admin.devices.repository;

import ru.runanddone.admin.devices.model.DeviceDto;
import ru.runanddone.admin.utils.DatabaseDataMapper;
import ru.runanddone.admin.utils.MySqlDatabaseConnector;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DevicesDataMapper implements DatabaseDataMapper<DeviceDto, String> {

    private final Map<String, DeviceDto> deviceDtoMap = new HashMap<>();

    @Override
    public List<DeviceDto> getAll() {
        Connection connection = new MySqlDatabaseConnector().connect();
        if (connection == null) {
            return null;
        }
        List<DeviceDto> deviceDtos = new ArrayList<>();
        try {
            PreparedStatement statement = connection.prepareStatement(
                    "SELECT id, gcmToken, os, device, request, code, active, time FROM rd_devices");
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                DeviceDto deviceDto = new DeviceDto();
                fillDtoFromResultSet(deviceDto, resultSet);
                deviceDtos.add(deviceDto);
            }
        } catch (SQLException throwables) {
            return null;
        }

        return deviceDtos;
    }

    @Override
    public DeviceDto getById(String id) {
        DeviceDto deviceDto = deviceDtoMap.get(id);
        if (deviceDto == null) {
            Connection connection = new MySqlDatabaseConnector().connect();
            if (connection == null) {
                throw new RuntimeException("Couldn't connect to DB");
            }
            try {
                PreparedStatement statement = connection.prepareStatement("""
                        SELECT id, gcmToken, os, device, request, code, active, time \
                        FROM rd_devices WHERE id = ?""");
                statement.setString(1, id);
                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    deviceDto = new DeviceDto();
                    fillDtoFromResultSet(deviceDto, resultSet);
                    deviceDtoMap.put(id, deviceDto);
                }
            } catch (SQLException throwables) {
                return null;
            }
        }
        return deviceDto;
    }

    private void fillDtoFromResultSet(DeviceDto dto, ResultSet resultSet) throws SQLException {
        dto.setId(resultSet.getString("id"));
        dto.setCode(resultSet.getString("code"));
        dto.setGcmToken(resultSet.getString("gcmToken"));
        dto.setOs(resultSet.getString("os"));
        dto.setDevice(resultSet.getString("device"));
        dto.setRequest(resultSet.getString("request"));
        dto.setActive(resultSet.getBoolean("active"));
        dto.setTime(resultSet.getTimestamp("time").toLocalDateTime());
    }

    @Override
    public DeviceDto save(DeviceDto object) {
        Connection connection = new MySqlDatabaseConnector().connect();
        if (connection == null) {
            throw new RuntimeException("Couldn't connect to DB");
        }

        try {
            PreparedStatement statement = connection.prepareStatement("""
                    INSERT INTO rd_devices (id, gcmToken, os, device, request, code, active, time)
                    VALUES (?,?,?,?,?,?,?,?)
                    """);
            statement.setString(1, object.getId());
            statement.setString(2, object.getGcmToken());
            statement.setString(3, object.getOs());
            statement.setString(4, object.getDevice());
            statement.setString(5, object.getRequest());
            statement.setString(6, object.getCode());
            statement.setBoolean(7, object.isActive());
            statement.setTimestamp(8, Timestamp.valueOf(object.getTime()));
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
                    "DELETE FROM rd_devices WHERE id = ?");
            statement.setString(1, id);
            statement.execute();
        } catch (SQLException ignored) {
            return false;
        }
        return true;
    }
}
