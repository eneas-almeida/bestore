package br.com.venzel.store.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
@ConfigurationProperties("email.service")
public class EmailConfig {
    
    private String name;
    private String host;
}
