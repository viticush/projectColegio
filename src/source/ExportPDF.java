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
    Document documento = new Document();
    public ExportPDF() throws FileNotFoundException, DocumentException{
      FileOutputStream archivo = new FileOutputStream("D:/listaAlumnos.pdf");
      
      
      PdfWriter.getInstance(documento, archivo);
}
    
        
    Query consulta = new Query();
    
    public void crearPDF(String texto) throws FileNotFoundException, DocumentException{
      
      documento.open();
        
      documento.add(new Paragraph(texto));
      documento.close();
      
    }
    
}
