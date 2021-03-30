package ru.runanddone.admin.utils;

import ru.runanddone.admin.offices.model.Office;

import java.util.UUID;

public class GuidIdGenerator {

    public static String generate(Office office) {

        if (office != null) {
            UUID uuid = UUID.randomUUID();
            int officeId = office.getId();
            String prefix = "000" + officeId;
            return prefix.substring(prefix.length() - 3) + "-" + uuid.toString();
        } else {
            return null;
        }
    }

}
