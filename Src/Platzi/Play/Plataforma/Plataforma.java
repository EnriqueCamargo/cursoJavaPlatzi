package Platzi.Play.Plataforma;

import Platzi.Play.Contenido.Pelicula;

import java.util.ArrayList;
import java.util.List;

public class Plataforma {
    private String nombre;
    private List<Pelicula> contenido;//agregacion

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
        /*for (Pelicula pelicula : contenido) {
            System.out.println(pelicula.getTitulo());
        }*/
        //LAMBDA

        contenido.forEach(pelicula -> System.out.println(pelicula.getTitulo()));

    }
    public void eliminar(String peliculaBuscada) {
        boolean eliminado = contenido.removeIf(pelicula -> pelicula.getTitulo().equalsIgnoreCase(peliculaBuscada));

        if (!eliminado) {
            System.out.println("La película '" + peliculaBuscada + "' no está dentro del catálogo");
        }else{
            System.out.println(peliculaBuscada+ " Eliminada exitosamente");
        }
    }
    public String buscarPorTitulo(String peliculaBuscada){
        /*
        for (Pelicula pelicula : contenido) {

            if(pelicula.getTitulo().equalsIgnoreCase(peliculaBuscada)){
                return pelicula.obtenerFichaTecnica();
            }

        }*/
        //LAMBDA
        contenido.stream().filter(pelicula ->pelicula.getTitulo().equalsIgnoreCase(peliculaBuscada))
                .map(Pelicula::obtenerFichaTecnica).
                findFirst().
                orElse("Pelicula no encontrada");


    }
}