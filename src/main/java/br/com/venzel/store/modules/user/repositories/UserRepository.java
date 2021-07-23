package br.com.venzel.store.modules.user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.venzel.store.modules.user.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {}
