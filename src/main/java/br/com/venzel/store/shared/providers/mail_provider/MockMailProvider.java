package br.com.venzel.store.shared.providers.mail_provider;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;

public class MockMailProvider extends AbstractMailProvider {

    private static final Logger LOG = LoggerFactory.getLogger(MockMailProvider.class);

    @Override
    public void sendMail(SimpleMailMessage message) {
        LOG.info("Simulate send mail");
        LOG.info(message.toString());
        LOG.info("Mail sent");
    }
}
