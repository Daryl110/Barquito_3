/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eam.modelo;

import com.eam.controlador.Main;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import org.hibernate.HibernateException;
import org.hibernate.internal.SessionImpl;

/**
 *
 * @author Daryl
 */
public class Report_FacturacionDiaria implements Reporte {
    
    private Date fecha;

    public Report_FacturacionDiaria(Date fecha) {
        this.fecha = fecha;
    }

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

        Map<String, Object> parametros = new HashMap<>();
        parametros.put("fecha", new SimpleDateFormat("yyyy-MM-dd").format(this.fecha));
        parametros.put("formatoFecha", "%Y-%m-%d");

        JasperPrint print;
        
        try {
            print = JasperFillManager.fillReport(DIRECCION_REPORTES + "FacturacionDiaria.jasper", parametros, conexion);
        } catch (JRException e) {
            JOptionPane.showMessageDialog(null, "Error al iniciar el reporte contacte con el administrador.");
            System.out.println("[Error] : " + e);
            return;
        } catch(NullPointerException e){
            JOptionPane.showMessageDialog(null, "No se encontrado cargas de la fecha especificada.");
            return;
        }
        
        JasperViewer view = new JasperViewer(print, false);
        view.setVisible(true);
    }

}
