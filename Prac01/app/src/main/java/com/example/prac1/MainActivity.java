package com.example.prac1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    TextView txtHoten,txtGPA;
    Button btnStart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        //
        txtHoten = findViewById(R.id.txtHoten);
        txtGPA = findViewById(R.id.txtGPA);
        btnStart = findViewById(R.id.btnStart);
        //
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this,InforActivity.class);
                startActivity(myIntent);
            }
        });
        //nhan Intent
        Intent myintent = getIntent();

        if (myintent.hasExtra("hoten")){
            String hoten = myintent.getStringExtra("hoten");
            txtHoten.setText("Họ và tên: "+hoten);
        }
        else {
            txtHoten.setVisibility(View.GONE); // Ẩn TextView nếu không có giá trị GPA
        }

//        Double gpa = myintent.getDoubleExtra("gpa",0);

        if (myintent.hasExtra("gpa")) {
            Double gpa = myintent.getDoubleExtra("gpa",0);
            txtGPA.setText("GPA: " + gpa);
        } else {
            txtGPA.setVisibility(View.GONE); // Ẩn TextView nếu không có giá trị GPA
        }

    }
}