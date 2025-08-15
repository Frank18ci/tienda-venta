package org.tienda.tiendavirtualapi.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorReponse {
    private int status;
    private String message;
    private LocalDateTime timeStamp;
}
