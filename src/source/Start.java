/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package source;

import graphics.AboutFrame;
import graphics.LoginVentana;
import graphics.MainUsuario;
import sqlconnection.SQLConnection;

/**
 *
 * @author victor
 */
public class Start {
   
    public static void main(String [] args){
       SQLConnection.startdb();
       LoginVentana.arrancar();   
    }
}
