package dam.laboratorio.appcompraventa;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterCategoria extends RecyclerView.Adapter<AdapterCategoria.ViewholderCat> {

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
    public AdapterCategoria(ArrayList<Categoria> listaCat){
        this.listaCategoria = listaCat;
    }

    @NonNull
    @Override
    public ViewholderCat onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fila_cat,null,false);
        ViewholderCat vh = new ViewholderCat(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewholderCat viewholderCat, int i) {
        viewholderCat.tvTitulo.setTag(i);
    }


    @Override
    public int getItemCount() {
        return this.listaCategoria.size();
    }


//    //PERMITE EL ENLACE ENTRE EL ARCHIVO fila_cat CON EL ADAPTADOR
//    @Override
//    public ViewHolderCategorias onCreateViewHolder(ViewGroup parent, int i) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fila_cat,null,false);
//        return new ViewHolderCategorias(view);
//    }
//
//    //COMUNICACION ENTRE LA CLASE VIEWHOLDERCATEGORIA Y NUESTRO ADAPTADOR.
//    @Override
//    public void onBindViewHolder(ViewHolderCategorias holderCategorias, int posicion) {
//        holderCategorias.asignarDatos(categoriaArrayList.get(posicion));
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return 0;
//    }

//    public class ViewHolderCategorias extends RecyclerView.ViewHolder {
//
//        TextView dato;
//
//        public ViewHolderCategorias(View itemView) {
//            super(itemView);
//            dato = (TextView) itemView.findViewById(R.id.tvTitulo);
//        }
//
//        public void asignarDatos(Categoria categoria) {
//            dato.setText(categoria.getNombre());
//        }
//    }
}
