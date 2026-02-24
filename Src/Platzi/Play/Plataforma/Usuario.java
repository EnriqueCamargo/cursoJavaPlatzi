package Platzi.Play.Plataforma;

import Platzi.Play.Contenido.Contenido;

public class Usuario {
    public String nombre;
    public String email;

    public void ver(Contenido pelicula){
        System.out.print(nombre+" ");
        pelicula.reproducir();
    }
}
