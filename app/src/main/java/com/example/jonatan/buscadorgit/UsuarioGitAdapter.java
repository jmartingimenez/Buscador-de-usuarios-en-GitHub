package com.example.jonatan.buscadorgit;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Jonatan on 07/07/2018.
 */

public class UsuarioGitAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private List<UsuarioGit> usuarios = new LinkedList<UsuarioGit>();
    private TextView textViewLogin;
    private TextView textViewScore;
    private ImageView imageViewAvatar;

    public UsuarioGitAdapter(List<UsuarioGit> usuarios){
        this.usuarios.clear();
        this.usuarios.addAll(usuarios);
    }

    //Constructor usado para datos dummy si hay falla en la busqueda
    public UsuarioGitAdapter(){
        for(int i=0;i<10;i++){
            usuarios.add(new UsuarioGit("loginDummy" + (i + 1), "x", 1.01));
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.contenedor_usuario,
                parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if(!usuarios.isEmpty()){
            textViewLogin.setText("Login: " + usuarios.get(position).getLogin());
            textViewScore.setText("Score: " + usuarios.get(position).getScore());
            //Ver la asignación del ImageView luego
        }

    }

    @Override
    public int getItemCount() {
        return usuarios.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(View itemView) {
            super(itemView);
            textViewLogin = itemView.findViewById(R.id.tvNombreUsuario);
            textViewScore = itemView.findViewById(R.id.tvScoreUsuario);
            imageViewAvatar = itemView.findViewById(R.id.ivContenedorUsuario);
        }
    }

    /*Agregados para evitar error al scrollear mucho*/
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }
}
