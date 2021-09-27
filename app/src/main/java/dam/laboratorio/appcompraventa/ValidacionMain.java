package dam.laboratorio.appcompraventa;

import android.text.TextUtils;
import android.util.Patterns;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ValidacionMain {

    //metodo para validar si es un email (falta validacion 3 caracteres despues del @)

    //String emailPattern = "[a-zA-Z0-9._-]+@+[a-z]{3,}+[.]+[a-z]";
    public static boolean esEmailValido(CharSequence email) {
        //return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN = "[a-zA-Z0-9._-]+@+[a-z]{3,}+[.]+[a-z]*";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

    //El campo setError muestra los campos con errores

    //metodo para validar si editext esta vacio
    public  boolean vacio(EditText campo){
        String dato = campo.getText().toString().trim();
        if(TextUtils.isEmpty(dato)){
            campo.setError("Campo Requerido");
            campo.requestFocus();
            return true;
        }
        else{
            return false;
        }
    }

// Metodo de verificacion del precio
    public  boolean mayor(EditText campo){
        if(!campo.getText().toString().equals("")){
            int numero = Integer.parseInt(campo.getText().toString());
            if (numero <= 0) {
                campo.setError("Valor mayor a cero");
                campo.requestFocus();
                return true;
            } else {
                return false;
            }
        }
        return false;
    }
    // ( Prueba ) metodo de verificación de un textView para el texto porcentaje

    public  boolean mayor(TextView campo){
        if(!campo.getText().toString().equals("")){
            int numero = Integer.parseInt(campo.getText().toString());
            if (numero <= 0) {
                campo.setError("Valor mayor a cero");
                campo.requestFocus();
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public boolean textoValido (String texto){
        String textoPattern = "[a-zA-Z0-9,.\n]*";

        Pattern pattern = Pattern.compile(textoPattern);
        Matcher m = pattern.matcher(texto);
        return m.matches();
    }


}
