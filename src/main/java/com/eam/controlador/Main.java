/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eam.controlador;

import com.eam.dao.DAO;
import com.eam.dao.IDAO;
import com.eam.util.Herramientas;
import com.eam.vista.FrmPrincipal;
import javax.swing.JOptionPane;

/**
 *
 * @author Daryl
 */
public class Main {

    public static IDAO dao;

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            dao = new DAO("ConexionBD");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Hubo un error al intentar conectar con la base de datos. contacte con el administrador.");
            System.out.println("[Error] : " + e);
            return;
        }
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
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrmPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            FrmPrincipal frmprincipal = new FrmPrincipal();
            frmprincipal.setLocationRelativeTo(null);
            frmprincipal.setVisible(true);
        });
    }
}
