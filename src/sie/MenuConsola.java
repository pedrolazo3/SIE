package sie;

public class MenuConsola {

    // Códigos ANSI
    private static final String RESET = "\u001B[0m";
    private static final String BOLD = "\u001B[1m";
    private static final String CYAN =  "\u001B[34m";
    private static final String BLUE = "\u001B[34m";
    private static final String GREEN = "\u001B[32m";
    private static final String YELLOW = "\u001B[33m";
    private static final String RED = "\u001B[31m";
    private static final String PURPLE = "\u001B[35m"; 

    public static void imprimirMenu() {
        int ancho = 60;

        String lineaArriba = BOLD + CYAN + "╔" + "═".repeat(ancho) + "╗" + RESET;
        String lineaAbajo = BOLD + CYAN + "╚" + "═".repeat(ancho) + "╝" + RESET;
        String separador = BOLD + CYAN + "╠" + "═".repeat(ancho) + "╣" + RESET;

        System.out.println();
        System.out.println(lineaArriba);
        System.out.println(BOLD + CYAN + "║" + centrar("SISTEMA DE CONTROL DE EMPLEADOS", ancho-9) + "║" + RESET);
        System.out.println(separador);
        System.out.println(BOLD + CYAN + "║" + RESET + " " + GREEN + "[1]" + RESET + "  Menu empleados" + " ".repeat(ancho - 33) + BOLD + CYAN + "║" + RESET);
        System.out.println(BOLD + CYAN + "║" + RESET + " " + GREEN + "[2]" + RESET + "  Menu horarios" + " ".repeat(ancho - 33) + BOLD + CYAN + "║" + RESET);
        System.out.println(BOLD + CYAN + "║" + RESET + " " + YELLOW + "[3]" + RESET + "  Registrar ingreso" + " ".repeat(ancho - 32) + BOLD + CYAN + "║" + RESET);
        System.out.println(BOLD + CYAN + "║" + RESET + " " + YELLOW + "[4]" + RESET + "  Registrar salida" + " ".repeat(ancho - 31) + BOLD + CYAN + "║" + RESET);
        System.out.println(BOLD + CYAN + "║" + RESET + " " + BLUE + "[5]" + RESET + "  Ver reporte por empleado" + " ".repeat(ancho - 39) + BOLD + CYAN + "║" + RESET);
        System.out.println(separador);
        System.out.println(BOLD + CYAN + "║" + RESET + " " + RED + "[0]" + RESET + "  Salir" + " ".repeat(ancho - 20) + BOLD + CYAN + "║" + RESET);
        System.out.println(lineaAbajo);
        System.out.println();
    }


    public static int leerOpcion(java.util.Scanner sc) {
        while (true) {
            System.out.print(BOLD + PURPLE + "➤ Seleccione una opción: " + RESET);
            String entrada = sc.nextLine().trim();
            try {
                int opcion = Integer.parseInt(entrada);
                if (opcion >= 0 && opcion <= 4) {
                    return opcion;
                }
                System.out.println(RED + "✖ Opción fuera de rango. Intente de nuevo." + RESET);
            } catch (NumberFormatException e) {
                System.out.println(RED + "✖ Debe ingresar un número." + RESET);
            }
        }
    }


    private static String centrar(String texto, int ancho) {
        if (texto.length() >= ancho) {
            return texto;
        }
        int izquierda = (ancho - texto.length()) / 2;
        int derecha = ancho - texto.length() - izquierda;
        return " ".repeat(izquierda) + texto + " ".repeat(derecha);
    }

    /**
     * Imprime un mensaje de éxito con ícono.
     */
    public static void exito(String msg) {
        System.out.println(GREEN + "✔ " + msg + RESET);
    }

    /**
     * Imprime un mensaje de error con ícono.
     */
    public static void error(String msg) {
        System.out.println(RED + "✖ " + msg + RESET);
    }

    /**
     * Imprime un mensaje informativo.
     */
    public static void info(String msg) {
        System.out.println(CYAN + "ℹ " + msg + RESET);
    }

    /**
     * Pausa hasta que el usuario presione Enter.
     */
    public static void pausar(java.util.Scanner sc) {
        System.out.print(YELLOW + "Presione ENTER para continuar..." + RESET);
        sc.nextLine();
    }
    
    public static void imprimirMenuEmpleado() {
        int ancho = 60;

        String lineaArriba = BOLD + CYAN + "╔" + "═".repeat(ancho) + "╗" + RESET;
        String lineaAbajo = BOLD + CYAN + "╚" + "═".repeat(ancho) + "╝" + RESET;
        String separador = BOLD + CYAN + "╠" + "═".repeat(ancho) + "╣" + RESET;

        System.out.println();
        System.out.println(lineaArriba);
        System.out.println(BOLD + CYAN + "║" + centrar("SISTEMA DE CONTROL DE EMPLEADOS - Menu empleado", ancho-9) + "║" + RESET);
        System.out.println(separador);
        System.out.println(BOLD + CYAN + "║" + RESET + " " + GREEN + "[1]" + RESET + "  Registrar empleado" + " ".repeat(ancho - 33) + BOLD + CYAN + "║" + RESET);
        System.out.println(BOLD + CYAN + "║" + RESET + " " + YELLOW + "[2]" + RESET + "  Editar empleado" + " ".repeat(ancho - 32) + BOLD + CYAN + "║" + RESET);
        System.out.println(BOLD + CYAN + "║" + RESET + " " + YELLOW + "[3]" + RESET + "  Eliminar empleado" + " ".repeat(ancho - 31) + BOLD + CYAN + "║" + RESET);
        System.out.println(BOLD + CYAN + "║" + RESET + " " + BLUE + "[4]" + RESET + "  Ver reporte de empleados" + " ".repeat(ancho - 39) + BOLD + CYAN + "║" + RESET);
        System.out.println(separador);
        System.out.println(BOLD + CYAN + "║" + RESET + " " + RED + "[0]" + RESET + "  Menu principal" + " ".repeat(ancho - 20) + BOLD + CYAN + "║" + RESET);
        System.out.println(lineaAbajo);
        System.out.println();
    }
    
    public static void imprimirMenuHorario() {
        int ancho = 60;

        String lineaArriba = BOLD + CYAN + "╔" + "═".repeat(ancho) + "╗" + RESET;
        String lineaAbajo = BOLD + CYAN + "╚" + "═".repeat(ancho) + "╝" + RESET;
        String separador = BOLD + CYAN + "╠" + "═".repeat(ancho) + "╣" + RESET;

        System.out.println();
        System.out.println(lineaArriba);
        System.out.println(BOLD + CYAN + "║" + centrar("SISTEMA DE CONTROL DE EMPLEADOS - Menu horarios", ancho-9) + "║" + RESET);
        System.out.println(separador);
        System.out.println(BOLD + CYAN + "║" + RESET + " " + GREEN + "[1]" + RESET + "  Registrar horario" + " ".repeat(ancho - 33) + BOLD + CYAN + "║" + RESET);
        System.out.println(BOLD + CYAN + "║" + RESET + " " + YELLOW + "[2]" + RESET + "  Editar horario" + " ".repeat(ancho - 32) + BOLD + CYAN + "║" + RESET);
        System.out.println(BOLD + CYAN + "║" + RESET + " " + YELLOW + "[3]" + RESET + "  Eliminar horarios" + " ".repeat(ancho - 31) + BOLD + CYAN + "║" + RESET);
        System.out.println(BOLD + CYAN + "║" + RESET + " " + BLUE + "[4]" + RESET + "  Ver reporte de horarios" + " ".repeat(ancho - 39) + BOLD + CYAN + "║" + RESET);
        System.out.println(separador);
        System.out.println(BOLD + CYAN + "║" + RESET + " " + RED + "[0]" + RESET + "  Menu principal" + " ".repeat(ancho - 20) + BOLD + CYAN + "║" + RESET);
        System.out.println(lineaAbajo);
        System.out.println();
    }
}
