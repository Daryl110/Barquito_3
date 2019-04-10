/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eam.controlador;

import com.eam.modelo.Puertos;
import com.eam.modelo.Viajes;

/**
 *
 * @author Daryl
 */
public class CtlViajes {
    
    public void asignarPuertoViaje(Puertos puertoLlegada, Puertos puertoSalida, Viajes viaje){
        viaje.setPuertoLlegada(puertoLlegada);
        viaje.setPuertoSalida(puertoSalida);
    }

    public boolean registrarViaje(Viajes viaje) {
        return ((boolean)(Main.dao.guardar(viaje)).get("Resultado"));
    }
}
