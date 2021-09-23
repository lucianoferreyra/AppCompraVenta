package dam.laboratorio.appcompraventa;
import dam.laboratorio.appcompraventa.ValidacionMain;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


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
       Spinner spinnerDescuento = (Spinner) findViewById(R.id.spinner);

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
                        //quito el signo "%" de el text Porcentaje para poder trabajar sobre la variable
                        mostrarPorcentajeDescuento.setText(String.valueOf(progress)/*+" %"*/);
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

        Switch eleccionDescuento = (Switch) findViewById(R.id.switch1);

        //Verifico el switch de descuento para hacer visible el seekbar y textView de porcentaje
        eleccionDescuento.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){

            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked){

                if(isChecked){

                    seekBar.setVisibility(View.VISIBLE);
                    mostrarPorcentajeDescuento.setVisibility(View.VISIBLE);

                }
                else{
                    seekBar.setVisibility(View.GONE);
                    mostrarPorcentajeDescuento.setVisibility(View.GONE);
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


        //La verificación comienza al hacer click en el boton PUBLICAR
    btn1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            //campos a validar
            EditText edtTitulo = (EditText) findViewById(R.id.editTextTextPersonName);
            EditText edtEmail = (EditText) findViewById(R.id.editTextTextEmailAddress);
            EditText edtPrecio = (EditText) findViewById(R.id.editTextNumber);
            Switch seleccionDescuento = eleccionDescuento;
            TextView edtPorcentaje = (TextView) findViewById(R.id.textPorcentaje);
            Spinner edtSpinner = spinnerDescuento;
            EditText edtDireccion;


            ValidacionMain objValidar; //objeto de nuestro clase Validaciones


            objValidar = new ValidacionMain();
            int valueSwitch = 0;
            String text ="";
            if (objValidar.vacio(edtTitulo))
                text += "El campo Titulo es obligatorio.\n";
            if (objValidar.vacio(edtEmail))
                text += "El campo Email es obligatorio.\n";
            if (!objValidar.isEmail(edtEmail.toString().trim()))
                text += "El campo Email es inválido.\n";

            if (objValidar.vacio(edtPrecio)) {
                text += "El campo Precio es obligatorio.\n";
            }
            else if (objValidar.mayor(edtPrecio)) {
                text += "El campo Precio debe ser mayor a cero.\n";
            }
            if(seleccionDescuento.isChecked()) {
                if (objValidar.mayor(edtPorcentaje))
                    text += "Por favor seleccione un porcentaje mayor a 0 o quite la opcion de ofrecer descuento de envio.\n";
            }
            if(ch1.isChecked()) {
                edtDireccion = ed1;
                if (objValidar.vacio(edtDireccion))
                    text += "El campo Dirección es obligatorio.\n";
            }

            if(text.length()>0)
                Toast.makeText(getApplicationContext(),text, Toast.LENGTH_SHORT).show();
        }

    });

    }


}
