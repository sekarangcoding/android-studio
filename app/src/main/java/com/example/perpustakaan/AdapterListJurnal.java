package com.example.perpustakaan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;

public class AdapterListJurnal extends RecyclerView.Adapter<AdapterListJurnal.ViewHolder>{

    Context context;
    ArrayList<HashMap<String, String>> list_data;

    public AdapterListJurnal(Jurnal mainActivity, ArrayList<HashMap<String, String>> list_data) {
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
        }
    }
}

