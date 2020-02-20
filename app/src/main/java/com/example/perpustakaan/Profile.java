package com.example.perpustakaan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Profile extends AppCompatActivity {

    Button btnPass;
    TextView txtnama,txtnim,txtkelas,txtjurusan,txttahun;
    String nama,nim,kelas,jurusan,tahun;
    SharedPreferences sharedPreferences;
    public static final String TAG_ID = "id";
    private final static String TAG_USERNAME = "username";
    private final static String TAG_PASSWORD = "password";
    private final static String TAG_NAMA = "nama";
    private final static String TAG_JURUSAN = "jurusan";
    private final static String TAG_TAHUN_ANGKTAN  = "tahun_angkatan";
    private final static String TAG_KELAS = "kelas";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        btnPass = (Button) findViewById(R.id.Password);
        txtnama = (TextView)findViewById(R.id.txtNama);
        txtnim = (TextView)findViewById(R.id.txtNim);
        txtkelas = (TextView)findViewById(R.id.txtKelas);
        txtjurusan = (TextView)findViewById(R.id.txtJurusan);
        txttahun = (TextView)findViewById(R.id.txtTahun);

        sharedPreferences = getSharedPreferences(Login.my_shared_preferences, Context.MODE_PRIVATE);

        nama = getIntent().getStringExtra(TAG_NAMA);
        nim = getIntent().getStringExtra(TAG_USERNAME);
        tahun = getIntent().getStringExtra(TAG_TAHUN_ANGKTAN);
        jurusan = getIntent().getStringExtra(TAG_JURUSAN);
        kelas = getIntent().getStringExtra(TAG_KELAS);

        txtnama.setText(nama);
        txtnim.setText(nim);
        txttahun.setText(tahun);
        txtjurusan.setText(jurusan);
        txtkelas.setText(kelas);



        btnPass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Profile.this, Password.class);
                startActivity(i);
            }
        });




    }

    public void Home(View v) {
        Intent intent = new Intent(Profile.this, MainActivity.class);
        startActivity(intent);
    }

    public void Exit(View v) {
        Intent intent = new Intent(Profile.this, Login.class);
        startActivity(intent);
    }
}
