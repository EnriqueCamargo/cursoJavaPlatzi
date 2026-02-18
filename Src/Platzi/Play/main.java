package Platzi.Play;

import Platzi.Play.Contenido.Pelicula;
import Platzi.Play.Plataforma.Plataforma;
import Platzi.Play.Plataforma.Usuario;
import Platzi.Play.util.ScannerUtils;

import java.util.List;
import java.util.Scanner;

public class main{
    public static final String PLATAFORMA= "platzi play";
    public static final String VERSION="1.0.1";
    public static final int AGREGAR=1;
    public static final int MOSTRARTODO=2;
    public static final int BUSCARPORTITULO=3;
    public static final int ELIMINAR=4;
    public static final int SALIR=6;
    public static final int POPULARES=5;

    public static void main(String Args[]){
        Plataforma plataforma=new Plataforma("peliculas");
        System.out.println("Bienvenido a "+PLATAFORMA+" v"+VERSION);
        plataforma.cargarCatalogo();
        System.out.println("mas de "+plataforma.getDuracionTotal()+" minutos de duracion");

        Scanner scanner=new Scanner(System.in);
        String nombre= ScannerUtils.capturarTexto("Escriba su nombre");
        System.out.println("Hola "+nombre);

        int edad = ScannerUtils.capturarNumero("Escriba su edad");
        if(edad>=18){
            System.out.println(nombre+" Eres apto para Acceder a nuestro servicio de Streaming");
            while(true) {
                System.out.println("""
                        1-Agregar Contenido\n
                        2-Mostrar todo\n
                        3-buscar por titulo\n
                        4-eliminar\n
                        5-Top peliculas mas populares\n 
                        6-salir\n
                        """);
                int x =ScannerUtils.capturarNumero(nombre +" Escoge una accion a realizar");
                switch(x){
                    case AGREGAR -> {
                        String nombrePelicula=ScannerUtils.capturarTexto("Escriba el titulo de la pelicula a agregar");
                        String descripcionPelicula=ScannerUtils.capturarTexto("Escriba la descripcion de la pelicula");
                        int duracionPelicula=ScannerUtils.capturarNumero("Escriba la duracion de la pelicula en minutos");
                        String generoPelicula=ScannerUtils.capturarTexto("Escribe el genero de la pelicula");
                        int anioEstreno=ScannerUtils.capturarNumero("Escriba el anio en que se estreno la pelicula");
                        double calificacionPelicula=ScannerUtils.capturarDecimal("Escriba la calificacion de la pelicula");

                        Pelicula pelicula = new Pelicula(nombrePelicula,descripcionPelicula,
                                duracionPelicula,generoPelicula,anioEstreno,
                                calificacionPelicula,true);
                        plataforma.agregar(pelicula);
                    }
                    case MOSTRARTODO -> {
                        List<String> titulos=plataforma.mostrarTitulos();
                        //System.out.println(titulos);
                        titulos.forEach(titulo -> System.out.println(titulo));
                        //Exactamente lo mismo que hacer
                        /*for (String titulo : titulos) {
                            System.out.println(titulo);
                        }*/
                    }
                    case BUSCARPORTITULO -> {
                        String buscarPelicula=ScannerUtils.capturarTexto("Escriba el titulo de la pelicula a buscar");
                        String peliculaEncontrada=plataforma.buscarPorTitulo(buscarPelicula);
                        if(plataforma.buscarPorTitulo(buscarPelicula)!=null){
                            System.out.println(peliculaEncontrada);
                        }else{
                            System.out.println("Pelicula no encontrada con el titul "+buscarPelicula);
                        }


                    }
                    case ELIMINAR -> {
                        String eliminarPelicula=ScannerUtils.capturarTexto("Escriba el titulo a eliminar");
                        plataforma.eliminar(eliminarPelicula);
                    }
                    case POPULARES -> {
                        while (true) {
                            int aux = ScannerUtils.capturarNumero("1-Mostrar Toda la lita \n2-Mostrar cierto numero de Peliculas");
                            if (aux == 1) {
                                List<Pelicula> topPopulares = plataforma.getTopMasPopulares();
                                topPopulares.forEach(pelicula -> System.out.println(pelicula.obtenerFichaTecnica()));
                                break;
                            } else if (aux == 2) {
                                int limit=ScannerUtils.capturarNumero("Escriba la cantidad de titulos a mostrar");
                                List<Pelicula> topPopulares = plataforma.getTopMasPopularesByNum(limit);
                                topPopulares.forEach(pelicula -> System.out.println(pelicula.obtenerFichaTecnica()));
                                break;
                            } else {
                                System.out.println("Escriba un numero valido");
                            }

                        }
                    }
                    case SALIR -> {
                        System.exit(0);
                    }
                }

            }
        }else{
            System.out.println("No eres apto, debes ser mayor a 18, tu edad es "+edad);
        }


    }
}