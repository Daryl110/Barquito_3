package com.eam.dao;

import com.eam.modelo.Conexion;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import org.json.simple.JSONObject;

/**
 *
 * @author Daryl Ospina
 */
public class DAO implements IDAO {

    private EntityManagerFactory entityManager;

    public DAO(String unidad) {
        this.entityManager = new Conexion(unidad).getFactory();
    }

    @Override
    public EntityManagerFactory getEntityManagerFactory() {
        return entityManager;
    }

    @Override
    public void setEntityManager(EntityManagerFactory entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public EntityManager getEntityManager() {
        return this.getEntityManagerFactory().createEntityManager();
    }

    @Override
    public Object cargar(String nombreClase, String campos) {
        EntityManager manager = null;
        Object lista = null;

        try {
            manager = getEntityManager();
            Query query = manager.createQuery("SELECT " + campos + " FROM " + nombreClase + " p");
            lista = (Object) query.getResultList();
        } catch (Exception e) {
            System.out.println("[Error] - " + e);
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
        return lista;
    }

    @Override
    public List cargar(String nombreClase, ArrayList camposAIgualar, ArrayList valoresAIgualar) {
        EntityManager manager = null;
        List lista = null;

        try {
            manager = getEntityManager();
            String consulta = "SELECT p FROM " + nombreClase + " p WHERE ";
            for (int i = 0; i < camposAIgualar.size(); i++) {
                consulta += "p."+camposAIgualar.get(i)+"='"+valoresAIgualar.get(i)+"'";
                if (i != camposAIgualar.size()-1) {
                    consulta += ", ";
                }
            }
            System.out.println(consulta);
            Query query = manager.createQuery(consulta);
            lista = query.getResultList();
        } catch (Exception e) {
            System.out.println("[Error] - " + e);
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
        return lista;
    }

    @Override
    public List cargar(String nombreClase) {
        EntityManager manager = null;
        List lista = null;

        try {
            manager = getEntityManager();
            Query query = manager.createQuery("SELECT p FROM " + nombreClase + " p");
            lista = query.getResultList();
        } catch (Exception e) {
            System.out.println("[Error] - " + e);
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
        return lista;
    }

    @Override
    public JSONObject guardar(Object objeto) {
        EntityManager manager = null;
        JSONObject joRespuesta = new JSONObject();
        try {
            manager = getEntityManager();
            manager.getTransaction().begin();
            manager.persist(objeto);
            manager.getTransaction().commit();
            joRespuesta.put("Registro", objeto);
            joRespuesta.put("Resultado", true);
        } catch (Exception e) {
            joRespuesta.put("Resultado", false);
            System.err.println(e);
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
        return joRespuesta;
    }

    @Override
    public JSONObject modificar(Object objeto) {
        EntityManager manager = null;
        JSONObject joRespuesta = new JSONObject();
        try {
            manager = getEntityManager();
            manager.getTransaction().begin();
            manager.merge(objeto);
            manager.getTransaction().commit();
            joRespuesta.put("Registro", objeto);
            joRespuesta.put("Resultado", true);
        } catch (Exception e) {
            joRespuesta.put("Resultado", false);
            System.err.println(e);
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
        return joRespuesta;
    }

    @Override
    public Object buscar(Object valorId, Class clase) {
        EntityManager manager = null;
        try {
            manager = getEntityManager();
            return manager.find(clase, valorId);
        } catch (Exception e) {
            System.err.println(e);
            return null;
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
    }

    @Override
    public JSONObject eliminar(Object obj, Class clase) {
        EntityManager manager = null;
        JSONObject joRespuesta = new JSONObject();
        try {
            manager = getEntityManager();
            manager.getTransaction().begin();
            Object objeto = manager.merge(obj);
            manager.remove(objeto);
            manager.getTransaction().commit();
            joRespuesta.put("Registro", obj);
            joRespuesta.put("Resultado", true);
        } catch (Exception e) {
            joRespuesta.put("Resultado", false);
            System.err.println(e);
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
        return joRespuesta;
    }

    @Override
    public List cargarConsulta(String query, Class clase) {
        EntityManager manager = null;
        List lista = null;

        try {
            manager = getEntityManager();
            Query result;
            if (clase != null) {
                result = manager.createNativeQuery(query, clase);
            } else {
                result = manager.createNativeQuery(query);
            }
            lista = result.getResultList();
        } catch (Exception e) {
            System.out.println("[Error] - " + e);
        } finally {
            if (manager != null) {
                manager.close();
            }
        }
        return lista;
    }
}
