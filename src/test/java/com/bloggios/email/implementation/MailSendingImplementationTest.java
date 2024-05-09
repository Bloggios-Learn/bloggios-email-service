package com.bloggios.email.implementation;

import com.bloggios.email.dao.implementation.pgabstractdao.MailHistoryEntityDao;
import com.bloggios.email.entity.MailHistoryEntity;
import com.bloggios.email.enums.DaoStatus;
import com.bloggios.email.exception.payload.InternalBadRequestException;
import com.bloggios.email.javamail.implementation.RegistrationOtpMailSending;
import com.bloggios.email.payload.request.RegisterOtpMailRequest;
import com.bloggios.email.payload.response.ApplicationResponse;
import com.bloggios.email.rules.implementation.exhibitor.RegisterOtpMailExhibitor;
import com.bloggios.email.transformer.implementation.transform.RegisterOtpToMailHistoryTransformer;
import com.bloggios.email.util.MailHistoryEntityUtil;
import com.bloggios.email.util.RegisterOtpMailRequestUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.mail.MessagingException;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Owner - Rohit Parihar and Bloggios
 * Author - rohit
 * Project - bloggios-email-service
 * Package - com.bloggios.email.implementation
 * Created_on - May 06 - 2024
 * Created_at - 21:32
 */

@ExtendWith(MockitoExtension.class)
class MailSendingImplementationTest {

    @InjectMocks
    private MailSendingImplementation mailSendingImplementation;

    @Mock
    private RegistrationOtpMailSending registrationOtpMailSending;

    @Mock
    private RegisterOtpMailExhibitor registerOtpMailExhibitor;

    @Mock
    private RegisterOtpToMailHistoryTransformer registerOtpToMailHistoryTransformer;

    @Mock
    private MailHistoryEntityDao mailHistoryEntityDao;

//    @Test
//    void sendRegisterOtpMail() throws MessagingException {
//        RegisterOtpMailRequest registerOtpMailRequest = RegisterOtpMailRequestUtil.getValidRequest();
//        MailHistoryEntity mailHistoryEntity = MailHistoryEntityUtil.getMailHistoryEntity();
//        MailHistoryEntity mailHistoryEntityWithId = MailHistoryEntityUtil.getMailHistoryEntityWithId();
//        Mockito.when(registerOtpToMailHistoryTransformer.transform(registerOtpMailRequest))
//                .thenReturn(mailHistoryEntity);
//        Mockito.when(mailHistoryEntityDao.initOperation(DaoStatus.CREATE, mailHistoryEntity))
//                .thenReturn(mailHistoryEntityWithId);
//        ApplicationResponse response = mailSendingImplementation.sendRegisterOtpMail(registerOtpMailRequest);
//        Mockito.verify(registrationOtpMailSending, Mockito.times(1))
//                .sendMail(registerOtpMailRequest);
//        Mockito.verify(registrationOtpMailSending, Mockito.timeout(1000))
//                .sendMail(registerOtpMailRequest);
//        assertEquals("123456", response.getId());
//    }
}