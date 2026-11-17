
package model;
 
public class Horario {
    private int idHorario;
    private String nombre;
    private String horaEntrada;
    private String horaSalida;
    private int toleranciaMin;

    public Horario(int idHorario, String nombre, String horaEntrada, String horaSalida, int toleranciaMin) {
        this.idHorario = idHorario;
        this.nombre = nombre;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.toleranciaMin = toleranciaMin;
    }

    public int getIdHorario() {
        return idHorario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public int getToleranciaMin() {
        return toleranciaMin;
    }

    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public void setToleranciaMin(int toleranciaMin) {
        this.toleranciaMin = toleranciaMin;
    }
    
}
