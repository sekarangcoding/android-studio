package com.example.perpustakaan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Jurnal_Detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jurnal__detail);
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
