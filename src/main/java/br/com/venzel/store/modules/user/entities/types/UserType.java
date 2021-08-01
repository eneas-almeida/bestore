package br.com.venzel.store.modules.user.entities.types;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserType {
    
    PHYSICAL_PERSON(1, "Physical Person"),
    LEGAL_PERSON(2, "Legal Person");

    private Integer code;
    private String description;

    public static UserType toEnum(Integer code) {

        if (code == null) {
            return null;
        }

        for (UserType e : UserType.values()) {
            if (e.getCode().equals(code)) {
                return e;
            }
        }

        throw new IllegalArgumentException("Code invalid "+ code);
    }
}
