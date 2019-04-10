/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eam.modelo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Daryl
 */
@Entity
@Table(name = "viajes")
@NamedQueries({
    @NamedQuery(name = "Viajes.findAll", query = "SELECT v FROM Viajes v")})
public class Viajes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idviajes")
    private Integer idviajes;
    @Column(name = "fechaPartida")
    @Temporal(TemporalType.DATE)
    private Date fechaPartida;
    @Column(name = "fechaLlegada")
    @Temporal(TemporalType.DATE)
    private Date fechaLlegada;
    @JoinColumn(name = "Etapa_idEtapa", referencedColumnName = "idEtapa")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Etapa etapaidEtapa;
    @JoinColumn(name = "puertoLlegada", referencedColumnName = "idPuertos")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Puertos puertoLlegada;
    @JoinColumn(name = "puertoSalida", referencedColumnName = "idPuertos")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Puertos puertoSalida;

    public Viajes() {
    }

    public Viajes(Date fechaPartida, Date fechaLlegada) {
        this.fechaPartida = fechaPartida;
        this.fechaLlegada = fechaLlegada;
    }

    public Viajes(Integer idviajes) {
        this.idviajes = idviajes;
    }

    public Integer getIdviajes() {
        return idviajes;
    }

    public void setIdviajes(Integer idviajes) {
        this.idviajes = idviajes;
    }

    public Date getFechaPartida() {
        return fechaPartida;
    }

    public void setFechaPartida(Date fechaPartida) {
        this.fechaPartida = fechaPartida;
    }

    public Date getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public Etapa getEtapaidEtapa() {
        return etapaidEtapa;
    }

    public void setEtapaidEtapa(Etapa etapaidEtapa) {
        this.etapaidEtapa = etapaidEtapa;
    }

    public Puertos getPuertoLlegada() {
        return puertoLlegada;
    }

    public void setPuertoLlegada(Puertos puertoLlegada) {
        this.puertoLlegada = puertoLlegada;
    }

    public Puertos getPuertoSalida() {
        return puertoSalida;
    }

    public void setPuertoSalida(Puertos puertoSalida) {
        this.puertoSalida = puertoSalida;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idviajes != null ? idviajes.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Viajes)) {
            return false;
        }
        Viajes other = (Viajes) object;
        if ((this.idviajes == null && other.idviajes != null) || (this.idviajes != null && !this.idviajes.equals(other.idviajes))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eam.modelo.Viajes[ idviajes=" + idviajes + " ]";
    }
    
}
