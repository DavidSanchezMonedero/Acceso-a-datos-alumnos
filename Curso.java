package principal;


public class Curso {
    private String codigoCurso;
    private String nombre;
    private int creditos;

    public Curso() {
    }

    public Curso(String codigoCurso, String nombre, int creditos) {
        this.codigoCurso = codigoCurso;
        this.nombre = nombre;
        this.creditos = creditos;
    }

    public String getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    @Override
    public String toString() {
        return "Curso{" + "codigoCurso=" + codigoCurso + ", nombre=" + nombre + ", creditos=" + creditos + '}';
    }
    
    
}
