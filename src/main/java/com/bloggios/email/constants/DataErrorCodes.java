package com.bloggios.email.constants;

import lombok.experimental.UtilityClass;

/**
 * Owner - Rohit Parihar and Bloggios
 * Author - rohit
 * Project - bloggios-email-service
 * Package - com.bloggios.email.constants
 * Created_on - May 06 - 2024
 * Created_at - 16:55
 */

@UtilityClass
public class DataErrorCodes {
    public static final String EMAIL_MANDATORY = "DE__MAIL-2001";
    public static final String EMAIL_NOT_VALID = "DE__MAIL-2002";
    public static final String OTP_MANDATORY = "DE__MAIL-2003";
    public static final String OTP_LENGTH_NOT_VALID = "DE__MAIL-2004";
    public static final String OTP_NOT_OF_VALID_NUMBERS = "DE__MAIL-2005";
    public static final String EMAIL_API_KEY_NOT_PRESENT = "DE__MAIL-2006";
    public static final String EMAIL_API_KEY_NOT_VALID = "DE__MAIL-2007";
}
