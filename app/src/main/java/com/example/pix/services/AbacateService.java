package com.example.pix.services;

import com.example.pix.models.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import okhttp3.*;

import java.io.IOException;
import java.math.BigDecimal;

public class AbacateService {

    private final String apiKey;
    private final String baseUrl = "https://api.abacatepay.com/v1";
    private final ObjectMapper mapper = new ObjectMapper();
    private final OkHttpClient client = new OkHttpClient();

    public AbacateService(String apiKey) {
        this.apiKey = apiKey;
    }

    public PixResponse createPix(PixRequest request) throws IOException {
        // Converte amount para BigDecimal
        BigDecimal amount = BigDecimal.valueOf(request.getAmount());

        // Validação mínima
        if (amount.compareTo(BigDecimal.valueOf(100)) < 0) {
            throw new IllegalArgumentException("Valor do PIX deve ser >= 100 centavos (R$1,00)");
        }

        // Monta request para Abacate
        AbacateCreatePixRequest body = new AbacateCreatePixRequest();
        body.setAmount(amount);
        body.setDescription(request.getDescription());

        if (request.getCustomerName() != null || request.getCustomerEmail() != null) {
            Customer c = new Customer();
            c.setName(request.getCustomerName());
            c.setEmail(request.getCustomerEmail());
            body.setCustomer(c);
        }

        String json = mapper.writeValueAsString(body);

        Request httpRequest = new Request.Builder()
                .url(baseUrl + "/pixQrCode/create")
                .addHeader("Authorization", "Bearer " + apiKey)
                .addHeader("Content-Type", "application/json")
                .post(RequestBody.create(json, MediaType.parse("application/json")))
                .build();

        Response response = client.newCall(httpRequest).execute();

        if (!response.isSuccessful()) {
            throw new IOException("Erro na API AbacatePay: " + response.code() + " - " + response.body().string());
        }

        AbacateCreatePixResponse abacateResp = mapper.readValue(response.body().string(), AbacateCreatePixResponse.class);

        PixResponse out = new PixResponse();
        if (abacateResp.getData() != null) {
            out.setStatus(abacateResp.getData().getStatus());
            out.setBrCode(abacateResp.getData().getBrCode());
            out.setBrCodeBase64(abacateResp.getData().getBrCodeBase64());
        }
        return out;
    }
}
