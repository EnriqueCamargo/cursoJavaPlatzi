package Platzi.Play.util;

import Platzi.Play.Contenido.Generos;
import Platzi.Play.Exception.CalificacionInvalidaException;
import Platzi.Play.Exception.GeneroInvalidoException;

import java.util.Scanner;

public class ScannerUtils {
    public static Scanner scanner=new Scanner(System.in);
    public static String capturarTexto(String mensaje){
        System.out.println(mensaje+": " );
        return scanner.nextLine();
    }
    public static int capturarNumero(String mensaje){
        System.out.println(mensaje+": " );
        while(!scanner.hasNextInt()){
            System.out.println("Escriba un numero entero\n"+mensaje );
            scanner.next();
        }
        int dato =scanner.nextInt();
        scanner.nextLine();
        return dato;

    }
    public static double capturarDecimal(String mensaje){
        System.out.println(mensaje+": ");
        while(!scanner.hasNextDouble()){
            System.out.println("Escriba un numero Decimal \n"+ mensaje);
            scanner.next();
        }
        double dato=scanner.nextDouble();
        scanner.nextLine();
        return dato;
    }
    public static Generos capturarGenero(String mensaje){
        while(true){
            System.out.println(mensaje +"... OPCIONES");
            for (Generos genero : Generos.values()){
                System.out.println("-" + genero.name());
            }
            String opcion=capturarTexto(mensaje);

            try{
                return Generos.valueOf(opcion.toUpperCase());
            }catch (IllegalArgumentException e){
                System.out.println(new GeneroInvalidoException(opcion).getMessage());
            }
        }
    }
    public static double capturarCalificacion(String mensaje){
        while (true){
            System.out.println(mensaje+": ");
            double x = scanner.nextDouble();
            if(x<=5.0 && x>=0){
                return x;
            }else{
                System.out.println(new CalificacionInvalidaException(x).getMessage());
            }
        }

    }

}
