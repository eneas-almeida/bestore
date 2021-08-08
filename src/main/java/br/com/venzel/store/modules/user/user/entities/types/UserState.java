package br.com.venzel.store.modules.user.user.entities.types;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserState {
    
    NEW(1, "new"),
    ACTIVE(2, "active"),
    BLOCKED(2, "blocked"),
    BANNED(3, "banned"),
    DELETED(4, "deleted");

    private Integer code;
    private String description;

    public static UserState toEnum(Integer code) {

        if (code == null) {
            return null;
        }

        for (UserState e : UserState.values()) {
            if (e.getCode().equals(code)) {
                return e;
            }
        }

        throw new IllegalArgumentException("Code invalid "+ code);
    }
}
