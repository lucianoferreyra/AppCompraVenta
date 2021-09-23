package dam.laboratorio.appcompraventa;

import android.text.TextUtils;
import android.util.Patterns;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Pattern;


public class ValidacionMain {


    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    //metodo para validar si es un email (no funciona)
    Pattern pattern = Pattern.compile("@.[a-z]_");
    public  boolean isEmail(String cadena) {
        boolean resultado;
        if (cadena.matches(emailPattern)) {
            resultado = true;
        } else {
            resultado = false;
        }

        return resultado;
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
}
