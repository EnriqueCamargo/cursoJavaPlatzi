package Platzi.Play.Contenido;

public class Pelicula {
    private String Titulo;
    private String Descripcion;
    private int Duracion;
    private String Genero;
    private int AnioEstreno;
    private double Calificacion;
    private Boolean Disponible;

    public Pelicula(String titulo,String Descripcion , int Duracion,  String Genero
    ,int anioEstreno,double Calificacion,
                    Boolean Disponible) {
        this.Titulo = titulo;
        this.Descripcion=Descripcion;
        this.Duracion=Duracion;
        this.Genero=Genero;
        this.AnioEstreno=anioEstreno;
        this.calificar(Calificacion);
        this.Disponible=Disponible;
    }

    public Pelicula() {
    }


    public void reproducir(){
        System.out.println("Reproduciendo"+this.Titulo);
    }
    public String obtenerFichaTecnica(){
        return this.Titulo+"("+this.AnioEstreno+")\n"
                +"Genero "+this.Genero+"\n"+
                " Calificacion: "+this.Calificacion+ "/5";
    }
    public void calificar(double calificacion){
        if(calificacion>= 0 && calificacion<=5){
            this.Calificacion=calificacion;
        }else{
            System.out.println("Calificacion invalida");
        }
    }
}
