package com.doacao.sague.exception.handler;

import com.doacao.sague.exception.BadRequestException;
import com.doacao.sague.exception.InternalServerException;
import com.doacao.sague.exception.NotFoundException;
import com.doacao.sague.exception.UnauthorizedException;
import com.doacao.sague.exception.dto.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
class CustomControllerAdvice {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ExceptionDTO> handleBadRequestExceptions(Exception e) {
        var badRequestException = (BadRequestException) e;
        return handle(e, HttpStatus.BAD_REQUEST, badRequestException.getMessage());
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ExceptionDTO> handleUnauthorizedException(Exception e) {
        var unauthorizedException = (UnauthorizedException) e;
        return handle(e, HttpStatus.UNAUTHORIZED, unauthorizedException.getMessage());
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDTO> handleNotFoundExceptions(Exception e) {
        var notFoundException = (NotFoundException) e;
        return handle(e, HttpStatus.NOT_FOUND, notFoundException.getMessage());
    }

    @ExceptionHandler(InternalServerException.class)
    public ResponseEntity<ExceptionDTO> handleExceptions(Exception e) {
        return handle(e, HttpStatus.INTERNAL_SERVER_ERROR, e.getMessage());
    }

    private ResponseEntity<ExceptionDTO> handle(Exception e, HttpStatus status, String message) {

        for (int i = 0; i < e.getStackTrace().length; i++) {
            System.out.println(e.getStackTrace()[i].toString());
        }

        return new ResponseEntity<>(ExceptionDTO.builder()
                .status(status.value())
                .message(message)
                .build(),
                status);
    }

}