package com.example.prac1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class InforActivity extends AppCompatActivity {

    EditText edtHoten,edtGpa;
    Button btnSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_infor);
        //
        edtHoten = findViewById(R.id.edtHoten);
        edtGpa = findViewById(R.id.edtGPA);
        btnSubmit = findViewById(R.id.btnSubmit);
        //
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //lay du lieu
                String hoten = edtHoten.getText().toString();
                Double GPA = Double.valueOf(edtGpa.getText().toString());
                //khai bao
                Intent myIntent2 = new Intent(InforActivity.this,MainActivity.class);

//                // tao goi Bundle
//                Bundle myBundle = new Bundle();
//                // Dua du lieu vao Bundle
//                myBundle.putString("hoten",hoten);
//                myBundle.putDouble("gpa",GPA);
//                // dua bundle vap Intent
//                myIntent2.putExtra("Groot",myBundle);
//                //khoi dong
//                startActivity(myIntent2);
                myIntent2.putExtra("hoten",hoten);
                myIntent2.putExtra("gpa",GPA);
                startActivity(myIntent2);
            }
        });

    }
}