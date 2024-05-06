package com.bloggios.email.rules.implementation.exhibitor;

import com.bloggios.email.payload.request.RegisterOtpMailRequest;
import com.bloggios.email.rules.Exhibitor;
import com.bloggios.email.rules.implementation.businessvalidator.EmailApiKeyValidator;
import com.bloggios.email.rules.implementation.businessvalidator.EmailValidator;
import com.bloggios.email.rules.implementation.businessvalidator.OtpValidator;
import org.springframework.stereotype.Component;

/**
 * Owner - Rohit Parihar and Bloggios
 * Author - rohit
 * Project - bloggios-email-service
 * Package - com.bloggios.email.rules.implementation.exhibitor
 * Created_on - May 06 - 2024
 * Created_at - 16:52
 */

@Component
public class RegisterOtpMailExhibitor implements Exhibitor<RegisterOtpMailRequest> {

    private final EmailValidator emailValidator;
    private final OtpValidator otpValidator;
    private final EmailApiKeyValidator emailApiKeyValidator;

    public RegisterOtpMailExhibitor(
            EmailValidator emailValidator,
            OtpValidator otpValidator,
            EmailApiKeyValidator emailApiKeyValidator
    ) {
        this.emailValidator = emailValidator;
        this.otpValidator = otpValidator;
        this.emailApiKeyValidator = emailApiKeyValidator;
    }

    @Override
    public void exhibit(RegisterOtpMailRequest request) {
        emailValidator.validate(request.getEmail());
        otpValidator.validate(request.getOtp());
        emailApiKeyValidator.validate(request.getApiKey());
    }
}
