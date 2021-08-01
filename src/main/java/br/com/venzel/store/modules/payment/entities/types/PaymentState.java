package br.com.venzel.store.modules.payment.entities.types;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PaymentState {
    
    PAYMENT_VERIFICATION(1, "Payment verification"),
    SEPARATE_PRODUCTS(2, "Separate products"),
    SEND_PRODUCTS(3, "Send products");

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
