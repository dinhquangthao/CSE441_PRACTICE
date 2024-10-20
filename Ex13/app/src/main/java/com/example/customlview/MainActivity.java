package com.example.customlview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int image[] = {R.drawable.iphone16,R.drawable.samsung,R.drawable.lg,R.drawable.bphone,R.drawable.xiaomi};
    String name[] = {"Điện thoại Iphone","Điện thoại SamSung","Điện thoại LG","Điện Thoại Bphone","Điện thoại Xiaomi"};
    // khai bao listVIew
    ArrayList<Phone> myList;
    MyArrayAdapter myAdapter;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        lv = findViewById(R.id.lv);
        myList = new ArrayList<>();// mang rong
        for(int i = 0; i<name.length;i++){
            myList.add(new Phone(image[i], name[i]));
        }
        myAdapter = new MyArrayAdapter(MainActivity.this,R.layout.layout_item, myList);
        lv.setAdapter(myAdapter);
        //xu ly click
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent myintent = new Intent(MainActivity.this,SubActivity.class);
                myintent.putExtra("name",name[i]);
                startActivity(myintent);
            }
        });
    }
}