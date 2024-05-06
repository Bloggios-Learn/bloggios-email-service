package com.bloggios.email.exception.payload;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Owner - Rohit Parihar and Bloggios
 * Author - rohit
 * Project - bloggios-email-service
 * Package - com.bloggios.email.exception
 * Created_on - May 01 - 2024
 * Created_at - 16:12
 */

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
public class BadRequestException extends ExceptionProvider {

    public BadRequestException(String code) {
        super(code);
    }

    public BadRequestException(String code, String message) {
        super(code);
        this.message = message;
    }

    private String message;
}
