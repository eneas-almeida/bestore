package br.com.venzel.store.modules.payment.payment.mappers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import br.com.venzel.store.modules.payment.payment.dtos.CreatePaymentDTO;
import br.com.venzel.store.modules.payment.payment.dtos.PaymentDTO;
import br.com.venzel.store.modules.payment.payment.dtos.UpdatePaymentDTO;
import br.com.venzel.store.modules.payment.payment.entities.Payment;

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

    public Page<PaymentDTO> toCollectionPageModel(Page<Payment> categories) {
        return categories.map(e -> toDTO(e));
    }

    public Payment toEntity(CreatePaymentDTO dto) {
        return modelMapper.map(dto, Payment.class);
    }

    public void toCopyEntity(UpdatePaymentDTO dto, Payment payment) {
        modelMapper.map(dto, payment);
    }
}
