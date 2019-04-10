/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eam.modelo;

/**
 *
 * @author Daryl
 */
public interface Reporte {
    
    public static String DIRECCION_REPORTES = "./src/main/resources/Reportes/MyReports/";
    
    public static enum tiposReportes{
        ALTA_SOLICITUD, ESTADO_CARGA, FACTURACION_DIARIA;
    }
    
    public abstract void generarReporte();
}
