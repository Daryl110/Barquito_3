/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eam.modelo;

import com.eam.controlador.Main;
import static com.eam.modelo.Reporte.DIRECCION_REPORTES;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import org.hibernate.HibernateException;
import org.hibernate.internal.SessionImpl;

/**
 *
 * @author Daryl
 */
public class Report_EstadoCarga implements Reporte{
    
    @Override
    public void generarReporte() {
        Connection conexion;

        try {
            conexion = Main.dao.getEntityManager().unwrap(SessionImpl.class).connection();
        } catch (HibernateException e) {
            JOptionPane.showMessageDialog(null, "Error al establecer la conexion con la base de datos contacte con el administrador.");
            System.out.println("[Error] : " + e);
            return;
        }

        JasperPrint print;
        
        try {
            print = JasperFillManager.fillReport(DIRECCION_REPORTES + "EstadoCarga.jasper", null, conexion);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error al iniciar el reporte contacte con el administrador.");
            System.out.println("[Error] : " + e);
            return;
        }
        
        JasperViewer view = new JasperViewer(print, false);
        view.setVisible(true);
    }
    
}
