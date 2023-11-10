package com.vaadincrm.application.backend.entity;

import jakarta.persistence.*;

import java.util.LinkedList;
import java.util.List;

@Entity
public class Company extends AbstractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    @OneToMany(mappedBy = "company", fetch = FetchType.EAGER)
    private List<Contact> employees = new LinkedList<>();

    public Company(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company(String name) {
        this.name = name;
    }

    public List<Contact> getEmployees() {
        return employees;
    }
}
