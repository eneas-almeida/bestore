package br.com.venzel.store.modules.user.dtos;

import java.time.OffsetDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
	
    private Long id;

    private String name;

    private String email;

    private String birthday;

    private String avatar;

    private Boolean activated;

    private Boolean allowed;

    private OffsetDateTime createdAt;

    private OffsetDateTime updatedAt;
}
