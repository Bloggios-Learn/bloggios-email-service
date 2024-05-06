package com.bloggios.email.exception;

import com.bloggios.email.constants.ServiceConstants;
import com.bloggios.email.exception.payload.BadRequestException;
import com.bloggios.email.payload.response.ExceptionResponse;
import com.bloggios.email.properties.FetchErrorProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Objects;

/**
 * Owner - Rohit Parihar and Bloggios
 * Author - rohit
 * Project - bloggios-email-service
 * Package - com.bloggios.email.exception
 * Created_on - May 01 - 2024
 * Created_at - 16:09
 */

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    private final FetchErrorProperties fetchErrorProperties;

    public GlobalExceptionHandler(
            FetchErrorProperties fetchErrorProperties
    ) {
        this.fetchErrorProperties = fetchErrorProperties;
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ExceptionResponse> handleBadRequestException(BadRequestException badRequestException) {
        ExceptionResponse exceptionResponse = fetchErrorProperties.exceptionResponse(HttpStatus.BAD_REQUEST, badRequestException.getCode());
        if (Objects.nonNull(badRequestException.getMessage())) {
            exceptionResponse = fetchErrorProperties.generateExceptionResponse(HttpStatus.BAD_REQUEST, badRequestException.getMessage(), badRequestException.getCode());
        }
        logger.error("""
                BadRequestException Occurred : {}
                Message : {}
                Field : {}
                Code : {}
                Type : {}
                """,
                MDC.get(ServiceConstants.BREADCRUMB_ID),
                exceptionResponse.getMessage(),
                exceptionResponse.getField(),
                exceptionResponse.getCode(),
                exceptionResponse.getType());
        return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
    }
}
