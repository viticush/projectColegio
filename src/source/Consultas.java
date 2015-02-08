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
     public String[] getDatosProfesor(String dni){
        ResultSet consulta = null;
        String[] resultado = new String[20];
        try {
           consulta = conexionBaseDeDatos
                    .consultar("select * from alumnos where dni='"+dni+"'");
            consulta.next();
            resultado[0] = consulta.getString("nombre");
            resultado[1] = consulta.getString("apellidos");
            resultado[2] = consulta.getString("faltas");
            resultado[3] = consulta.getString("observaciones");
           
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
     
    public String[] getDatosJefatura(String dni){
        ResultSet consulta = null;
        String[] resultado = new String[20];
        try {
           consulta = conexionBaseDeDatos
                    .consultar("select * from alumnos where dni='"+dni+"'");
            consulta.next();
            resultado[0] = consulta.getString("nombre");
            resultado[1] = consulta.getString("apellidos");
            resultado[2] = consulta.getString("faltas");
            resultado[3] = consulta.getString("partes_expulsion");
            resultado[4] = consulta.getString("curso");
            consulta.close();
            
           /* consulta = conexionBaseDeDatos
                     .consultar("select * from notas where id='"+dni+"'");
            int i = 5;
            while(consulta.next()){
                
                resultado[i] = consulta.getString(1);
                i++;
                
            }*/
           
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
    public boolean nuevoUsuario(String u, String pass){
          boolean resultado = false;
        try {
          
            resultado = conexionBaseDeDatos
                    .ejecutar("insert into usuarios (usuario, contraseña, rol) values ('"+u+"', '"+pass+"', 3)");
            
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
     
      
    
}
