package com.zapateria.zapatapp.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.zapateria.zapatapp.Modelo.Sneaker;

import java.util.ArrayList;
import java.util.List;

public class DbCarrito extends DbHelper{
    private static final String TABLE_CARRITO = "t_carrito";

    Context context;

    public DbCarrito(@Nullable Context context) {
        super(context);
        this.context = context;
    }

    public long agregarProductoCarrito(String nombre, String descripcion, int idDrawable){
        long id=0;
        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ContentValues valores = new ContentValues();
            valores.put("nombre",nombre);
            valores.put("descripcion",descripcion);
            valores.put("idDrawable",idDrawable);

            id = db.insert(TABLE_CARRITO, null, valores);

        }catch (Exception ex){
            ex.toString();
        }

        return id;
    }
    // Método para obtener todos los productos del carrito
    public List<Sneaker> obtenerProductosCarrito() {
        List<Sneaker> listaProductos = new ArrayList<>();

        try {
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase db = dbHelper.getReadableDatabase();

            // Define las columnas que deseas obtener de la tabla
            String[] columnas = {"id", "nombre", "descripcion", "imagen"};

            // Realiza la consulta a la tabla
            Cursor cursor = db.query(TABLE_CARRITO, columnas, null, null, null, null, null);

            // Recorre el cursor y agrega los productos a la lista
            if (cursor.moveToFirst()) {
                do {


                    int columnIndexId = cursor.getColumnIndex("id");
                    String columnIndexNombre = String.valueOf(cursor.getColumnIndex("nombre"));
                    String columnIndexDescripcion = String.valueOf(cursor.getColumnIndex("descripcion"));
                    int columnIndexidDrawable = cursor.getColumnIndex("precio");

                    Sneaker producto = new Sneaker(columnIndexId, columnIndexNombre, columnIndexDescripcion, columnIndexidDrawable);
                    listaProductos.add(producto);
                } while (cursor.moveToNext());
            }

            // Cierra el cursor y la base de datos
            cursor.close();
            db.close();

        } catch (Exception ex) {
            ex.toString();
        }

        return listaProductos;
    }
}
