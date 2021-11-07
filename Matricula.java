package principal;


public class Matricula {
    
    private String codigoAlumno;
    private String codigoCurso;
    private String fechaMatricula;

    public Matricula() {
    }

    public Matricula(String codigoAlumno, String codigoCurso, String fechaMatricula) {
        this.codigoAlumno = codigoAlumno;
        this.codigoCurso = codigoCurso;
        this.fechaMatricula = fechaMatricula;
    }

    public String getCodigoAlumno() {
        return codigoAlumno;
    }

    public void setCodigoAlumno(String codigoAlumno) {
        this.codigoAlumno = codigoAlumno;
    }

    public String getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(String codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public String getFechaMatricula() {
        return fechaMatricula;
    }

    public void setFechaMatricula(String fechaMatricula) {
        this.fechaMatricula = fechaMatricula;
    }

    @Override
    public String toString() {
        return "Matricula{" + "codigoAlumno=" + codigoAlumno + ", codigoCurso=" + codigoCurso + ", fechaMatricula=" + fechaMatricula + '}';
    }
    
    
    
}
