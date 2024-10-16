package com.example.sharedfreferences;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Timer;

public class MainActivity extends AppCompatActivity {
    EditText edtHoten,edtCmnd,edtBosung;
    Button btnGui;
    RadioGroup idGroup;
    CheckBox chkDocsach, chkDocbao,chkCoding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
    // anh xa
        edtHoten = findViewById(R.id.edtHoten);
        edtCmnd = findViewById(R.id.edtCmnd);
        edtBosung = findViewById(R.id.edtBosung);
        btnGui = findViewById(R.id.btnGui);
        idGroup = findViewById(R.id.idGroup);
        chkDocbao = findViewById(R.id.chkDocbao);
        chkDocsach = findViewById(R.id.chkDocsach);
        chkCoding = findViewById(R.id.chkCoding);
    // xu ly su kien
        btnGui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // lay thong tin ho ten
                String hoten = edtHoten.getText().toString();
                if (hoten.length() < 3){
                    // day thong bao
                    Toast.makeText(MainActivity.this, "Họ tên phải >=3 ký tự", Toast.LENGTH_LONG).show();
                    edtHoten.requestFocus();
                    edtHoten.selectAll();
                    return;
                }
                // lay thong tin CMNH
                String CMND = edtCmnd.getText().toString();
                if (edtCmnd.length() != 9){
                    Toast.makeText(MainActivity.this, "CMND phải có 9 số !", Toast.LENGTH_LONG).show();
                    edtCmnd.requestFocus();
                    edtCmnd.selectAll();
                    return;
                }
                // lay thong tin bang cap
                int idselect = idGroup.getCheckedRadioButtonId();
                RadioButton radselect = findViewById(idselect);
                String bangcap = radselect.getText().toString();
                // lay thong tin so thich
                String sothich = "";
                if (chkDocbao.isChecked())
                    sothich += chkDocbao.getText().toString() + " - ";
                if (chkDocsach.isChecked())
                    sothich += chkDocsach.getText().toString() + " - ";
                if (chkCoding.isChecked())
                    sothich += chkCoding.getText().toString();

                // lay thong tin bo sung
                String bosung = edtBosung.getText().toString();
                String Tonghop = hoten + "\n" + CMND + "\n" + bangcap + "\n" + sothich + "\n";
                Tonghop +=  "-------------THÔNG TIN BỔ SUNG--------------\n";
                Tonghop += bosung +"\n";
                Tonghop += "---------------------------------------------";

                //tao dialog va hien thi thong tin len
                AlertDialog.Builder myDialog = new AlertDialog.Builder(MainActivity.this);
                myDialog.setTitle("THÔNG TIN CÁ NHÂN");
                myDialog.setMessage(Tonghop);
                myDialog.setPositiveButton("Đóng", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                myDialog.create().show();
            }

        });
    }
    //tao hop thoai thong bao khi thoat

    @Override
    public void onBackPressed() {
        //tao hop thoai
        AlertDialog.Builder mydialog = new AlertDialog.Builder(MainActivity.this);
        mydialog.setTitle("Question");
        mydialog.setIcon(R.drawable.canhbao);
        mydialog.setMessage("Bạn có muốn thoát không ?");
        mydialog.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish(); //thoat ung dung
            }
        });
        mydialog.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which) {
                dialogInterface.cancel();
            }
        });
mydialog.create().show();//hien thi Dialog
    }
}