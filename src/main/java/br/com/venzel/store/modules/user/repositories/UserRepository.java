package br.com.venzel.store.modules.user.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.venzel.store.modules.user.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findOneById(Long id);

    Optional<User> findOneByEmail(String email);

    Optional<User> findOneByName(String name);
    
    List<User> findAllByNameContaining(String name);

    Optional<User> findFirstByNameContaining(String name);

    List<User> findTop5ByNameContaining(String name);

    Boolean existsByName(String name);

    Boolean existsByEmail(String email);

    Integer countByName(String name);
}
