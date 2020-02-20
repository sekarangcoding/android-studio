package com.example.perpustakaan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Buku (View v) {
        Intent intent = new Intent(MainActivity.this, Buku.class);
        startActivity(intent);
    }

    public void Skripsi (View v) {
        Intent intent = new Intent(MainActivity.this, Skripsi.class);
        startActivity(intent);
    }

    public void Jurnal (View v) {
        Intent intent = new Intent(MainActivity.this, Jurnal.class);
        startActivity(intent);
    }

    public void Profile (View v) {
        Intent intent = new Intent(MainActivity.this, Profile.class);
        startActivity(intent);

    }
}
