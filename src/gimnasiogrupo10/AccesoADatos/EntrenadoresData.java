package gimnasiogrupo10.AccesoADatos;

import gimnasiogrupo10.entidades.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class EntrenadoresData {
    
    private Connection con=null;
    
    public EntrenadoresData(){
        con=Conexion.getConexion();
    }    
    
        public void guardarEntrenador(Entrenadores entrenadores){
        
       String sql="INSERT INTO entrenadores (DNI, Nombre, Apellido, Especialidad, Estado)"
               + "VALUES (?,?,?,?,?)";
        
        try {
           try (PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)) {
               ps.setInt(1, entrenadores.getDNI());
               ps.setString(2, entrenadores.getNombre());
               ps.setString(3, entrenadores.getApellido());
               ps.setString(4, entrenadores.getEspecialidad());
               ps.setBoolean(5, entrenadores.getEstado());
               
               ps.executeUpdate();
               
               ResultSet rs=ps.getGeneratedKeys();
               
               if(rs.next()){
                   entrenadores.setID_Entrenador(rs.getInt(1));   //recorremos con if porque solo es 1 entrenador
                   JOptionPane.showMessageDialog(null, "entrenador cargado correctamente");
               }
               ps.close();
           }
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al acceder a la tabla entrenadores");
        }

    }
    
        public List<Entrenadores> listarEntrenadores(){
        
        String sql="SELECT ID_Entrenador, Nombre, Apellido, DNI, Especialidad FROM entrenadores WHERE estado = 1";
        
        ArrayList<Entrenadores> entrenadores=new ArrayList<>(); //iniciamos un array de entrenadores vacio
        
        try {
                PreparedStatement ps = con.prepareStatement(sql) ;
                
                ResultSet rs=ps.executeQuery();
                
                while(rs.next()){
                    
                    Entrenadores entrenador=new Entrenadores(); //creamos un entrenador vacio
                    
                    entrenador.setID_Entrenador(rs.getInt("ID_Entrenador"));
                    entrenador.setDNI(rs.getInt("DNI"));
                    entrenador.setApellido(rs.getString("Apellido"));
                    entrenador.setNombre(rs.getString("Nombre"));
                    entrenador.setEspecialidad(rs.getString("Especialidad"));
                    entrenador.setEstado(true);

                    entrenadores.add(entrenador);
                }
                
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Entrenadores");
        }
        return entrenadores;
    }    
    
        public Entrenadores buscarEntrenadorPorNombre(String Nombre, String Apellido){
        
        String sql="SELECT ID_Entrenador, DNI, Apellido, Nombre, Especialidad FROM entrenadores WHERE nombre = ? AND apellido=? AND estado = 1";
        
        Entrenadores entrenador=null; //iniciamos un entrenador vacio
        
        try {
             PreparedStatement ps = con.prepareStatement(sql) ;
                ps.setString(1, Nombre);
                ps.setString(2, Apellido);
                
                ResultSet rs=ps.executeQuery();
                
                if(rs.next()){
                    
                    entrenador=new Entrenadores(); //creamos un Entrenador vacio
                    entrenador.setID_Entrenador(rs.getInt("ID_Entrenador"));
                    entrenador.setApellido(rs.getString("Apellido"));
                    entrenador.setNombre(rs.getString("Nombre"));
                    entrenador.setDNI(rs.getInt("DNI"));
                    entrenador.setEspecialidad(rs.getString("Especialidad"));
                    

                }else{
                    
                    JOptionPane.showMessageDialog(null, "El Entrenador no existe");
                }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Entrenador");
        }
        return entrenador;
    
    } 
        
        public Entrenadores buscarEntrenadorPorEspecialidad(String Especialidad){
        
        String sql="SELECT ID_Entrenador, DNI, Apellido, Nombre,Especialidad FROM entrenadores WHERE Especialidad=? AND estado = 1";
        
        Entrenadores entrenador=null; //iniciamos un entrenador vacio
        
        try {
             PreparedStatement ps = con.prepareStatement(sql) ;
                ps.setString(1, Especialidad);
                
                ResultSet rs=ps.executeQuery();
                
                if(rs.next()){
                    
                    entrenador=new Entrenadores(); //creamos un Entrenador vacio
                    
                    entrenador.setID_Entrenador(rs.getInt("ID_Entrenador"));
                    entrenador.setApellido(rs.getString("Apellido"));
                    entrenador.setNombre(rs.getString("Nombre"));
                    entrenador.setDNI(rs.getInt("DNI"));
                    entrenador.setEspecialidad(rs.getString("Especialidad"));
                    

                }else{
                    
                    JOptionPane.showMessageDialog(null, "El Entrenador no existe");
                }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Entrenador");
        }
        return entrenador;
    
    }  
        
       public Entrenadores buscarEntrenadorPorID(int ID_Entrenador){
        
        String sql="SELECT ID_Entrenador, DNI, Apellido, Nombre, Especialidad FROM entrenadores WHERE ID_Entrenador = ? AND estado = 1";
        
        Entrenadores entrenador=null; //iniciamos un entrenador vacio
        
        try {
             PreparedStatement ps = con.prepareStatement(sql) ;
                ps.setInt(1, ID_Entrenador);
                
                ResultSet rs=ps.executeQuery();
                
                if(rs.next()){
                    
                    entrenador=new Entrenadores(); //creamos un Entrenador vacio
                    entrenador.setID_Entrenador(rs.getInt("ID_Entrenador"));
                    entrenador.setApellido(rs.getString("Apellido"));
                    entrenador.setNombre(rs.getString("Nombre"));
                    entrenador.setDNI(rs.getInt("DNI"));
                    entrenador.setEspecialidad(rs.getString("Especialidad"));
                    

                }else{
                    
                    JOptionPane.showMessageDialog(null, "El Entrenador no existe");
                }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Entrenador");
        }
        return entrenador;
    
    }  
        
    
    
    
}
