package dam.laboratorio.appcompraventa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.ToggleButton;

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

        //Obtengo los valores de la view para trabajar con las variables de "retiro" y "terminos y condiciones"
        CheckBox ch1 = (CheckBox) findViewById(R.id.checkRetiro);
        CheckBox ch2 = (CheckBox) findViewById(R.id.checkTermino);
        TextView tv1 = (TextView) findViewById(R.id.textViewRetiro);
        EditText ed1 = (EditText) findViewById(R.id.editTextTextRetiro);


        SeekBar seekBar;
        TextView mostrarPorcentajeDescuento;

        mostrarPorcentajeDescuento = (TextView) findViewById(R.id.textPorcentaje);

        // SeekBar
        seekBar = (SeekBar)findViewById(R.id.seekBarDescuento);
        // Valor Inicial
        seekBar.setProgress(0);
        // Valot Final
        seekBar.setMax(100);
        seekBar.setOnSeekBarChangeListener(
                new SeekBar.OnSeekBarChangeListener() {
                    //hace un llamado a la perilla cuando se arrastra
                    @Override
                    public void onProgressChanged(SeekBar seekBar,
                                                  int progress, boolean fromUser) {
                        mostrarPorcentajeDescuento.setText(String.valueOf(progress)+" %");
                    }
                    //hace un llamado  cuando se toca la perilla
                    public void onStartTrackingTouch(SeekBar seekBar) {
                    }
                    //hace un llamado  cuando se detiene la perilla
                    public void onStopTrackingTouch(SeekBar seekBar) {
                    }
                });









        //VERIFICACIONES

        //Verifico el checkbox de retiro a domicilio para hacer visible el campo domicilio
        ch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    tv1.setVisibility(View.VISIBLE);
                    ed1.setVisibility(View.VISIBLE);
                }
                else{
                    tv1.setVisibility(View.GONE);
                    ed1.setVisibility(View.GONE);
                }
            }

        });

        //Obtengo el valor del toggle "Publicar"
        Button btn1 = (Button) findViewById(R.id.ButtonPublicar);

        //Verifico la validacion del checkbox "Terminos y condiciones" para habilitar el Toggle "Publicar"
        ch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked) {
                    btn1.setEnabled(true);
                }
                else{
                    btn1.setEnabled(false);

                }
            }

        });

    }




}