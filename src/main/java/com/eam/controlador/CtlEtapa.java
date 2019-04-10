/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eam.controlador;

import com.eam.modelo.Etapa;
import com.eam.modelo.Puertos;
import com.eam.modelo.Viajes;
import com.eam.util.Herramientas;
import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Daryl
 */
public class CtlEtapa {

    public boolean registrarEtapa(Etapa etapa) {
        return ((boolean) (Main.dao.guardar(etapa)).get("Resultado"));
    }

    public boolean asignarViajeEtapa(Etapa etapa, Puertos puertoLlegada, Puertos puertoSalida) {
        CtlViajes controladorViaje = new CtlViajes();
        
        Date fecha1 = Herramientas.generarFechaAleatoria(),
                fecha2 = Herramientas.generarFechaAleatoria();
        
        Viajes viaje;
        
        if (fecha1.before(fecha2)) {
            viaje = new Viajes(fecha1, fecha2);
        } else {
            viaje = new Viajes(fecha2, fecha1);
        }
        
        controladorViaje.asignarPuertoViaje(puertoLlegada, puertoSalida, viaje);
        viaje.setEtapaidEtapa(etapa);
        
        return ((boolean) (Main.dao.guardar(viaje)).get("Resultado"));
    }
}
