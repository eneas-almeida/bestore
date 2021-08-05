package br.com.venzel.store.modules.order.order_item.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.venzel.store.modules.order.order_item.entities.OrderItem;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

    Optional<OrderItem> findOneById(Long id);
}
