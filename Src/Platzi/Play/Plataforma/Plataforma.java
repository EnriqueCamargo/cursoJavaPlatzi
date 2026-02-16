package Platzi.Play.Plataforma;

import Platzi.Play.Contenido.Pelicula;

import java.util.ArrayList;
import java.util.List;

public class Plataforma {
    private String nombre;
    private List<Pelicula> contenido;

    public Plataforma(String nombre){
        this.nombre=nombre;
        this.contenido=new ArrayList<>();
    }

    public List<Pelicula> getContenido() {
        return contenido;
    }

    public void setContenido(List<Pelicula> contenido) {
        this.contenido = contenido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void agregar(Pelicula elemento){
        this.contenido.add(elemento);

    }
    public void mostrarTitulos(){
        for (Pelicula pelicula : contenido) {
            System.out.println(pelicula.getTitulo());
        }
    }
    public void eliminar(Pelicula pelicula){
        this.contenido.remove(pelicula);
        System.out.println("Se elimino "+pelicula);
    }
}
