package com.bloggios.email.rules.implementation.businessvalidator;

import com.bloggios.email.constants.DataErrorCodes;
import com.bloggios.email.constants.ServiceConstants;
import com.bloggios.email.exception.payload.BadRequestException;
import com.bloggios.email.exception.payload.InternalBadRequestException;
import com.bloggios.email.rules.BusinessValidator;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

/**
 * Owner - Rohit Parihar and Bloggios
 * Author - rohit
 * Project - bloggios-email-service
 * Package - com.bloggios.email.rules.implementation.businessvalidator
 * Created_on - May 01 - 2024
 * Created_at - 16:07
 */

@Component
public class EmailValidator implements BusinessValidator<String> {

    @Override
    public void validate(String email) {
        if (email == null || ObjectUtils.isEmpty(email)) {
            throw new InternalBadRequestException(DataErrorCodes.EMAIL_MANDATORY);
        }
        if (!email.matches(ServiceConstants.EMAIL_REGEX)) {
            throw new InternalBadRequestException(DataErrorCodes.EMAIL_NOT_VALID);
        }
    }
}
