package com.example.perpustakaan;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class Skripsi extends AppCompatActivity {

    private RecyclerView lvjudul;

    private RequestQueue requestQueue;
    private StringRequest stringRequest;

    ArrayList<HashMap<String, String>> list_data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skripsi);
        String url = "http://192.168.0.100/buku/api/skripsi.php";

        lvjudul = (RecyclerView) findViewById(R.id.lvJudul);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        lvjudul.setLayoutManager(llm);

        requestQueue = Volley.newRequestQueue(Skripsi.this);

        list_data = new ArrayList<HashMap<String, String>>();

        stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("response ", response);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray = jsonObject.getJSONArray("hasil");
                    for (int a = 0; a < jsonArray.length(); a++) {
                        JSONObject json = jsonArray.getJSONObject(a);
                        HashMap<String, String> map = new HashMap<String, String>();
                        map.put("id", json.getString("id"));
                        map.put("judul", json.getString("judul"));
                        map.put("penulis", json.getString("penulis"));
                        map.put("penerbit", json.getString("penerbit"));
                        map.put("tahun_terbit", json.getString("tahun_terbit"));
                        map.put("file_skripsi", json.getString("file_skripsi"));
                        list_data.add(map);
                        AdapterListSkripsi adapter = new AdapterListSkripsi(Skripsi.this, list_data);
                        lvjudul.setAdapter(adapter);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Skripsi.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue.add(stringRequest);
    }

    public void Home (View v) {
        Intent intent = new Intent(Skripsi.this, MainActivity.class);
        startActivity(intent);
    }
}
