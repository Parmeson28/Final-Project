package com.example.pix.models;

public class AbacateCreatePixData {
    private int amount;
    private String status;
    private boolean devMode;
    private String method;
    private String brCode;
    private String brCodeBase64;

    public AbacateCreatePixData() {}

    // Getters e setters
    public int getAmount() { return amount; }
    public void setAmount(int amount) { this.amount = amount; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public boolean isDevMode() { return devMode; }
    public void setDevMode(boolean devMode) { this.devMode = devMode; }

    public String getMethod() { return method; }
    public void setMethod(String method) { this.method = method; }

    public String getBrCode() { return brCode; }
    public void setBrCode(String brCode) { this.brCode = brCode; }

    public String getBrCodeBase64() { return brCodeBase64; }
    public void setBrCodeBase64(String brCodeBase64) { this.brCodeBase64 = brCodeBase64; }
}
