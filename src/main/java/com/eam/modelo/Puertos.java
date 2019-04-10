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
@Table(name = "puertos")
@NamedQueries({
    @NamedQuery(name = "Puertos.findAll", query = "SELECT p FROM Puertos p")})
public class Puertos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPuertos")
    private Integer idPuertos;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "coordenadasX")
    private BigDecimal coordenadasX;
    @Column(name = "coordenadasY")
    private BigDecimal coordenadasY;
    @Size(max = 45)
    @Column(name = "tipoPuerto")
    private String tipoPuerto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "puertoLlegada", fetch = FetchType.LAZY)
    private List<Viajes> viajesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "puertoSalida", fetch = FetchType.LAZY)
    private List<Viajes> viajesList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "puertosidPuertos", fetch = FetchType.LAZY)
    private List<Carga> cargaList;

    public Puertos() {
    }

    public Puertos(String descripcion, BigDecimal coordenadasX, BigDecimal coordenadasY, String tipoPuerto) {
        this.descripcion = descripcion;
        this.coordenadasX = coordenadasX;
        this.coordenadasY = coordenadasY;
        this.tipoPuerto = tipoPuerto;
    }
    
    
    public Puertos(Integer idPuertos) {
        this.idPuertos = idPuertos;
    }

    public Integer getIdPuertos() {
        return idPuertos;
    }

    public void setIdPuertos(Integer idPuertos) {
        this.idPuertos = idPuertos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getCoordenadasX() {
        return coordenadasX;
    }

    public void setCoordenadasX(BigDecimal coordenadasX) {
        this.coordenadasX = coordenadasX;
    }

    public BigDecimal getCoordenadasY() {
        return coordenadasY;
    }

    public void setCoordenadasY(BigDecimal coordenadasY) {
        this.coordenadasY = coordenadasY;
    }

    public String getTipoPuerto() {
        return tipoPuerto;
    }

    public void setTipoPuerto(String tipoPuerto) {
        this.tipoPuerto = tipoPuerto;
    }

    public List<Viajes> getViajesList() {
        return viajesList;
    }

    public void setViajesList(List<Viajes> viajesList) {
        this.viajesList = viajesList;
    }

    public List<Viajes> getViajesList1() {
        return viajesList1;
    }

    public void setViajesList1(List<Viajes> viajesList1) {
        this.viajesList1 = viajesList1;
    }

    public List<Carga> getCargaList() {
        return cargaList;
    }

    public void setCargaList(List<Carga> cargaList) {
        this.cargaList = cargaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPuertos != null ? idPuertos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Puertos)) {
            return false;
        }
        Puertos other = (Puertos) object;
        if ((this.idPuertos == null && other.idPuertos != null) || (this.idPuertos != null && !this.idPuertos.equals(other.idPuertos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idPuertos+" - "+descripcion;
    }
    
}
