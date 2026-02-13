package Platzi.Play.Contenido;

public class Pelicula {
    public String Titulo;
    public String Descripcion;
    public int Duracion;
    public String Genero;
    public int AnioEstreno;
    public double Calificacion;
    public Boolean Disponible;

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
