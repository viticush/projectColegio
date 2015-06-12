/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package source;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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
    public void imprimirAlumnos() throws IOException, SQLException{
        ResultSet consulta = null;
        FileWriter fichero = null;
        PrintWriter pw = null;
        //int counter = 0;
        fichero = new FileWriter("D:/prueba_"+contador+".txt");
        pw = new PrintWriter(fichero);
        
        /*consulta = conexionBaseDeDatos.consultar("select count(*) from alumnos");
        int numFilas = consulta.getIngetInt(1);
        System.out.println(numFilas);*/
        consulta = conexionBaseDeDatos.consultar("select * from alumnos");
        do{
         
        consulta.next();
        pw.printf("---------------------------------------------------------------------------------------------------------------------------------------------%n%n%n");
        pw.printf("DNI: "+consulta.getString("dni")+"%n"
                  +"Nombre: "+consulta.getString("nombre")+"%n"
                  +"Apellidos: "+consulta.getString("apellidos")+"%n"
                  +"Domicilio: "+consulta.getString("domicilio")+"%n"
                  +"Teléfono: "+consulta.getString("telefono")+"%n"
                  +"Fecha de nacimiento: "+consulta.getString("fecha_nacimiento")+"%n"
                  +"Faltas de asistencia: "+consulta.getString("faltas")+"%n"
                  +"Curso: "+consulta.getString("curso")+"%n"
                  +"Partes de expulsión: "+consulta.getString("partes_expulsion")+"%n"
                  +"Asignaturas: "+consulta.getString("asignaturas")+"%n%n%n"
        );
        //counter++;
        }while(consulta.next());
        fichero.close();
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
     
     public void modificarPartes(String dni){
        
         ResultSet consulta = null;
         String resultado = null;
        try {
           consulta = conexionBaseDeDatos
                    .consultar("select Partes_expulsion from alumnos where dni='"+dni+"'");
            consulta.next();
            resultado = consulta.getString(1);
            
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
        int count;
        count = Integer.parseInt(resultado);
        count++;
        try {
            conexionBaseDeDatos
                    .ejecutar("update alumnos set Partes_expulsion ='"+count+"' where dni='"+dni+"'");
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
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
    
    public String[] getNotasAlumno(String dni){
        ResultSet consulta = null;
        String[] resultado = new String[20];
        try {
           consulta = conexionBaseDeDatos
                    .consultar("select * from notas where id='"+dni+"'");
            consulta.next();
            resultado[0] = consulta.getString("matematicas");
            resultado[1] = consulta.getString("lengua");
            resultado[2] = consulta.getString("conocimiento_del_medio");
            resultado[3] = consulta.getString("ingles");
            resultado[4] = consulta.getString("educacion_fisica");
            resultado[5] = consulta.getString("musica");
            resultado[6] = consulta.getString("plastica");
            resultado[7] = consulta.getString("lectura_estudio");
            resultado[8] = consulta.getString("curso");
                      
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
    
    public boolean crearTablaNotas(String dni){
        ResultSet curso = null;
        boolean resultado = false;
        try {
            curso  = conexionBaseDeDatos.consultar("select * from alumnos where dni='"+dni+"'");
            curso.next();
            String cursoAlumno = curso.getString("curso");
            
            int num = Integer.parseInt(cursoAlumno.charAt(0)+"");
            System.out.println(num);
            //TODO falla la consulta
            resultado = conexionBaseDeDatos
                    .ejecutar("insert into notas (id, matematicas, lengua, conocimiento_del_medio, ingles, educacion_fisica, musica, plastica, lectura_estudio, curso) values ('"+dni+"', -1, -1, -1, -1, -1, -1, -1, -1,"+num+")");
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
        
    }
    
    public boolean actualizarNotas(String[] dato, String dni){
        int[] datos= new int[8];
        for (int i = 0; i< dato.length; i++){
            datos[i]= Integer.parseInt(dato[i]);
        }
        boolean resultado = false;
        try {
            resultado = conexionBaseDeDatos
                    .ejecutar("update notas set matematicas ='"+datos[0]+"', lengua ='"+datos[1]+"', conocimiento_del_medio ='"+datos[2]+"', ingles ='"+datos[3]+"', educacion_fisica ='"+datos[4]+"', "
                            + "musica ='"+datos[5]+"', plastica ='"+datos[6]+"', lectura_estudio ='"+datos[7]+"'  where id='"+dni+"'");
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
            return resultado;
        
        
    }
    
    
    //PENDIENTE DE HACER
    public boolean listarAlumnos (String[] datos){
        boolean resultado = false;
        return resultado;
        
    }
    
    
    
    
    
    //PENDIENTE DE PROBAR
    
    public String generarBoletinNotas(int curso){
        ResultSet consulta = null;
        String result = null;
        
        try {
            consulta = conexionBaseDeDatos.consultar("select * from notas where curso='"+curso+"'");
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
        
    }
    
    
    
    
    
    /*
    
    public String[][] generarBoletinNotas(){
        ResultSet consulta1 = null;
        String[][] resultado = null;
        String[] notas = null;
        
        try {
            int count = 0;
            consulta1 = conexionBaseDeDatos
                    .consultar("select id from notas");
            while(consulta1.next()){
                resultado[count][0] = this.getNombreAlumno(consulta1.getString(1));
                notas = this.getNotasAlumno(consulta1.getString(1));
                for(int i = 0;i<8;i++)
                    resultado[count][i+1] = notas[i];
                    count++;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
    
    
    public String getNombreAlumno(String id) {
        ResultSet consulta = null;
        String resultado = null;
        try {
           consulta = conexionBaseDeDatos
                    .consultar("select nombre from alumnos where dni='"+id+"'");
            consulta.next();
            resultado = consulta.getString("nombre");
            
           
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;    
    }
    
    
    public String[] getNotasAlumno(String id) {
        ResultSet consulta = null;
        String[] resultado = null;
        
         try {
           consulta = conexionBaseDeDatos
                    .consultar("select * from notas where Id='"+id+"'");
            consulta.next();
            resultado[0] = consulta.getString(2);
            resultado[1] = consulta.getString(3);
            resultado[2] = consulta.getString(4);
            resultado[3] = consulta.getString(5);
            resultado[4] = consulta.getString(6);
            resultado[5] = consulta.getString(7);
            resultado[6] = consulta.getString(8);
            resultado[7] = consulta.getString(9);
           
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    
    
    
    public boolean agregarNotasNuevas(String[] datos) {
            boolean resultado = false;
        try {
          
            resultado = conexionBaseDeDatos
                    .ejecutar("insert into notas (Matematicas,Lengua,Conocimiento_del_medio,Ingles,Educacion_fisica,Musica,Plastica,Lectura/estudio) "
                            + "values ('"+datos[1]+"', '"+datos[2]+"', '"+datos[3]+"', '"+datos[4]+"', '"+datos[5]+"', '"+datos[6]+"','"+datos[7]+"','"+datos[8]+"') where Id='"+datos[0]+"'");
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;    
    }

    public boolean modificarNotas(String[] datos) {
        boolean resultado = false;
        try {
          
            resultado = conexionBaseDeDatos
                    .ejecutar("update notas set Matematicas ='"+datos[1]+"', Lengua ='"+ datos[2]+
                            "', Conocimiento_del_medio='"+datos[3]+"', Ingles = '"+
                            datos[4]+"', Educacion_fisica = '"+datos[5]+"'"
                            + ", Musica = '"+ datos[6]+"', Plastica ='"+ datos[7]
                            +"', Lectura/estudio = '"+datos[8]+"' where Id='"+datos[0]+"'");
            
        } catch (SQLException ex) {
            Logger.getLogger(Query.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;   
    }*/
}
