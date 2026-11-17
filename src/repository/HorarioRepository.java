package repository;

public class HorarioRepository {

    public String[][] cargarHorarios() {
        String[][] datosHorario = {
            {"1", "PartTime", "08:00", "12:00", "10"},
            {"2", "FullTime", "08:00", "17:00", "15"}
        };
        return datosHorario;
    }
}
