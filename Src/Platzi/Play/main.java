package Platzi.Play;

import Platzi.Play.Contenido.Generos;
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
    public static final int SALIR=9;
    public static final int POPULARES=5;
    public static final int GENERO=6;
    public static final int BUENAS=7;
    public static final int DURACION=8;
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
            System.out.println(nombre+" Eres apto para Acceder a nuestro servicio de Streaming\n\n");
            while(true) {
                System.out.println("""
                        1-Agregar Contenido\n
                        2-Mostrar todo\n
                        3-buscar por titulo\n
                        4-eliminar\n
                        5-Top peliculas mas populares\n
                        6-Buscar peliculas de cierto genero\n
                        7-Ver Solo peliculas con buena calificacion\n
                        8-Buscar Pelicula por duracion\n
                        9-salir\n
                        """);
                int x =ScannerUtils.capturarNumero(nombre +" Escoge una accion a realizar");
                switch(x){
                    case AGREGAR -> {
                        String nombrePelicula=ScannerUtils.capturarTexto("Escriba el titulo de la pelicula a agregar");
                        String descripcionPelicula=ScannerUtils.capturarTexto("Escriba la descripcion de la pelicula");
                        int duracionPelicula=ScannerUtils.capturarNumero("Escriba la duracion de la pelicula en minutos");
                        Generos generoPelicula=ScannerUtils.capturarGenero("Escribe el genero de la pelicula");
                        int anioEstreno=ScannerUtils.capturarNumero("Escriba el anio en que se estreno la pelicula");
                        double calificacionPelicula=ScannerUtils.capturarCalificacion("Escriba la calificacion de la pelicula");

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
                            System.out.println("Pelicula no encontrada con el titulo "+buscarPelicula);
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
                    case GENERO -> {
                        List<Pelicula> peliculasPorGenero=plataforma.getPeliculasPorGenero(ScannerUtils.capturarGenero("Escriba el genero a buscar"));
                        peliculasPorGenero.forEach(pelicula -> System.out.println(pelicula.obtenerFichaTecnica()));
                    }
                    case BUENAS->{
                        List<Pelicula> peliculasBuenas = plataforma.getPeliculasBuenas();
                        peliculasBuenas.forEach(pelicula -> System.out.println(pelicula.obtenerFichaTecnica()));

                    }
                    case DURACION -> {
                        while(true){

                            int duracion=ScannerUtils.capturarNumero("Quieres ver la pelicula con mayor o menor duracion?\n1-Mayor\n2-Menor");
                            if(duracion==1){
                                Pelicula peliculaMaslarga =plataforma.getPeliculaMasLarga();
                                System.out.println(peliculaMaslarga.obtenerFichaTecnica());
                                break;
                            }else if(duracion == 2){
                                Pelicula peliculaMasCorta = plataforma.getPeliculaMasCorta();
                                System.out.println(peliculaMasCorta.obtenerFichaTecnica());
                                break;
                            }else{
                                System.out.println("Opcion invalida!!");
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