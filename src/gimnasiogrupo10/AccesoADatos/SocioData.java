package gimnasiogrupo10.AccesoADatos;

import gimnasiogrupo10.entidades.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class SocioData {
    
    
    private Connection con=null;
    
    public SocioData(){
        con=Conexion.getConexion();
    }
    
    public void guardarSocio(Socios socio){
        
        
       String sql="INSERT INTO socios (DNI, Nombre, Apellido, Edad, Correo, Telefono, Estado)"
               + "VALUES (?,?,?,?,?,?,?)";
        
        try {
           try (PreparedStatement ps = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)) {
               ps.setInt(1, socio.getDNI());
               ps.setString(2, socio.getNombre());
               ps.setString(3, socio.getApellido());
               ps.setInt(4, socio.getEdad());
               ps.setString(5, socio.getCorreo());
               ps.setString(6, socio.getTelefono());
               ps.setBoolean(7, socio.isEstado());
               
               ps.executeUpdate();
               
               ResultSet rs=ps.getGeneratedKeys();
               
               if(rs.next()){
                   socio.setID_Socio(rs.getInt(1));   //recorremos con if porque solo es 1 socio
                   JOptionPane.showMessageDialog(null, "Socio cargado correctamente");
               }
               ps.close();
           }
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Socios");
        }

    }  
    
    public Socios buscarSocio(int id){
        
        String sql="SELECT DNI, Apellido, Nombre, Edad, Estado FROM socios WHERE Id_Socio = ? AND Estado = 1";
        
        Socios socio=null; //iniciamos un socio vacio
        
        try {
             PreparedStatement ps = con.prepareStatement(sql) ;
                ps.setInt(1, id);
                
                ResultSet rs=ps.executeQuery();
                
                if(rs.next()){
                    
                    socio=new Socios(); //creamos un Socio vacio
                    
                    socio.setID_Socio(id);
                    socio.setDNI(rs.getInt("DNI"));
                    socio.setApellido(rs.getString("Apellido"));
                    socio.setNombre(rs.getString("Nombre"));
                    socio.setEdad(rs.getInt("Edad"));
                    socio.setEstado(rs.getBoolean("Estado"));
                }else{
                    
                    JOptionPane.showMessageDialog(null, "El Socio no existe");
                }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Socios");
        }
        return socio;
    
    }
    
    public Socios buscarSocioPorNombre(String Nombre){
        
        String sql="SELECT DNI, Apellido, Nombre, Edad, Estado FROM socios WHERE Nombre = ? AND Estado = 1";
        
        Socios socio=null; //iniciamos un socio vacio
        
        try {
             PreparedStatement ps = con.prepareStatement(sql) ;
                ps.setString(1, Nombre);
                
                ResultSet rs=ps.executeQuery();
                
                if(rs.next()){
                    
                    socio=new Socios(); //creamos un Socio vacio
                    
                    socio.setNombre(Nombre);
                    socio.setDNI(rs.getInt("DNI"));
                    socio.setApellido(rs.getString("Apellido"));
                    socio.setID_Socio(rs.getInt("ID_Socio"));
                    socio.setEdad(rs.getInt("Edad"));
                    socio.setEstado(rs.getBoolean("Estado"));
                }else{
                    
                    JOptionPane.showMessageDialog(null, "El Socio no existe");
                }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Socios");
        }
        return socio;
    
    }
    
    public Socios buscarSocioXDni(int DNI){
        
        String sql="SELECT * FROM socios WHERE DNI = ? ";
        
        Socios socio=null; //iniciamos un socio vacio
        
        try {
             PreparedStatement ps = con.prepareStatement(sql) ;
                ps.setInt(1, DNI);
                
                ResultSet rs=ps.executeQuery();
                
                if(rs.next()){
                    
                    socio=new Socios(); //creamos un Socio vacio
                    
                    socio.setID_Socio(rs.getInt("ID_Socio"));
                    socio.setDNI(DNI);
                    socio.setDNI(rs.getInt("DNI"));
                    socio.setApellido(rs.getString("Apellido"));
                    socio.setNombre(rs.getString("Nombre"));
                    socio.setEdad(rs.getInt("Edad"));
                    socio.setEstado(rs.getBoolean("Estado"));
                }else{
                    
                    JOptionPane.showMessageDialog(null, "El Socio no existe");
                }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Socios");
        }
        return socio;
    
    }
    
    public List<Socios> listarSocios(){
        
        String sql="SELECT ID_Socio, DNI, Apellido, Nombre FROM socios WHERE Estado = 1";
        
        ArrayList<Socios> socios=new ArrayList<>(); //iniciamos un array de socios vacio
        
        try {
                PreparedStatement ps = con.prepareStatement(sql) ;
                
                ResultSet rs=ps.executeQuery();
                
                while(rs.next()){
                    
                    Socios socio=new Socios(); //creamos un socio vacio
                    
                    socio.setID_Socio(rs.getInt("ID_Socio"));
                    socio.setDNI(rs.getInt("DNI"));
                    socio.setApellido(rs.getString("Apellido"));
                    socio.setNombre(rs.getString("Nombre"));
                    socio.setEstado(true);

                    socios.add(socio);
                }
                
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Socio");
        }
        return socios;
    }
    
    public void borrarSocio(int id){
        
       String sql="UPDATE socios SET Estado = 0 WHERE ID_Socio = ?";
       
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            
            ps.setInt(1, id);
            
            int gl=ps.executeUpdate();
            
            if(gl==1){
                
                JOptionPane.showMessageDialog(null, "Socio dado de baja exitosamente");

            }                
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla SOcio");
        }
        
    }
    
    public void restarPase(int idSocio) {
        
        String sql = "UPDATE membresias SET CantidadPases = CantidadPases - 1 WHERE ID_Socio = ?";
        
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, idSocio);
            
            int rows = ps.executeUpdate();
            
            if (rows > 0) {
                JOptionPane.showMessageDialog(null, "Se ha restado un pase correctamente");
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró al socio con ID " + idSocio);
            }
            
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al restar un pase: " + ex.getMessage());
        }
    }
    
    public void altaSocio(int id){
        
       String sql="UPDATE socios SET Estado = 1 WHERE ID_Socio = ?";
       
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            
            ps.setInt(1, id);
            
            int gl=ps.executeUpdate();
            
            if(gl==1){
                
                JOptionPane.showMessageDialog(null, "Socio dado de alta exitosamente");

            }                
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla SOcio");
        }
        
    }
    

   
}