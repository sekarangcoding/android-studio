package com.example.perpustakaan;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
public class Login extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    EditText user, pass;
    String id,username,password,nama,jurusan,tahun_angkatan,kelas;
    Boolean session = false;
    Button login;

    private static final String TAG = Login.class.getSimpleName();

    private static final String session_status = "session_status";
    public static final String my_shared_preferences = "my_shared_preferences";

    private final static String TAG_ID = "id";
    private final static String TAG_USERNAME = "username";
    private final static String TAG_NAMA = "nama";
    private final static String TAG_JURUSAN = "jurusan";
    private final static String TAG_TAHUN_ANGKTAN  = "tahun_angkatan";
    private final static String TAG_KELAS = "kelas";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user = findViewById(R.id.Username);
        pass = findViewById(R.id.Password);
        login = findViewById(R.id.button);

        // cek session login
        sharedPreferences = getSharedPreferences(my_shared_preferences, Context.MODE_PRIVATE);
        session = sharedPreferences.getBoolean(session_status, false);

        id = sharedPreferences.getString(TAG_ID, null);
        username = sharedPreferences.getString(TAG_USERNAME, null);
        nama = sharedPreferences.getString(TAG_NAMA, null);
        jurusan = sharedPreferences.getString(TAG_JURUSAN, null);
        tahun_angkatan = sharedPreferences.getString(TAG_TAHUN_ANGKTAN, null);
        kelas = sharedPreferences.getString(TAG_KELAS, null);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                String txtUser =  user.getText().toString();
//                String txtPass =  pass.getText().toString();
//                if (TextUtils.isEmpty(txtUser) || TextUtils.isEmpty(txtPass) ) {
//                    Toast.makeText(Login.this, "All field Request", Toast.LENGTH_SHORT).show();
//                }else {
//
//                    Login(txtUser,txtPass);
//
//                }
                Login();
            }


        });

    }

    public void Login() {
        StringRequest loginRequest = new StringRequest(Request.Method.POST, "http://192.168.0.100/buku/api/login.php",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject json = new JSONObject(response);
                            String status = json.getString("status");
                            if (status.equals("success")) {

                                // menyimpan login ke session
                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                editor.putBoolean(session_status, false);
                                editor.putString(TAG_ID, id);
                                editor.putString(TAG_USERNAME, username);
                                editor.putString(TAG_NAMA, nama);
                                editor.putString(TAG_JURUSAN, jurusan);
                                editor.putString(TAG_TAHUN_ANGKTAN, tahun_angkatan);
                                editor.putString(TAG_KELAS, kelas);
                                editor.commit();



                                Intent intent = new Intent(Login.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                            } else {
                                Toast.makeText(getApplicationContext(), "Username & Password Salah", Toast.LENGTH_LONG).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                }
        ) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> params = new HashMap<>();
                params.put("username", user.getText().toString());
                params.put("password", pass.getText().toString());
                return params;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(loginRequest);
    }
}
