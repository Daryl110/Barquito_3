/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eam.controlador;

import com.eam.modelo.Carga;
import com.eam.modelo.Cliente;
import com.eam.modelo.Puertos;
import com.eam.modelo.Ruta;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Daryl
 */
public class CtlCarga {

    public boolean crearCarga(BigDecimal tamanio, BigDecimal peso, String estado, Cliente clientecedula, Puertos puertosidPuertos) {
        Carga carga = new Carga(tamanio, peso, estado, clientecedula, puertosidPuertos);
        return ((boolean) (Main.dao.guardar(carga)).get("Resultado"));
    }

    public boolean asociarRuta(Carga carga, Ruta ruta) {
        carga.setRutaIdruta(ruta);
        carga.setEstado("CARGADO");
        return ((boolean)(Main.dao.modificar(carga)).get("Resultado"));
    }
    
    public boolean darAltaCarga(Carga carga){
        carga.setEstado("DESCARGADO");
        return ((boolean)(Main.dao.modificar(carga)).get("Resultado"));
    }
    
    public DefaultTableModel listarCargas(String estado,String valor){
        String[] columnas = {"ID","Tamaño", "Peso", "Puerto"};
        
        DefaultTableModel modelo = new DefaultTableModel(new Object[][]{}, columnas);
        
        ArrayList<String> campos = new ArrayList<>(), valores = new ArrayList<>();
        campos.add(valor);
        valores.add(estado);
        
        ArrayList<Carga> cargas = new ArrayList<>(Main.dao.cargar("Carga", campos, valores));
        
        for(Carga carga: cargas) {
            modelo.addRow(new Object[]{
                carga.getIdCarga(),
                carga.getTamanio(),
                carga.getPeso(),
                carga.getPuertosidPuertos().getDescripcion()
            });
        };
        
        return modelo;
    }
    
    public boolean quitarRuta(Carga carga) {
        carga.setRutaIdruta(null);
        carga.setEstado("ACTIVO");
        return ((boolean)(Main.dao.modificar(carga)).get("Resultado"));
    }
    
    public Carga traerCarga(Integer id){
        return (Carga) Main.dao.buscar(id, Carga.class);
    }
    
}
