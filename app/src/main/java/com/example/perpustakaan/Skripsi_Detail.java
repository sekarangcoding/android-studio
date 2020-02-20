package com.example.perpustakaan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Skripsi_Detail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skripsi__detail);
    }

    public void Search(View v) {
        Intent intent = new Intent(Skripsi_Detail.this, Skripsi.class);
        startActivity(intent);
    }

    public void Home(View v) {
        Intent intent = new Intent(Skripsi_Detail.this, MainActivity.class);
        startActivity(intent);
    }
}
