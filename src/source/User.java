/*
 * Clase que contiene el listado de usuarios en la base de datos
 * Se usa para realizar el login correctamente
 */

package source;



/**
 *
 * @author victor
 */
public class User {
    
    private String nickname;

    private String password;
    
  
    
    public void setNickname(String name){
        
        this.nickname = name;
        
    }
    public void setPassword(String pass){
        
        this.password = pass;
        
    }
    public String getNickname(){
        
        return this.nickname;
        
    }
    public String getPassword(){
        
        return this.password;
        
    }
    
    
   

    
}
