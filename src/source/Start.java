/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package source;

import graficos.AboutFrame;
import graficos.LoginFrame;
import graficos.ProfFrame;
import oracleconnection.OracleConnection;

/**
 *
 * @author victor
 */
public class Start {
   
    public static void main(String [] args){
       OracleConnection.startdb();
       LoginFrame.arrancar();   
    }
}
