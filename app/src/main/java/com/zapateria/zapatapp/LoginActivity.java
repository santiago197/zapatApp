package com.zapateria.zapatapp;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.zapateria.zapatapp.db.DbHelper;
import com.zapateria.zapatapp.db.DbUsuarios;

public class LoginActivity extends AppCompatActivity {
    private Button btnConectarDB, btnSave, btnGetRegistros;
    private EditText textUsuario, textPassword, textNombre, textCorreo;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        iniciarlizarComponentes();
        accionar();
    }
    public void iniciarlizarComponentes(){
        btnConectarDB=findViewById(R.id.btnConectarBD);
        btnSave=findViewById(R.id.btnGuardarRegistro);
        btnGetRegistros=findViewById(R.id.btnListaRegistros);

        textNombre=findViewById(R.id.editNombreCompleto);
        textUsuario=findViewById(R.id.editUsuario);
        textCorreo=findViewById(R.id.editCorreo);
        textPassword=findViewById(R.id.editPassword);

    }

    public void accionar(){
        btnGetRegistros.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),ListarUsuarios.class);
                startActivity(intent);
            }
        });
        btnConectarDB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DbHelper dbHelper=new DbHelper(LoginActivity.this);
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                if(db!=null){
                    Toast.makeText(LoginActivity.this, "Conexión a DB realizada", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(LoginActivity.this, "Error a conexión a DB ", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    DbUsuarios dbUsuarios = new DbUsuarios(LoginActivity.this);
                    String nombre = textNombre.getText().toString();
                    String usuario = textUsuario.getText().toString();
                    String correo = textCorreo.getText().toString();
                    String password = textPassword.getText().toString();


                    long idr = dbUsuarios.insertarUsuario(nombre,usuario,correo,password);

                    if(idr>0){
                        Toast.makeText(LoginActivity.this, "Usuario registrado exitosamente!", Toast.LENGTH_SHORT).show();
                        Toast.makeText(LoginActivity.this, "Base de datos creada éxitosamente", Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(LoginActivity.this, "Error al registrar el usuario", Toast.LENGTH_SHORT).show();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }

            }
        });
    }



}
