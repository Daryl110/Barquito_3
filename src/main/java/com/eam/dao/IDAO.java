/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eam.dao;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.json.simple.JSONObject;

/**
 *
 * @author Daryl Ospina
 */
public interface IDAO<T> {
    
    public abstract Object cargar(String nombreClase,String campos);
    public abstract List cargar(String nombreClase, ArrayList<String> camposAIgualar, ArrayList<String> valoresAIgualar);
    public abstract List cargar(String nombreClase);
    public abstract JSONObject guardar(Object objeto);
    public abstract JSONObject modificar(Object objeto);
    public abstract Object buscar(Object valorId,Class<T> clase);
    public abstract JSONObject eliminar(Object valorId,Class<T> clase);
    public abstract EntityManager getEntityManager();
    public abstract EntityManagerFactory getEntityManagerFactory();
    public abstract void setEntityManager(EntityManagerFactory entityManager);
    public abstract List cargarConsulta(String query,Class<T> clase);
}
