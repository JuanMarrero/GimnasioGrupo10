/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gimnasiogrupo10.entidades;

/**
 *
 * @author Juan
 */
public class Entrenadores {
    
    private int ID_Entrenador;
    private int DNI;
    private String Nombre;
    private String Apellido;
    private String Especialidad;
    private boolean Estado;
    

    public Entrenadores() {
    }

    public Entrenadores(int ID_Entrenador, int DNI, String Nombre, String Apellido, String Especialidad, boolean Estado) {
        this.ID_Entrenador = ID_Entrenador;
        this.DNI = DNI;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Especialidad = Especialidad;
        this.Estado = Estado;
    }

    public Entrenadores(int DNI, String Nombre, String Apellido, String Especialidad, boolean Estado) {
        this.DNI = DNI;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Especialidad = Especialidad;
        this.Estado = Estado;
    }

    public int getID_Entrenador() {
        return ID_Entrenador;
    }

    public void setID_Entrenador(int ID_Entrenador) {
        this.ID_Entrenador = ID_Entrenador;
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getEspecialidad() {
        return Especialidad;
    }

    public void setEspecialidad(String Especialidad) {
        this.Especialidad = Especialidad;
    }

    public boolean getEstado() {
        return Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }

    @Override
    public String toString() {
        return  ID_Entrenador + "," + Nombre + "," + Apellido + "," + Especialidad ;
    }
    
    
    
}
