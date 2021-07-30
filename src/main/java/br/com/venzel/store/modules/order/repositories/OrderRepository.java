package br.com.venzel.store.modules.order.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.venzel.store.modules.order.entities.Order;
import br.com.venzel.store.modules.product.entities.Product;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    Optional<Product> findOneById(Long id);
}
