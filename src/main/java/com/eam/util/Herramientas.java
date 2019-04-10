/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eam.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author Daryl
 */
public class Herramientas {

    //Codigo basado en: https://aprenderaprogramar.com/foros/index.php?topic=948.0
    public static Date generarFechaAleatoria() {
        Random aleatorio;
        aleatorio = new Random();
        Calendar unaFecha = Calendar.getInstance();
        unaFecha.set(aleatorio.nextInt(10) + 2014, aleatorio.nextInt(12) + 1, aleatorio.nextInt(30) + 1);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMMMM/yyyy");
        System.out.println("La fecha vale " + sdf.format(unaFecha.getTime()));
        return unaFecha.getTime();
    }
    
    public static BigDecimal generarNumeroBigAleatorio(int bound){
        return new BigDecimal((int) ((Math.random() * (bound-1) + 0)) + "");
    }
    
    public static int generarNumeroAleatorio(int bound){
        return (int) (Math.random() * (bound-1) + 0);
    }
    
    public static String generarCadenaAleatorio(int tamanio){
        Random aleatorio = new Random();
        String cadena = "";
        for (int i = 0; i < tamanio; i++) {
            cadena += (char) aleatorio.nextInt(250)+"";
        }
        return cadena;
    }
}
