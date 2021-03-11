package com.example.lab3.controller;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab3.R;
import com.example.lab3.model.Country;
import com.example.lab3.model.ViewHolder;

import java.util.ArrayList;

public class ItemRecycleViewer extends RecyclerView.Adapter<ViewHolder> {

    private int layout_view;
    private ArrayList<Country> countryList;

    public ItemRecycleViewer(int id, ArrayList<Country> countryList) {
        this.layout_view = layout_view;
        this.countryList = countryList;

}

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layout_view,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TextView name = holder.name;
        TextView country = holder.country;
        name.setText(countryList.get(position).name);
        country.setText(countryList.get(position).capital);
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}