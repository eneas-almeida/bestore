package br.com.venzel.store.modules.user.providers.hash_provider;

public interface HashProvider {
    
    String generateHash(String payload);

    Boolean compareHash(String payload, String hashed);
}
