package gimnasiogrupo10.entidades;

public class Socios {
   private int ID_Socio;
   private int DNI;
   private String Nombre;
   private String Apellido;
   private int Edad;
   private String Correo;
   private String Telefono;   
   private boolean Estado;
   
    public Socios() {
    }

    public Socios(int DNI, String Nombre, String Apellido, int Edad, String Correo, String Telefono, boolean Estado) {
        this.DNI = DNI;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Edad = Edad;
        this.Correo = Correo;
        this.Telefono = Telefono;
        this.Estado=Estado;
    }

    public Socios(int ID_Socio, int DNI, String Nombre, String Apellido, int Edad, String Correo, String Telefono, boolean Estado) {
        this.ID_Socio = ID_Socio;
        this.DNI = DNI;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Edad = Edad;
        this.Correo = Correo;
        this.Telefono = Telefono;
        this.Estado=Estado;
    }

    public int getID_Socio() {
        return ID_Socio;
    }

    public void setID_Socio(int ID_Socio) {
        this.ID_Socio = ID_Socio;
    }

    public int getDNI() {
        return DNI;
    }

    public boolean isEstado() {
        return Estado;
    }

    public void setEstado(boolean Estado) {
        this.Estado = Estado;
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

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int Edad) {
        this.Edad = Edad;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    @Override
    public String toString() {
        return  ID_Socio + "," + DNI + "," + Nombre + "," + Apellido + '}';
    }
    
   
}
