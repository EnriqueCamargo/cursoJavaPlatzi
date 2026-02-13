package Platzi.Play;

import Platzi.Play.Contenido.Pelicula;
import Platzi.Play.Plataforma.Usuario;
import Platzi.Play.util.ScannerUtils;

import java.util.Scanner;

public class main{
    public static void main(String Args[]){
        System.out.println("hola mundo");

        Scanner scanner=new Scanner(System.in);
        String nombre= ScannerUtils.capturarTexto("Escriba su nombre");
        System.out.println("Hola "+nombre);
;
        int edad = ScannerUtils.capturarNumero("Escriba su edad");
        if(edad>=18){
            System.out.println(nombre+" Eres apto para jugar");

        }else{
            System.out.println("No eres apto, debes ser mayor a 18, tu edad es "+edad);
        }

        Pelicula pelicula = new Pelicula();
        pelicula.Titulo="El senior de los anillos";
        pelicula.AnioEstreno=2001;
        pelicula.Genero="Fantasia";
        pelicula.calificar(4.7);
        System.out.println(pelicula.obtenerFichaTecnica());
        Usuario usuario= new Usuario();
        usuario.nombre=nombre;
        usuario.ver(pelicula);
    }
}