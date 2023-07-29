package com.zapateria.zapatapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.zapateria.zapatapp.R;
import com.zapateria.zapatapp.entidades.Usuario;

import java.util.ArrayList;

public class ListarUsuariosAdapter extends RecyclerView.Adapter<ListarUsuariosAdapter.UsuarioViewHolder> {
    ArrayList<Usuario> usuarios;
    public ListarUsuariosAdapter(ArrayList<Usuario> usuarios){
        this.usuarios = usuarios; // Assign the input parameter to the class variable
    }


    @NonNull
    @Override
    public UsuarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_usuario,null,false);
        return new UsuarioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsuarioViewHolder holder, int position) {
        holder.txtNombre.setText(this.usuarios.get(position).getNombre());
        holder.txtUsuario.setText(this.usuarios.get(position).getNombreUsuario());
        holder.txtCorreo.setText(this.usuarios.get(position).getCorreo());
    }

    @Override
    public int getItemCount() {
        return this.usuarios.size();
    }

    public class UsuarioViewHolder extends RecyclerView.ViewHolder {
        TextView txtNombre,txtUsuario, txtCorreo;
        public UsuarioViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNombre=itemView.findViewById(R.id.nombreItem);
            txtUsuario=itemView.findViewById(R.id.usuarioItem);
            txtCorreo=itemView.findViewById(R.id.correoItem);
        }
    }
}
