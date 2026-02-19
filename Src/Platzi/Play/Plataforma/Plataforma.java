package Platzi.Play.Plataforma;

import Platzi.Play.Contenido.Pelicula;

import java.util.ArrayList;
import java.util.Comparator;
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
    public void cargarCatalogo(){
        List<Pelicula> catalogo = new ArrayList<>();

        catalogo.add(new Pelicula("Inception", "Un ladrón que roba secretos a través de los sueños.", 148, "Ciencia Ficción", 2010, 4.8, true));
        catalogo.add(new Pelicula("The Godfather", "El patriarca de una dinastía del crimen organizado.", 175, "Drama", 1972, 4.9, true));
        catalogo.add(new Pelicula("Toy Story", "Juguetes que cobran vida cuando los humanos no ven.", 81, "Animación", 1995, 4.5, true));
        catalogo.add(new Pelicula("The Dark Knight", "Batman se enfrenta al Joker en Gotham.", 152, "Acción", 2008, 4.9, true));
        catalogo.add(new Pelicula("Pulp Fiction", "Vidas de criminales y asesinos se entrelazan.", 154, "Crimen", 1994, 4.7, false));
        catalogo.add(new Pelicula("Interstellar", "Un grupo de astronautas viaja a través de un agujero de gusano.", 169, "Ciencia Ficción", 2014, 4.6, true));
        catalogo.add(new Pelicula("Jurassic Park", "Dinosaurios clonados escapan de un parque temático.", 127, "Aventura", 1993, 4.4, true));
        catalogo.add(new Pelicula("Parasite", "Una familia pobre se infiltra en una casa rica.", 132, "Suspenso", 2019, 4.8, false));
        catalogo.add(new Pelicula("Mad Max: Fury Road", "Persecución épica en un mundo post-apocalíptico.", 120, "Acción", 2015, 4.3, true));
        catalogo.add(new Pelicula("Spirited Away", "Una niña entra en un mundo mágico de dioses y espíritus.", 125, "Animación", 2001, 4.7, true));
        this.contenido=catalogo;
    }
    public List<String >mostrarTitulos(){
        /*for (Pelicula pelicula : contenido) {
            System.out.println(pelicula.getTitulo());
        }*/
        //LAMBDA

        //contenido.forEach(pelicula -> System.out.println(pelicula.getTitulo()));
        return contenido.stream().map(Pelicula :: getTitulo).toList();
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
        return contenido.stream().filter(pelicula ->pelicula.getTitulo().equalsIgnoreCase(peliculaBuscada))
                .map(Pelicula::obtenerFichaTecnica).
                findFirst().
                orElse("Pelicula no encontrada");


    }
    public int getDuracionByTitulo(String tituloBuscar){
        return contenido.stream().filter(pelicula -> pelicula.getTitulo().equalsIgnoreCase(tituloBuscar))
                .map(Pelicula :: getDuracion).findFirst().orElseThrow(() ->new RuntimeException("Pelicula no encontrada"));
    }

    public int getDuracionTotal(){
        return contenido.stream().mapToInt(pelicula -> pelicula.getDuracion()).sum();
    }
    public List<Pelicula> getTopMasPopulares(){
        return contenido.stream().sorted(Comparator.comparingDouble(Pelicula::getCalificacion).reversed()).toList();
    }
    public List<Pelicula> getTopMasPopularesByNum(int limite){
        return contenido.stream().sorted(Comparator.comparingDouble(Pelicula::getCalificacion).reversed()).limit(limite).toList();
    }

    public List<Pelicula> getPeliculasBuenas(){
        return contenido.stream().filter(pelicula -> pelicula.getCalificacion()>=4.0).toList();
    }

    public Pelicula getPeliculaMasLarga(){
        return contenido.stream().sorted(Comparator.comparingInt(Pelicula::getDuracion).reversed()).findFirst().orElse(null);
    }
    public Pelicula getPeliculaMasCorta(){
        return contenido.stream().sorted(Comparator.comparingInt(Pelicula::getDuracion)).findFirst().orElse(null);
    }

}