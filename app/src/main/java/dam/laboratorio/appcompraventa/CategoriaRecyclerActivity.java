package dam.laboratorio.appcompraventa;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;

public class CategoriaRecyclerActivity extends AppCompatActivity {
    //CategoriaDao categoriaDao;

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    TextView tvTitulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fila_cat); //PREGUNTAR SI ES FILA_CAT O OTRA ACTIVIDAD QUE HAY QUE CREAR.

        //categoriaDao = new CategoriaDao();

        //LISTA DE CATEGORÍAS.
        ArrayList<Categoria> listaCategorias = new ArrayList<>();
        listaCategorias.add(new Categoria ( cat -> {
            cat.setId(1);
            cat.setNombre("REMERA");
        }));
        listaCategorias.add(new Categoria ( cat -> {
            cat.setId(2);
            cat.setNombre("SHORT");
        }));

        String dato = getIntent().getExtras().getString("Titulo");

        recyclerView= findViewById(R.id.rvRecycler);
        tvTitulo = findViewById(R.id.tvTitulo);
        tvTitulo.setText("- " +dato);

        recyclerView.setHasFixedSize(true); //Setea que todas las cardViews tengan el mismo tamaño.
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new CategoriaAdapter(listaCategorias);
        recyclerView.setAdapter(adapter);

    }

}
