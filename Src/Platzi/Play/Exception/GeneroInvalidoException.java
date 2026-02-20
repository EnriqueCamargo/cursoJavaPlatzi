package Platzi.Play.Exception;

public class GeneroInvalidoException extends IllegalArgumentException{
    public GeneroInvalidoException(String genero){
        super("El genero "+genero+" no se encuentra en nuestro catalogo de generos");
    }
}
