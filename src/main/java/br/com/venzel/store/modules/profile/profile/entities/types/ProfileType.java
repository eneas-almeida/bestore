package br.com.venzel.store.modules.profile.profile.entities.types;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ProfileType {
    
    PHYSICAL_PERSON(1, "Physical Person"),
    LEGAL_PERSON(2, "Legal Person");

    private Integer code;
    private String description;

    public static ProfileType toEnum(Integer code) {

        if (code == null) {
            return null;
        }

        for (ProfileType e : ProfileType.values()) {
            if (e.getCode().equals(code)) {
                return e;
            }
        }

        throw new IllegalArgumentException("Code invalid "+ code);
    }
}
