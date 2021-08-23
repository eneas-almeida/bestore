package br.com.venzel.store.shared.providers.mail_provider;

import org.springframework.mail.SimpleMailMessage;

import br.com.venzel.store.modules.order.order.entities.Order;
import br.com.venzel.store.modules.user.user.entities.User;

public interface MailProvider {

    public void sendUserConfirmationMail(User user);

    public void sendOrderConfirmationMail(Order order);

    public void sendMail(SimpleMailMessage message);
}