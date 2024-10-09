package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    //Khai báo các biến giao diện
    EditText edtF,edtC;
    Button btnF,btnC,btnXoa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //Ánh xạ ID
    edtC = findViewById(R.id.edtC);
    edtF = findViewById(R.id.btnF);
    btnC = findViewById(R.id.btnC);
    btnF = findViewById(R.id.btnF);
    btnXoa = findViewById(R.id.btnXoa);

    //Xử lý click
        btnF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DecimalFormat dcf = new DecimalFormat("0.00"); // làm tròn đến chữ số.
                int c = Integer.parseInt(edtC.getText().toString());
                double f = c * 1.8 + 32;
                edtF.setText(dcf.format(f)+"");
            }
        });

        btnC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DecimalFormat dcf = new DecimalFormat("0.00"); // làm tròn đến chữ số.
                int f = Integer.parseInt(edtF.getText().toString());
                double c = (f-32)/1.8;
                edtC.setText(dcf.format(c)+"");
            }
        });

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtF.setText("");
                edtC.setText("");
            }
        });
    }
}