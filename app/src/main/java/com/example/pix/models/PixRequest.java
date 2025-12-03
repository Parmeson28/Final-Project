package com.example.pix.models;

public class PixRequest {
    private int amount; // valor em centavos
    private String description;
    private String customerName;
    private String customerEmail;

    public PixRequest() {}

    public PixRequest(int amount, String description, String customerName, String customerEmail) {
        this.amount = amount;
        this.description = description;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
    }

    // Getters e setters
    public int getAmount() { return amount; }
    public void setAmount(int amount) { this.amount = amount; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }

    public String getCustomerEmail() { return customerEmail; }
    public void setCustomerEmail(String customerEmail) { this.customerEmail = customerEmail; }
}
