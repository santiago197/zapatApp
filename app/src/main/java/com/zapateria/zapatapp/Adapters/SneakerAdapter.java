package com.zapateria.zapatapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zapateria.zapatapp.Fragments.ProductosFragment;
import com.zapateria.zapatapp.Modelo.Sneaker;
import com.zapateria.zapatapp.R;

public class SneakerAdapter extends BaseAdapter {

    private Context context;

    public SneakerAdapter(Context context){
    this.context=context;

    }
    @Override
    public int getCount() {
        return Sneaker.ITEMS.length;
    }

    @Override
    public Sneaker getItem(int position) {
        return Sneaker.ITEMS[position];
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).getId();
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        if(view==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_grilla,parent,false);
        }
        ImageView imgSneaker = (ImageView) view.findViewById(R.id.sneakerImg);
        TextView nameSneaker = (TextView) view.findViewById(R.id.sneakerName);

        Sneaker item = getItem(position);
        imgSneaker.setImageResource(item.getIdDrawable());
        nameSneaker.setText(item.getName());

        return view;
    }
}
