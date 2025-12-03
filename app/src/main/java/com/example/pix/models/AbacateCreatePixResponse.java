package com.example.pix.models;

public class AbacateCreatePixResponse {
    private Object error;
    private AbacateCreatePixData data;

    public AbacateCreatePixResponse() {}

    // Getters e setters
    public Object getError() { return error; }
    public void setError(Object error) { this.error = error; }

    public AbacateCreatePixData getData() { return data; }
    public void setData(AbacateCreatePixData data) { this.data = data; }
}
