package br.com.venzel.store.modules.user.providers.hash_provider;

import org.springframework.stereotype.Service;

@Service
public class MockHashProvider implements HashProvider {

    public String generateHash(String payload) {
        return payload + "###mock";
    }

    public Boolean compareHash(String payload, String hashed) {
        return true;
    }
}
