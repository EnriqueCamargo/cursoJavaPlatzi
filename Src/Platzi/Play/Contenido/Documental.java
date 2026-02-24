package Platzi.Play.Contenido;

public class Documental extends Contenido{
    private String Narrador;
    public Documental(String titulo, String Descripcion, int Duracion, Generos Genero, int anioEstreno,
                      double Calificacion, Boolean Disponible,String narrador) {
        super(titulo, Descripcion, Duracion, Genero, anioEstreno, Calificacion, Disponible);
        this.Narrador=narrador;
    }

    public String getNarrador() {
        return Narrador;
    }

    public void setNarrador(String narrador) {
        Narrador = narrador;
    }
    @Override
    public void reproducir(){
        System.out.println("Reproduciendo el documental "+this.getTitulo()+" Narrado por: "+this.getNarrador());
    }
}
