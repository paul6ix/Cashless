package com.example.paulchidi.cashless.activities;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
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
    EditText editText_QrDataName;
    EditText editText_QrDataAcctNo;
    EditText editText_QrDataAmount;
    String qrData;
    String qrMessage;
    String acct;
    String name;
    String amount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generator);
        imageView_QrCode = (ImageView) findViewById(R.id.imageView_QrCode);
        editText_QrDataName = (EditText) findViewById(R.id.editText_accountname);
        editText_QrDataAcctNo = (EditText) findViewById(R.id.editText_accountnum);
        editText_QrDataAmount = (EditText) findViewById(R.id.editText_amount);
        button_QrCode = (Button) findViewById(R.id.button_generate);
        button_QrCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                amount = editText_QrDataAmount.getText().toString();
                name = editText_QrDataName.getText().toString();
                acct = editText_QrDataAcctNo.getText().toString();
                //to hide keyboard
                if (view != null) {
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
                }
                //end hide keyboard code
                qrMessage = "Do you wish to transfer #" + amount + " to " + name.toUpperCase() + " with account Number: " + acct;
                AlertDialog.Builder dialog = new AlertDialog.Builder(GeneratorActivity.this);
                dialog.setTitle("Confirmation");
                dialog.setMessage(qrMessage);
                dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        MultiFormatWriter formatWriter = new MultiFormatWriter();
                        qrData = "Account Name: " + name + "\nAccount No: " + acct + "\nAmount: " + amount;
                        try {
                            BitMatrix bitMatrix = formatWriter.encode(qrData, BarcodeFormat.QR_CODE, 200, 200);
                            BarcodeEncoder encoder = new BarcodeEncoder();
                            Bitmap bitmap = encoder.createBitmap(bitMatrix);
                            imageView_QrCode.setImageBitmap(bitmap);


                        } catch (Exception e) {
                            e.printStackTrace();
                        }


                    }
                });
                dialog.setNegativeButton("Cancel", null);
                dialog.show();


            }
        });
    }
}
