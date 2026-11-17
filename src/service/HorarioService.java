package service;

import model.Empleado;
import repository.HorarioRepository;

public class HorarioService {

    static HorarioRepository dbHorario = new HorarioRepository();
    static String[][] datosHorario = dbHorario.cargarHorarios();

    public void mostrarHorarios() {
        System.out.printf("Codigo      Nombre       Hora entrada        Hora Salida     Tolerancia \n");
        for (String[] fila : datosHorario) {
            System.out.printf("%s %18s %12s %20s %10s min", fila[0], fila[1], fila[2], fila[3], fila[4]);
            System.out.println("");
        }
    }
}
