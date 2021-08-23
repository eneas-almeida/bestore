package br.com.venzel.store.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import br.com.venzel.store.shared.providers.mail_provider.GoogleMailProvider;

@Configuration
@Profile("production")
public class ProductionConfig {
    
    @Bean
    public GoogleMailProvider emailProvider() {
        return new GoogleMailProvider();
    }
}
