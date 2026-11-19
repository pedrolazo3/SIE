 
package model;
 
public class Empleado {
    private int idEmpleado;
    private String codigo;
    private String nombre;
    private String apellido;
    private int idHorario;
    private String idEstado;

    public Empleado(int idEmpleado, String codigo, 
            String nombre, String apellido,int idHorario
            ,String idEstado) {
        this.idEmpleado = idEmpleado;
        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.idHorario = idHorario;
        this.idEstado=idEstado;
    }
    public Empleado(){
        
    }

    public void setIdEstado(String idEstado) {
        this.idEstado = idEstado;
    }

    public String getIdEstado() {
        return idEstado;
    }

    
    
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApellido() {
        return apellido;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIdHorario(int idHorario) {
        this.idHorario = idHorario;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getIdHorario() {
        return idHorario;
    }
    
}
