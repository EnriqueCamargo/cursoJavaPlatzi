package Platzi.Play.Exception;

public class CalificacionInvalidaException extends IllegalArgumentException{
    public CalificacionInvalidaException(double x){
        super("La calificacion "+x+" es invalida, solo se permite calificar entre 1.0 y 5.0");
    }
}
