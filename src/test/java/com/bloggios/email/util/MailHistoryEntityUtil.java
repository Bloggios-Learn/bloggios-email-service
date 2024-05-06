package com.bloggios.email.util;

import com.bloggios.email.entity.MailHistoryEntity;
import com.bloggios.email.enums.MailFor;
import com.bloggios.email.enums.MailProvider;
import lombok.experimental.UtilityClass;

import java.util.Date;
import java.util.UUID;

import static com.bloggios.email.constants.EnvironmentConstants.APPLICATION_VERSION;

/**
 * Owner - Rohit Parihar and Bloggios
 * Author - rohit
 * Project - bloggios-email-service
 * Package - com.bloggios.email.util
 * Created_on - May 06 - 2024
 * Created_at - 22:45
 */

@UtilityClass
public class MailHistoryEntityUtil {

    public static MailHistoryEntity getMailHistoryEntity() {
        return MailHistoryEntity
                .builder()
                .mailTo("rohit@bloggios.com")
                .mailContent("123456")
                .mailProvider(MailProvider.GMAIL)
                .mailFor(MailFor.REGISTER_OTP)
                .dateSent(new Date())
                .apiVersion("1")
                .build();
    }

    public static MailHistoryEntity getMailHistoryEntityWithId() {
        MailHistoryEntity mailHistoryEntity = getMailHistoryEntity();
        mailHistoryEntity.setMailHistoryId("123456");
        return mailHistoryEntity;
    }
}
