package com.bloggios.email.implementation;

import com.bloggios.email.constants.InternalErrorCodes;
import com.bloggios.email.dao.implementation.pgabstractdao.MailHistoryEntityDao;
import com.bloggios.email.entity.MailHistoryEntity;
import com.bloggios.email.enums.DaoStatus;
import com.bloggios.email.exception.payload.InternalException;
import com.bloggios.email.javamail.implementation.RegistrationOtpMailSending;
import com.bloggios.email.payload.request.RegisterOtpMailRequest;
import com.bloggios.email.payload.response.ApplicationResponse;
import com.bloggios.email.rules.implementation.exhibitor.RegisterOtpMailExhibitor;
import com.bloggios.email.service.MailSendingService;
import com.bloggios.email.transformer.implementation.transform.RegisterOtpToMailHistoryTransformer;
import lombok.SneakyThrows;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.concurrent.CompletableFuture;

/**
 * Owner - Rohit Parihar and Bloggios
 * Author - rohit
 * Project - bloggios-email-service
 * Package - com.bloggios.email
 * Created_on - May 05 - 2024
 * Created_at - 16:46
 */

@Service
public class MailSendingImplementation implements MailSendingService {

    private static final Logger logger = LoggerFactory.getLogger(MailSendingImplementation.class);

    private final RegistrationOtpMailSending registrationOtpMailSending;
    private final RegisterOtpMailExhibitor registerOtpMailExhibitor;
    private final RegisterOtpToMailHistoryTransformer registerOtpToMailHistoryTransformer;
    private final MailHistoryEntityDao mailHistoryEntityDao;

    public MailSendingImplementation(
            RegistrationOtpMailSending registrationOtpMailSending,
            RegisterOtpMailExhibitor registerOtpMailExhibitor,
            RegisterOtpToMailHistoryTransformer registerOtpToMailHistoryTransformer,
            MailHistoryEntityDao mailHistoryEntityDao
    ) {
        this.registrationOtpMailSending = registrationOtpMailSending;
        this.registerOtpMailExhibitor = registerOtpMailExhibitor;
        this.registerOtpToMailHistoryTransformer = registerOtpToMailHistoryTransformer;
        this.mailHistoryEntityDao = mailHistoryEntityDao;
    }

    @Override
    public ApplicationResponse sendRegisterOtpMail(RegisterOtpMailRequest request) {
        long startTime = System.currentTimeMillis();
        registerOtpMailExhibitor.exhibit(request);
        CompletableFuture.runAsync(()-> {
            try {
                registrationOtpMailSending.sendMail(request);
                logger.info("Mail sent for Register OTP in : {}ms", System.currentTimeMillis() - startTime);
            } catch (MessagingException exception) {
                throw new InternalException(InternalErrorCodes.MAIL_SENDING_FAILED);
            }
        });
        MailHistoryEntity transform = registerOtpToMailHistoryTransformer.transform(request);
        MailHistoryEntity mailHistoryEntity = mailHistoryEntityDao.initOperation(DaoStatus.CREATE, transform);
        logger.info("Execution complete for Register OTP mail sending in {}ms", System.currentTimeMillis() - startTime);
        return ApplicationResponse
                .builder()
                .message("Mail Sent")
                .id(mailHistoryEntity.getMailHistoryId())
                .build();
    }
}
