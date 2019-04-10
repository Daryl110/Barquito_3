/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eam.modelo;

import com.eam.controlador.Main;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.json.simple.JSONObject;

/**
 *
 * @author Daryl
 */
@Entity
@Table(name = "cliente")
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "cedula")
    private String cedula;
    @Size(max = 45)
    @Column(name = "telefono")
    private String telefono;
    @Size(max = 45)
    @Column(name = "ciudad")
    private String ciudad;
    @Size(max = 45)
    @Column(name = "nombre")
    private String nombre;
    @JoinColumn(name = "Usuario_correo", referencedColumnName = "correo")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario usuariocorreo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clientecedula", fetch = FetchType.LAZY)
    private List<Carga> cargaList;

    public Cliente() {
    }

    public Cliente(String cedula, String telefono, String ciudad, String nombre, Usuario usuariocorreo) {
        this.cedula = cedula;
        this.telefono = telefono;
        this.ciudad = ciudad;
        this.nombre = nombre;
        this.usuariocorreo = usuariocorreo;
    }

    public Cliente(String cedula, Usuario usuariocorreo) {
        this.cedula = cedula;
        this.usuariocorreo = usuariocorreo;
    }
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Usuario getUsuariocorreo() {
        return usuariocorreo;
    }

    public void setUsuariocorreo(Usuario usuariocorreo) {
        this.usuariocorreo = usuariocorreo;
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
        hash += (cedula != null ? cedula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.cedula == null && other.cedula != null) || (this.cedula != null && !this.cedula.equals(other.cedula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eam.modelo.Cliente[ cedula=" + cedula + " ]";
    }
    
    public boolean registrar(){
        JSONObject joRespuesta = (Main.dao.guardar(this));
        System.out.println("[Registro]"+joRespuesta.get("Registro").toString());
        return ((boolean)(joRespuesta.get("Resultado")));
    }
   
}
