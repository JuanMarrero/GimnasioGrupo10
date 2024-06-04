package gimnasiogrupo10.AccesoADatos;

import gimnasiogrupo10.entidades.*;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;

public class ClasesData {
 
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
        
        String sql="SELECT ID_Clase,Nombre, ID_Entrenador, Horario FROM clases WHERE estado = 1";

        ArrayList<Clases> clases=new ArrayList<>(); //iniciamos un array de clases vacio
        
        try {
                PreparedStatement ps = con.prepareStatement(sql) ;
                
                ResultSet rs=ps.executeQuery();
                
                while(rs.next()){
                    
                    Clases clase=new Clases(); //creamos una clase vacia
                    
                    clase.setID_Clase(rs.getInt("ID_Clase"));
                    clase.setNombre(rs.getString("Nombre"));
                    clase.setEstado(true);
                    clase.setHorario(rs.getTime("Horario"));
                    clases.add(clase);
                }
                
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Clases");
        }
        return clases;
    }
    
}
