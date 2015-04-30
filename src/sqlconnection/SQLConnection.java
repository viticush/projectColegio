package sqlconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SQLConnection {

    //Usuario de la base de datos
    private static final String USUARIO = "root";
    //Contraseña del usuario de la base de datos
    private static final String PASS = "ingSoft15";
    //SID de la base de datos, este lo registramos en la instalacion
   /* private static final String SID = "xe";
    //Host donde se encuentra la base de datos, para nuesto caso como es local*/
    //se indica que esta en localhost
    private static final String HOST = "127.0.0.2";
    
    //Esquema de la BD
    private static final String SCHEMA = "colegio";
    //Puerto por donde conecta la base da datos
    private static final int PUERTO = 3306;
    //Objeto donde se almacenara nuestra conexion
    private static Connection conection;

   public Connection getConexion() throws SQLException {
        if (conection == null || conection.isClosed()) {
            this.conectar();
        }
        return conection;
    }

   

  
   
    private SQLConnection conectar() {
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String cadenaConexion = "jdbc:mysql://" + HOST + ":"  + PUERTO + "/" + SCHEMA;
            //BD == nombre y usuario de la base de datos
            //123 == contraseña de acceso
            conection = DriverManager.getConnection(cadenaConexion, USUARIO, PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this;
    }

    /*
     * Con este metodo cerramos la conexion una vez hayamos terminado de usar la
     * base de datos
     */
    public void cerrar() throws SQLException {
        if (conection != null && conection.isClosed() == false) {
            conection.close();
        }
    }

    /*
     * Main para comprobar que funciona, aqui hacemos un select a una tabla del
     * sistema para obtener la version.
     */
    public static void startdb() {

        SQLConnection conexionSQL = new SQLConnection();
        try {
            conexionSQL.conectar();
            Connection conn = conexionSQL.getConexion();
            // driver@machineName:port:SID           ,  userid,  password
            Statement stmt = conn.createStatement();
            stmt.close();
            conexionSQL.cerrar();
        } catch (SQLException ex) {
            Logger.getLogger(SQLConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   public ResultSet consultar(String sql) throws SQLException {
        ResultSet resultado = null;
        try {
            Statement sentencia;
            sentencia = getConexion().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            resultado = sentencia.executeQuery(sql);
            //getConexion().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }
   
   public boolean ejecutar(String sql) throws SQLException {
        try {
            Statement sentencia;
            sentencia = getConexion().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            sentencia.executeUpdate(sql);
            //getConexion().commit();
            sentencia.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.print("ERROR SQL");
            return false;
        }
        return true;
    }


}