package com.identity.role.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.validation.constraints.*;

@Data
@Component
public class User {

    @NotNull(message = "Id Cannot be null or empty")
    private Long id;
    @NotNull(message = "Name Cannot be null or empty")
    private String name;
    @NotNull(message = "Role Cannot be null or empty")
    private Roles role;

    public User(){
        this.id = (long) (Math.random() * (1 - 5));
        this.name = "Default";
        this.role = new Roles();
    }

}
