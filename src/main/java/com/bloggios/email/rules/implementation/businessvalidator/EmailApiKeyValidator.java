package com.bloggios.email.rules.implementation.businessvalidator;

import com.bloggios.email.constants.DataErrorCodes;
import com.bloggios.email.constants.EnvironmentConstants;
import com.bloggios.email.exception.payload.InternalBadRequestException;
import com.bloggios.email.rules.BusinessValidator;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

/**
 * Owner - Rohit Parihar and Bloggios
 * Author - rohit
 * Project - bloggios-email-service
 * Package - com.bloggios.email.rules.implementation.businessvalidator
 * Created_on - May 06 - 2024
 * Created_at - 19:38
 */

@Component
public class EmailApiKeyValidator implements BusinessValidator<String> {

    private final Environment environment;

    public EmailApiKeyValidator(
            Environment environment
    ) {
        this.environment = environment;
    }

    @Override
    public void validate(String apiKey) {
        if (apiKey == null || ObjectUtils.isEmpty(apiKey)) {
            throw new InternalBadRequestException(DataErrorCodes.EMAIL_API_KEY_NOT_PRESENT);
        }
        String property = environment.getProperty(EnvironmentConstants.EMAIL_API_KEY);
        if (!apiKey.equals(property)) {
            throw new InternalBadRequestException(DataErrorCodes.EMAIL_API_KEY_NOT_VALID);
        }
    }
}
