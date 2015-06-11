/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package source;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sqlconnection.SQLConnection;
/**
 *
 * @author victor
 */
public class Backup {
    
    //private Runtime llamada= Runtime.getRuntime().exec(command);
   // private String comando = "cmd /c start";
    private Component ventana;
      
    public void hacerBackup(){
        //TODO:Ojo con el metodo de los cojones
        String line;
        String p ="sekret";
        try {
            String[] command = new String[] {"cmd.exe", "/c", "\"C:/Program Files/MySQL/MySQL Server 5.6/bin/mysqldump.exe\" -h viti-raspbian.ddns.net -u root --password=sekret colegio > D:/colegio.sql"};
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
            while ((line = input.readLine()) != null) {
                
                System.out.println(line); //there you can write file
            }
            input.close();
        } catch (IOException ex) {
            Logger.getLogger(Backup.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //DEPRECATED!!!
    public void importarDatos(){
        try {
            String command = "impdp hr directory=CARPETA_EXPORT dumpfile=copia_bd.dmp logfile=copia_bd.log  SCHEMAS=colegio";
            Process child = Runtime.getRuntime().exec(command);
            //llamada.exec(comando);
            JOptionPane.showMessageDialog(null, "La copia de seguridad se ha restaurado correctamente");
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
