package com.identity.role.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Data
@Component
public class Roles {
    @Autowired
    AccessType accessType;

    @NotNull
    private String name;
    @NotNull
    private String type;
    @NotNull
    private List group;

    private AccessType access;

    public Roles() {
        this.name = "default";
        this.type = "default";
        this.group = new ArrayList<String>() {
            { add("default");}};
        this.access = accessType;
    }
}
