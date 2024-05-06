package com.bloggios.email.constants;

import lombok.experimental.UtilityClass;

/**
 * Owner - Rohit Parihar and Bloggios
 * Author - rohit
 * Project - bloggios-email-service
 * Package - com.bloggios.email.constants
 * Created_on - May 05 - 2024
 * Created_at - 16:38
 */

@UtilityClass
public class EndpointConstants {

    public static class MailSending {
        public static final String BASE = "/mail-sending";
        public static final String REGISTER_OTP = "/register-otp";
    }
}
