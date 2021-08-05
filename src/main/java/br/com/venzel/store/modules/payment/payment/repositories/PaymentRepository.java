package br.com.venzel.store.modules.payment.payment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.venzel.store.modules.payment.payment.entities.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {}