package br.com.venzel.store.shared.providers.mail_provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class GoogleMailProvider extends AbstractMailProvider {
    
    @Autowired
    private MailSender mailSender;

    private static final Logger LOG = LoggerFactory.getLogger(GoogleMailProvider.class);

    @Override
    public void sendMail(SimpleMailMessage message) {
        LOG.info("Simulate send mail");
        mailSender.send(message);
        LOG.info("Mail sent");
    }
}