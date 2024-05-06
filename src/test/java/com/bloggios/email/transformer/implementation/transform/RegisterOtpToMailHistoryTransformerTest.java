package com.bloggios.email.transformer.implementation.transform;

import com.bloggios.email.constants.EnvironmentConstants;
import com.bloggios.email.entity.MailHistoryEntity;
import com.bloggios.email.payload.request.RegisterOtpMailRequest;
import com.bloggios.email.util.RegisterOtpMailRequestUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.env.Environment;
import org.springframework.core.env.EnvironmentCapable;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Owner - Rohit Parihar and Bloggios
 * Author - rohit
 * Project - bloggios-email-service
 * Package - com.bloggios.email.transformer.implementation.transform
 * Created_on - May 06 - 2024
 * Created_at - 21:26
 */

@ExtendWith(MockitoExtension.class)
class RegisterOtpToMailHistoryTransformerTest {

    @InjectMocks
    private RegisterOtpToMailHistoryTransformer registerOtpToMailHistoryTransformer;

    @Mock
    private Environment environment;

    @Test
    void transform() {
        RegisterOtpMailRequest validRequest = RegisterOtpMailRequestUtil.getValidRequest();
        Mockito.when(environment.getProperty(EnvironmentConstants.APPLICATION_VERSION))
                .thenReturn("1");
        MailHistoryEntity transform = registerOtpToMailHistoryTransformer.transform(validRequest);
        assertEquals("rohit@bloggios.com", transform.getMailTo());
        assertEquals("1", transform.getApiVersion());
    }
}