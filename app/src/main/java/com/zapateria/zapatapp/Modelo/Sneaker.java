package com.zapateria.zapatapp.Modelo;

import com.zapateria.zapatapp.R;

public class Sneaker {
    private int id;
    private String name;
    private String description;

    private int idDrawable;

    public Sneaker(int id, String name,String description, int idDrawable){
        this.id=id;
        this.name=name;
        this.description=description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static Sneaker[] ITEMS = {
            new Sneaker(1,"Adidas","Zapatillas Adidas las mejores del mercado", R.drawable.adidas),
            new Sneaker(2,"Adidas NMD R1","Zapatillas Adidas las mejores del mercado",  R.drawable.adidas_nmd),
            new Sneaker(3,"Runner", "Zapatillas Adidas las mejores del mercado", R.drawable.runner),
            new Sneaker(4,"Under Armour","Zapatillas Adidas las mejores del mercado",  R.drawable.under_armour),
            new Sneaker(5,"Nike", "Zapatillas Adidas las mejores del mercado", R.drawable.nike),
            new Sneaker(6,"Skeachers", "Zapatillas Adidas las mejores del mercado", R.drawable.skeachers),
            new Sneaker(7,"Adidas", "Zapatillas Adidas las mejores del mercado", R.drawable.adidas),
            new Sneaker(8,"Adidas", "Zapatillas Adidas las mejores del mercado", R.drawable.adidas),
            new Sneaker(9,"Adidas", "Zapatillas Adidas las mejores del mercado", R.drawable.adidas),
            new Sneaker(10,"Adidas", "Zapatillas Adidas las mejores del mercado", R.drawable.adidas),
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
