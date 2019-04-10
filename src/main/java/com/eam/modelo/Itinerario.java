/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eam.modelo;

import com.eam.controlador.CtlEtapa;
import com.eam.controlador.CtlViajes;
import com.eam.controlador.Main;
import com.eam.util.Herramientas;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
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
@Table(name = "itinerario")
@NamedQueries({
    @NamedQuery(name = "Itinerario.findAll", query = "SELECT i FROM Itinerario i")})
public class Itinerario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idItinerario")
    private Integer idItinerario;
    @Column(name = "costo")
    private BigDecimal costo;
    @Size(max = 45)
    @Column(name = "clima")
    private String clima;
    @Column(name = "tiempo")
    private BigDecimal tiempo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "itinerarioidItinerario", fetch = FetchType.LAZY)
    private List<Etapa> etapaList;
    @JoinColumn(name = "ruta_idruta", referencedColumnName = "idruta")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Ruta rutaIdruta;

    public Itinerario() {
    }

    public Itinerario(Integer idItinerario) {
        this.idItinerario = idItinerario;
    }

    public Integer getIdItinerario() {
        return idItinerario;
    }

    public void setIdItinerario(Integer idItinerario) {
        this.idItinerario = idItinerario;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public BigDecimal getTiempo() {
        return tiempo;
    }

    public void setTiempo(BigDecimal tiempo) {
        this.tiempo = tiempo;
    }

    public List<Etapa> getEtapaList() {
        return etapaList;
    }

    public void setEtapaList(List<Etapa> etapaList) {
        this.etapaList = etapaList;
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
        hash += (idItinerario != null ? idItinerario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Itinerario)) {
            return false;
        }
        Itinerario other = (Itinerario) object;
        if ((this.idItinerario == null && other.idItinerario != null) || (this.idItinerario != null && !this.idItinerario.equals(other.idItinerario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.eam.modelo.Itinerario[ idItinerario=" + idItinerario + " ]";
    }

    public boolean generarItinerario(Ruta ruta) {
        
        String[] climas = {"Soleado", "Lluvioso", "Tomentoso", "Nublado", "Nevado", "Humedo", "Moderado"};
        
        this.clima = climas[Herramientas.generarNumeroAleatorio(climas.length)];
        this.rutaIdruta = ruta;
        this.tiempo = Herramientas.generarNumeroBigAleatorio(200);
        
        CtlEtapa controladorEtapa = new CtlEtapa();

        ArrayList<String> campos = new ArrayList<>(), valores = new ArrayList<>();
        campos.add("tipoPuerto");
        valores.add("CARGA");

        ArrayList<Puertos> puertosCarga = new ArrayList<>(Main.dao.cargar("Puertos", campos, valores));

        ArrayList<Carga> cargas = new ArrayList<>(ruta.getCargaList());

        ruta.setEstado("ZARPADO");
        
        ArrayList<Etapa> etapas = new ArrayList<>();
        
        int tarifota = 0;

        for (int i = 0; i < cargas.size(); i++) {
            int num = Herramientas.generarNumeroAleatorio(200);
            Etapa etapa = new Etapa(new BigDecimal("" + (i + 1)), Herramientas.generarCadenaAleatorio(20),
                    new BigDecimal(num+""));
            etapa.setItinerarioidItinerario(this);
            tarifota += num;
            etapas.add(etapa);
        }
        
        this.costo = new BigDecimal(tarifota+"");
        
        boolean itinerarioGuardado = (boolean) Main.dao.guardar(this).get("Resultado");
        
        for (int i = 0; i < etapas.size(); i++) {
            controladorEtapa.registrarEtapa(etapas.get(i));
            cargas.get(i).setEstado("DESCARGADO");
            controladorEtapa.asignarViajeEtapa(etapas.get(i), 
                    puertosCarga.get(Herramientas.generarNumeroAleatorio(puertosCarga.size())),
                    cargas.get(i).getPuertosidPuertos());
        }
        
        boolean rutaGuardada = (boolean) Main.dao.modificar(ruta).get("Resultado");

        return rutaGuardada && itinerarioGuardado;
    }

}
