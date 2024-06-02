/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gimnasiogrupo10.entidades;

import java.util.Date;

/**
 *
 * @author Juan
 */
public class Inscripciones {
    
    private int ID_Inscripto;
    private Socios socio;
    private Clases clase;
    private Date Fecha_Asistencia;

    public Inscripciones() {
    }

    public Inscripciones(int ID_Inscripto, Socios socio, Clases clase) {
        this.ID_Inscripto = ID_Inscripto;
        this.socio = socio;
        this.clase = clase;
        this.Fecha_Asistencia=Fecha_Asistencia;
    }

    public Inscripciones(Socios socio, Clases clase) {
        this.socio = socio;
        this.clase = clase;
        this.Fecha_Asistencia=Fecha_Asistencia;
    }

    public int getID_Inscripto() {
        return ID_Inscripto;
    }

    public Date getFecha_Asistencia() {
        return Fecha_Asistencia;
    }

    public void setFecha_Asistencia(Date Fecha_Asistencia) {
        this.Fecha_Asistencia = Fecha_Asistencia;
    }

    public void setID_Inscripto(int ID_Inscripto) {
        this.ID_Inscripto = ID_Inscripto;
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

    @Override
    public String toString() {
        return "Inscripciones{" + "ID_Inscripto=" + ID_Inscripto + ", socio=" + socio + ", clase=" + clase + '}';
    }
    
    
}
