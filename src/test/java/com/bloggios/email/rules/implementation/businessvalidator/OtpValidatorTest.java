package com.bloggios.email.rules.implementation.businessvalidator;

import com.bloggios.email.exception.payload.InternalBadRequestException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Owner - Rohit Parihar and Bloggios
 * Author - rohit
 * Project - bloggios-email-service
 * Package - com.bloggios.email.rules.implementation.businessvalidator
 * Created_on - May 06 - 2024
 * Created_at - 21:13
 */

@ExtendWith(MockitoExtension.class)
class OtpValidatorTest {

    @InjectMocks
    private OtpValidator otpValidator;

    @Test
    void validate() {
        assertThrows(InternalBadRequestException.class,
                ()-> otpValidator.validate(null));
        assertThrows(InternalBadRequestException.class,
                ()-> otpValidator.validate("12345"));
    }

    @Test
    void validateLongInvalid() {
        assertThrows(InternalBadRequestException.class,
                ()-> otpValidator.validate("12345r"));
    }

    @Test
    void validateValidOtp() {
        assertDoesNotThrow(()-> otpValidator.validate("123456"));
    }
}