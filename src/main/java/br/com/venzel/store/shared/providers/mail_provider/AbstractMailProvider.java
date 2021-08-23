package br.com.venzel.store.shared.providers.mail_provider;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;

import br.com.venzel.store.configs.MailConfig;
import br.com.venzel.store.modules.order.order.entities.Order;
import br.com.venzel.store.modules.user.user.entities.User;

public abstract class AbstractMailProvider implements MailProvider {

    @Autowired
    private MailConfig emailConfig;

    @Override
    public void sendUserConfirmationMail(User user) {

        SimpleMailMessage sm = new SimpleMailMessage();

        sm.setTo(user.getEmail());
        sm.setFrom(emailConfig.getRecipient());
        sm.setSubject("User confirmation");
        sm.setSentDate(new Date(System.currentTimeMillis()));
        sm.setText(user.toString());

        sendMail(sm);
    }
    
    @Override
    public void sendOrderConfirmationMail(Order order) {
        
        SimpleMailMessage sm = new SimpleMailMessage();

        sm.setTo(order.getUser().getEmail());
        sm.setFrom(emailConfig.getRecipient());
        sm.setSubject("Order confirmation");
        sm.setSentDate(new Date(System.currentTimeMillis()));
        sm.setText(order.toString());

        sendMail(sm);
    }
}
