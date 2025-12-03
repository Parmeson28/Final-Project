package com.example.pix.controller;

import com.example.pix.model.PixRequest;
import com.example.pix.service.AbacateService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Base64;

@RestController
@RequestMapping("/api/pix")
public class PixController {

    private final AbacateService abacateService;

    public PixController(AbacateService abacateService) {
        this.abacateService = abacateService;
    }

    @PostMapping("/qr")
    public ResponseEntity<byte[]> getPixQr(@RequestBody PixRequest req) {
        var pixResponse = abacateService.createPix(req);

        if (pixResponse.getBrCodeBase64() == null || !pixResponse.getBrCodeBase64().startsWith("data:image/png;base64,")) {
            return ResponseEntity.badRequest().build();
        }

        // Remove o prefixo "data:image/png;base64,"
        String base64Data = pixResponse.getBrCodeBase64().split(",")[1];

        // Decodifica o Base64 para bytes da imagem
        byte[] imageBytes = Base64.getDecoder().decode(base64Data);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);

        return ResponseEntity.ok()
                .headers(headers)
                .body(imageBytes);
    }
}
