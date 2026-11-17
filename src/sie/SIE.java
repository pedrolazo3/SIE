package sie;

import java.io.PrintStream;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import repository.EmpleadoRepository;
import repository.HorarioRepository;
import service.EmpleadoService;
import service.HorarioService;
import model.Empleado;

public class SIE {

    static EmpleadoService empleadoService = new EmpleadoService();
    static HorarioService horarioService = new HorarioService();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        menuPrincipal();
       
        
    }
    public static void menuPrincipal(){
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int opcion;
        
        do {
            MenuConsola.imprimirMenu();
            opcion = MenuConsola.leerOpcion(sc);

            switch (opcion) {
                case 1 -> {
                    MenuConsola.info("Menu empleados...");
                    menuEmpleado();
                    // TODO: lógica de registro
                    //MenuConsola.exito("Empleado registrado.");
                }
                case 2 -> {
                    MenuConsola.info("Menu horarios...");
                    menuHorario();
                    // TODO: lógica de ingreso
                }
                case 3 -> {
                    MenuConsola.info("Registrando ingreso...");                    
                    // TODO: lógica de ingreso
                }
                case 4 -> {
                    MenuConsola.info("Registrando salida...");
                    // TODO: lógica de salida
                }
                case 5 -> {
                    MenuConsola.info("Mostrando reporte por empleado...");
                    // TODO: lógica de reporte
                }
                case 0 -> MenuConsola.info("Saliendo del sistema...");
            }

            if (opcion != 0) {
                MenuConsola.pausar(sc);
            }
        } while (opcion != 0);

        sc.close();
    }
    public static void menuEmpleado(){
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int opcion;
        
        do {
            MenuConsola.imprimirMenuEmpleado();
            opcion = MenuConsola.leerOpcion(sc);

            switch (opcion) {
                case 1 -> {
                    MenuConsola.info("Registrando empleado...");
                    // TODO: lógica de registro
                    registrarEmpleado();                    
                }
                case 2 -> {
                    MenuConsola.info("Editando empleado...");
                    // TODO: lógica de ingreso
                    MenuConsola.exito("Empleado editado.");
                }
                case 3 -> {
                    MenuConsola.info("Eliminando empleado...");
                    // TODO: lógica de salida
                    MenuConsola.exito("Empleado eliminado.");
                }
                case 4 -> {
                    MenuConsola.info("Mostrando reporte de empleados...");
                    empleadoService.mostrarEmpleados();
                }
                case 0 -> {
                    MenuConsola.info("Regresando al menu principal...");
                    menuPrincipal();
                }
            }

            if (opcion != 0) {
                MenuConsola.pausar(sc);
            }
        } while (opcion != 0);

        sc.close();
    }
    public static void menuHorario(){
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int opcion;
        
        do {
            MenuConsola.imprimirMenuHorario();
            opcion = MenuConsola.leerOpcion(sc);

            switch (opcion) {
                case 1 -> {
                    MenuConsola.info("Registrando horario...");
                    // TODO: lógica de registro
                    MenuConsola.exito("horario registrado.");
                }
                case 2 -> {
                    MenuConsola.info("Editando horario...");
                    // TODO: lógica de ingreso
                    MenuConsola.exito("horario editado.");
                }
                case 3 -> {
                    MenuConsola.info("Eliminando horario...");
                    // TODO: lógica de salida
                    MenuConsola.exito("horario eliminado.");
                }
                case 4 -> {
                    MenuConsola.info("Mostrando reporte de horario...");
                    // TODO: lógica de reporte
                }
                case 0 -> {
                    MenuConsola.info("Regresando al menu principal...");
                    menuPrincipal();
                }
            }

            if (opcion != 0) {
                MenuConsola.pausar(sc);
            }
        } while (opcion != 0);

        sc.close();
    }
    
    public static void registrarEmpleado() {
        System.out.println("Ingrese nombre : ");
        String nombre = sc.nextLine();

        System.out.println("Ingrese apellido : ");
        String apellido = sc.nextLine();

        System.out.println("\n Horarios disponibles: \n");
        horarioService.mostrarHorarios();

        System.out.println("Ingrese codigo de horario : ");
        int idHorario = sc.nextInt();

        String codigo = empleadoService.generarCodigoEmpleado(nombre, apellido);
        System.out.println("Codigo autogenerado: " + codigo);
        
        Empleado empleado = new Empleado();
        empleado.setIdEmpleado(empleadoService.obtenerSiguienteIdEmpleado());
        empleado.setNombre(nombre);
        empleado.setApellido(apellido);
        empleado.setCodigo(codigo);
        empleado.setIdHorario(idHorario);
        empleadoService.registrarEmpleado(empleado);
        MenuConsola.exito("Empleado registrado.");
        empleadoService.mostrarEmpleados();
    }
    public static void registrarIngreso(){
        //Pedir codigo de empleado y luego mostrar la hora  actual
        //finalmente pedir confirmar para registrar ingreso.
    }
    public static void registrarSalida(){
        //Pedir codigo de empleado y luego mostrar la hora  actual
        //finalmente pedir confirmar para registrar salida.
    }   
}
