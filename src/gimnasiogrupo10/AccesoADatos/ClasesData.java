package gimnasiogrupo10.AccesoADatos;

import gimnasiogrupo10.entidades.*;
import java.sql.*;
import java.time.LocalTime;
import java.util.*;
import javax.swing.JOptionPane;

public class ClasesData {
    private EntrenadoresData ed = new EntrenadoresData();
    private SocioData sd = new SocioData();
    
    private Connection con=null;
    
    public ClasesData(){
        con=Conexion.getConexion();
    }    
    
      public void guardarClase(Clases clases){

          
       String sql="INSERT INTO clases (Nombre, ID_Entrenador, Horario, Capacidad, Estado)"
               + "VALUES (?,?,?,?,?)";
        
        try {
           try (PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)) {

               ps.setString(1, clases.getNombre());
               ps.setInt(2, clases.getEntrenadores().getID_Entrenador());
               ps.setTime(3, Time.valueOf(clases.getHorario()));
               ps.setInt(4, clases.getCapacidad());
               ps.setBoolean(5, clases.isEstado());
 
               
               ps.executeUpdate();
               
               ResultSet rs=ps.getGeneratedKeys();
               
               if(rs.next()){
                clases.setID_Clase(rs.getInt(1));
                   
                   JOptionPane.showMessageDialog(null, "Clase cargada correctamente");
               }
               ps.close();
           }
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Clases");
        }

    }
       
       
      public List<Clases> listarClases(){
        
        String sql="SELECT * FROM clases WHERE Estado = 1";

        ArrayList<Clases> clases=new ArrayList<>(); //iniciamos un array de clases vacio
        
        try {
                PreparedStatement ps = con.prepareStatement(sql) ;
                
                ResultSet rs=ps.executeQuery();
                
                while(rs.next()){
                    
                    Clases cl=new Clases();
                    cl.setID_Clase(rs.getInt("ID_Clase"));
                    cl.setNombre(rs.getString("Nombre"));
                    Entrenadores ent=ed.buscarEntrenadorPorNombre("Nombre", "Apellido");
                    cl.setEntrenadores(ent);
                    cl.setHorario(rs.getTime("Horario").toLocalTime());
                    cl.setEstado(rs.getBoolean("Estado"));
                   clases.add(cl);
                    
                }
                ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Clases");
        }
        return clases;
    }
      
      public Clases buscarClasesPorNombre(String Nombre){
        
        String sql="SELECT * FROM Clases WHERE Nombre = ?";
        
        Clases clase=null; //iniciamos una clase vacia
        
        try {
             PreparedStatement ps = con.prepareStatement(sql) ;
                ps.setString(1, Nombre);
                
                ResultSet rs=ps.executeQuery();
                
                if(rs.next()){
                    
                    clase=new Clases(); //creamos una clase vacia
                    clase.setID_Clase(rs.getInt("ID_Clase"));
                    clase.setNombre(rs.getString("Nombre"));
                    clase.setHorario(rs.getTime("Horario").toLocalTime());
                    

                }else{
                    
                    JOptionPane.showMessageDialog(null, "La Clase no existe");
                }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Clase");
        }
        return clase;
    
    } 
      
      public List<Clases> buscarClasesPorEntrenador(int ID_Entrenador){
        
        String sql="SELECT * FROM Clases WHERE ID_Entrenador = ? ";
        
        List<Clases> claseList = new ArrayList<>();
        
        try {
             PreparedStatement ps = con.prepareStatement(sql) ;
                ps.setInt(1, ID_Entrenador);
                
                ResultSet rs=ps.executeQuery();
                

            while (rs.next()) {
                Clases clase = new Clases();
                Entrenadores ent = ed.buscarEntrenadorPorID(ID_Entrenador);
                clase.setEntrenadores(ent);
                clase.setCapacidad(rs.getInt("Capacidad"));
                clase.setID_Clase(rs.getInt("ID_Clase"));
                clase.setNombre(rs.getString("Nombre"));
                clase.setHorario(rs.getTime("Horario").toLocalTime());
                clase.setEstado(rs.getBoolean("Estado"));

                claseList.add(clase);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Clase");
        }

        return claseList;
    }
      
     public Clases buscarClasesPorID(int ID_Clase){
        
        String sql="SELECT * FROM Clases WHERE ID_Clase = ? ";
        
        Clases clase=null; //iniciamos una clase vacia
        
        try {
             PreparedStatement ps = con.prepareStatement(sql) ;
                ps.setInt(1, ID_Clase);
                
                ResultSet rs=ps.executeQuery();
                
                if(rs.next()){
                    
                    clase=new Clases(); //creamos una clase vacia
                    clase.setID_Clase(rs.getInt("ID_Clase"));
                    clase.setNombre(rs.getString("Nombre"));
                    clase.setHorario(rs.getTime("Horario").toLocalTime());
                    

                }else{
                    
                    JOptionPane.showMessageDialog(null, "La Clase no existe");
                }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Clase");
        }
        return clase;
    
    } 
      

    public List<Clases> listarClasesActivas() {
    List<Clases> clasesActivas = new ArrayList<>();
    String sql = "SELECT * FROM clases WHERE Estado = 1";
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Clases clase = new Clases();
            clase.setID_Clase(rs.getInt("ID_Clase"));
            clase.setNombre(rs.getString("Nombre"));
            clase.setHorario(rs.getTime("Horario").toLocalTime());
            clase.setCapacidad(rs.getInt("Capacidad"));
            clase.setEstado(rs.getBoolean("Estado"));

            // Agregar la clase a la lista
            clasesActivas.add(clase);
        }
        rs.close();
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al acceder a la lista de clases activas");
        System.out.println("Error: " + e.getMessage());
        e.printStackTrace();
    }
    return clasesActivas;
}
     
      public List<Clases> listarClasesInactivas() {

        List<Clases> listaClase = new ArrayList<>();
        String sql = "SELECT * FROM clases WHERE Estado = 0";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Clases clases = new Clases();
                clases.setID_Clase(rs.getInt("ID_clase"));
                clases.setNombre(rs.getString("Nombre"));
              
                clases.setHorario(rs.getTime("Horario").toLocalTime());
                clases.setCapacidad(rs.getInt("Capacidad"));
                clases.setEstado(rs.getBoolean("Estado"));
                   
                Entrenadores entrenadores = new Entrenadores(); 
                 entrenadores.setID_Entrenador(rs.getInt("ID_Entrenador"));
                 entrenadores.setNombre(rs.getString("nombre_entrenador"));
              
                clases.setEntrenadores(entrenadores);
                listaClase.add(clases);
            }
            rs.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la lista Clases ");
            System.out.println("error " + e.getMessage());
            e.printStackTrace();
        }
        return listaClase;
    }
     
    public List<LocalTime> listarHorariosClasesActivas() {
        List<LocalTime> listaHorarios = new ArrayList<>();
        String sql = "SELECT Horario FROM clases WHERE estado = 1";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                listaHorarios.add(rs.getTime("Horario").toLocalTime());
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a los horarios de las Clases");
            System.out.println("error " + e.getMessage());
            e.printStackTrace();
        }
        return listaHorarios;
    }
     
    public List<LocalTime> listarHorariosDisponibles() {
        List<LocalTime> horariosDisponibles = new ArrayList<>();
        List<LocalTime> horariosOcupados = listarHorariosClasesActivas();
        
        LocalTime inicio = LocalTime.of(8, 0);
        LocalTime fin = LocalTime.of(20, 0);
        for (LocalTime time = inicio; !time.isAfter(fin); time = time.plusHours(1)) {
            horariosDisponibles.add(time);
        }

        horariosDisponibles.removeAll(horariosOcupados);

        return horariosDisponibles;
    
}
     
     
     public void decrementarCapacidad(int IdClase) {
        String sql = "UPDATE Clases SET Capacidad = Capacidad - 1 WHERE ID_Clase = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, IdClase);
            
            int rows = ps.executeUpdate();
            
            if (rows > 0) {
                JOptionPane.showMessageDialog(null, "Se ha decrementado la capacidad de la clase correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró la clase con ID " + IdClase);
            }
            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al decrementar la capacidad de la clase: " + ex.getMessage());
        }
    }
     
    public int obtenerCapacidadActual(int idClase) {
        int capacidadActual = 0;
        String sql = "SELECT Capacidad FROM clases WHERE ID_Clase = ?";

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idClase);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                capacidadActual = rs.getInt("Capacidad");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró ninguna clase con ID " + idClase);
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener la capacidad actual de la clase");
            ex.printStackTrace();
        }

        return capacidadActual;
    }
}  

