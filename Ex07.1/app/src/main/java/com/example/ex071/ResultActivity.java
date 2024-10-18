package com.example.ex071;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResultActivity extends AppCompatActivity {
    TextView txt_nghiem;
    Button btnback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_result);
        // anh xa
        txt_nghiem = findViewById(R.id.txtNghiem);
        btnback = findViewById(R.id.btnBack);
       // nhan Intent
          Intent myIntent = getIntent();
        // lay bundel khoi Intent
          Bundle myBundel = myIntent.getBundleExtra("mypackage");
        // lay du lieu ra khoi Bundle
        int a = myBundel.getInt("soa");
        int b = myBundel.getInt("sob");
       //tien hanh giai phuong trinh va hien thi ket qua
        String nghiem = "";
        if(a == 0 && b == 0){
            nghiem = "Phuong trinh vo so nghiem";
        }
        else if(a == 0 && b != 0){
            nghiem = "Phuong trinh vo nghiem";
        }
        else
        {
            nghiem = "Nghiem PT = " + (-1.0)*b/a;
        }
        txt_nghiem.setText(nghiem);

    }
}