package br.com.venzel.store.modules.payment.use_cases.update_payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.venzel.store.modules.payment.dtos.PaymentDTO;
import br.com.venzel.store.modules.payment.entities.Payment;
import br.com.venzel.store.modules.payment.mapper.PaymentMapper;
import br.com.venzel.store.modules.payment.repositories.PaymentRepository;

@Service
public class UpdatePaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private PaymentMapper paymentMapper;

    @Transactional
    public PaymentDTO execute(PaymentDTO dto, Long id) {

        Payment payment = paymentMapper.toEntity(dto);

        paymentRepository.save(payment);

        return paymentMapper.toDTO(payment);
    }
}
