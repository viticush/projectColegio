package oracleconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracle.jdbc.driver.OracleDriver;

public class OracleConection {

    //Usuario de la base de datos
    private static final String USUARIO = "colegio";
    //Contraseña del usuario de la base de datos
    private static final String PASS = "software";
    //SID de la base de datos, este lo registramos en la instalacion
    private static final String SID = "xe";
    //Host donde se encuentra la base de datos, para nuesto caso como es local
    //se indica que esta en localhost
    private static final String HOST = "localhost";
    //El puerto 1521 es el estandar para este tipo de instalaciones a menos que
    //se indicque lo contrario
    private static final int PUERTO = 1521;
    //Objeto donde se almacenara nuestra conexion
    private static Connection conection;

   public Connection getConexion() throws SQLException {
        if (conection == null || conection.isClosed()) {
            this.conectar();
        }
        return conection;
    }

   

  
   
    private OracleConection conectar() {
        try {
            Class.forName("oracle.jdbc.OracleDriver");

            String cadenaConexion = "jdbc:oracle:thin:@" + HOST + ":" + PUERTO + ":" + SID;
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

        OracleConection conexionOracle = new OracleConection();
        try {
            conexionOracle.conectar();
            Connection conn = conexionOracle.getConexion();
            // driver@machineName:port:SID           ,  userid,  password
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery("select BANNER from SYS.V_$VERSION");
            while (rset.next()) {
                System.out.println(rset.getString(1));   // Print col 1
            }
            stmt.close();
            conexionOracle.cerrar();
        } catch (SQLException ex) {
            Logger.getLogger(OracleConection.class.getName()).log(Level.SEVERE, null, ex);
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


}