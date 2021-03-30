package ru.runanddone.admin.common;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ErrorResponse {
    private String message;
    private StackTraceElement[] debugInfo;
}
