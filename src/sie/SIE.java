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

    public static void menuPrincipal() {
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
                case 0 ->
                    MenuConsola.info("Saliendo del sistema...");
            }
            if (opcion != 0) {
                MenuConsola.pausar(sc);
            }
        } while (opcion != 0);
        sc.close();
    }

    public static void menuEmpleado() {
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
                    editarEmpleado();
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

    public static void menuHorario() {
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
                    horarioService.mostrarHorarioService();
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
        int idHorario = mostrarHorarios();
        if(idHorario==0)return;

        String codigo = empleadoService.generarCodigoEmpleado(nombre, apellido);
        //System.out.println("Codigo autogenerado: " + codigo);
        MenuConsola.info("Codigo autogenerado: " + codigo);

        Empleado empleado = new Empleado();
        empleado.setIdEmpleado(empleadoService.obtenerSiguienteIdEmpleado());
        empleado.setNombre(nombre);
        empleado.setApellido(apellido);
        empleado.setCodigo(codigo);
        empleado.setIdHorario(idHorario);
        empleado.setIdEstado("1");
        empleadoService.registrarEmpleado(empleado);
        MenuConsola.exito("Empleado registrado.");
        empleadoService.mostrarEmpleados();
    }

    public static void editarEmpleado() {

        empleadoService.mostrarEmpleados();
        System.out.println("Para editar ingrese codigo : ");
        String codigo = sc.nextLine().trim();

        if (codigo.isEmpty()) {
            MenuConsola.error("El código no puede estar vacío.");
            //editarEmpleado();
            return;
        }

        if (!empleadoService.existeCodigo(codigo)) {
            MenuConsola.error("No existe un empleado con ese código.");
            //editarEmpleado();
            return;
        }
 
        System.out.println("Ingrese nombre (puede dejarlo vacío si edita el apellido) : ");
        String nombre = sc.nextLine().trim();

        System.out.println("Ingrese apellido (puede dejarlo vacío si edita el nombre) : ");
        String apellido = sc.nextLine().trim();

        // Validación: al menos uno de los dos debe tener valor
        if (nombre.isEmpty() && apellido.isEmpty()) {
            MenuConsola.error("Debe ingresar al menos el nombre o el apellido.");
            return;
        }

        boolean editado = empleadoService.editarEmpleadoPorCodigo(codigo, nombre, apellido);

        if (editado) {
            MenuConsola.exito("Empleado editado.");
            empleadoService.mostrarEmpleados();
        } else {
            MenuConsola.error("No se encontró un empleado con ese código.");
        }
    }

    public static int mostrarHorarios() {
        System.setOut(new PrintStream(System.out, true, StandardCharsets.UTF_8));
        Scanner sc = new Scanner(System.in);
        int idHorario=0;
        MenuConsola.info("Mostrando horarios disponibles...");
        horarioService.mostrarHorarioService();
        
        System.out.println("Ingrese Codigo de horario : ");
        String codigo = sc.nextLine().trim();

        if (codigo.isEmpty()) {
            MenuConsola.error("El idHorario no puede estar vacío.");            
            return 0;
        }

        if (!horarioService.existeIdHorario(codigo)) {
            MenuConsola.error("No existe un horario con este código.");
            return 0;
        }         
        idHorario = Integer.parseInt(codigo);
        return idHorario;
    }

    public static void registrarIngreso() {
        //Pedir codigo de empleado y luego mostrar la hora  actual
        //finalmente pedir confirmar para registrar ingreso.
    }

    public static void registrarSalida() {
        //Pedir codigo de empleado y luego mostrar la hora  actual
        //finalmente pedir confirmar para registrar salida.
    }
}
