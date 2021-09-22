package dam.laboratorio.appcompraventa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obtengo el spinner por el id
        Spinner cat_spinner =  (Spinner)findViewById(R.id.spinner);

        // Creo un ArrayAdapter usando un string array y un default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.array_categoria, android.R.layout.simple_spinner_item);

        // Se especifica el diseño a usar cuando aparece la lista de opciones
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Se aplica el adapter al spinner
        cat_spinner.setAdapter(adapter);
    }
}