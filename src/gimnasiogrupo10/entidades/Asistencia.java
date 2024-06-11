
package gimnasiogrupo10.entidades;

import java.time.LocalDate;

public class Asistencia {
    private int ID_Asistencia;
    private Socios socio;
    private Clases clase;
    private LocalDate Fecha_Asistencia;

    public Asistencia() {
    }

    public Asistencia(int ID_Asistencia, Socios socio, Clases clase, LocalDate Fecha_Asistencia) {
        this.ID_Asistencia = ID_Asistencia;
        this.socio = socio;
        this.clase = clase;
        this.Fecha_Asistencia = Fecha_Asistencia;
    }

    public Asistencia(Socios socio, Clases clase, LocalDate Fecha_Asistencia) {
        this.socio = socio;
        this.clase = clase;
        this.Fecha_Asistencia = Fecha_Asistencia;
    }

    public int getID_Asistencia() {
        return ID_Asistencia;
    }

    public void setID_Asistencia(int ID_Asistencia) {
        this.ID_Asistencia = ID_Asistencia;
    }

    public Socios getSocio() {
        return socio;
    }

    public void setSocio(Socios socio) {
        this.socio = socio;
    }

    public Clases getClase() {
        return clase;
    }

    public void setClase(Clases clase) {
        this.clase = clase;
    }

    public LocalDate getFecha_Asistencia() {
        return Fecha_Asistencia;
    }

    public void setFecha_Asistencia(LocalDate Fecha_Asistencia) {
        this.Fecha_Asistencia = Fecha_Asistencia;
    }

    @Override
    public String toString() {
        return "Asistencia{" + "ID_Asistencia=" + ID_Asistencia + ", socio=" + socio + ", clase=" + clase + ", Fecha_Asistencia=" + Fecha_Asistencia + '}';
    }

}
