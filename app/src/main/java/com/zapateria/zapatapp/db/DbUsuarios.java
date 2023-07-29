package com.zapateria.zapatapp.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.annotation.Nullable;

import com.zapateria.zapatapp.entidades.Usuario;

import java.util.ArrayList;

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
    public ArrayList<Usuario> obtenerListaUsuarios(){
        try{
            DbHelper dbHelper=new DbHelper(context);
            SQLiteDatabase db = dbHelper.getWritableDatabase();

            ArrayList<Usuario> listaUsuarios = new ArrayList<>();
            Usuario usu = null;
            Cursor cursorUsu=null;

            cursorUsu=db.rawQuery("SELECT * FROM usuarios",null);
            if(cursorUsu.moveToFirst()){
                do {

                    usu = new Usuario();
                    usu.setNombre((cursorUsu.getString(1)));
                    usu.setNombreUsuario((cursorUsu.getString(2)));
                    usu.setCorreo((cursorUsu.getString(3)));
                    listaUsuarios.add(usu);
                }while (cursorUsu.moveToNext());
            }
            cursorUsu.close();
            return listaUsuarios;

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

}
