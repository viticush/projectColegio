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
import sqlconnection.SQLConnection;


public class Consultas {
    SQLConnection conexionBaseDeDatos;
    
    public Consultas(){
        
        conexionBaseDeDatos = new SQLConnection();
        
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
            resultado[5] = consulta.getString("asignaturas");
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
    
    public boolean borrarUsuario(String u){
          boolean resultado = false;
        try {
          
            resultado = conexionBaseDeDatos
                    .ejecutar("delete from usuarios where usuario='"+u+"'");
            
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
     public boolean modificarUsuario(String u, String pass){
          boolean resultado = false;
        try {
          
            resultado = conexionBaseDeDatos
                    .ejecutar("update usuarios set contraseña='"+pass+"' where usuario='"+u+"'");
            
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
     
     public boolean agregarAlumno(String[] datos){
          boolean resultado = false;
        try {
          
            resultado = conexionBaseDeDatos
                    .ejecutar("insert into alumnos (dni, nombre, apellidos, domicilio, telefono, fecha_nacimiento, curso, faltas, asignaturas, partes_expulsion) values ('"+datos[0]+"', '"+datos[1]+"', '"+datos[2]+"', '"+datos[3]+"', '"+datos[4]+"', TO_DATE('"+datos[5]+"', 'MM/DD/YYYY'),'"+datos[6]+"',0,'Matemáticas, Lengua, Conocimiento del medio, Inglés, Educación física, Música, Plástica, Lectura/estudio',0)");
            
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
     
     public boolean modificarFaltas(int faltas, String nombre){
          boolean resultado = false;
        try {
          
            resultado = conexionBaseDeDatos
                    .ejecutar("update alumnos set faltas ='"+faltas+"' where dni='"+nombre+"'");
            
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
    public String getFaltas(String nombre){
        ResultSet consulta = null;
        String resultado = null;
        try {
           consulta = conexionBaseDeDatos
                    .consultar("select faltas from alumnos where dni='"+nombre+"'");
            consulta.next();
            resultado = consulta.getString(1);
           
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
      
    
}
