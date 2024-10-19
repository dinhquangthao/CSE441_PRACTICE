package com.example.listviewcb;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    //
    TextView txt_select;
    ListView lv1;
    //data
    String myPhone[] = {"Điện thoại Samsung","Điện thoại Iphone","Điện thoại Oppo","Điện thoại Nokia","Điện thoại Bphone"};
    ArrayAdapter<String> myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        //
        txt_select = findViewById(R.id.txt_select);
        lv1 = findViewById(R.id.lv1);
        myAdapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, myPhone);
        lv1.setAdapter(myAdapter);
        //bat xu kien vao item listview
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                txt_select.setText("Vị trí: "+i +" "+ myPhone[i]);
            }
        });
    }
}