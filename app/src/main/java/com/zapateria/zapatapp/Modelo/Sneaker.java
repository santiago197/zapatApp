package com.zapateria.zapatapp.Modelo;

import com.zapateria.zapatapp.R;

public class Sneaker {
    private int id;
    private String name;

    private int idDrawable;

    public Sneaker(int id, String name, int idDrawable){
        this.id=id;
        this.name=name;
        this.idDrawable=idDrawable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdDrawable() {
        return idDrawable;
    }

    public void setIdDrawable(int idDrawable) {
        this.idDrawable = idDrawable;
    }

    public static Sneaker[] ITEMS = {
            new Sneaker(1,"Adidas", R.drawable.adidas),
            new Sneaker(2,"Adidas", R.drawable.adidas),
            new Sneaker(3,"Adidas", R.drawable.adidas),
            new Sneaker(4,"Adidas", R.drawable.adidas),
            new Sneaker(5,"Adidas", R.drawable.adidas),
            new Sneaker(6,"Adidas", R.drawable.adidas),
            new Sneaker(7,"Adidas", R.drawable.adidas),
            new Sneaker(8,"Adidas", R.drawable.adidas),
            new Sneaker(9,"Adidas", R.drawable.adidas),
            new Sneaker(10,"Adidas", R.drawable.adidas),
    };
    public static Sneaker getItem(int id){
        for (Sneaker sneakerActual:ITEMS){
            if(sneakerActual.getId()==id){
                return sneakerActual;
            }
        }
        return null;
    }
}
