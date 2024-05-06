package com.bloggios.email.rules.implementation.businessvalidator;

import com.bloggios.email.exception.payload.InternalBadRequestException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Owner - Rohit Parihar and Bloggios
 * Author - rohit
 * Project - bloggios-email-service
 * Package - com.bloggios.email.rules.implementation.businessvalidator
 * Created_on - May 06 - 2024
 * Created_at - 21:06
 */

@ExtendWith(MockitoExtension.class)
class EmailValidatorTest {

    @InjectMocks
    private EmailValidator emailValidator;

    @Test
    void validateNullOrEmpty() {
        assertThrows(InternalBadRequestException.class,
                ()-> emailValidator.validate(null));
        assertThrows(InternalBadRequestException.class,
                ()-> emailValidator.validate(""));
    }

    @Test
    void validateInvalidEmail() {
        String invalidEmail = "invalid";
        assertThrows(InternalBadRequestException.class,
                ()-> emailValidator.validate(invalidEmail));
    }

    @Test
    void validateValidEmail() {
        String validEmail = "rohit@bloggios.com";
        assertDoesNotThrow(()-> emailValidator.validate(validEmail));
    }
}