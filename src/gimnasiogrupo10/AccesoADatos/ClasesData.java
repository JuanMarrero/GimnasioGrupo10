package gimnasiogrupo10.AccesoADatos;

import gimnasiogrupo10.entidades.*;
import java.sql.*;
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
               ps.setTime(3, clases.getHorario());
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
        
        String sql="SELECT * FROM clases";

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
                    cl.setHorario(rs.getTime("Horario"));
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
        
        String sql="SELECT * FROM Clases WHERE nombre = ? AND estado = 1";
        
        Clases clase=null; //iniciamos una clase vacia
        
        try {
             PreparedStatement ps = con.prepareStatement(sql) ;
                ps.setString(1, Nombre);
                
                ResultSet rs=ps.executeQuery();
                
                if(rs.next()){
                    
                    clase=new Clases(); //creamos una clase vacia
                    clase.setID_Clase(rs.getInt("ID_Clase"));
                    clase.setNombre(rs.getString("Nombre"));
                    clase.setHorario(rs.getTime("Horario"));
                    

                }else{
                    
                    JOptionPane.showMessageDialog(null, "La Clase no existe");
                }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Clase");
        }
        return clase;
    
    } 
      
      public Clases buscarClasesPorEntrenador(int ID_Entrenador){
        
        String sql="SELECT * FROM Clases WHERE ID_Entrenador = ? AND estado = 1";
        
        Clases clase=null; //iniciamos una clase vacia
        
        try {
             PreparedStatement ps = con.prepareStatement(sql) ;
                ps.setInt(1, ID_Entrenador);
                
                ResultSet rs=ps.executeQuery();
                
                if(rs.next()){
                    
                    clase=new Clases(); //creamos una clase vacia
                    Entrenadores ent=ed.buscarEntrenadorPorNombre("Nombre", "Apellido");
                    clase.setEntrenadores(ent);
                    clase.setID_Clase(rs.getInt("ID_Clase"));
                    clase.setNombre(rs.getString("Nombre"));
                    clase.setHorario(rs.getTime("Horario"));
                    

                }else{
                    
                    JOptionPane.showMessageDialog(null, "La Clase no existe");
                }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Clase");
        }
        return clase;
    
    }
      
    
}
