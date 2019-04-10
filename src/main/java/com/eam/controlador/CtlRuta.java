                        /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eam.controlador;

import com.eam.modelo.Ruta;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import org.json.simple.JSONObject;

/**
 *
 * @author nick_
 */
public class CtlRuta {

    public Double calcularTarifaTotal() {
        return 0.0;
    }

    public Boolean registrarRuta(String origen, String destino, BigDecimal capacidadTotal, String estado, Date fechaPartida) {
        JSONObject joRespuesta = (Main.dao.guardar(new Ruta(origen, destino, capacidadTotal, estado, fechaPartida)));
        return ((boolean) (joRespuesta.get("Resultado")));
    }
    
    public DefaultTableModel listarRutas(String estado){
        String[] columnas = {"ID","Origen", "Destino", "Capacidad Total","Fecha partida"};
        
        DefaultTableModel modelo = new DefaultTableModel(new Object[][]{}, columnas);
        
        ArrayList<String> campos = new ArrayList<>(), valores = new ArrayList<>();
        campos.add("estado");
        valores.add(estado);
        
        ArrayList<Ruta> cargas = new ArrayList<>(Main.dao.cargar("Ruta", campos, valores));
        
        cargas.forEach((ruta) -> {
            modelo.addRow(new Object[]{
                ruta.getIdruta()+"",
                ruta.getOrigen(),
                ruta.getDestino(),
                ruta.getCapacidadTotal()+"",
                ruta.getFechaPartida()+""
            });
        });
        
        return modelo;
    }
        public Ruta traerruta(Integer id){
        return (Ruta) Main.dao.buscar(id, Ruta.class);
    }

}
