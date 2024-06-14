package gimnasiogrupo10.AccesoADatos;

import gimnasiogrupo10.entidades.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class MembresiasData {
    
     private SocioData sc = new SocioData();
     private EntrenadoresData ed = new EntrenadoresData();
     private ClasesData cd = new ClasesData();
     private Connection con=null;
    
    public MembresiasData(){
        con=Conexion.getConexion();
    }   
    
    public void guardarInscripcion(Membresias insc) {


    String sql = "INSERT INTO membresias(ID_Socio,ID_Clase, Costo, CantidadPases, Fecha_Inicio, Fecha_Fin, Estado) VALUES (?,?,?,?,?,?,?)";
    try {
        try (PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, insc.getSocio().getID_Socio());
            ps.setInt(2, insc.getClase().getID_Clase());
            ps.setDouble(3, insc.getCosto());
            ps.setInt(4, insc.getCantidadPases());
            ps.setDate(5, new java.sql.Date(insc.getFecha_Inicio().getTime()));
            ps.setDate(6, new java.sql.Date(insc.getFecha_Fin().getTime()));
            ps.setBoolean(7, insc.isEstado());
            
            ps.executeUpdate();
            
            ResultSet rs = ps.getGeneratedKeys();
            
            if (rs.next()) {
                insc.setID_Membresia(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Inscripción Registrada");
            }
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al conectarse a la tabla Membresias: " + ex.getMessage());
    }
}  
    
    public List<Membresias> obtenerInscripcionesPorSocio(int ID_Socio){
        
        ArrayList<Membresias> inscripciones= new ArrayList<>();
        
        String sql="SELECT * FROM membresias WHERE ID_Socio= ?";
        
        try {
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                
                ps.setInt(1, ID_Socio);
                
                ResultSet rs= ps.executeQuery();
                
                while (rs.next()){
                    Membresias insc= new Membresias();
                    
                    insc.setID_Membresia(rs.getInt("ID_Membresia"));
                    insc.setCosto(rs.getDouble("Costo"));
                    insc.setCantidadPases(rs.getInt("CantidadPases"));
                    insc.setFecha_Inicio(rs.getDate("Fecha_Inicio"));
                    insc.setFecha_Fin(rs.getDate("Fecha_Fin"));
                    insc.setEstado(rs.getBoolean("Estado"));                    
                    Socios scs=sc.buscarSocio(rs.getInt("ID_Socio"));                    
                    Clases cs=cd.buscarClasesPorID(rs.getInt("ID_Clase"));
                    
                    insc.setSocio(scs);
                    insc.setClase(cs);
                    inscripciones.add(insc);
                }
                ps.close();
            }
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error Al Acceder a la Tabla de Membresias");
        }
        return inscripciones;
        
        
    }
    public List<Membresias> obtenerActivasInscripcionesPorSocio(int ID_Socio){
        
        ArrayList<Membresias> inscripciones= new ArrayList<>();
        
        String sql="SELECT * FROM membresias WHERE ID_Socio= ? AND Estado=1";
        
        try {
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                
                ps.setInt(1, ID_Socio);
                
                ResultSet rs= ps.executeQuery();
                
                while (rs.next()){
                    Membresias insc= new Membresias();
                    
                    insc.setID_Membresia(rs.getInt("ID_Membresia"));
                    insc.setCosto(rs.getDouble("Costo"));
                    insc.setCantidadPases(rs.getInt("CantidadPases"));
                    insc.setFecha_Inicio(rs.getDate("Fecha_Inicio"));
                    insc.setFecha_Fin(rs.getDate("Fecha_Fin"));
                    insc.setEstado(rs.getBoolean("Estado"));                    
                    Socios scs=sc.buscarSocio(rs.getInt("ID_Socio"));                    
                    Clases cs=cd.buscarClasesPorID(rs.getInt("ID_Clase"));
                    
                    insc.setSocio(scs);
                    insc.setClase(cs);
                    inscripciones.add(insc);
                }
                ps.close();
            }
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error Al Acceder a la Tabla de Membresias");
        }
        return inscripciones;
        
        
    }
    public List<Membresias> obtenerInactivasInscripcionesPorSocio(int ID_Socio){
        
        ArrayList<Membresias> inscripciones= new ArrayList<>();
        
        String sql="SELECT * FROM membresias WHERE ID_Socio= ? AND Estado=0";
        
        try {
            try (PreparedStatement ps = con.prepareStatement(sql)) {
                
                ps.setInt(1, ID_Socio);
                
                ResultSet rs= ps.executeQuery();
                
                while (rs.next()){
                    Membresias insc= new Membresias();
                    
                    insc.setID_Membresia(rs.getInt("ID_Membresia"));
                    insc.setCosto(rs.getDouble("Costo"));
                    insc.setCantidadPases(rs.getInt("CantidadPases"));
                    insc.setFecha_Inicio(rs.getDate("Fecha_Inicio"));
                    insc.setFecha_Fin(rs.getDate("Fecha_Fin"));
                    insc.setEstado(rs.getBoolean("Estado"));                    
                    Socios scs=sc.buscarSocio(rs.getInt("ID_Socio"));                    
                    Clases cs=cd.buscarClasesPorID(rs.getInt("ID_Clase"));
                    
                    insc.setSocio(scs);
                    insc.setClase(cs);
                    inscripciones.add(insc);
                }
                ps.close();
            }
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Error Al Acceder a la Tabla de Membresias");
        }
        return inscripciones;
        
        
    }
    
    public void renovarMembresia(int ID_Membresia, Date nuevaFechaFin) {
        String sql = "UPDATE membresias SET Fecha_Fin = ? WHERE ID_Membresia = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setDate(1, new java.sql.Date(nuevaFechaFin.getTime()));
            
            ps.setInt(2, ID_Membresia);
            
            int rows = ps.executeUpdate();
            
            if (rows > 0) {
                
                JOptionPane.showMessageDialog(null, "Membresía renovada correctamente");
                
            } else {
                
                JOptionPane.showMessageDialog(null, "No se encontró la membresía con ID " + ID_Membresia);
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al renovar la membresía: " + ex.getMessage());
        }
    }
    
    
    public boolean cancelarMembresia(int ID_Membresia) {
        String sql = "UPDATE membresias SET Estado = FALSE WHERE ID_Membresia = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            
            ps.setInt(1, ID_Membresia);
            
            int rows = ps.executeUpdate();
            
            if (rows > 0) {
                
                JOptionPane.showMessageDialog(null, "Membresía cancelada correctamente");
                
            } else {
                JOptionPane.showMessageDialog(null, "No se encontró la membresía con ID " + ID_Membresia);
                
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al cancelar la membresía: " + ex.getMessage());
        }
         return false;
    }
    
        
        
}
