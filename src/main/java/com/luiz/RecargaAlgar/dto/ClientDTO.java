package com.luiz.RecargaAlgar.dto;

import com.luiz.RecargaAlgar.Entity.Client;

public class ClientDTO {
    private Long id;
    private String name;
    private String phoneNumber;

    public ClientDTO(Client client) {
        this.id = client.getId();
        this.name = client.getName();
        this.phoneNumber = client.getPhoneNumber();
    }

    public ClientDTO(Long id, String name, String phoneNumber) {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

