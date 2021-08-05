package br.com.venzel.store.modules.payment.payment.use_cases.create_payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.venzel.store.modules.payment.payment.dtos.CreatePaymentDTO;
import br.com.venzel.store.modules.payment.payment.dtos.PaymentDTO;
import br.com.venzel.store.modules.payment.payment.entities.Payment;
import br.com.venzel.store.modules.payment.payment.mappers.PaymentMapper;
import br.com.venzel.store.modules.payment.payment.repositories.PaymentRepository;

@Service
public class CreatePaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private PaymentMapper paymentMapper;

    @Transactional
    public PaymentDTO execute(CreatePaymentDTO dto) {
        
        Payment payment = paymentMapper.toEntity(dto);

        paymentRepository.save(payment);

        return paymentMapper.toDTO(payment);
    }
}
