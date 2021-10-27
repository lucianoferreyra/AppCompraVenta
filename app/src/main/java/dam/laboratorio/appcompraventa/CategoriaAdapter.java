package dam.laboratorio.appcompraventa;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class CategoriaAdapter extends RecyclerView.Adapter<CategoriaAdapter.ViewholderCat> {

    private ArrayList<Categoria> listaCategoria;

    public static class ViewholderCat extends RecyclerView.ViewHolder{
        CardView cv;
        TextView tvTitulo;
        public ViewholderCat(@NonNull View itemView) {
            super(itemView);
            cv = itemView.findViewById(R.id.cvCategoria);
            tvTitulo = itemView.findViewById(R.id.tvTitulo);
        }
    }
    //CONSTRUCTOR QUE RECIBE LA LISTA A PROCESAR.
    public CategoriaAdapter(ArrayList<Categoria> listaCat){
        this.listaCategoria = listaCat;
    }

    //Definición método onCreateViewHolder: Retorna la vista.
    //Se ejecuta una vez por cada fila que se visualiza.
    @NonNull
    @Override
    public ViewholderCat onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.fila_cat,null,false);
        ViewholderCat vh = new ViewholderCat(view);
        return vh;
    }

    //Definición método onBindViewHolder: Por cada fila obtenemos y seteamos los datos.
    @Override
    public void onBindViewHolder(@NonNull ViewholderCat viewholderCat, int i) {
        viewholderCat.tvTitulo.setTag(i);
    }


    @Override
    public int getItemCount() {
        return this.listaCategoria.size();
    }


}
