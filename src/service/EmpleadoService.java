package service;

import repository.EmpleadoRepository;
import static service.HorarioService.datosHorario;
import model.Empleado;
import sie.MenuConsola;

public class EmpleadoService {

    EmpleadoRepository empleadosRepo = new EmpleadoRepository();
    String[][] datosEmpleado = empleadosRepo.cargarEmpleados();

    public void mostrarEmpleados() {

        System.out.printf("%s %17s %17s %25s %12s\n",
                "Codigo", "Nombre", "Apellido", "Horario", "Estado");
        for (String[] fila : datosEmpleado) {
            String horarioNombre = obtenerNombreHorario(fila[4]);
            String estado = fila[5] == "1" ? "Activo" : "Inactivo";
            System.out.printf("%s %12s %25s %18s %12s", fila[1], fila[2],
                    fila[3], horarioNombre, estado);
            System.out.println("");
        }
    }

    public void mostrarEmpleadosActivos() {

        System.out.printf("%s %17s %17s %25s %12s\n",
                "Codigo", "Nombre", "Apellido", "Horario", "Estado");
        for (String[] fila : datosEmpleado) {
            if (fila[5] == "1") {
                String horarioNombre = obtenerNombreHorario(fila[4]);
                String estado = "Activo";
                System.out.printf("%s %12s %25s %18s %12s", fila[1], fila[2],
                        fila[3], horarioNombre, estado);
                System.out.println("");
            }

        }
    }

    public String obtenerNombreHorario(String idHorario) {
        for (String[] fila : datosHorario) {
            if (fila[0].equalsIgnoreCase(idHorario)) {
                return fila[1];
            }
        }
        return "xx";
    }

    public String generarCodigoEmpleado(String nombre, String apellido) {
        String prefijo = obtenerPrefijo(nombre, apellido);   // "JUME"
        int correlativo = obtenerSiguienteCorrelativo(datosEmpleado, prefijo);
        return prefijo + String.format("%02d", correlativo);  // "JUME03"
    }

    private String obtenerPrefijo(String nombre, String apellido) {
        return primerLetra(nombre.toLowerCase()) + primerApellido(apellido.toLowerCase());   // "JUME"
    }

    private String primerLetra(String texto) {
        if (texto.isEmpty()) {
            return "XX";
        }
        if (texto.length() == 1) {
            return texto + "X";
        }
        return texto.substring(0, 1);
    }

    private String primerApellido(String texto) {
        if (texto == null || texto.trim().isEmpty()) {
            return "XX";
        }
        return texto.trim().split("\\s+")[0];
    }

    public int obtenerSiguienteCorrelativo(String[][] datosEmpleado, String prefijo) {
        int maxCorrelativo = 0;

        for (String[] fila : datosEmpleado) {
            String codigo = fila[1].toLowerCase();   // columna 1 = codigo

            if (codigo != null && codigo.startsWith(prefijo)) {
                // Extrae los 2 dígitos finales: "jume02" -> "02"
                String numeros = codigo.substring(prefijo.length());
                try {
                    int correlativo = Integer.parseInt(numeros);
                    if (correlativo > maxCorrelativo) {
                        maxCorrelativo = correlativo;
                    }
                } catch (NumberFormatException e) {
                    // Si el código no termina en número, lo ignoramos
                }
            }
        }

        return maxCorrelativo + 1;
    }

    public int obtenerSiguienteIdEmpleado() {
        int mayorIdEmpleado = Integer.parseInt(datosEmpleado[0][0]);
        for (String[] fila : datosEmpleado) {
            if (mayorIdEmpleado < Integer.parseInt(fila[0].toString())) {
                mayorIdEmpleado = Integer.parseInt(fila[0].toString());
            }
        }
        return mayorIdEmpleado + 1;
    }

    public void registrarEmpleado(Empleado empleado) {
        String[][] nuevaMatriz = new String[datosEmpleado.length + 1][5];
        for (int i = 0; i < datosEmpleado.length; i++) {
            nuevaMatriz[i] = datosEmpleado[i];
        }
        nuevaMatriz[nuevaMatriz.length - 1] = new String[]{
            String.valueOf(empleado.getIdEmpleado()),
            empleado.getCodigo(),
            empleado.getNombre(),
            empleado.getApellido(),
            String.valueOf(empleado.getIdHorario()),
            empleado.getIdEstado()};

        datosEmpleado = nuevaMatriz;
    }

    public boolean editarEmpleadoPorCodigo(String codigo,
            String nuevoNombre, String nuevoApellido) {
        for (int i = 0; i < datosEmpleado.length; i++) {
            if (datosEmpleado[i][1] != null && datosEmpleado[i][1].equals(codigo)) {
                // Columna 2 = nombre -> solo se edita si no viene vacío
                if (nuevoNombre != null && !nuevoNombre.trim().isEmpty()) {
                    datosEmpleado[i][2] = nuevoNombre;
                }
                // Columna 3 = apellido -> solo se edita si no viene vacío
                if (nuevoApellido != null && !nuevoApellido.trim().isEmpty()) {
                    datosEmpleado[i][3] = nuevoApellido;
                }
                return true;
            }
        }
        return false;
    }

    public boolean existeCodigo(String codigo) {
        for (int i = 0; i < datosEmpleado.length; i++) {
            if (datosEmpleado[i][1] != null && datosEmpleado[i][1].equals(codigo)) {
                return true;
            }
        }
        return false;
    }

}
