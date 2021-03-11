package com.example.lab3.ui.country_list;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.lab3.R;
import com.example.lab3.model.Country;
import com.example.lab3.controller.ItemRecycleViewer;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.CookieHandler;
import java.util.ArrayList;

public class CountryListFragment extends Fragment {

    private CountryListViewModel countryListViewModel;
    private RecyclerView recyclerView;
    private ArrayList<Country> countryList;
    private RecyclerView.Adapter adapter;
    private ItemRecycleView itemRecycleView;
    private RequestQueue queue;

    private String URL = "https://restcountries.eu/rest/v1/all";

    public View onCreateView(@NonNull LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState){
        countryListViewModel = new ViewModelProvider(this).get(CountryListViewModel.class);
        View root = inflater.inflate(R.layout.fragment_countries,container,false);

        queue = Volley.newRequestQueue(getContext());
        countryList = new ArrayList<>();
        adapter = new ItemRecycleView(R.layout.cardview_layout,countryList);

        recyclerView = root.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        loadCountryData();

        return root;
    }



    private void loadCountryData() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, URL,
                new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray array = new JSONArray(response);
                            Log.i("PGB_X", "size: " + String.valueOf(array.length()));
                            for (int i = 0; i < array.length(); i++) {
                                JSONObject jsonData = array.getJSONObject(i);
                                String name = jsonData.getString("name");
                                String capital = jsonData.getString("capital");
                                Country country = new Country(name, capital);
                                countryList.add(country);
                            }

                            recyclerView.setAdapter(adapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        queue.add(stringRequest);
    }


    }