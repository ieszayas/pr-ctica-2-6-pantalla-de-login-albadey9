/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package VistaControlador;

import Modelo.Loguear;
import javax.swing.JOptionPane;

/**
 *
 * @author DAM2_06
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form practica2_6
     */
    public Login() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        texto_usuario = new javax.swing.JLabel();
        texto_contrasena = new javax.swing.JLabel();
        usuario = new javax.swing.JTextField();
        txt_contrasena = new javax.swing.JPasswordField();
        check_mostrar = new javax.swing.JCheckBox();
        boton_loguear = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Login");

        jLabel1.setText("Por favor, introduzca sus credenciales para acceder:");

        texto_usuario.setText("Usuario");

        texto_contrasena.setText("Contraseña");

        usuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioActionPerformed(evt);
            }
        });

        check_mostrar.setText("Mostrar");
        check_mostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                check_mostrarActionPerformed(evt);
            }
        });

        boton_loguear.setText("Loguear");
        boton_loguear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boton_loguearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(texto_contrasena)
                            .addComponent(texto_usuario))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(usuario)
                            .addComponent(txt_contrasena)
                            .addComponent(boton_loguear, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(18, 18, 18)
                .addComponent(check_mostrar)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(texto_usuario)
                    .addComponent(usuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(texto_contrasena)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_contrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(check_mostrar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
                .addComponent(boton_loguear)
                .addGap(47, 47, 47))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void usuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usuarioActionPerformed

    private void check_mostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_check_mostrarActionPerformed
        if (check_mostrar.isSelected()) {
            txt_contrasena.setEchoChar((char) 0);
        } else {
            txt_contrasena.setEchoChar('*');
        }
    }//GEN-LAST:event_check_mostrarActionPerformed

    public void vibrarPantalla() {
        final int originalX = this.getLocationOnScreen().x;  // Obtener la posición original en X
        final int originalY = this.getLocationOnScreen().y;  // Obtener la posición original en Y

        // Creamos un hilo para que no bloquee el hilo principal de la UI
        new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    // Mover la ventana a posiciones levemente distintas
                    this.setLocation(originalX + (int) (Math.random() * 10 - 5),
                            originalY + (int) (Math.random() * 10 - 5));
                    Thread.sleep(20);  // Pausa breve entre cada movimiento
                }
                // Volver a la posición original al finalizar
                this.setLocation(originalX, originalY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void boton_loguearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boton_loguearActionPerformed
        String user = usuario.getText();
        String password = String.valueOf(txt_contrasena.getPassword());
        Loguear loguear = new Loguear();
        if (user.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor rellena el campo", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (loguear.validar(user, password)) {
            Principal principal = new Principal(user);
            principal.setVisible(true);
        } else {
            vibrarPantalla();
            JOptionPane.showMessageDialog(this, "Por favor, no se ha podido realizar, vuelva a intentarlo", "Error", JOptionPane.ERROR_MESSAGE);
            usuario.setText("");
            txt_contrasena.setText("");
            return;
        }


    }//GEN-LAST:event_boton_loguearActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boton_loguear;
    private javax.swing.JCheckBox check_mostrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel texto_contrasena;
    private javax.swing.JLabel texto_usuario;
    private javax.swing.JPasswordField txt_contrasena;
    private javax.swing.JTextField usuario;
    // End of variables declaration//GEN-END:variables
}
