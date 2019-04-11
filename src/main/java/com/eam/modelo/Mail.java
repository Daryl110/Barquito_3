/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eam.modelo;

import com.eam.controlador.Main;
import com.eam.util.Herramientas;
import java.io.Serializable;
import java.util.ArrayList;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.json.simple.JSONObject;

/**
 *
 * @author Daryl
 */
@Entity
@Table(name = "mail")
@NamedQueries({
    @NamedQuery(name = "Mail.findAll", query = "SELECT m FROM Mail m")})
public class Mail implements Serializable, Factura, Notificacion, Cronologia {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idMail")
    private Integer idMail;
    @Size(max = 45)
    @Column(name = "notificacion")
    private String notificacion;
    @Size(max = 1000)
    @Column(name = "descripcion")
    private String descripcion;
    @JoinColumn(name = "Usuario_correo", referencedColumnName = "correo")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario usuariocorreo;

    public Mail() {
    }

    public Mail(Integer idMail) {
        this.idMail = idMail;
    }

    public Integer getIdMail() {
        return idMail;
    }

    public void setIdMail(Integer idMail) {
        this.idMail = idMail;
    }

    public String getNotificacion() {
        return notificacion;
    }

    public void setNotificacion(String notificacion) {
        this.notificacion = notificacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Usuario getUsuariocorreo() {
        return usuariocorreo;
    }

    public void setUsuariocorreo(Usuario usuariocorreo) {
        this.usuariocorreo = usuariocorreo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMail != null ? idMail.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Mail)) {
            return false;
        }
        Mail other = (Mail) object;
        if ((this.idMail == null && other.idMail != null) || (this.idMail != null && !this.idMail.equals(other.idMail))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return notificacion+"\n"+descripcion;
    }

    public void generarMail(Itinerario itinerario) {
        ArrayList<Carga> listaC = new ArrayList<>(itinerario.getRutaIdruta().getCargaList());
        this.descripcion="";
        listaC.forEach((carga) -> {
            this.descripcion += generarFactura(carga);
            this.descripcion += "\n";
            this.descripcion += generarCronologia(itinerario);
            notificacion = agregarNotificacion(Herramientas.generarCadenaAleatorio(20));
            this.usuariocorreo = carga.getClientecedula().getUsuariocorreo();
            JSONObject joRespuesta = (Main.dao.guardar(this));
        });

    }

    @Override
    public String generarFactura(Carga c) {
        String factura = "";
        factura += c.toString();
        factura += "\n Valor:" + Herramientas.generarNumeroAleatorio(200) + "000";
        return factura;
    }

    @Override
    public String agregarNotificacion(String Descripcion) {
        return "Notificacion:" + Descripcion;
    }

    @Override
    public String generarCronologia(Itinerario itinerario) {
        String cronologia = " Cronologia: \n";
        //ArrayList<Etapa> listaE = new ArrayList<>(itinerario.getEtapaList());
        ArrayList<String> campos = new ArrayList<>() , valores = new ArrayList<>();
        campos.add("itinerarioidItinerario.idItinerario");
        valores.add(itinerario.getIdItinerario()+"");
        ArrayList<Etapa> listaE = new ArrayList<>(Main.dao.cargar("Etapa", campos, valores));
        for (Etapa etapa : listaE) {
            cronologia += etapa.toString();
        }
        return cronologia;
    }
}
