package br.com.venzel.store.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ConfigurationProperties("email.service")
public class GeralConfig {
    
    private String name;
    private String host;
}
