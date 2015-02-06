/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package source;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import oracleconnection.OracleConection;


public class Consultas {
    OracleConection conexionBaseDeDatos;
    
    public Consultas(){
        
        conexionBaseDeDatos = new OracleConection();
        
    }
    
    public String getContraseña(String nombre){
        ResultSet consulta = null;
        String resultado = null;
        try {
           consulta = conexionBaseDeDatos
                    .consultar("select contraseña from usuarios where usuario='"+nombre+"'");
            consulta.next();
            resultado = consulta.getString(1);
           
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
     public String getRol(String nombre){
        ResultSet consulta = null;
        String resultado = null;
        try {
           consulta = conexionBaseDeDatos
                    .consultar("select rol from usuarios where usuario='"+nombre+"'");
            consulta.next();
            resultado = consulta.getString(1);
           
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
     
      
    
}
