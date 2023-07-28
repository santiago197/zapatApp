package com.zapateria.zapatapp.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class DbCarrito extends DbHelper{
    private static final String TABLE_CARRITO = "t_carrito";

    Context context;

    public DbCarrito(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long agregarProductoCarrito(String nombre, String descripcion, String precio){
        long id=0;
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues valores = new ContentValues();
            valores.put("nombre",nombre);
            valores.put("descripcion",descripcion);
            valores.put("precio",precio);

            id = db.insert(TABLE_CARRITO, null, valores);

        }catch (Exception ex){
            ex.toString();
        }

        return id;
    }
}
