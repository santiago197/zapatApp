package com.zapateria.zapatapp.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.zapateria.zapatapp.Adapters.SneakerAdapter;
import com.zapateria.zapatapp.Modelo.Sneaker;
import com.zapateria.zapatapp.R;
import com.zapateria.zapatapp.SneakerDetailActivity;
import com.zapateria.zapatapp.ui.home.HomeFragment;

public class ProductosFragment extends Fragment {

    private GridView gridView;
    private SneakerAdapter sneakerAdapter;

    public ProductosFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.listado_productos, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        gridView = getView().findViewById(R.id.grilla);
        sneakerAdapter = new SneakerAdapter(getContext());
        gridView.setAdapter(sneakerAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Sneaker item = (Sneaker) adapterView.getItemAtPosition(i);

                Intent intent = new Intent(getActivity(), SneakerDetailActivity.class);
                intent.putExtra("sneaker_id",item.getId());
                intent.putExtra("sneaker_title",item.getName());
                intent.putExtra("sneaker_description",item.getDescription());
                intent.putExtra("sneaker_img",item.getIdDrawable());
                startActivity(intent);

                Toast.makeText(getActivity().getApplicationContext(), "Se selecciono: " + item.getName(), Toast.LENGTH_LONG).show();
            }
        });


    }

}
