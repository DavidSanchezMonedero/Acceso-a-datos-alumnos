package principal;

import java.util.List;
import java.util.Scanner;


public class Main {


    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String s,f1,f2;
        do{
            do{
            MetodosHito.cls();
            MetodosHito.menu();
            s = sc.next();
            }while(!(Integer.parseInt(s)>=0 && Integer.parseInt(s)<=10));
            switch(s){
                case "1":
                case "01":  
                    MetodosHito.cls();
                    System.out.println("Mostrar datos de un alumno:\n\n");
                    System.out.print("Ingrese el codigo del alumno: ");
                    s = sc.next();
                    MetodosHito.opcion1(s);
                    MetodosHito.pause();
                    break;
                    
                case "2":
                case "02":
                    MetodosHito.cls();
                    System.out.println("Mostrar los alumnos matriculados en una fecha:\n\n");
                    System.out.print("Ingrese una fecha de matriculacion en formato (dd/MM/aaaa): ");
                    s = sc.next();
                    MetodosHito.opcion2(s);
                    MetodosHito.pause();
                    break;
                    
                case "3":
                case "03":
                    MetodosHito.cls();
                    System.out.println("Mostrar los alumnos matriculados entre 2 fechas:\n\n");
                    System.out.println("Ingrese las fechas en formato (dd/MM/aaaa: ");
                    System.out.print("Ingrese la primera fecha: ");
                    f1 = sc.next();
                    System.out.print("Ingrese la segunda fecha: ");
                    f2 = sc.next();
                    MetodosHito.opcion3(f1,f2);
                    MetodosHito.pause();
                    break;
                    
                case "4":
                case "04":                   
                    MetodosHito.cls();
                    System.out.println("Mostrar alumnos matriculados en una asignatura:\n\n");
                    System.out.print("Ingrese el nombre de una asignatura: ");
                    s = sc.next();
                    MetodosHito.opcion4(s);
                    MetodosHito.pause();
                    break;
                
                case "5":
                case "05": 
                    MetodosHito.cls();
                    System.out.println("Mostrar asignaturas a las que esta matriculado un alumno:\n\n");
                    System.out.println("Ingrese el código de un alumno");
                    s = sc.next();
                    MetodosHito.opcion5(s);
                    MetodosHito.pause();
                    break;
                case "6":
                case "06":                     
                    MetodosHito.cls();
                    System.out.println("Mostrar todos los alumnos que no estan matriculados en ninguna asignatura:\n\n");
                    MetodosHito.opcion6();
                    MetodosHito.pause();
                    break;
                case "7":
                case "07":           
                    MetodosHito.cls();
                    System.out.println("Mostrar alumnos menores de edad matriculados:\n\n");
                    MetodosHito.opcion7();
                    MetodosHito.pause();
                    break;
                case "8":
                case "08":                    
                    MetodosHito.cls();
                    System.out.println("Mostrar alumnos nacidos en año bisiesto:\n\n");
                    MetodosHito.opcion8();
                    MetodosHito.pause();
                    break;
                case "9":
                case "09":                    
                    MetodosHito.cls();
                    System.out.println("Mostrar datos los alumnos junto a el numero de asignaturas a las que estan amtriculados:\n\n");
                    MetodosHito.opcion9();
                    MetodosHito.pause();
                    break; 
                case "10":                   
                    MetodosHito.cls();
                    System.out.println("Mostrar asignaturas indicando cuantos alumnos tiene matriculado cada asignatura:\n\n");
                    MetodosHito.opcion10();
                    MetodosHito.pause();
                    break;
            }
        }while(!s.equals("0"));

        
    }
    
}
