/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package source;
import java.io.FileOutputStream;
import java.util.Date;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;

 
/**
 *
 * @author Y
 */
public class ExportPDF {
    
    Query consulta = new Query();
    
    public void crearPDF() throws FileNotFoundException, DocumentException{
        FileOutputStream archivo = new FileOutputStream("D:/boletinNotas.pdf");
      Document documento = new Document();
      
      PdfWriter.getInstance(documento, archivo);
        
      documento.open();
        
     /* documento.add(new Paragraph("Nombre - Matematicas - Lengua - Conocimiento del Medio - Ingles - Educacion Fisica - Musica - Plastica - Lectura/Estudio"));
        
      documento.add(new Paragraph("---------------------------------------------------------------------------------------------------------------------------------"));
      String[][] notas = consulta.generarBoletinNotas();
      documento.add(new Paragraph(notas[0][0]));
      /*for(int i = 0; i<notas.length;i++){
          documento.add(new Paragraph(notas[i][0] + " - " + notas[i][1] + " - " + notas[i][2] 
                  + " - " + notas[i][3] + " - " + notas[i][4] + " - " + notas[i][5] + " - " + notas[i][6] + " - " 
                  + notas[i][7] + " - " + notas[i][8] + " - "));
      }
      */documento.add(new Paragraph("---------------------------------------------------------------------------------------------------------------------------------"));
      documento.close();
      
    }
    
}
