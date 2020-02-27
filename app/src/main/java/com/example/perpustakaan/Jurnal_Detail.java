package com.example.perpustakaan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Jurnal_Detail extends AppCompatActivity {

    TextView tv1,tv2,tv3,tv4,tv5,tv6;
    Button btnBaca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jurnal__detail);

        tv1 = (TextView) findViewById(R.id.txtjudul);
        tv2 = (TextView) findViewById(R.id.txtPenulis);
        tv3 = (TextView) findViewById(R.id.txtPenerbit);
        tv4 = (TextView) findViewById(R.id.txtISSN);
        tv5 = (TextView) findViewById(R.id.txtTahun);
        tv6 = (TextView) findViewById(R.id.txtFile);
        btnBaca = (Button) findViewById(R.id.button2);

        tv1.setText(getIntent().getStringExtra("judul"));
        tv2.setText(getIntent().getStringExtra("penulis"));
        tv3.setText(getIntent().getStringExtra("penerbit"));
        tv4.setText(getIntent().getStringExtra("issn"));
        tv5.setText(getIntent().getStringExtra("tahun_terbit"));
        tv6.setText(getIntent().getStringExtra("file_jurnal"));

    }

    public void Search(View v) {
        Intent intent = new Intent(Jurnal_Detail.this, Jurnal.class);
        startActivity(intent);
    }

    public void Home(View v) {
        Intent intent = new Intent(Jurnal_Detail.this, MainActivity.class);
        startActivity(intent);
    }
}
