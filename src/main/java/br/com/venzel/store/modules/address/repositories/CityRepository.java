package br.com.venzel.store.modules.address.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.venzel.store.modules.address.entities.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {

    Optional<City> findOneById(Long id);

    Optional<City> findOneByName(String name);

    Integer countByName(String name);
}

