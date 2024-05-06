package com.bloggios.email.controller;

import com.bloggios.email.constants.EndpointConstants;
import com.bloggios.email.payload.request.RegisterOtpMailRequest;
import com.bloggios.email.payload.response.ApplicationResponse;
import com.bloggios.email.service.MailSendingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Owner - Rohit Parihar and Bloggios
 * Author - rohit
 * Project - bloggios-email-service
 * Package - com.bloggios.email.controller
 * Created_on - May 05 - 2024
 * Created_at - 16:38
 */

@RestController
@RequestMapping(EndpointConstants.MailSending.BASE)
public class MailSendingController {

    private final MailSendingService mailSendingService;

    public MailSendingController(
            MailSendingService mailSendingService
    ) {
        this.mailSendingService = mailSendingService;
    }

    @PostMapping(EndpointConstants.MailSending.REGISTER_OTP)
    public ResponseEntity<ApplicationResponse> sendRegisterOtpMail(@RequestBody RegisterOtpMailRequest request) {
        return ResponseEntity.ok(mailSendingService.sendRegisterOtpMail(request));
    }
}
