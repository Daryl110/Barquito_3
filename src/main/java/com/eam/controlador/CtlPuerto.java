/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eam.controlador;

import com.eam.modelo.Puertos;
import java.math.BigDecimal;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Cristian
 */
public class CtlPuerto {

    public DefaultComboBoxModel listarPuertos(String tipoPuerto) {

        DefaultComboBoxModel modelo = new DefaultComboBoxModel();

        ArrayList<String> campos = new ArrayList<>(), valores = new ArrayList<>();
        campos.add("tipoPuerto");
        valores.add(tipoPuerto);

        ArrayList<Puertos> puertos = new ArrayList<>(Main.dao.cargar("Puertos", campos, valores));

        puertos.forEach((puertoss) -> {
            modelo.addElement(puertoss.toString()
            );
        });

        return modelo;
    }

    public Puertos traerPuerto(Integer id) {
        return (Puertos) Main.dao.buscar(id, Puertos.class);
    }
}
