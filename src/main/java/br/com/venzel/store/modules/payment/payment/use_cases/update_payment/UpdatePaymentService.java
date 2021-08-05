package br.com.venzel.store.modules.payment.payment.use_cases.update_payment;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.venzel.store.modules.payment.payment.dtos.PaymentDTO;
import br.com.venzel.store.modules.payment.payment.dtos.UpdatePaymentDTO;
import br.com.venzel.store.modules.payment.payment.entities.Payment;
import br.com.venzel.store.modules.payment.payment.exceptions.PaymentNotFoundException;
import br.com.venzel.store.modules.payment.payment.mappers.PaymentMapper;
import br.com.venzel.store.modules.payment.payment.repositories.PaymentRepository;
import br.com.venzel.store.modules.payment.payment.utils.PaymentMessageUtils;

@Service
public class UpdatePaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private PaymentMapper paymentMapper;

    @Transactional
    public PaymentDTO execute(UpdatePaymentDTO dto, Long id) {

        Optional<Payment> optionalEntity = paymentRepository.findById(id);

        if (!optionalEntity.isPresent()) {
            throw new PaymentNotFoundException(PaymentMessageUtils.PAYMENT_NOT_FOUND);
        }

        Payment payment = optionalEntity.get();

        paymentMapper.toCopyEntity(dto, payment);

        return paymentMapper.toDTO(payment);
    }
}
