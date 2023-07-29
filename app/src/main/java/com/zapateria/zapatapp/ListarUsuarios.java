package com.zapateria.zapatapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.zapateria.zapatapp.Adapters.ListarUsuariosAdapter;
import com.zapateria.zapatapp.db.DbUsuarios;
import com.zapateria.zapatapp.entidades.Usuario;

import java.util.ArrayList;

public class ListarUsuarios extends AppCompatActivity {
    RecyclerView recyclerListarUsuarios;
    ArrayList<Usuario> usuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_usuarios);
        inicializarComponentes();
    }
    public void inicializarComponentes(){
        recyclerListarUsuarios=findViewById(R.id.listaUsuarios);
        recyclerListarUsuarios.setLayoutManager(new LinearLayoutManager(this));
        DbUsuarios dbu = new DbUsuarios(ListarUsuarios.this);
        usuarios = dbu.obtenerListaUsuarios();

        ListarUsuariosAdapter lua = new ListarUsuariosAdapter(usuarios);
        recyclerListarUsuarios.setAdapter(lua);
    }
}