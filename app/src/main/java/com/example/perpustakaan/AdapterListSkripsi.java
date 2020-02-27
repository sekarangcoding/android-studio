package com.example.perpustakaan;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;

public class AdapterListSkripsi extends RecyclerView.Adapter<AdapterListSkripsi.ViewHolder>{

    Context context;
    ArrayList<HashMap<String, String>> list_data;

    public AdapterListSkripsi(Skripsi mainActivity, ArrayList<HashMap<String, String>> list_data) {
        this.context = mainActivity;
        this.list_data = list_data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, null);
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

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtjudul;

        public ViewHolder(View itemView) {
            super(itemView);

            txtjudul = (TextView) itemView.findViewById(R.id.txtjudul);
            txtjudul.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Integer pos = Integer.parseInt(txtjudul.getTag().toString())-1;
                    Intent intent = new Intent(context, Skripsi_Detail.class);
                    intent.putExtra("id", list_data.get(pos).get("id"));
                    intent.putExtra("judul", list_data.get(pos).get("judul"));
                    intent.putExtra("penulis", list_data.get(pos).get("penulis"));
                    intent.putExtra("penerbit", list_data.get(pos).get("penerbit"));
                    intent.putExtra("tahun_terbit", list_data.get(pos).get("tahun_terbit"));
                    intent.putExtra("file_skripsi", list_data.get(pos).get("file_skripsi"));
                    context.startActivity(intent);
                }
            });
        }
    }
}

