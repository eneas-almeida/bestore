package br.com.venzel.store.modules.product.product.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.venzel.store.modules.product.product.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Optional<Product> findOneById(Long id);

    Optional<Product> findOneByName(String name);
    
    List<Product> findAllByNameContaining(String name);

    Optional<Product> findFirstByNameContaining(String name);

    List<Product> findTop5ByNameContaining(String name);

    Boolean existsByName(String name);

    Integer countByName(String name);
}
