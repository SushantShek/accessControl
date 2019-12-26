package com.identity.role.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class AccessType {

    private boolean read;
    private boolean write;
    private boolean edit;
    private boolean delete;

    public AccessType(){
        this.read=true;
    }
}
