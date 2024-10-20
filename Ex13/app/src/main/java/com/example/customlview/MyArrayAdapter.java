package com.example.customlview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class MyArrayAdapter extends ArrayAdapter<Phone> {
    Activity context;
    int Idlayout;
    ArrayList<Phone> myList;
    //constructor de MainActivity goi den va truyen cac tha so vao

    public MyArrayAdapter( Activity context, int idLayout, ArrayList<Phone> myList) {
        super(context, idLayout,myList);
        this.context = context;
        this.Idlayout = idLayout;
        this.myList = myList;
    }
    // goi ham getView de tien hanh sap xep du lieu


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // tao de chua layout
        LayoutInflater myflacter = context.getLayoutInflater();
        // dat idlayout len de de tao thanh View
        convertView = myflacter.inflate(Idlayout,null);
        //lay 1 phan tu trong mang
        Phone myphone = myList.get(position);
        //khai bao tham chieu id va hien thi anh len ImageView
        ImageView imgPhone = convertView.findViewById(R.id.imgPhone);
        imgPhone.setImageResource(myphone.getImage());
        //khai bao tham chieu id va hien thi ten dien thoai len txtView
        TextView txtPhone =  convertView.findViewById(R.id.txtPhone);
        txtPhone.setText(myphone.getName());
        return convertView;
    }
}
