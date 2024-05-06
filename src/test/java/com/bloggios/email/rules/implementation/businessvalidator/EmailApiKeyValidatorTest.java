package com.bloggios.email.rules.implementation.businessvalidator;

import com.bloggios.email.constants.EnvironmentConstants;
import com.bloggios.email.exception.payload.InternalBadRequestException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.env.Environment;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Owner - Rohit Parihar and Bloggios
 * Author - rohit
 * Project - bloggios-email-service
 * Package - com.bloggios.email.rules.implementation.businessvalidator
 * Created_on - May 06 - 2024
 * Created_at - 20:55
 */

@ExtendWith(MockitoExtension.class)
class EmailApiKeyValidatorTest {

    @InjectMocks
    private EmailApiKeyValidator emailApiKeyValidator;

    @Mock
    private Environment environment;

    @Test
    void validate() {
        assertThrows(InternalBadRequestException.class,
                ()-> emailApiKeyValidator.validate(null));
        assertThrows(InternalBadRequestException.class,
                ()-> emailApiKeyValidator.validate(""));
    }

    @Test
    void validateWithInvalidApiKey() {
        String invalidApiKey = "1234567";
        Mockito.when(environment.getProperty(EnvironmentConstants.EMAIL_API_KEY))
                .thenReturn(invalidApiKey);
        assertThrows(InternalBadRequestException.class,
                ()-> emailApiKeyValidator.validate("1234"));
    }

    @Test
    void validateNoError() {
        String validApiKey = "1234567";
        Mockito.when(environment.getProperty(EnvironmentConstants.EMAIL_API_KEY))
                .thenReturn(validApiKey);
        assertDoesNotThrow(()-> emailApiKeyValidator.validate(validApiKey));
    }
}