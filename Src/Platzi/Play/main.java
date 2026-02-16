package Platzi.Play;

import Platzi.Play.Contenido.Pelicula;
import Platzi.Play.Plataforma.Plataforma;
import Platzi.Play.Plataforma.Usuario;
import Platzi.Play.util.ScannerUtils;

import java.util.Scanner;

public class main{
    public static final String PLATAFORMA= "platzi play";
    public static final String VERSION="1.0.1";
    public static void main(String Args[]){
        System.out.println("Bienvenido a "+PLATAFORMA+" v"+VERSION);


        Scanner scanner=new Scanner(System.in);
        String nombre= ScannerUtils.capturarTexto("Escriba su nombre");
        System.out.println("Hola "+nombre);

        int edad = ScannerUtils.capturarNumero("Escriba su edad");
        if(edad>=18){
            System.out.println(nombre+" Eres apto para Acceder a nuestro servicio de Streaming");
            Pelicula seniorDeLosAnillos = new Pelicula("El senior de los anillos","pelicula de fantasia",180,"Fantasia",2001,4.7,true);
            Pelicula reyLeon=new Pelicula("Rey leon","Pelicula animada",135,
                    "Infantil",
                    1990,4,true);

            Pelicula harryPotter=new Pelicula("Harry potter", "Pelicula de fantasia",
                    200,
                    "Fantasia",2004,4.5,true);
            System.out.println(seniorDeLosAnillos.obtenerFichaTecnica());
            Usuario usuario= new Usuario();
            usuario.nombre=nombre;
            usuario.ver(seniorDeLosAnillos);
            Plataforma plataforma=new Plataforma(PLATAFORMA);
            plataforma.agregar(seniorDeLosAnillos);
            plataforma.agregar(harryPotter);
            plataforma.agregar(reyLeon);
            System.out.println("Numero de elementos en la plataforma "+plataforma.getContenido().size());
            plataforma.mostrarTitulos();
            plataforma.eliminar(harryPotter);


        }else{
            System.out.println("No eres apto, debes ser mayor a 18, tu edad es "+edad);
        }


    }
}