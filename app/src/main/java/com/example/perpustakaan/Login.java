package com.example.perpustakaan;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.session.MediaSession;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;
public class Login extends AppCompatActivity {

    EditText user, pass;
    Button login;
    SharedPrefManager sharedPrefManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        user = findViewById(R.id.Username);
        pass = findViewById(R.id.Password);
        login = findViewById(R.id.button);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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
                            // Mengambil variable status pada response
                            String status = json.getString("status");
                            if(status.equals("success")){

//                                String token = sharedPrefManager.getSpToken();
////                                Log.d("tes", token.getToken());
//
//                                sharedPrefManager.saveToken(SharedPrefManager.SP_TOKEN, token);
//                                sharedPrefManager.getSpToken();
////                                Log.d("token", sharedPrefManager.getSpToken());
//
//
//                                sharedPrefManager.saveSPBoolean(SharedPrefManager.SP_SUDAH_LOGIN, true);

                                // Jika Login Sukses Maka pindah ke activity lain.
                                Intent intent = new Intent(Login.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                            }
                            else{
                                Toast.makeText(getApplicationContext(), "Username & Password Salah", Toast.LENGTH_LONG).show();
                            }
                        } catch (JSONException e) {
//                            e.printStackTrace();
                            Toast.makeText(Login.this, "Error " +e.toString(),Toast.LENGTH_SHORT).show();
                        }
                    }
                },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();

            }
        }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> params = new HashMap<>();
                params.put("username", user.getText().toString());
                params.put("password", pass.getText().toString());
                return params;
            }
        };
        // Buat antrian request pada cache android
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        // Tambahkan Request pada antrian request
        requestQueue.add(loginRequest);
    }

}
