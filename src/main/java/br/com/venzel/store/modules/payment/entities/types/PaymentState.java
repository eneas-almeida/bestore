package br.com.venzel.store.modules.payment.entities.types;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PaymentState {
    
    PENDING(1, "Peding"),
    SETTLED(2, "Settled"),
    CANCELED(3, "Canceled");

    private Integer code;
    private String description;

    public static PaymentState toEnum(Integer code) {

        if (code == null) {
            return null;
        }

        for (PaymentState e : PaymentState.values()) {
            if (e.getCode().equals(code)) {
                return e;
            }
        }

        throw new IllegalArgumentException("Code invalid "+ code);
    }
}
