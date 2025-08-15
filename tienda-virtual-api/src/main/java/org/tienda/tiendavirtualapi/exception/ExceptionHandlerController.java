package org.tienda.tiendavirtualapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.tienda.tiendavirtualapi.exception.types.ResourceFound;
import org.tienda.tiendavirtualapi.exception.types.ResourceNotFound;

import java.time.LocalDateTime;

@ControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<?> handleResourceNotFound(ResourceNotFound ex) {
        ErrorReponse errorReponse = new ErrorReponse(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(errorReponse.getStatus()).body(errorReponse);
    }
    @ExceptionHandler(ResourceFound.class)
    public ResponseEntity<?> handleResourceFound(ResourceFound ex) {
        ErrorReponse errorReponse = new ErrorReponse(
                HttpStatus.BAD_REQUEST.value(),
                ex.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(errorReponse.getStatus()).body(errorReponse);
    }
}
