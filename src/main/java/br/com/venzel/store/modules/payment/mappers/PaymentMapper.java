package br.com.venzel.store.modules.payment.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.venzel.store.modules.payment.dtos.CreatePaymentDTO;
import br.com.venzel.store.modules.payment.dtos.PaymentDTO;
import br.com.venzel.store.modules.payment.dtos.UpdatePaymentDTO;
import br.com.venzel.store.modules.payment.entities.Payment;

@Component
public class PaymentMapper {
    
    @Autowired
    private ModelMapper modelMapper;

    public PaymentDTO toDTO(Payment payment) {
        return modelMapper.map(payment, PaymentDTO.class);
    }

    public List<PaymentDTO> toCollectionModel(List<Payment> payments) {
        return payments.stream()
                    .map(e -> toDTO(e))
                    .collect(Collectors.toList());
    }

    public Payment toEntity(CreatePaymentDTO dto) {
        return modelMapper.map(dto, Payment.class);
    }

    public void toCopyEntity(UpdatePaymentDTO dto, Payment payment) {
        modelMapper.map(dto, payment);
    }
}