package Platzi.Play;

import Platzi.Play.Contenido.Pelicula;

public class mainStackHeap {
    public static void main(){

        Pelicula reyLeon=new Pelicula("Rey leon","Pelicula animada",135,
                "Infantil",
                1990,4,true);

        Pelicula harryPotter=new Pelicula("Harry potter", "Pelicula de fantasia",
                200,
                "Fantasia",2004,4.5,true);
        reyLeon=harryPotter;
        reyLeon.setTitulo("One Piece");
        System.out.println("Rey leon: "+reyLeon.getTitulo());
        System.out.println("harry Potter: "+ harryPotter.getTitulo());

        /*En esta practica, podemos ver como al asignar una variable la cual referencia a un objeto
        es asignado a otro, el contructor inicial que teniamos queda inutil por el Garbage colelctor
        java lo considera innecesario y lo descarta al estar ambos objetos apuntando al mismo
        espacio de memoria*/
    }
}
