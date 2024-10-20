package com.example.customlview;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SubActivity extends AppCompatActivity {
    TextView txtSubphone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sub);
        //
        txtSubphone =findViewById(R.id.txtSubphone);
        Intent myintent = new Intent();
        //
        String namephone = myintent.getStringExtra("name");
        txtSubphone.setText(namephone);
    }
}