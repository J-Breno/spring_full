package com.github.jbreno.gestao_vagas.exceptions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ExceptionHandlerController {

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ErrorMessageDTO>> handleMethodArgumentNotValidException(final MethodArgumentNotValidException ex) {
        List<ErrorMessageDTO> dto = new ArrayList<>();

        ex.getBindingResult().getFieldErrors().forEach((error) -> {
            String message = messageSource
                    .getMessage(error, LocaleContextHolder.getLocale());
            ErrorMessageDTO erro = new ErrorMessageDTO(message, error.getField());
            dto.add(erro);
        });
        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
    }
}
