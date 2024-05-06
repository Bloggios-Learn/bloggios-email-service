package com.bloggios.email.exception.payload;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Owner - Rohit Parihar and Bloggios
 * Author - rohit
 * Project - bloggios-email-service
 * Package - com.bloggios.email.exception
 * Created_on - May 01 - 2024
 * Created_at - 16:09
 */

@Getter
@Setter
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ExceptionProvider extends RuntimeException {

    private final String code;
}
