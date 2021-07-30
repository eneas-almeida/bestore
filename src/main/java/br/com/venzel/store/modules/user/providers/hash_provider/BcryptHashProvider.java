package br.com.venzel.store.modules.user.providers.hash_provider;

import org.springframework.stereotype.Service;

@Service
public class BcryptHashProvider implements HashProvider {

    @Override
    public String generateHash(String payload) {
        return payload + "###bcrypt";
    }

    @Override
    public Boolean compareHash(String payload, String hashed) {
        return true;
    }
}