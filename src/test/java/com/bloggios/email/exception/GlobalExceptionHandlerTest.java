package com.bloggios.email.exception;

import com.bloggios.email.exception.payload.BadRequestException;
import com.bloggios.email.payload.response.ExceptionResponse;
import com.bloggios.email.properties.FetchErrorProperties;
import com.bloggios.email.util.ExceptionResponseUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Owner - Rohit Parihar and Bloggios
 * Author - rohit
 * Project - bloggios-email-service
 * Package - com.bloggios.email.exception
 * Created_on - May 06 - 2024
 * Created_at - 23:04
 */

@ExtendWith(MockitoExtension.class)
class GlobalExceptionHandlerTest {

    @InjectMocks
    private GlobalExceptionHandler globalExceptionHandler;

    @Mock
    private FetchErrorProperties fetchErrorProperties;

    @Test
    void handleBadRequestException() {
        BadRequestException badRequestException = new BadRequestException(
                "DE__AUTH-1001",
                "Error Occurred"
        );
        Mockito.when(fetchErrorProperties.generateExceptionResponse(HttpStatus.BAD_REQUEST, badRequestException.getMessage(), badRequestException.getCode()))
                .thenReturn(ExceptionResponseUtil.getExceptionResponse());
        ResponseEntity<ExceptionResponse> response = globalExceptionHandler.handleBadRequestException(badRequestException);
        assertEquals(Objects.requireNonNull(response.getBody()).getCode(), ExceptionResponseUtil.getExceptionResponse().getCode());
    }

    @Test
    void handleBadRequestExceptionNoMessage() {
        BadRequestException badRequestException = new BadRequestException(
                "DE__AUTH-1001"
        );
        Mockito.when(fetchErrorProperties.exceptionResponse(HttpStatus.BAD_REQUEST, badRequestException.getCode()))
                .thenReturn(ExceptionResponseUtil.getExceptionResponse());
        ResponseEntity<ExceptionResponse> response = globalExceptionHandler.handleBadRequestException(badRequestException);
        assertEquals(Objects.requireNonNull(response.getBody()).getCode(), ExceptionResponseUtil.getExceptionResponse().getCode());
    }
}