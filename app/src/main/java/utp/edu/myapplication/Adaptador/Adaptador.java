package utp.edu.myapplication.Adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.zip.Inflater;

import utp.edu.myapplication.R;
import utp.edu.myapplication.entidades.Departamento;

public class Adaptador extends RecyclerView.Adapter<Adaptador.MyHolder> {
    ArrayList<Departamento> listDepa;
    Context context;

    public Adaptador(ArrayList<Departamento> listDepa) {
        this.listDepa = listDepa;
    }

    @NonNull
    @Override
    public Adaptador.MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.vista,parent,false);
        return new MyHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Adaptador.MyHolder holder, int position) {
        final Departamento depa = listDepa.get(position);
        holder.id.setText(""+depa.getId());
        holder.cliente.setText(depa.getCliente());
        holder.tipo.setText(""+depa.getTipo());
        holder.imagen.setImageResource(imagenDrawable(depa.getTipo()));
    }

    public int imagenDrawable(int tipo){
        int imagen = 0;
        switch (tipo){
            case 1:
                imagen = R.drawable.departamento1;
                break;
            case 2:
                imagen = R.drawable.departamento2;
                break;
            case 3:
                imagen = R.drawable.departamento3;
                break;
            case 4:
                imagen = R.drawable.departamento4;
                break;
        }
        return imagen;
    }

    @Override
    public int getItemCount() {
        return listDepa.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        CardView card;
        TextView id,tipo,cliente;
        ImageView imagen;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.txtNro);
            cliente = itemView.findViewById(R.id.cliente);
            tipo = itemView.findViewById(R.id.tipoDepa);
            card = itemView.findViewById(R.id.card);
            imagen = itemView.findViewById(R.id.imagen1);
        }
    }
}
