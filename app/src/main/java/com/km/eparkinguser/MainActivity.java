package com.km.eparkinguser;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class MainActivity extends AppCompatActivity {
    private ImageView qrCodeImage;
    private TextView userName, bikeName, bikeNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initIds();

        setData();
    }

    private void initIds() {
        qrCodeImage = findViewById(R.id.qr_code_image);
        userName = findViewById(R.id.user_name);
        bikeName = findViewById(R.id.bike_name);
        bikeNumber = findViewById(R.id.bike_number);
    }

    private void setData() {
        String[] userDetails = new AppPreferences(this).getUserDetails().split("~/");

        String name = userDetails[0];
        String bikeModel = userDetails[2];
        String licenceNumber = userDetails[3];

        userName.setText(name);
        bikeName.setText(bikeModel);
        bikeNumber.setText(licenceNumber);

        generateAndSetQRCode(name + bikeModel + licenceNumber);
    }


    private void generateAndSetQRCode(String content) {
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        try {
            BitMatrix bitMatrix = multiFormatWriter.encode(content, BarcodeFormat.QR_CODE, 200, 200);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
            qrCodeImage.setImageBitmap(bitmap);
        } catch (WriterException e) {
            e.printStackTrace();
        }
    }
}
