package gimnasiogrupo10.entidades;

import java.util.Date;

public class Membresias {
    
    private int ID_Membresia;
    private Double Costo;
    private int CantidadPases;
    private Date Fecha_Inicio;
    private Date Fecha_Fin;
    private Socios socios;

    public Membresias() {
    }

    public Membresias(int ID_Membresia, Double Costo, int CantidadPases, Date Fecha_Inicio, Date Fecha_Fin, Socios socios) {
        this.ID_Membresia = ID_Membresia;
        this.Costo = Costo;
        this.CantidadPases = CantidadPases;
        this.Fecha_Inicio = Fecha_Inicio;
        this.Fecha_Fin = Fecha_Fin;
        this.socios = socios;
    }

    public Membresias(Double Costo, int CantidadPases, Date Fecha_Inicio, Date Fecha_Fin, Socios socios) {
        this.Costo = Costo;
        this.CantidadPases = CantidadPases;
        this.Fecha_Inicio = Fecha_Inicio;
        this.Fecha_Fin = Fecha_Fin;
        this.socios = socios;
    }

    public int getID_Membresia() {
        return ID_Membresia;
    }

    public void setID_Membresia(int ID_Membresia) {
        this.ID_Membresia = ID_Membresia;
    }

    public Double getCosto() {
        return Costo;
    }

    public void setCosto(Double Costo) {
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

    public Socios getSocios() {
        return socios;
    }

    public void setSocios(Socios socios) {
        this.socios = socios;
    }

    @Override
    public String toString() {
        return "Membresias{" + "ID_Membresia=" + ID_Membresia + ", CantidadPases=" + CantidadPases + ", Fecha_Inicio=" + Fecha_Inicio + ", Fecha_Fin=" + Fecha_Fin + ", socios=" + socios + '}';
    }
    
    
}
