
package repository;


public class EmpleadoRepository {
     public String[][] cargarEmpleados() {
        String[][] datosEmpleado = {
            {"1", "mrosales01", "Maria", "Rosales Jimenez", "1"},
            {"2", "jmendoza01", "Juana", "Mendoza Casimiro", "1"},
            {"3", "lcobain01", "Luis", "Cobain Poter", "2"},
            {"4", "jmendoza02", "Julia", "Mendoza Contreras", "2"}
        };
        return datosEmpleado;
    }
}
