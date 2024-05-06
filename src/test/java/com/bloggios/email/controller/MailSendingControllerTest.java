package com.bloggios.email.controller;

import com.bloggios.email.payload.request.RegisterOtpMailRequest;
import com.bloggios.email.payload.response.ApplicationResponse;
import com.bloggios.email.service.MailSendingService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Owner - Rohit Parihar and Bloggios
 * Author - rohit
 * Project - bloggios-email-service
 * Package - com.bloggios.email.controller
 * Created_on - May 06 - 2024
 * Created_at - 20:37
 */

@ExtendWith(MockitoExtension.class)
class MailSendingControllerTest {

    @InjectMocks
    private MailSendingController mailSendingController;

    @Mock
    private MailSendingService mailSendingService;

    @Test
    void sendRegisterOtpMail() {
        RegisterOtpMailRequest request = new RegisterOtpMailRequest();
        request.setEmail("rohit@gmail.com");
        request.setOtp("12345");
        Mockito.when(mailSendingService.sendRegisterOtpMail(request))
                .thenReturn(new ApplicationResponse());
        ResponseEntity<ApplicationResponse> response = mailSendingController.sendRegisterOtpMail(request);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        Mockito.verify(mailSendingService, Mockito.times(1)).sendRegisterOtpMail(request);
    }
}