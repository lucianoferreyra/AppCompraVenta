package dam.laboratorio.appcompraventa;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterCategoria extends ArrayAdapter<Categoria> {

    ArrayList<Categoria> categoriaArrayList;
    //CONSTRUCTORES DE LA LISTA.

    public AdapterCategoria(Context context, ArrayList<Categoria> categoriaArrayList) {
        super(context, 0, categoriaArrayList);
    }

    //IMPLEMENTAMOS EL METODO getView().
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        LayoutInflater inflater = LayoutInflater.from(this.getContext());
        View fila  = inflater.inflate(R.layout.fila_cat, parent, false);

        TextView tvTitulo = fila.findViewById(R.id.tvTitulo);

        Categoria unaCategoria = this.getItem(position);

        tvTitulo.setText(unaCategoria.getNombre());

        return super.getView(position, convertView, parent);
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
