package br.com.venzel.store.modules.user.user.providers.hash_provider;

public interface HashProvider {
    
    String generateHash(String payload);

    Boolean compareHash(String payload, String hashed);
}
