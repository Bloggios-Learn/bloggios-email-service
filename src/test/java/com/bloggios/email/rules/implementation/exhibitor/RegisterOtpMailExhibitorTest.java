package com.bloggios.email.rules.implementation.exhibitor;

import com.bloggios.email.payload.request.RegisterOtpMailRequest;
import com.bloggios.email.rules.implementation.businessvalidator.EmailApiKeyValidator;
import com.bloggios.email.rules.implementation.businessvalidator.EmailValidator;
import com.bloggios.email.rules.implementation.businessvalidator.OtpValidator;
import com.bloggios.email.util.RegisterOtpMailRequestUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Owner - Rohit Parihar and Bloggios
 * Author - rohit
 * Project - bloggios-email-service
 * Package - com.bloggios.email.rules.implementation.exhibitor
 * Created_on - May 06 - 2024
 * Created_at - 21:22
 */

@ExtendWith(MockitoExtension.class)
class RegisterOtpMailExhibitorTest {

    @InjectMocks
    private RegisterOtpMailExhibitor registerOtpMailExhibitor;

    @Mock
    private EmailValidator emailValidator;

    @Mock
    private OtpValidator otpValidator;

    @Mock
    private EmailApiKeyValidator emailApiKeyValidator;

    @Test
    void exhibit() {
        assertDoesNotThrow(()-> registerOtpMailExhibitor.exhibit(RegisterOtpMailRequestUtil.getValidRequest()));
    }
}