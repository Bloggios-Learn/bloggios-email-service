package com.bloggios.email.javamail;

import com.bloggios.email.constants.BeanNameConstants;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mail.javamail.JavaMailSender;
import javax.mail.internet.MimeMessage;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;

/**
 * Owner - Rohit Parihar and Bloggios
 * Author - rohit
 * Project - bloggios-email-service
 * Package - com.bloggios.email.javamail
 * Created_on - May 05 - 2024
 * Created_at - 16:30
 */

@Component
public abstract class GmailSending<A> {

    private final JavaMailSender javaMailSender;

    protected GmailSending(
            @Qualifier(BeanNameConstants.GOOGLE_MAIL_SENDER_BEAN) JavaMailSender javaMailSender
    ) {
        this.javaMailSender = javaMailSender;
    }

    @Async(BeanNameConstants.ASYNC_TASK_INTERNAL_POOL)
    public void sendMail(A a) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        mailingData(mimeMessage, a);
        javaMailSender.send(mimeMessage);
    }

    public abstract void mailingData(MimeMessage message, A a) throws MessagingException;
}
