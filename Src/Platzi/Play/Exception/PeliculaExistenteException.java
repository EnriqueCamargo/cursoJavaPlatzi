package Platzi.Play.Exception;

public class PeliculaExistenteException extends RuntimeException{
    public PeliculaExistenteException(String titulo){
        super("La pelicula "+ titulo+" Ya existe");
    }
}
