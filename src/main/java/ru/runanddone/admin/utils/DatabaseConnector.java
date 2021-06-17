package ru.runanddone.admin.utils;

import java.sql.Connection;

public interface DatabaseConnector {
    Connection connect();
}
