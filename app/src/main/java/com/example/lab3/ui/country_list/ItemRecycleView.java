package com.example.lab3.ui.country_list;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lab3.model.Country;
import com.example.lab3.model.ViewHolder;

import java.util.ArrayList;

public class ItemRecycleView extends RecyclerView.Adapter<ViewHolder> {

    private int layout_id;
    private ArrayList<Country> countryList;

    public ItemRecycleView(int id, ArrayList<Country> countryList){
        this.layout_id=id;
        this.countryList=countryList;

    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(layout_id,parent,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        TextView name = holder.name;
        TextView country = holder.country;

        name.setText(countryList.get(position).name);
        country.setText(countryList.get(position).capital);

    }



    @Override
    public int getItemCount() {
        return countryList.size();
    }
}
