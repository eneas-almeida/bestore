package br.com.venzel.store.modules.user.profile.address.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.venzel.store.modules.user.profile.address.entities.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    Optional<Address> findOneById(Long id);
}

