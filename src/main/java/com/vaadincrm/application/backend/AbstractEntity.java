package com.vaadincrm.application.backend;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    public Long getId() {
        return id;
    }

    public boolean isPersisted(){
        return id != null;
    }

    @Override
    public int hashCode(){
        if (getId() != null){
            return getId().hashCode();
        }
        return super.hashCode();
    }
}
