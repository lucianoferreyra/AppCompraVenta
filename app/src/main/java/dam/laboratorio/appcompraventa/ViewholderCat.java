package dam.laboratorio.appcompraventa;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class ViewholderCat extends RecyclerView.ViewHolder{

    public ViewholderCat(@NonNull View itemView) {
        super(itemView);

        TextView tvTitulo = itemView.findViewById(R.id.tvTitulo);
    }
}
