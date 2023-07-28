package com.zapateria.zapatapp.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

public class DbUsuarios extends DbHelper {

    private static final String TABLE_USUARIOS = "usuarios";
    Context context;

    public DbUsuarios(@Nullable Context context) {
        super(context);
        this.context=context;
    }
    public long insertarUsuario(String nombre,String usuario,String correo,String password){
        try{
            DbHelper dbHelper=new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put("nombreCompleto",nombre);
            values.put("nombreUsuario",usuario);
            values.put("correo",correo);
            values.put("password",password);

            long id = db.insert(TABLE_USUARIOS,null,values);
            return id;
        }catch (Exception e){
            e.printStackTrace();
            return -1;
        }


    }

}
