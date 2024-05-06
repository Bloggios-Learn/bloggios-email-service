package com.bloggios.email.rules.implementation.businessvalidator;

import com.bloggios.email.constants.DataErrorCodes;
import com.bloggios.email.exception.payload.BadRequestException;
import com.bloggios.email.exception.payload.InternalBadRequestException;
import com.bloggios.email.rules.BusinessValidator;
import org.springframework.stereotype.Component;

/**
 * Owner - Rohit Parihar and Bloggios
 * Author - rohit
 * Project - bloggios-email-service
 * Package - com.bloggios.email.rules.implementation.businessvalidator
 * Created_on - May 06 - 2024
 * Created_at - 17:04
 */

@Component
public class OtpValidator implements BusinessValidator<String> {

    @Override
    public void validate(String otp) {
        if (otp == null) {
            throw new InternalBadRequestException(DataErrorCodes.OTP_MANDATORY);
        }
        if (otp.length() != 6) {
            throw new InternalBadRequestException(DataErrorCodes.OTP_LENGTH_NOT_VALID);
        }
        try {
            Long.parseLong(otp);
        } catch (Exception exception) {
            throw new InternalBadRequestException(DataErrorCodes.OTP_NOT_OF_VALID_NUMBERS);
        }
    }
}
