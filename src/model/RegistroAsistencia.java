
package model;

public class RegistroAsistencia {
    private int idRegistro;
    private int idEmpleado;
    private String fecha;
    private String hora;
    private int tipo;

    public RegistroAsistencia(int idRegistro, int idEmpleado, String fecha, String hora, int tipo) {
        this.idRegistro = idRegistro;
        this.idEmpleado = idEmpleado;
        this.fecha = fecha;
        this.hora = hora;
        this.tipo = tipo;
    }

    public void setIdRegistro(int idRegistro) {
        this.idRegistro = idRegistro;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public int getIdRegistro() {
        return idRegistro;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public int getTipo() {
        return tipo;
    }
        
}
