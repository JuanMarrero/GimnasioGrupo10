package gimnasiogrupo10.entidades;

import java.sql.Time;
import java.time.LocalTime;


public class Clases {
    
    private int ID_Clase;
    private String Nombre;
    private Entrenadores entrenadores;
    private LocalTime Horario;
    private int Capacidad;
    private boolean Estado;

    public Clases() {
    }

    public Clases(int ID_Clase, String Nombre, Entrenadores entrenadores, LocalTime Horario, int Capacidad, boolean Estado) {
        this.ID_Clase = ID_Clase;
        this.Nombre = Nombre;
        this.entrenadores = entrenadores;
        this.Horario = Horario;
        this.Estado=Estado;
        this.Capacidad=Capacidad;
    }

    public int getCapacidad() {
        return Capacidad;
    }

    public void setCapacidad(int Capacidad) {
        this.Capacidad = Capacidad;
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }

    public Clases(String Nombre, Entrenadores entrenadores, LocalTime Horario,int Capacidad, boolean Estado) {
        this.Nombre = Nombre;
        this.entrenadores = entrenadores;
        this.Horario = Horario;
        this.Estado=Estado;
        this.Capacidad=Capacidad;
    }

    public int getID_Clase() {
        return ID_Clase;
    }

    public void setID_Clase(int ID_Clase) {
        this.ID_Clase = ID_Clase;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public Entrenadores getEntrenadores() {
        return entrenadores;
    }

    public void setEntrenadores(Entrenadores entrenadores) {
        this.entrenadores = entrenadores;
    }

    public LocalTime getHorario() {
        return Horario;
    }

    public void setHorario(LocalTime Horario) {
        this.Horario = Horario;
    }

    @Override
    public String toString() {
        return Nombre + ", entrenadores=" + entrenadores + ", Horario=" + Horario ;
    }
    
    
    
    
}
