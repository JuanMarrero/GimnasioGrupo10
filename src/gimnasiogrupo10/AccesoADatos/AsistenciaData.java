
package gimnasiogrupo10.AccesoADatos;

import gimnasiogrupo10.entidades.*;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;

    
    public class AsistenciaData {
        
     private SocioData sc = new SocioData();
     private EntrenadoresData ed = new EntrenadoresData();
     private ClasesData cd = new ClasesData();

    private Connection con=null;
    
    public AsistenciaData(){
        con=Conexion.getConexion();
    }
   
    public void registrarAsistencia(Asistencia asistencia) {
    String sql = "INSERT INTO Asistencia (ID_Socio, ID_Clase, Fecha_Asistencia) VALUES (?, ?, ?)";
    try {
        PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setInt(1, asistencia.getSocio().getID_Socio());
        ps.setInt(2, asistencia.getClase().getID_Clase());
        ps.setDate(3, java.sql.Date.valueOf(asistencia.getFecha_Asistencia()));
        
        ps.executeUpdate();
        
        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next()) {
            asistencia.setID_Asistencia(rs.getInt(1));
        }
        
        rs.close();
        ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al registrar la asistencia: " + ex.getMessage());
    }
}
    
    public void actualizarAsistencia(Asistencia asistencia) {
    String sql = "UPDATE Asistencia SET ID_Socio = ?, ID_Clase = ?, Fecha_Asistencia = ? WHERE ID_Asistencia = ?";
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, asistencia.getSocio().getID_Socio());
        ps.setInt(2, asistencia.getClase().getID_Clase());
        ps.setDate(3, java.sql.Date.valueOf(asistencia.getFecha_Asistencia()));
        ps.setInt(4, asistencia.getID_Asistencia());
        
        ps.executeUpdate();
        
        ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al actualizar la asistencia: " + ex.getMessage());
    }
} 
    
    public void borrarAsistencia(int idAsistencia) {
    String sql = "DELETE FROM Asistencia WHERE ID_Asistencia = ?";
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idAsistencia);
        
        ps.executeUpdate();
        
        ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al eliminar la asistencia: " + ex.getMessage());
    }
}
    
    public Asistencia buscarAsistenciaPorID(int idAsistencia) {
    String sql = "SELECT * FROM Asistencia WHERE ID_Asistencia = ?";
    Asistencia asistencia = null;
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idAsistencia);
        
        ResultSet rs = ps.executeQuery();
        
        if (rs.next()) {
            asistencia = new Asistencia();
            asistencia.setID_Asistencia(rs.getInt("ID_Asistencia"));
            // Obtener socio y clase según su ID
            int idSocio = rs.getInt("ID_Socio");
            int idClase = rs.getInt("ID_Clase");
            asistencia.setSocio(sc.buscarSocio(idSocio));
            asistencia.setClase(cd.buscarClasesPorID(idClase));
            asistencia.setFecha_Asistencia(rs.getDate("Fecha_Asistencia").toLocalDate());
        }
        
        rs.close();
        ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al buscar la asistencia: " + ex.getMessage());
    }
    return asistencia;
}
    
    public List<Asistencia> listarAsistencias() {
    List<Asistencia> asistencias = new ArrayList<>();
    String sql = "SELECT * FROM Asistencia";
    try {
        Statement statement = con.createStatement();
        ResultSet rs = statement.executeQuery(sql);
        
        while (rs.next()) {
            Asistencia asistencia = new Asistencia();
            asistencia.setID_Asistencia(rs.getInt("ID_Asistencia"));
            // Obtener socio y clase según su ID
            int idSocio = rs.getInt("ID_Socio");
            int idClase = rs.getInt("ID_Clase");
            asistencia.setSocio(sc.buscarSocio(idSocio));
            asistencia.setClase(cd.buscarClasesPorID(idClase));
            asistencia.setFecha_Asistencia(rs.getDate("Fecha_Asistencia").toLocalDate());
            asistencias.add(asistencia);
        }
        
        rs.close();
        statement.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al listar las asistencias: " + ex.getMessage());
    }
    return asistencias;
}   
    
    public List<Asistencia> listarAsistenciasPorSocio(int idSocio) {
    List<Asistencia> asistencias = new ArrayList<>();
    String sql = "SELECT * FROM Asistencia WHERE ID_Socio = ?";
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idSocio);
        
        ResultSet rs = ps.executeQuery();
        
        while (rs.next()) {
            Asistencia asistencia = new Asistencia();
            asistencia.setID_Asistencia(rs.getInt("ID_Asistencia"));
            // Obtener clase según su ID
            int idClase = rs.getInt("ID_Clase");
            asistencia.setClase(cd.buscarClasesPorID(idClase));
            asistencia.setFecha_Asistencia(rs.getDate("Fecha_Asistencia").toLocalDate());
            asistencias.add(asistencia);
        }
        
        rs.close();
        ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al listar las asistencias del socio: " + ex.getMessage());
    }
    return asistencias;
}
    
    public int obtenerCantidadInscripciones(int idClase) {
    String sql = "SELECT COUNT(*) AS cantidadInscripciones FROM asistencia WHERE ID_Clase = ?";
    int cantidadInscripciones = 0;

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idClase);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            cantidadInscripciones = rs.getInt("cantidadInscripciones");
        }

        ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al obtener la cantidad de inscripciones: " + ex.getMessage());
    }
    return cantidadInscripciones;
}
    
    }  

