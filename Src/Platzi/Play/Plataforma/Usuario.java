package Platzi.Play.Plataforma;

import Platzi.Play.Contenido.Pelicula;

public class Usuario {
    public String nombre;
    public String email;

    public void ver(Pelicula pelicula){
        System.out.println(nombre);
        pelicula.reproducir();
    }
}
