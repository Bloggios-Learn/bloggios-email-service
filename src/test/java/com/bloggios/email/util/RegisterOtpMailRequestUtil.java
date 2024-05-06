package com.bloggios.email.util;

import com.bloggios.email.payload.request.RegisterOtpMailRequest;
import lombok.experimental.UtilityClass;

/**
 * Owner - Rohit Parihar and Bloggios
 * Author - rohit
 * Project - bloggios-email-service
 * Package - com.bloggios.email.util
 * Created_on - May 06 - 2024
 * Created_at - 21:28
 */

@UtilityClass
public class RegisterOtpMailRequestUtil {

    public RegisterOtpMailRequest getValidRequest() {
        RegisterOtpMailRequest request = new RegisterOtpMailRequest();
        request.setEmail("rohit@bloggios.com");
        request.setOtp("123456");
        request.setApiKey("123456");
        return request;
    }
}
