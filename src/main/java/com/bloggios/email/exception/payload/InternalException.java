package com.bloggios.email.exception.payload;

import lombok.EqualsAndHashCode;

/**
 * Owner - Rohit Parihar and Bloggios
 * Author - rohit
 * Project - bloggios-email-service
 * Package - com.bloggios.email.exception
 * Created_on - May 01 - 2024
 * Created_at - 16:19
 */

@EqualsAndHashCode(callSuper = true)
public class InternalException extends ExceptionProvider {

    public InternalException(String code) {
        super(code);
    }
}
