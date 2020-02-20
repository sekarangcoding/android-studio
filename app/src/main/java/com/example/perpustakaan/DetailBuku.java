package com.example.perpustakaan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DetailBuku extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_buku);

    }

    public void Search(View v) {
        Intent intent = new Intent(DetailBuku.this, Buku.class);
        startActivity(intent);
    }

    public void Home(View v) {
        Intent intent = new Intent(DetailBuku.this, MainActivity.class);
        startActivity(intent);
    }
}
