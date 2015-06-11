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


public class Query {
    SQLConnection conexionBaseDeDatos;
    int contador = 1;
    public Query(){
        
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
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
     
     public String[] getDatosSecretaria(String dni){
        ResultSet consulta = null;
        String[] resultado = new String[20];
        try {
           consulta = conexionBaseDeDatos
                    .consultar("select * from alumnos where dni='"+dni+"'");
            consulta.next();
            resultado[0] = consulta.getString("nombre");
            resultado[1] = consulta.getString("apellidos");
            resultado[2] = consulta.getString("domicilio");
            resultado[3] = consulta.getString("telefono");
            resultado[4] = consulta.getString("fecha_nacimiento");
            resultado[5] = consulta.getString("curso");
            
           
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
    public boolean nuevoUsuario(String u, String pass){
          boolean resultado = false;
        try {
          
            resultado = conexionBaseDeDatos
                    .ejecutar("insert into usuarios (usuario, contraseña, rol) values ('"+u+"', '"+pass+"', 3)");
            
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
    public boolean borrarUsuario(String u){
          boolean resultado = false;
        try {
          
            resultado = conexionBaseDeDatos
                    .ejecutar("delete from usuarios where usuario='"+u+"'");
            
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
     public boolean modificarUsuario(String u, String pass){
          boolean resultado = false;
        try {
          
            resultado = conexionBaseDeDatos
                    .ejecutar("update usuarios set contraseña='"+pass+"' where usuario='"+u+"'");
            
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
     
    public boolean modificarAlumno(String[] datos){
          boolean resultado = false;
        try {
            System.out.println("telefono --> "+ datos[4]);
            resultado = conexionBaseDeDatos
                    .ejecutar("update alumnos set nombre='"+datos[1]+"', apellidos='"+datos[2]+"', domicilio='"+datos[3]+"', telefono='"+datos[4]+"', fecha_nacimiento='"+datos[5]+"', curso='"+datos[6]+"' where dni='"+datos[0]+"'");
                    //.ejecutar("update alumnos set nombre='"+datos[1]+"', apellidos='"+datos[2]+"' where dni='"+datos[0]+"'");
            
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
    public boolean modificarObservaciones(String dni, String observaciones){
        boolean resultado = false;
        try {
            resultado = conexionBaseDeDatos
                    .ejecutar("update alumnos set observaciones = '"+observaciones+"' where dni= '"+dni+"'");
            
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
        
        
    }
    public void imprimirAlumnos(){
        
        String ruta = "/home/pi/listados/resultado_"+contador+".txt";
        try {
            conexionBaseDeDatos
                    .consultar("SELECT * INTO OUTFILE '"+ruta+"' FIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY ''LINES TERMINATED BY '\n' FROM alumnos;");
                    
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
        contador++;
    }
    public boolean agregarAlumno(String[] datos){
          boolean resultado = false;
        try {
          
            resultado = conexionBaseDeDatos
                    .ejecutar("insert into alumnos (dni, nombre, apellidos, domicilio, telefono, fecha_nacimiento, curso, faltas, asignaturas, partes_expulsion) values ('"+datos[0]+"', '"+datos[1]+"', '"+datos[2]+"', '"+datos[3]+"', '"+datos[4]+"', '"+datos[5]+"', '"+datos[6]+"', 0, 'Matemáticas, Lengua, Conocimiento del medio, Inglés, Educación física, Música, Plástica, Lectura/estudio', 0)");
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
     public boolean modificarFaltas(int faltas, String nombre){
          boolean resultado = false;
        try {
          
            resultado = conexionBaseDeDatos
                    .ejecutar("update alumnos set faltas ='"+faltas+"' where dni='"+nombre+"'");
            
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
    public boolean listarAlumnos (String[] datos){
        boolean resultado = false;
        return resultado;
        
    }
    
    /*public boolean hacerBackup(){
        //TODO: ojo con este metodo
        Date fecha;
        int yyyy = 0;
        int mm = 0;
        int dd = 0;
        fecha = new Date(yyyy,mm,dd);
        boolean result = false;
        String ruta ="http://192.168.1.180:/backup";
        try {
            result = conexionBaseDeDatos.ejecutar ("mysqldump --opt --password=sekret --user=root colegio > archivo.sql");
        } catch (SQLException ex) {
            Logger.getLogger(Backup.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return result;
    }
    */
}
