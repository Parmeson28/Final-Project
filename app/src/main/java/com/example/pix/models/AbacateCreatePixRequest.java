package com.example.pix.models;

import java.math.BigDecimal;

public class AbacateCreatePixRequest {
    private BigDecimal amount;
    private String description;
    private Customer customer;

    public AbacateCreatePixRequest() {}

    // Getters e setters
    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }
}
