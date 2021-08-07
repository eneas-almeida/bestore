package br.com.venzel.store.modules.user.profile.address.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.venzel.store.modules.user.profile.address.entities.State;

@Repository
public interface StateRepository extends JpaRepository<State, Long> {

    Optional<State> findOneById(Long id);

    Optional<State> findOneByName(String name);

    Integer countByName(String name);
}
