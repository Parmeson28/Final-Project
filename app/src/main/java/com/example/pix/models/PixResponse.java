package com.example.pix.models;

public class PixResponse {
    private String id;
    private String status;
    private String brCode;
    private String brCodeBase64;

    public PixResponse() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getBrCode() { return brCode; }
    public void setBrCode(String brCode) { this.brCode = brCode; }

    public String getBrCodeBase64() { return brCodeBase64; }
    public void setBrCodeBase64(String brCodeBase64) { this.brCodeBase64 = brCodeBase64; }
}
