package Platzi.Play.Contenido;

public abstract class Contenido {
    private String Titulo;
    private String Descripcion;
    private int Duracion;
    private Generos Genero;
    private int AnioEstreno;
    private double Calificacion;
    private Boolean Disponible;

    public Contenido(String titulo, String Descripcion , int Duracion, Generos Genero
    , int anioEstreno, double Calificacion,
                     Boolean Disponible) {
        this.Titulo = titulo;
        this.Descripcion=Descripcion;
        this.Duracion=Duracion;
        this.Genero=Genero;
        this.AnioEstreno=anioEstreno;
        this.calificar(Calificacion);
        this.Disponible=Disponible;
    }

    public Contenido() {
    }

    public Generos getGenero() {
        return Genero;
    }

    public void setGenero(Generos genero) {
        Genero = genero;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public int getDuracion() {
        return Duracion;
    }

    public void setDuracion(int duracion) {
        Duracion = duracion;
    }

    public int getAnioEstreno() {
        return AnioEstreno;
    }

    public void setAnioEstreno(int anioEstreno) {
        AnioEstreno = anioEstreno;
    }

    public double getCalificacion() {
        return Calificacion;
    }

    public void setCalificacion(double calificacion) {
        Calificacion = calificacion;
    }

    public Boolean getDisponible() {
        return Disponible;
    }

    public void setDisponible(Boolean disponible) {
        Disponible = disponible;
    }

    public abstract void reproducir();

    public String obtenerFichaTecnica(){
        return this.Titulo+"("+this.AnioEstreno+")\n"
                +"Genero "+this.Genero+"\n"+
                " Calificacion: "+this.Calificacion+ "/5"+ " Duracion: "+this.Duracion+"min";
    }
    public void calificar(double calificacion){
        if(calificacion>= 0 && calificacion<=5){
            this.Calificacion=calificacion;
        }else{
            System.out.println("Calificacion invalida");
        }
    }
}
