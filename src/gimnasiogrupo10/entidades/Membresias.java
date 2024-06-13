
package gimnasiogrupo10.entidades;

import java.util.Date;

/**
 *
 * @author Juan
 */
public class Membresias {
    
    private int ID_Membresia;
    private Socios socio;
    private Clases clase;
    private double Costo;
    private int CantidadPases;
    private Date Fecha_Inicio;
    private Date Fecha_Fin;
    private boolean Estado;

    public Membresias() {
    }

    public Membresias(int ID_Membresia, Socios socio, Clases clase, double Costo, int CantidadPases, Date Fecha_Inicio, Date Fecha_Fin, boolean Estado) {
        this.ID_Membresia = ID_Membresia;
        this.socio = socio;
        this.clase = clase;
        this.Costo = Costo;
        this.CantidadPases = CantidadPases;
        this.Fecha_Inicio = Fecha_Inicio;
        this.Fecha_Fin = Fecha_Fin;
        this.Estado = Estado;
    }

    public Membresias(Socios socio, Clases clase, double Costo, int CantidadPases, Date Fecha_Inicio, Date Fecha_Fin, boolean Estado) {
        this.socio = socio;
        this.clase = clase;
        this.Costo = Costo;
        this.CantidadPases = CantidadPases;
        this.Fecha_Inicio = Fecha_Inicio;
        this.Fecha_Fin = Fecha_Fin;
        this.Estado = Estado;
    }

    public int getID_Membresia() {
        return ID_Membresia;
    }

    public void setID_Membresia(int ID_Membresia) {
        this.ID_Membresia = ID_Membresia;
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

    public double getCosto() {
        return Costo;
    }

    public void setCosto(double Costo) {
        this.Costo = Costo;
    }

    public int getCantidadPases() {
        return CantidadPases;
    }

    public void setCantidadPases(int CantidadPases) {
        this.CantidadPases = CantidadPases;
    }

    public Date getFecha_Inicio() {
        return Fecha_Inicio;
    }

    public void setFecha_Inicio(Date Fecha_Inicio) {
        this.Fecha_Inicio = Fecha_Inicio;
    }

    public Date getFecha_Fin() {
        return Fecha_Fin;
    }

    public void setFecha_Fin(Date Fecha_Fin) {
        this.Fecha_Fin = Fecha_Fin;
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
    }

    @Override
    public String toString() {
        return  ID_Membresia + "," + socio + "," + clase + "," + CantidadPases + "," + Fecha_Inicio + "," + Fecha_Fin + "," + Estado;
    }
    
    

}