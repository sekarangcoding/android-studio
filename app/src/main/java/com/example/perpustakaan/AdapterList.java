package com.example.perpustakaan;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;

public class AdapterList extends RecyclerView.Adapter<AdapterList.ViewHolder>{

    Context context;
    ArrayList<HashMap<String, String>> list_data;

    public AdapterList(Buku mainActivity, ArrayList<HashMap<String, String>> list_data) {
        this.context = mainActivity;
        this.list_data = list_data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, null);
        //object ViewHolder
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txtjudul.setText(list_data.get(position).get("judul"));
        holder.txtjudul.setTag(list_data.get(position).get("id"));
    }

    @Override
    public int getItemCount() {
        return list_data.size();
    }

    public void getItemCount(int position) {

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtjudul;
        public ViewHolder(View itemView) {
            super(itemView);

            txtjudul = (TextView) itemView.findViewById(R.id.txtjudul);
            txtjudul.setOnClickListener( new View.OnClickListener() {


//                @Override

                public void onClick(View v) {
                    //Toast.makeText(context,txtjudul.getTag().toString(),Toast.LENGTH_SHORT).show();
                    Integer pos = Integer.parseInt(txtjudul.getTag().toString())-1;
                    Intent intent = new Intent(context, DetailBuku.class);
                      intent.putExtra("id", list_data.get(pos).get("id"));
                      intent.putExtra("judul", list_data.get(pos).get("judul"));
                      intent.putExtra("penulis", list_data.get(pos).get("penulis"));
                      intent.putExtra("penerbit", list_data.get(pos).get("penerbit"));
                      intent.putExtra("tahun_terbit", list_data.get(pos).get("tahun_terbit"));
                      intent.putExtra("isbn", list_data.get(pos).get("isbn"));
                      intent.putExtra("file_buku", list_data.get(pos).get("file_buku"));
                      context.startActivity(intent);
                }
            });
        }
    }
}

