package dam.laboratorio.appcompraventa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //DEFINICIÓN DE RECYCLER VIEW.
    private RecyclerView recyclerView;
    //DEFINICION DE ADAPTER.
    AdapterCategoria categoriaArrayAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //CREAR LISTA DE CATEGORIAS.
        ArrayList<Categoria> categoriaArrayList = new ArrayList<>();
        categoriaArrayList.add(new Categoria ( cat -> {
            cat.setId(1);
            cat.setNombre("REMERA");
        }));
        categoriaArrayList.add(new Categoria ( cat -> {
            cat.setId(2);
            cat.setNombre("SHORT");
        }));
        categoriaArrayList.add(new Categoria ( cat -> {
            cat.setId(3);
            cat.setNombre("CAMPERA");
        }));
        categoriaArrayList.add(new Categoria ( cat -> {
            cat.setId(4);
            cat.setNombre("BERMUDA");
        }));
        categoriaArrayList.add(new Categoria ( cat -> {
            cat.setId(5);
            cat.setNombre("CAMISA");
        }));
        categoriaArrayList.add(new Categoria ( cat -> {
            cat.setId(6);
            cat.setNombre("BOXER");
        }));
        categoriaArrayList.add(new Categoria ( cat -> {
            cat.setId(7);
            cat.setNombre("JEANS");
        }));
        categoriaArrayList.add(new Categoria ( cat -> {
            cat.setId(8);
            cat.setNombre("JOGGIN");
        }));

        //FIND VIEW BY ID --> Falta modificar con el patron HOLDER.
        recyclerView = findViewById(R.id.rvRecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        //Todas las tarjetas del mismo tamaño.
        recyclerView.setHasFixedSize(true);
//
//
//        //CREAMOS EL ADAPTADOR.
//        AdapterCategoria categoriaArrayAdapter = new AdapterCategoria(this, categoriaArrayList);
//
//

        this.categoriaArrayAdapter = new AdapterCategoria(categoriaArrayList);

        //recyclerView.setAdapter();


    }
}