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
        
        String sql="SELECT ID_Entrenador, Nombre, Apellido, DNI, Especialidad FROM entrenadores WHERE Estado = 1";
        
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
    
        public Entrenadores buscarEntrenadorPorNombre(String Nombre, String apellido){
        
        String sql="SELECT ID_Entrenador, DNI, Apellido, Nombre, Especialidad FROM entrenadores WHERE Nombre = ? AND Apellido=? AND Estado = 1";
        
        Entrenadores entrenador=null; //iniciamos un entrenador vacio
        
        try {
             PreparedStatement ps = con.prepareStatement(sql) ;
                ps.setString(1, Nombre);
                
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
        
        String sql="SELECT ID_Entrenador, DNI, Apellido, Nombre,Especialidad FROM entrenadores WHERE Especialidad=? AND Estado = 1";
        
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
        
        String sql="SELECT ID_Entrenador, DNI, Apellido, Nombre, Especialidad FROM entrenadores WHERE ID_Entrenador = ? AND Estado = 1";
        
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
        
         public Entrenadores buscarPorDni(String DNI){
        Entrenadores entrenadores = null;
        String sql = "SELECT `ID_Entrenador`, `DNI`, `Nombre`, `Apellido`, `Especialidad`, `Estado` FROM `entrenadores` WHERE DNI=?"; 
      
        PreparedStatement ps = null;
       
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, DNI);
            ResultSet rs = ps.executeQuery(); 
            
            if(rs.next()){
            entrenadores = new Entrenadores ();
            entrenadores.setID_Entrenador(rs.getInt("id-entrenador"));
            entrenadores.setDNI(rs.getInt("dni"));
            entrenadores.setNombre(rs.getString("nombre"));
            entrenadores.setApellido(rs.getString("apellido"));
            entrenadores.setEspecialidad(rs.getString("especialidad"));
            //entrenadores.setEstado(true);
            entrenadores.setEstado(rs.getBoolean("estado-en"));
            }else{
            JOptionPane.showMessageDialog(null, "No se encontró el entrenador");
            }
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Entrenador ");
            System.out.println("error " + ex.getMessage());
            ex.printStackTrace();
        }
    
    return entrenadores;}
        
        public Entrenadores buscarPorNombreYApellido(String nom, String ape){
        Entrenadores entrenadores = null;
        String sql = "SELECT `ID_Entrenador`, `DNI`, `Nombre`, `Apellido`, `Especialidad`, `Estado` "
                + "FROM `entrenadores` WHERE Nombre=? AND Apellido=?"; 
        PreparedStatement ps = null;
       
        try{
            ps = con.prepareStatement(sql);
            ps.setString(1, nom);
            ps.setString(2, ape);
            ResultSet rs = ps.executeQuery(); //busqueda////////////
            
            if(rs.next()){
            entrenadores = new Entrenadores ();
            entrenadores.setID_Entrenador(rs.getInt("id-entrenador"));
            entrenadores.setDNI(rs.getInt("dni"));
            entrenadores.setNombre(rs.getString("nombre"));
            entrenadores.setApellido(rs.getString("apellido"));
            entrenadores.setEspecialidad(rs.getString("especialidad"));
            //entrenador.setEstado(true);
            entrenadores.setEstado(rs.getBoolean("estado-en"));
            }else{
            JOptionPane.showMessageDialog(null, "No se encontró el entrenador");
            }
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Entrenador ");
            System.out.println("error " + ex.getMessage());
            ex.printStackTrace();
        }
    
    return entrenadores;}

        public List<Entrenadores> buscarPorNombreApellidoEspecialidad(String nom,String ape,String espe) {
        List<Entrenadores> lista = new ArrayList<>();
        String sql = "SELECT * FROM `entrenadores`WHERE Nombre=? AND Apellido=? AND Especialidad=?";
        boolean flag=false;

        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nom);
            ps.setString(2, ape);
            ps.setString(3, espe);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                flag=true;
                Entrenadores entrenadores = new Entrenadores();
                entrenadores.setID_Entrenador(rs.getInt("id-entrenador"));
                entrenadores.setDNI(rs.getInt("dni"));
                entrenadores.setNombre(rs.getString("nombre"));
                entrenadores.setApellido(rs.getString("apellido"));
                entrenadores.setEspecialidad(rs.getString("especialidad"));
                //entrenadores.setEstado(true);
                entrenadores.setEstado(rs.getBoolean("estado-en"));

                lista.add(entrenadores);
            }
            if(!flag){
                JOptionPane.showMessageDialog(null, "no se encontro el nombre: "+nom);
            }
            ps.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Entrenador ");
            System.out.println("error " + e.getMessage());
            e.printStackTrace();
        }

        return lista;}
    
        public void actualizarEntrenadores(Entrenadores entrenadores) {

        String sql = "UPDATE `entrenadores` "
                   + "SET `DNI`=?,`Nombre`=?,`Apellido`=?,`Especialidad`=?,`Estado`=? "
                   + "WHERE `ID_Entrenador`=? ";
        PreparedStatement ps = null;

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, entrenadores.getDNI());
            ps.setString(2, entrenadores.getNombre());
            ps.setString(3, entrenadores.getApellido());
            ps.setString(4, entrenadores.getEspecialidad());
            ps.setBoolean(5, entrenadores.getEstado());
            ps.setInt(6, entrenadores.getID_Entrenador());
            
            int exito = ps.executeUpdate();

            if (exito==1) { // pregunta si tiene datos
                JOptionPane.showMessageDialog(null, "Datos del entrenador actualizados");
            }
            ps.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar datos del entrenador");
            System.out.println("error " + e.getMessage());
            e.printStackTrace();
        }

    }
    
        public void darBaja(int id){ 
    
        try {
        //String sql= "UPDATE alumno SET estado = 0 WHERE idAlumno = ? ";
        String sql= "UPDATE `entrenadores` SET `Estado`=0 WHERE `ID_Entrenador`=? ";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, id);
        int fila = ps.executeUpdate();
        
        if(fila==1){
            JOptionPane.showMessageDialog(null, "Se dio de baja al entrenador con id: "+id);
        }else{
            JOptionPane.showMessageDialog(null, "No se pudo dar de baja al entrenador con id: "+id);
        }
        ps.close();
        
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al actualizar datos");
            System.out.println("error " + e.getMessage());
            e.printStackTrace();
        }

    }
    
    
}
