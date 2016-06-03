package proyectovideoclub;

import java.sql.*;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gallegomanuel88
 */
public class BD {

    Connection conexion = null;
    static String usuarioActual;
    static String passActual;

    public BD() {
    }

    public static String getUsuarioActual() {
        return usuarioActual;
    }

    public static String getPassActual() {
        return passActual;
    }
    
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
            usuarioActual = user;
            passActual = pass;
            System.out.println("Conexion de logueo realizada");
            return true;
        } catch (SQLException ex) {
            System.out.println("SQLException: " + ex.getMessage());
            return false;
        }
    }
    
    public String condicionConsulta (String titulo, String anho, String categoria, String director, String actor) {
        
        String consulta = "";
        
        if (true!=(titulo.equals(""))) {
            consulta+= " where titulo like '%" + titulo + "%'";
            if (true!=(anho.equals(""))){
               consulta+= " and anho='" + anho + "'";
               if (true!=(categoria.equals(""))){
                   consulta+= " and nombrecat='" + categoria + "'";
                   if (true!=(director.equals(""))){
                       consulta+= " and coddir in (select coddir from directores where nombre like '%" + director + "%')";
                       if (true!=(actor.equals(""))){
                           consulta+= " and codpel in (select codpel from actorespel where coda in(select coda from actores where nombre like '%" + actor + "%'))";
                       }
                   }
               }
            }
        }
        else if (true!=(anho.equals(""))){
            consulta+= " where anho='" + anho + "'";
            if (true!=(categoria.equals(""))){
                consulta+= " and nombrecat='" + categoria + "'";
                if (true!=(director.equals(""))){
                    consulta+= " and coddir in (select coddir from directores where nombre like '%" + director + "%')";
                    if (true!=(actor.equals(""))){
                        consulta+= " and codpel in (select codpel from actorespel where coda in(select coda from actores where nombre like '%" + actor + "%'))";
                    }
                }
            }
        }
        else if (true!=(categoria.equals(""))){
            consulta+= " where nombrecat='" + categoria + "'";
            if (true!=(director.equals(""))){
                consulta+= " and coddir in (select coddir from directores where nombre like '%" + director + "%')";
                if (true!=(actor.equals(""))){
                    consulta+= " and codpel in (select codpel from actorespel where coda in(select coda from actores where nombre like '%" + actor + "%'))";
                }
            }
        }
        else if (true!=(director.equals(""))){
            consulta+= " where coddir in (select coddir from directores where nombre like '%" + director + "%')";
            if (true!=(actor.equals(""))){
                consulta+= " and codpel in (select codpel from actorespel where coda in(select coda from actores where nombre like '%" + actor + "%'))";
            }
        }
        else if (true!=(actor.equals(""))){
            consulta+= " where codpel in (select codpel from actorespel where coda in(select coda from actores where nombre like '%" + actor + "%'))";
        }
        return consulta;
    }
    
    public void limpiarTabla (JTable tabla) {
        try {
            DefaultTableModel modelo=(DefaultTableModel) tabla.getModel();
            int filas=tabla.getRowCount();
            for (int i = 0;filas>i; i++) {
                modelo.removeRow(0);
            }
        } catch (Exception e) {
            System.out.println("Error al limpiar la tabla.");
        }
    }
    
    public void traerImagen (JLabel caratula, String titulo, String ruta){
        ImageIcon imagen = new ImageIcon(this.getClass().getResource(ruta+titulo+".jpg"));
        caratula.setIcon(imagen);
    }
}
