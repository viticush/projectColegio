/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package source;

import java.io.IOException;
import static java.lang.Compiler.command;
import javax.swing.JOptionPane;

/**
 *
 * @author victor
 */
public class Backup {
    
    //private Runtime llamada= Runtime.getRuntime().exec(command);
   // private String comando = "cmd /c start";
      
    public void exportarDatos(){
        //comando+="notepad.exe";
       // comando += "expdp system/software dumpfile=copia_bd.dmp logfile=copia_bd.log directory=CARPETA_EXPORT SCHEMAS=colegio";
        try {
            String command = "expdp system/software dumpfile=copia_bd.dmp logfile=copia_bd.log directory=CARPETA_EXPORT SCHEMAS=colegio";
            Process child = Runtime.getRuntime().exec(command);
            //llamada.exec(comando);
            JOptionPane.showMessageDialog(null, "La copia de seguridad se ha generado correctamente");
        } catch (IOException e) {
            System.out.println(e);
        }
    }

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
