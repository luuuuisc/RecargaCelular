package com.luiz.RecargaAlgar.Entity;

import jakarta.persistence.*;


@Entity
@Table(name = "tb_recharge")
public class Recharge {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "amount")
    private double amount;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    private String status;  // PENDING, COMPLETED, FAILED

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;  // Adiciona uma referência ao Cliente

    public Recharge() {
        this.id = id;
        this.amount = amount;
        this.status = status;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public String getStatus() {
        return status;
    }

    public Client getClient() {
        return client;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setClient(Client client) {
        this.client = client;
    }


}
