package com.example.lab3.model;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;
import com.example.lab3.R;

public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private String TAG = "VIEW HOLDER";

    public TextView name;
    public TextView country;

    public ViewHolder(View viewItem){
        super(viewItem);
        viewItem.setOnClickListener(this);
        name = viewItem.findViewById(R.id.text_name);
        country = viewItem.findViewById(R.id.text_capital);
    }
    @Override
    public void onClick(View view) {

        Log.i(TAG,"clicked");
        Navigation.findNavController(itemView).navigate(R.id.action_navigation_notifications_to_detailsFragment);
    }
}
