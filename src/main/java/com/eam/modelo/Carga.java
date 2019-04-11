/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eam.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
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

/**
 *
 * @author Daryl
 */
@Entity
@Table(name = "carga")
@NamedQueries({
    @NamedQuery(name = "Carga.findAll", query = "SELECT c FROM Carga c")})
public class Carga implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCarga")
    private Integer idCarga;
    @Column(name = "tamanio")
    private BigDecimal tamanio;
    @Column(name = "peso")
    private BigDecimal peso;
    @Size(max = 45)
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "Cliente_cedula", referencedColumnName = "cedula")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Cliente clientecedula;
    @JoinColumn(name = "Puertos_idPuertos", referencedColumnName = "idPuertos")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Puertos puertosidPuertos;
    @JoinColumn(name = "ruta_idruta", referencedColumnName = "idruta")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Ruta rutaIdruta;

    public Carga() {
    }

    public Carga(BigDecimal tamanio, BigDecimal peso, String estado, Cliente clientecedula, Puertos puertosidPuertos) {
        this.tamanio = tamanio;
        this.peso = peso;
        this.estado = estado;
        this.clientecedula = clientecedula;
        this.puertosidPuertos = puertosidPuertos;
    }

    public Integer getIdCarga() {
        return idCarga;
    }

    public void setIdCarga(Integer idCarga) {
        this.idCarga = idCarga;
    }

    public BigDecimal getTamanio() {
        return tamanio;
    }

    public void setTamanio(BigDecimal tamanio) {
        this.tamanio = tamanio;
    }

    public BigDecimal getPeso() {
        return peso;
    }

    public void setPeso(BigDecimal peso) {
        this.peso = peso;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Cliente getClientecedula() {
        return clientecedula;
    }

    public void setClientecedula(Cliente clientecedula) {
        this.clientecedula = clientecedula;
    }

    public Puertos getPuertosidPuertos() {
        return puertosidPuertos;
    }

    public void setPuertosidPuertos(Puertos puertosidPuertos) {
        this.puertosidPuertos = puertosidPuertos;
    }

    public Ruta getRutaIdruta() {
        return rutaIdruta;
    }

    public void setRutaIdruta(Ruta rutaIdruta) {
        this.rutaIdruta = rutaIdruta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCarga != null ? idCarga.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carga)) {
            return false;
        }
        Carga other = (Carga) object;
        if ((this.idCarga == null && other.idCarga != null) || (this.idCarga != null && !this.idCarga.equals(other.idCarga))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Carga: Peso= " + peso + " Tamaño= "+tamanio;
    }
    
}
