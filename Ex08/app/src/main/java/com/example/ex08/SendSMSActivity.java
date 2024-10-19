package com.example.ex08;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SendSMSActivity extends AppCompatActivity {
    EditText edtSMS;
    ImageButton btnSMS;
    Button btnBack2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_send_smsactivity);
       //
        edtSMS = findViewById(R.id.edtSMS);
        btnSMS = findViewById(R.id.btnSMS);
        btnBack2 = findViewById(R.id.btnback2);
        //
        btnSMS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // khai bao intent an goi den ung dung gui tin nhan
                Intent smsIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:"+edtSMS.getText().toString()));
                startActivity(smsIntent);
            }
        });
        btnBack2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}