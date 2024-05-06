package com.bloggios.email.util;

import com.bloggios.email.payload.response.ExceptionResponse;
import lombok.experimental.UtilityClass;
import org.springframework.http.HttpStatus;

/**
 * Owner - Rohit Parihar and Bloggios
 * Author - rohit
 * Project - bloggios-email-service
 * Package - com.bloggios.email.util
 * Created_on - May 06 - 2024
 * Created_at - 23:09
 */

@UtilityClass
public class ExceptionResponseUtil {

    public static ExceptionResponse getExceptionResponse() {
        return ExceptionResponse
                .builder()
                .message("Error Occurred")
                .code("DE__AUTH-1001")
                .code(HttpStatus.BAD_REQUEST.name())
                .field("")
                .build();
    }
}
