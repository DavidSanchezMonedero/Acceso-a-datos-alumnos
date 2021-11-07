package principal;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.io.*;
import java.util.*;
//cambiar el del hasset de String a Matricula

public class MetodosHito {

    public static ArrayList leerAlumno(int numEjercicio, String respuesta) {
        String nombreRutaArchivoTexto = "data/alumno.txt";
        String codigo, nombre, paterno, nacimiento;
        char sexo;
        String[] campo;
        String registro;

        ArrayList arraylistlectura;
        Alumno alumno;

        File f;
        FileReader fr;
        fr = null;
        BufferedReader br;

        try {
            arraylistlectura = new ArrayList();
            // (1) CREAR UN OBJETO DEL ARCHIVO
            f = new File(nombreRutaArchivoTexto);
            // (2) ABRE UN FLUJO DE ENTRADA DESDE UN ARCHIVO (LECTURA)
            fr = new FileReader(f);
            // (3) OBTENER LA INFORMACION POR EL FLUJO ENTRADA DESDE UN ARCHIVO
            br = new BufferedReader(fr);
            while ((registro = br.readLine()) != null) {
                campo = registro.split(";");

                codigo = campo[0];
                nombre = campo[1];
                paterno = campo[2];
                nacimiento = campo[3];
                sexo = campo[4].charAt(0);
                if (numEjercicio == 1) {
                    if (respuesta.equalsIgnoreCase(codigo)) {
                        alumno = new Alumno(codigo, nombre, paterno, nacimiento, sexo);
                        arraylistlectura.add(alumno);
                    }
                }
                if (numEjercicio == 6) {
                    if (respuesta.equalsIgnoreCase(codigo)) {
                        alumno = new Alumno(codigo, nombre, paterno, nacimiento, sexo);
                        arraylistlectura.add(alumno);
                    }
                } else if (numEjercicio == 11 ) {
                    alumno = new Alumno(codigo, nombre, paterno, nacimiento, sexo);
                    arraylistlectura.add(alumno);
                }
                
            }
        } catch (IOException e) {
            arraylistlectura = null;
        } //(3) CIERRA EL FLUJO DE ENTRADA DESDE UN ARCHIVO
        finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (IOException e) {
                arraylistlectura = null;
            }
        }
        return arraylistlectura;
    }
//-----------------------------------------------------------------------------------------------------------------------------------------------

    public static List<Matricula> leerMatricula(String s, int numEjercicio) {

        String nombreRutaArchivoTexto = "data/matricula.txt";
        String codigoAlumno, codigoCurso, fechaMatricula = null;
        String[] campo;
        String registro;
        Set<Matricula> codigoAlumno_hs = new HashSet<Matricula>(5);
        List<Matricula> matricula_al = new ArrayList<Matricula>();

        ArrayList arraylistlectura;
        ArrayList alumnos_al = null;
        Matricula matricula;

        File f;
        FileReader fr;
        fr = null;
        BufferedReader br;

        try {
            arraylistlectura = new ArrayList();
            // (1) CREAR UN OBJETO DEL ARCHIVO
            f = new File(nombreRutaArchivoTexto);
            // (2) ABRE UN FLUJO DE ENTRADA DESDE UN ARCHIVO (LECTURA)
            fr = new FileReader(f);
            // (3) OBTENER LA INFORMACION POR EL FLUJO ENTRADA DESDE UN ARCHIVO
            br = new BufferedReader(fr);
            while ((registro = br.readLine()) != null) {
                campo = registro.split(";");

                codigoAlumno = campo[0];
                codigoCurso = campo[1];
                fechaMatricula = campo[2];
                /*matricula = new Matricula(codigoAlumno,codigoCurso,fechaMatricula);
                    arraylistlectura.add(matricula);*/
                if (numEjercicio == 2) {
                    if (s.equals(fechaMatricula)) {

                        matricula = new Matricula(codigoAlumno, codigoCurso, fechaMatricula);

                        codigoAlumno_hs.add(matricula);

                    }
                    matricula_al = new ArrayList<Matricula>(codigoAlumno_hs);
                } else {
                    matricula = new Matricula(codigoAlumno, codigoCurso, fechaMatricula);
                    matricula_al.add(matricula);
                }
            }

        } catch (IOException e) {
            matricula_al = null;
        } //(3) CIERRA EL FLUJO DE ENTRADA DESDE UN ARCHIVO
        finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (IOException e) {
                matricula_al = null;
            }
        }

        return matricula_al;
    }
//-----------------------------------------------------------------------------------------------------------------------------------------------

    public static List<Curso> leerCurso(String s, int numEjercicio) {

        String nombreRutaArchivoTexto = "data/curso.txt";
        String codigoCurso, nombre;
        int creditos;
        String[] campo;
        String registro;

        ArrayList arraylistlectura;
        Curso curso;

        File f;
        FileReader fr;
        fr = null;
        BufferedReader br;

        try {
            arraylistlectura = new ArrayList();
            // (1) CREAR UN OBJETO DEL ARCHIVO
            f = new File(nombreRutaArchivoTexto);
            // (2) ABRE UN FLUJO DE ENTRADA DESDE UN ARCHIVO (LECTURA)
            fr = new FileReader(f);
            // (3) OBTENER LA INFORMACION POR EL FLUJO ENTRADA DESDE UN ARCHIVO
            br = new BufferedReader(fr);
            while ((registro = br.readLine()) != null) {
                campo = registro.split(";");
                codigoCurso = campo[0];
                nombre = campo[1];
                creditos = Integer.parseInt(campo[2]);

                if (numEjercicio == 4) {

                    if (s.equalsIgnoreCase(nombre)) {

                        curso = new Curso(codigoCurso, nombre, creditos);
                        arraylistlectura.add(curso);
                    }
                } else if (numEjercicio == 5) {
                    if (s.equals(codigoCurso)) {
                        curso = new Curso(codigoCurso, nombre, creditos);
                        arraylistlectura.add(curso);
                    }
                } else {
                    curso = new Curso(codigoCurso, nombre, creditos);
                    arraylistlectura.add(curso);
                }

            }
        } catch (IOException e) {
            arraylistlectura = null;
        } //(3) CIERRA EL FLUJO DE ENTRADA DESDE UN ARCHIVO
        finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (IOException e) {
                arraylistlectura = null;
            }
        }
        return arraylistlectura;
    }
//-----------------------------------------------------------------------------------------------------------------------------------------------

    public static List<Matricula> filtratMatriculas(String filtro, int numEjercicio) {

        String nra = "data/matricula.txt";

        String codigoAlumno, codigoCurso, fechaMatricula, s;

        List<Matricula> matricula_al = new ArrayList<Matricula>();

        String registro;
        String[] campo;
        Matricula matricula;

        File f;
        FileReader fr;
        fr = null;

        BufferedReader br;

        try {
            // (1) CREAR UN OBJETO DEL ARCHIVO
            f = new File(nra);

            // (2) ABRE UN FLUJO DE ENTRADA DESDE UN ARCHIVO (LECTURA)
            fr = new FileReader(f);

            // (3) OBTENER LA INFORMACION POR EL FLUJO ENTRADA DESDE UN ARCHIVO
            br = new BufferedReader(fr);

            while ((registro = br.readLine()) != null) {

                campo = registro.split(";");
                codigoAlumno = campo[0];
                codigoCurso = campo[1];
                fechaMatricula = campo[2];
                if (numEjercicio == 4) {
                    if (codigoCurso.equals(filtro)) {
                        matricula = new Matricula(codigoAlumno, codigoCurso, fechaMatricula);
                        matricula_al.add(matricula);
                    }
                } else if (numEjercicio == 5) {
                    if (codigoAlumno.equals(filtro)) {
                        matricula = new Matricula(codigoAlumno, codigoCurso, fechaMatricula);
                        matricula_al.add(matricula);
                    }
                }
            }//cierra while 1                            
        } catch (Exception e) {
            matricula_al = null;
        } //(3) CIERRA EL FLUJO DE ENTRADA DESDE UN ARCHIVO
        finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (IOException e) {
                matricula_al = null;
            }
        }

        return matricula_al;

    }  
//-----------------------------------------------------------------------------------------------------------------------------------------------
    
    public static void escribirAlumno(List<Alumno> alumnos_al) {
        try {
            if (alumnos_al != null) {
                System.out.printf("%-6s %-10s %-10s %-12s %-5s\n", "CODIGO", "NOMBRE", "PATERNO", "NACIMIENTO", "SEXO");
                for (int i = 0; i < alumnos_al.size(); i++) {
                    Alumno a = (Alumno) alumnos_al.get(i);
                    System.out.printf("%-6s %-10s %-10s %-12s %-5s\n", a.getCodigoAlumno(), a.getNombre(), a.getPaterno(), a.getNacimiento(), a.getSexo());
                }
            } else {
                System.out.println("ERROR: LISTA VACIA");
            }
        } catch (Exception e) {
            alumnos_al = null;
        }
    }
//-----------------------------------------------------------------------------------------------------------------------------------------------
    
    public static List<Alumno> filtrarAlumnos(List<String> CodAlum) {
        String nra = "data/alumno.txt";
        List<Alumno> alumnos_al = new ArrayList<Alumno>();

        String codigo, nombre, paterno, nacimiento, s;
        char sexo;

        String registro;

        String[] campo;
        Alumno alumno;

        File f;
        FileReader fr;
        fr = null;
        BufferedReader br;
        try {
            // (1) CREAR UN OBJETO DEL ARCHIVO
            f = new File(nra);
            // (2) ABRE UN FLUJO DE ENTRADA DESDE UN ARCHIVO (LECTURA)
            fr = new FileReader(f);
            // (3) OBTENER LA INFORMACION POR EL FLUJO ENTRADA DESDE UN ARCHIVO
            br = new BufferedReader(fr);
            registro = null;
            while ((registro = br.readLine()) != null) {
                for (String i : CodAlum) {
                    campo = registro.split(";");
                    codigo = campo[0];
                    nombre = campo[1];
                    paterno = campo[2];
                    nacimiento = campo[3];
                    sexo = campo[4].charAt(0);
                    if (i.equals(codigo)) {
                        alumno = new Alumno(codigo, nombre, paterno, nacimiento, sexo);
                        alumnos_al.add(alumno);
                    }
                }
            }
        } catch (Exception e) {
            alumnos_al = null;
        } //(3) CIERRA EL FLUJO DE ENTRADA DESDE UN ARCHIVO
        finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (IOException e) {
                alumnos_al = null;
            }
        }

        return alumnos_al;
    }
//-----------------------------------------------------------------------------------------------------------------------------------------------
    
    public static List<Alumno> Matriculado(boolean respuesta) {
        List<Matricula> matriculas_al = MetodosHito.leerMatricula("", 6);

        HashSet<Matricula> matriculas_hs = new HashSet<Matricula>(matriculas_al);//quito duplicacios

        matriculas_al = new ArrayList<Matricula>(matriculas_hs);//vuelvo a pasar a ArrayList pero ya sin dupliacados

        List<Alumno> alumnos_al = MetodosHito.leerAlumno(11, "");
        List<String> codigosMatriculas_al = new ArrayList<String>();
        for (Matricula obj : matriculas_al) {
            codigosMatriculas_al.add(obj.getCodigoAlumno());
        }

        List<String> codigosAlumnos_al = new ArrayList<String>();
        for (Alumno obj : alumnos_al) {
            codigosAlumnos_al.add(obj.getCodigoAlumno());
        }

        List<String> codigosFinales_al = new ArrayList<String>();
        for (int i = 0; i < alumnos_al.size(); i++) {

            if (codigosMatriculas_al.contains(codigosAlumnos_al.get(i)) == respuesta) {//para saber si existe un elemento dentro de otro array
                codigosFinales_al.add(codigosAlumnos_al.get(i));
            }
        }
        alumnos_al = MetodosHito.filtrarAlumnos(codigosFinales_al);

        return alumnos_al;
    }
//-----------------------------------------------------------------------------------------------------------------------------------------------

    public static void menu() {
        System.out.println("Seleccione una opción o introduzca 0 para salir\n\n"
                + "(01)Ingresar el código de un alumno y mostrar sus datos(código, nombre, apaterno, fnacimiento, sexo) de dicho alumno.\n"
                + "(02)Ingresar una fecha en el formato 01/01/2021 y se mostrará todos los alumnos matriculados en dicha fecha\n"
                + "(03)Ingresar dos fechas y se mostrará todos los alumnos matriculados entre dichas fechas.\n"
                + "(04)Ingresar el nombre de la asignatura y se mostrará todos los alumnos matriculados en dicha asignatura.\n"
                + "(05)Ingresar el código de un alumno y se mostrará las asignaturas en la que está matriculado dicho alumno con los créditos de cada asignatura y el total de créditos matriculados.\n"
                + "(06)Mostrar todos los alumnos que no se han matriculado en ninguna asignatura.\n"
                + "(07)Mostrar todos los alumnos que son menor de edad matriculados.\n"
                + "(08)Mostrar los alumnos matriculados que hayan nacido en un año bisiesto.\n"
                + "(09)Mostrar los alumnos incluido el número de asignaturas en la que está matriculado. (código,nombre,apterno,fnacimiento,sexo,número_asignaturas).\n"
                + "(10)Mostrar las asignaturas indicando cuantos alumnos tiene matriculado cada asignatura.\n");
    }
//-----------------------------------------------------------------------------------------------------------------------------------------------

    public static void cls() {
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
//-----------------------------------------------------------------------------------------------------------------------------------------------

    public static void pause() {
        try {
            System.out.print("\nPresiona una tecla para continuar...");
            System.in.read();
        } catch (IOException e) {
        }
    }
    
//***********************************************************************************************************************************************

    public static void opcion1(String s) {
        
        try{
        ArrayList arraylistlectura;         
        arraylistlectura = MetodosHito.leerAlumno(1, s);
        if(arraylistlectura != null){
        List<Alumno> alumnos_al = new ArrayList<Alumno>(arraylistlectura);
        escribirAlumno(alumnos_al);
        }else{
            System.out.println("El alumno introducido no existe");
        }
        }catch(Exception e){
            System.out.println("Ha habido algun error "+e.getMessage());
        }
    }

    public static void opcion2(String s) {
        HashSet<String> arraylistlectura_hs = new HashSet<String>();

        //ArrayList arraylistlectura;
        ArrayList arraylistlecturaFiltrado;
        List<String> arraylistlectura;

        try {
            //arraylistlectura=null;

            arraylistlecturaFiltrado = new ArrayList();

            List<Matricula> matricula_al = MetodosHito.leerMatricula(s, 2);

            for (Matricula obj : matricula_al) {
                arraylistlectura_hs.add(obj.getCodigoAlumno());
            }
            arraylistlectura = new ArrayList<String>(arraylistlectura_hs);

            if (arraylistlectura.get(0) != null) {
                arraylistlecturaFiltrado = (ArrayList) filtrarAlumnos(arraylistlectura);
            } else {
                System.out.println("ERROR: LISTA VACIA");
            }

            if (arraylistlecturaFiltrado != null) {
                System.out.printf("%-6s %-10s %-10s %-12s %-5s\n", "CODIGO", "NOMBRE", "PATERNO", "NACIMIENTO", "SEXO");
                for (int i = 0; i < arraylistlecturaFiltrado.size(); i++) {
                    Alumno a = (Alumno) arraylistlecturaFiltrado.get(i);
                    System.out.printf("%-6s %-10s %-10s %-12s %-5s\n", a.getCodigoAlumno(), a.getNombre(), a.getPaterno(), a.getNacimiento(), a.getSexo());
                }
            } else {
                System.out.println("ERROR: LISTA VACIA");
            }
        } catch (Exception e) {
            arraylistlectura = null;
            System.out.println("Ha habido un error");

        }
    }

    public static void opcion3(String fecha1, String fecha2) {
        Scanner sc = new Scanner(System.in);

        String nra = "data/matricula.txt";

        String codigoAlumno, codigoCurso, fechaMatricula;
        Set<String> codigoAlumno_hs = new HashSet<String>(5);
        List<Alumno> alumnos_al = new ArrayList<Alumno>();
        String registro;

        String[] campo;

        ArrayList arraylistlectura;
        Matricula matricula;
        File f;

        FileReader fr;

        fr = null;

        BufferedReader br;

        try {
            arraylistlectura = new ArrayList();
            // (1) CREAR UN OBJETO DEL ARCHIVO
            f = new File(nra);

            // (2) ABRE UN FLUJO DE ENTRADA DESDE UN ARCHIVO (LECTURA)
            fr = new FileReader(f);

            // (3) OBTENER LA INFORMACION POR EL FLUJO ENTRADA DESDE UN ARCHIVO
            br = new BufferedReader(fr);

            String[] f1sep = fecha1.split("/");
            String fd1 = f1sep[0];

            String[] f2sep = fecha2.split("/");
            String fd2 = f2sep[0];

            while ((registro = br.readLine()) != null) {
            try{
                campo = registro.split(";");
                codigoAlumno = campo[0];
                codigoCurso = campo[1];
                fechaMatricula = campo[2];
                String[] fmsep = campo[2].split("/");
                String fdm = fmsep[0];

                if (Integer.parseInt(fdm) >= Integer.parseInt(fd1) && Integer.parseInt(fdm) <= Integer.parseInt(fd2)) {
                    matricula = new Matricula(codigoAlumno, codigoCurso, fechaMatricula);
                    codigoAlumno_hs.add(codigoAlumno);
                }
            }catch(Exception e){
                System.out.println("Eroor con la fecha/s introducida");
            }
            }//cierra while 1
            List codigoAlumno_al = new ArrayList<String>(codigoAlumno_hs);

            if (codigoAlumno_al != null) {
                alumnos_al = filtrarAlumnos(codigoAlumno_al);
            } else {
                System.out.println("ERROR: LISTA VACIA");
            }
            escribirAlumno(alumnos_al);

        } catch (Exception e) {
            arraylistlectura = null;
        } finally {
            try {
                if (null != fr) {
                    fr.close();
                }
            } catch (IOException e) {
                arraylistlectura = null;
            }
        }
    }

    public static void opcion4(String s) {
        try{
            List<Matricula> matricula_al = new ArrayList<Matricula>();
            List<String> codalum_al = new ArrayList<String>();
            List<Alumno> alumnos_al = new ArrayList<Alumno>();
            List<Curso> curso_al = new ArrayList<Curso>();

            String registro;

            String[] campo;

            ArrayList arraylistlectura;
            Curso curso = null;
            curso_al = MetodosHito.leerCurso(s, 4);
            Curso primero = curso_al.get(0);
            matricula_al = MetodosHito.filtratMatriculas(primero.getCodigoCurso(), 4);

            if(matricula_al != null){
                for (int i = 0; i < matricula_al.size(); i++) {
                    codalum_al.add(matricula_al.get(i).getCodigoAlumno());
                }
            }
            alumnos_al = MetodosHito.filtrarAlumnos(codalum_al);

            escribirAlumno(alumnos_al);
        }catch(Exception e){
            System.out.println("Ha habido algun error");
        }
    }

    public static void opcion5(String s) {
        try{
            List<Matricula> matricula_al = MetodosHito.filtratMatriculas(s, 5);
            List<Curso> codmatricula_al = null;
            List<Curso> cursos_al = null;
            int sumacreditos = 0;

            System.out.printf("%-20s %-10s\n", "Nombre Curso", "Creditos");
            for (Matricula obj : matricula_al) {
                cursos_al = new ArrayList<Curso>(MetodosHito.leerCurso(obj.getCodigoCurso(), 5));
                Curso c = cursos_al.get(0);
                System.out.printf("%-20s %-10s\n", c.getNombre(), c.getCreditos());
                sumacreditos += c.getCreditos();
            }
            System.out.println("La suma de los creditos del alumno es = " + sumacreditos);
        }catch(Exception e){
            System.out.println("Ha habido algun error");
        }
    }  

    public static void opcion6() {
        try{
        List<Alumno> alumnos_al = MetodosHito.Matriculado(false);
        escribirAlumno(alumnos_al);
        }catch(Exception e){
            System.out.println("Ha habido algun error");
        }
    }

    public static void opcion7() {
        try{            
            List<Alumno> alumnos_al = MetodosHito.Matriculado(true);
            List<Alumno> alumnosMayoresEdad = new ArrayList<Alumno>();
            String fechanazi = null;
            String partes[];
            Calendar fecha = new GregorianCalendar();
            int anoNow = fecha.get(Calendar.YEAR);
            int mayoriaedad = anoNow - 18;
            int ano;
            for (Alumno obj : alumnos_al) {
                fechanazi = obj.getNacimiento();
                partes = fechanazi.split("/");
                ano = Integer.parseInt(partes[2]);
                if (ano < mayoriaedad) {
                    alumnosMayoresEdad.add(obj);
                }
            }
            MetodosHito.escribirAlumno(alumnosMayoresEdad);
        }catch(Exception e){
            System.out.println("Ha habido algun error");
        }
    }

    public static void opcion8() {
        try{
            List<Alumno> alumnos_al = MetodosHito.Matriculado(true);
            List<Alumno> alumnosAnoBisiesto = new ArrayList<Alumno>();
            String fechanazi = null;
            String partes[];
            int ano;
            for (Alumno obj : alumnos_al) {
                fechanazi = obj.getNacimiento();
                partes = fechanazi.split("/");
                ano = Integer.parseInt(partes[2]);
                if ((ano % 4 == 0) && ((ano % 100 != 0) || (ano % 400 == 0))) {
                    alumnosAnoBisiesto.add(obj);
                }
            }
            MetodosHito.escribirAlumno(alumnosAnoBisiesto);
        }catch(Exception e){
            System.out.println("Ha habido algun error");
        }
    }

    public static void opcion9() {
        try{
            List<Matricula> matricula_al = new ArrayList<Matricula>();
            Map<String, Integer> totalAsig_mp = new HashMap<String, Integer>();
            matricula_al = MetodosHito.leerMatricula("", 9);
            String cod=null;

            for(int i = 0;i<matricula_al.size();i++){
                int total=0;
                cod=matricula_al.get(i).getCodigoAlumno();
                for(int x = 0;x<matricula_al.size();x++){
                    if(matricula_al.get(x).getCodigoAlumno().equals(cod)){
                        total++;    
                    }
                }
                totalAsig_mp.put(matricula_al.get(i).getCodigoAlumno(), total);
                //System.out.println(matricula_al.get(i)+" esta matriculado en "+total+" asignaturas");
            }       
            List<Alumno>alumnos_al=MetodosHito.leerAlumno(11, "");

            try {
                if (alumnos_al != null) {
                    System.out.printf("%-6s %-10s %-10s %-12s %-5s %-20s\n", "CODIGO", "NOMBRE", "PATERNO", "NACIMIENTO", "SEXO", "NUMERO_ASIGNATURAS");
                    for (int i = 0; i < alumnos_al.size(); i++) {
                        Alumno a = (Alumno) alumnos_al.get(i);
                        System.out.printf("%-6s %-10s %-10s %-12s %-5s %-20s\n", a.getCodigoAlumno(), a.getNombre(), a.getPaterno(), a.getNacimiento(), a.getSexo(), totalAsig_mp.get(a.getCodigoAlumno()));
                    }
                } else {
                    System.out.println("ERROR: LISTA VACIA");
                }
            } catch (Exception e) {
                alumnos_al = null;
            }
        }catch(Exception e){
            System.out.println("Ha habido algun error");
        }

    }
    
    public static void opcion10(){
       try{
        List<Matricula> matricula_al = new ArrayList<Matricula>();
        Map<String, Integer> totalAsig_mp = new HashMap<String, Integer>();
        matricula_al = MetodosHito.leerMatricula("", 9);
       
        String cod=null;
       
        for(int i = 0;i<matricula_al.size();i++){
            int total=0;
            cod=matricula_al.get(i).getCodigoCurso();
            for(int x = 0;x<matricula_al.size();x++){
                if(matricula_al.get(x).getCodigoCurso().equals(cod)){
                    total++;    
                }
            }
            totalAsig_mp.put(matricula_al.get(i).getCodigoCurso(), total);
            //System.out.println(matricula_al.get(i)+" esta matriculado en "+total+" asignaturas");
        }       
        List<Curso>curso_al=MetodosHito.leerCurso("", 0);
                      
        try {
            if (curso_al != null) {
                System.out.printf("%-6s %-15s %-15s %-10s\n", "CODIGO", "NOMBRE", "CREDITOS", "ALUMNOS_MATRICULADOS");
                for (int i = 0; i < curso_al.size(); i++) {
                    Curso c = curso_al.get(i);
                    System.out.printf("%-6s %-15s %-15s %-10s\n", c.getCodigoCurso(), c.getNombre(), c.getCreditos(), totalAsig_mp.get(c.getCodigoCurso()));
                }
            } else {
                System.out.println("ERROR: LISTA VACIA");
            }
        } catch (Exception e) {
            curso_al = null;
        }
        }catch(Exception e){
            System.out.println("Ha habido algun error");
        }
    }

}