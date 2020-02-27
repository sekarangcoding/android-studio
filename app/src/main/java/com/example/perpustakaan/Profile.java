package com.example.perpustakaan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;

public class Profile extends AppCompatActivity {

    Button btnPass,btnExit;
    TextView txtnama,txtnim,txtkelas,txtjurusan,txttahun;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        btnPass = (Button) findViewById(R.id.Password);
        btnExit = (Button) findViewById(R.id.Exit);
        txtnama = (TextView)findViewById(R.id.txtNama);
        txtnim = (TextView)findViewById(R.id.txtNim);
        txtkelas = (TextView)findViewById(R.id.txtKelas);
        txtjurusan = (TextView)findViewById(R.id.txtJurusan);
        txttahun = (TextView)findViewById(R.id.txtTahun);

//        sessionManager = new SessionManager(getApplicationContext());
//        HashMap<String, String> user = sessionManager.getUserDetails();
//        String nim = user.get(SessionManager.kunci_username);
//        String nama = user.get(SessionManager.kunci_nama);
//
//        txtnim.setText(nim);
//        txtnama.setText(nama);

        btnPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Profile.this, Password.class);
                startActivity(i);
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    public void Home(View v) {
        Intent intent = new Intent(Profile.this, MainActivity.class);
        startActivity(intent);
    }
}
