package com.example.ex081;

import static android.provider.MediaStore.ACTION_IMAGE_CAPTURE;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    ImageButton btnCamera;
    ImageView imgvTrang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        //
        btnCamera = findViewById(R.id.btnCamera);
        imgvTrang = findViewById(R.id.imvTrang);
        //
        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //khai bao intent
                Intent cameraIntent = new Intent(ACTION_IMAGE_CAPTURE);
                // Yeu cau quyen truy cap vao camera
                if (ActivityCompat.checkSelfPermission(MainActivity.this,
                        android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
                {
                    ActivityCompat.requestPermissions(MainActivity.this,new
                            String[]{android.Manifest.permission.CAMERA}, 1);
                    return;
                }
                // khoi dong Intent va cho ket qua tra ve
                startActivityForResult(cameraIntent,99);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 99 && resultCode == Activity.RESULT_OK){
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imgvTrang.setImageBitmap(photo);
        }
    }
}