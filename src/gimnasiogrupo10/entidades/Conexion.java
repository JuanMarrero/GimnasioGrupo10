package gimnasiogrupo10.entidades;


import java.sql.*;
import javax.swing.JOptionPane;

    public class Conexion {
    private static final String URL="jdbc:mariadb://localhost/";
    private static final String DB="gimnasiogrupo10";
    private static final String USER="root";
    private static final String PASS="";
    private static Connection connection;
    
    private Conexion(){}
    
        public static Connection getConexion(){
            
            if (connection==null){
                
                try {
                    Class.forName("org.mariadb.jdbc.Driver");
                    connection = DriverManager.getConnection(URL+DB,USER,PASS);
                                       
                } catch (ClassNotFoundException ex) {
                    JOptionPane.showMessageDialog(null,"Error a la carga de driver");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null,"Error de conexion a la base de datos");
                }                
            }            
            return connection;
        }    
}