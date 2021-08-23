package br.com.venzel.store.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.venzel.store.shared.providers.mail_provider.MailProvider;
import br.com.venzel.store.shared.providers.mail_provider.MockMailProvider;

@Configuration
@Profile("development")
public class DevelopmentConfig {
    
    @Bean
    public MailProvider emailProvider() {
        return new MockMailProvider();
    }
}
