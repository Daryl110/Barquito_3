/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eam.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Daryl
 */
@Entity
@Table(name = "etapa")
@NamedQueries({
    @NamedQuery(name = "Etapa.findAll", query = "SELECT e FROM Etapa e")})
public class Etapa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEtapa")
    private Integer idEtapa;
    @Column(name = "numeroEtapa")
    private BigDecimal numeroEtapa;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "tarifa")
    private BigDecimal tarifa;
    @JoinColumn(name = "Itinerario_idItinerario", referencedColumnName = "idItinerario")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Itinerario itinerarioidItinerario;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "etapaidEtapa", fetch = FetchType.LAZY)
    private List<Viajes> viajesList;

    public Etapa() {
    }

    public Etapa(BigDecimal numeroEtapa, String descripcion, BigDecimal tarifa) {
        this.numeroEtapa = numeroEtapa;
        this.descripcion = descripcion;
        this.tarifa = tarifa;
    }

    public Integer getIdEtapa() {
        return idEtapa;
    }

    public void setIdEtapa(Integer idEtapa) {
        this.idEtapa = idEtapa;
    }

    public BigDecimal getNumeroEtapa() {
        return numeroEtapa;
    }

    public void setNumeroEtapa(BigDecimal numeroEtapa) {
        this.numeroEtapa = numeroEtapa;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getTarifa() {
        return tarifa;
    }

    public void setTarifa(BigDecimal tarifa) {
        this.tarifa = tarifa;
    }

    public Itinerario getItinerarioidItinerario() {
        return itinerarioidItinerario;
    }

    public void setItinerarioidItinerario(Itinerario itinerarioidItinerario) {
        this.itinerarioidItinerario = itinerarioidItinerario;
    }

    public List<Viajes> getViajesList() {
        return viajesList;
    }

    public void setViajesList(List<Viajes> viajesList) {
        this.viajesList = viajesList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEtapa != null ? idEtapa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Etapa)) {
            return false;
        }
        Etapa other = (Etapa) object;
        if ((this.idEtapa == null && other.idEtapa != null) || (this.idEtapa != null && !this.idEtapa.equals(other.idEtapa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {       
        return "Etapa numero: "+numeroEtapa+" descripcion: "+descripcion+"\n";
    }
    
}
