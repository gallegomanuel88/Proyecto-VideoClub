package proyectovideoclub;

import java.sql.*;

/**
 *
 * @author galle
 */
public class BD {

    Connection conexion = null;

    public void driver() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Registro exitoso");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean conexion(String user, String pass) {

        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/BDvideoclub", user, pass);
            System.out.println("Conexion realizada");
            Statement s = conexion.createStatement();
            ResultSet rs = s.executeQuery("describe peliculas");
            while (rs.next()) {
                System.out.println(rs.getString(1));
            }
            return true;
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            return false;
        }
    }

    public void consultaPrueba() {

    }
}
