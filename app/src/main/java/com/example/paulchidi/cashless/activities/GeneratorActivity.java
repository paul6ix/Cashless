package com.example.paulchidi.cashless.activities;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.paulchidi.cashless.R;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class GeneratorActivity extends AppCompatActivity {
    ImageView imageView_QrCode;
    Button button_QrCode;
    EditText editText_QrData;
    String text2QR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generator);
        imageView_QrCode = (ImageView) findViewById(R.id.imageView_QrCode);
        editText_QrData = (EditText) findViewById(R.id.editText_generate);
        button_QrCode = (Button) findViewById(R.id.button_generate);
        button_QrCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MultiFormatWriter formatWriter = new MultiFormatWriter();
                text2QR = editText_QrData.getText().toString();
                try {
                    BitMatrix bitMatrix = formatWriter.encode(text2QR, BarcodeFormat.QR_CODE, 200, 200);
                    BarcodeEncoder encoder = new BarcodeEncoder();
                    Bitmap bitmap = encoder.createBitmap(bitMatrix);
                    imageView_QrCode.setImageBitmap(bitmap);


                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        });
    }
}
