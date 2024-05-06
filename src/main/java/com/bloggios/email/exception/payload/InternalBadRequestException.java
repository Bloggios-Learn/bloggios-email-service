package com.bloggios.email.exception.payload;

/**
 * Owner - Rohit Parihar and Bloggios
 * Author - rohit
 * Project - bloggios-email-service
 * Package - com.bloggios.email.exception.payload
 * Created_on - May 06 - 2024
 * Created_at - 17:07
 *
 * This exception is created to log all the errors in the postgres database
 */

public class InternalBadRequestException extends ExceptionProvider {

    public InternalBadRequestException(String code) {
        super(code);
    }
}
