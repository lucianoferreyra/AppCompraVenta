package dam.laboratorio.appcompraventa;

import java.util.function.Consumer;

public class Categoria {
    private Integer id;
    private String nombre;

    public Categoria (){
    }

    public Categoria(Consumer<Categoria> consumer){
        consumer.accept(this);
    }

    public Categoria(Integer id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    @Override
    public String toString() {
        return "nombre= " +nombre;
    }
}
