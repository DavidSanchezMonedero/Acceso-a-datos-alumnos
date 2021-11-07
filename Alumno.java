package principal;


public class Alumno {
    
    private String codigoAlumno;
    private String nombre;
    private String paterno;//appellido
    private String nacimiento;
    private char sexo;

    public Alumno() {
    }

    public Alumno(String codigoAlumno, String nombre, String paterno, String nacimiento, char sexo) {
        this.codigoAlumno = codigoAlumno;
        this.nombre = nombre;
        this.paterno = paterno;
        this.nacimiento = nacimiento;
        this.sexo = sexo;
    }

    public String getCodigoAlumno() {
        return codigoAlumno;
    }

    public void setCodigoAlumno(String codigoAlumno) {
        this.codigoAlumno = codigoAlumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public String getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(String nacimiento) {
        this.nacimiento = nacimiento;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Alumno{" + "codigoAlumno=" + codigoAlumno + ", nombre=" + nombre + ", paterno=" + paterno + ", nacimiento=" + nacimiento + ", sexo=" + sexo + '}';
    }
    
    
}
