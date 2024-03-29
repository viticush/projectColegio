/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package graphics;

import java.awt.Component;
import javax.swing.JOptionPane;
import source.Query;

/**
 *
 * @author victor
 */
public class ModificarAlumno extends javax.swing.JFrame {
    private Query consulta;
    private Component ventana;

    /**
     * Creates new form ModificarAlumno
     */
    public ModificarAlumno() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel10 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabelDNI1 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jTextFieldDNI1 = new javax.swing.JTextField();
        jTextFieldNombre1 = new javax.swing.JTextField();
        jTextFieldApellidos1 = new javax.swing.JTextField();
        jTextFieldDomicilio1 = new javax.swing.JTextField();
        jTextFieldTelefono1 = new javax.swing.JTextField();
        jTextFieldNacimiento1 = new javax.swing.JTextField();
        jTextFieldCurso1 = new javax.swing.JTextField();
        jButtonModifAlum = new javax.swing.JButton();
        jButtonBorrarModAlum = new javax.swing.JButton();
        jButtonSearchModAlum = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel30.setText("Nuevo nombre:");

        jLabel31.setText("Apellidos:");

        jLabel32.setText("Domicilio:");

        jLabel33.setText("Teléfono:");

        jLabelDNI1.setText("DNI:");

        jLabel34.setText("Fecha de nacimiento (yyyy-mm-dd):");

        jTextFieldDNI1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldDNI1ActionPerformed(evt);
            }
        });

        jTextFieldTelefono1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTelefono1ActionPerformed(evt);
            }
        });

        jTextFieldCurso1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldCurso1ActionPerformed(evt);
            }
        });

        jButtonModifAlum.setText("Modificar");
        jButtonModifAlum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModifAlumActionPerformed(evt);
            }
        });

        jButtonBorrarModAlum.setText("Clear");
        jButtonBorrarModAlum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarModAlumActionPerformed(evt);
            }
        });

        jButtonSearchModAlum.setText("Buscar");
        jButtonSearchModAlum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSearchModAlumActionPerformed(evt);
            }
        });

        jLabel35.setText("Curso:");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel33)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldTelefono1))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabelDNI1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldDNI1))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel32)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldDomicilio1))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel31)
                        .addGap(2, 2, 2)
                        .addComponent(jTextFieldApellidos1))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel30)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jButtonModifAlum, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonBorrarModAlum, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel34)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldNacimiento1))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addComponent(jLabel35)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldCurso1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonSearchModAlum)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelDNI1)
                    .addComponent(jTextFieldDNI1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSearchModAlum))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(jTextFieldNombre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(jTextFieldApellidos1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel32)
                    .addComponent(jTextFieldDomicilio1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel33)
                    .addComponent(jTextFieldTelefono1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel34)
                    .addComponent(jTextFieldNacimiento1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldCurso1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel35))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonBorrarModAlum, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonModifAlum, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldDNI1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldDNI1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldDNI1ActionPerformed

    private void jTextFieldTelefono1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTelefono1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTelefono1ActionPerformed

    private void jTextFieldCurso1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldCurso1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldCurso1ActionPerformed

    private void jButtonModifAlumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModifAlumActionPerformed
        // TODO add your handling code here:
        String[] datos = new String[20];
        consulta = new Query();

        datos[0] = jTextFieldDNI1.getText();
        datos[1] = jTextFieldNombre1.getText();
        datos[2] = jTextFieldApellidos1.getText();
        datos[3] = jTextFieldDomicilio1.getText();
        datos[4] = jTextFieldTelefono1.getText();
        datos[5] = jTextFieldNacimiento1.getText();
        datos[6] = jTextFieldCurso1.getText();
        consulta.modificarAlumno(datos);

        jTextFieldDNI1.setText("");
        jTextFieldNombre1.setText("");
        jTextFieldApellidos1.setText("");
        jTextFieldDomicilio1.setText("");
        jTextFieldNacimiento1.setText("");
        jTextFieldTelefono1.setText("");
        jTextFieldCurso1.setText("");
        this.dispose();
    }//GEN-LAST:event_jButtonModifAlumActionPerformed

    private void jButtonBorrarModAlumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarModAlumActionPerformed
        // TODO add your handling code here:
        jTextFieldDNI1.setText("");
        jTextFieldNombre1.setText("");
        jTextFieldApellidos1.setText("");
        jTextFieldDomicilio1.setText("");
        jTextFieldTelefono1.setText("");
        jTextFieldNacimiento1.setText("");
        jTextFieldCurso1.setText("");
    }//GEN-LAST:event_jButtonBorrarModAlumActionPerformed

    private void jButtonSearchModAlumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSearchModAlumActionPerformed
        // TODO add your handling code here:
        //hacemos una consulta en función al dni del alumno (debe estar en la BD)
        
        String d = jTextFieldDNI1.getText();
        if (d.length()> 9 || d.length()==0){
            JOptionPane.showMessageDialog(ventana,
    "El DNI no es correcto.",
    "Be careful!",
    JOptionPane.WARNING_MESSAGE);
            
        } else {
        
        consulta = new Query();
        String[] campos = new String[20];
        
        campos = consulta.getDatosSecretaria(d);

        jTextFieldNombre1.setText(campos[0]);
        jTextFieldApellidos1.setText(campos[1]);
        jTextFieldDomicilio1.setText(campos[2]);
        jTextFieldTelefono1.setText(campos[3]);
        jTextFieldNacimiento1.setText(campos[4]);
        jTextFieldCurso1.setText(campos[5]);
        
        }
    }//GEN-LAST:event_jButtonSearchModAlumActionPerformed

    public  void arrancarModificarAlumno() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ModificarAlumno().setVisible(true);      
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonBorrarModAlum;
    private javax.swing.JButton jButtonModifAlum;
    private javax.swing.JButton jButtonSearchModAlum;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabelDNI1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JTextField jTextFieldApellidos1;
    private javax.swing.JTextField jTextFieldCurso1;
    private javax.swing.JTextField jTextFieldDNI1;
    private javax.swing.JTextField jTextFieldDomicilio1;
    private javax.swing.JTextField jTextFieldNacimiento1;
    private javax.swing.JTextField jTextFieldNombre1;
    private javax.swing.JTextField jTextFieldTelefono1;
    // End of variables declaration//GEN-END:variables
}
