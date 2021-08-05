package br.com.venzel.store.modules.product.category.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.venzel.store.modules.product.category.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findOneById(Long id);

    Optional<Category> findOneByName(String name);
    
    List<Category> findAllByNameContaining(String name);

    Optional<Category> findFirstByNameContaining(String name);

    List<Category> findTop5ByNameContaining(String name);

    Boolean existsByName(String name);

    Integer countByName(String name);
}

