package ru.runanddone.admin.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.runanddone.admin.common.ErrorResponse;
import ru.runanddone.admin.common.ObjectNotFoundException;

@ControllerAdvice
public class ExceptionControllerAdvice {
    @ExceptionHandler
    public ResponseEntity<?> handleObjectNotFoundException(ObjectNotFoundException e) {
        return new ResponseEntity<>(new ErrorResponse(e.getLocalizedMessage(), e.getStackTrace()), HttpStatus.BAD_REQUEST);
    }
}
