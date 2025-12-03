package com.example.pix;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.pix.models.PixRequest;
import com.example.pix.models.PixResponse;
import com.example.pix.services.AbacateService;

import java.util.Base64;

public class PixActivity extends AppCompatActivity {

    private AbacateService abacateService;
    private ImageView qrImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pix);

        qrImageView = findViewById(R.id.qrImageView);

        // Inicializa o serviço com sua API Key
        abacateService = new AbacateService("SUA_API_KEY_AQUI");

        // Cria o PixRequest
        PixRequest request = new PixRequest();
        request.setAmount(150); // valor em centavos
        request.setDescription("Pagamento teste");
        request.setCustomerName("Fulano");
        request.setCustomerEmail("fulano@email.com");

        // Chama a API em background thread
        new Thread(() -> {
            try {
                PixResponse response = abacateService.createPix(request);

                if (response.getBrCodeBase64() != null && response.getBrCodeBase64().contains(",")) {
                    String base64Data = response.getBrCodeBase64().split(",")[1];
                    byte[] imageBytes = Base64.getDecoder().decode(base64Data);
                    Bitmap bitmap = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);

                    runOnUiThread(() -> qrImageView.setImageBitmap(bitmap));
                } else {
                    runOnUiThread(() ->
                            Toast.makeText(PixActivity.this, "Erro: QR code não gerado", Toast.LENGTH_SHORT).show()
                    );
                }

            } catch (Exception e) {
                e.printStackTrace();
                runOnUiThread(() ->
                        Toast.makeText(PixActivity.this, "Erro ao criar Pix: " + e.getMessage(), Toast.LENGTH_LONG).show()
                );
            }
        }).start();
    }
}
