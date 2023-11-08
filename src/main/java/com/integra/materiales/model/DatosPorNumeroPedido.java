package com.integra.materiales.model;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({})
public class DatosPorNumeroPedido {
    /* Campos tabla Movimiento */
    private Long idMov;
    private String nroFisico;
    private String tipoDocumento;
    private Date fecha;
    private Long idBodega;
    private String bodega;
    private String producto;
    private Long idLote;
    private String identifBobina;
    private Long tarjeta;
    private Long peso;
    private Long idProveedorFk;
    private String origen;
    private String division;
    private Long esFsc;
    private Long porcFsc;
    private String tipoFsc;

    /* Campos tabla ListaCorte */
    private Long numeroPedido;
    private String cliente;
    private String simbolo;
    private String tipoParte;
    private Date fechaIniProduccion;
    private Long listaCorte;
    private String proceso;
    private Long cantidadProducidaNr;

    public DatosPorNumeroPedido(Long idMov,
            String nroFisico,
            String tipoDocumento,
            Date fecha,
            Long idBodega,
            String bodega,
            String producto,
            Long idLote,
            String identifBobina,
            Long tarjeta,
            Long peso,
            Long idProveedorFk,
            String origen,
            String division,
            Long esFsc,
            Long porcFsc,
            String tipoFsc,
            Long numeroPedido,
            String cliente,
            String simbolo,
            String tipoParte,
            Date fechaIniProduccion,
            Long listaCorte,
            String proceso,
            Long cantidadProducidaNr
            ) {
        this.idMov = idMov;
        this.nroFisico = nroFisico;
        this.tipoDocumento = tipoDocumento;
        this.fecha = fecha;
        this.idBodega = idBodega;
        this.bodega = bodega;
        this.producto = producto;
        this.idLote = idLote;
        this.identifBobina = identifBobina;
        this.tarjeta = tarjeta;
        this.peso = peso;
        this.idProveedorFk = idProveedorFk;
        this.origen = origen;
        this.division = division;
        this.numeroPedido = numeroPedido;
        this.cliente = cliente;
        this.simbolo = simbolo;
        this.tipoParte = tipoParte;
        this.fechaIniProduccion = fechaIniProduccion;
        this.listaCorte = listaCorte;
        this.proceso = proceso;
        this.cantidadProducidaNr = cantidadProducidaNr;
        this.esFsc = esFsc;
        this.porcFsc = porcFsc;
        this.tipoFsc = tipoFsc;
    }

    public Long getIdMov() {
        return idMov;
    }

    public void setIdMov(Long idMov) {
        this.idMov = idMov;
    }

    public String getNroFisico() {
        return nroFisico;
    }

    public void setNroFisico(String nroFisico) {
        this.nroFisico = nroFisico;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Long getIdBodega() {
        return idBodega;
    }

    public void setIdBodega(Long idBodega) {
        this.idBodega = idBodega;
    }

    public String getBodega() {
        return bodega;
    }

    public void setBodega(String bodega) {
        this.bodega = bodega;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public Long getIdLote() {
        return idLote;
    }

    public void setIdLote(Long idLote) {
        this.idLote = idLote;
    }

    public String getIdentifBobina() {
        return identifBobina;
    }

    public void setIdentifBobina(String identifBobina) {
        this.identifBobina = identifBobina;
    }

    public Long getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Long tarjeta) {
        this.tarjeta = tarjeta;
    }

    public Long getPeso() {
        return peso;
    }

    public void setPeso(Long peso) {
        this.peso = peso;
    }

    public Long getIdProveedorFk() {
        return idProveedorFk;
    }

    public void setIdProveedorFk(Long idProveedorFk) {
        this.idProveedorFk = idProveedorFk;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public Long getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(Long numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getTipoParte() {
        return tipoParte;
    }

    public void setTipoParte(String tipoParte) {
        this.tipoParte = tipoParte;
    }

    public Date getFechaIniProduccion() {
        return fechaIniProduccion;
    }

    public void setFechaIniProduccion(Date fechaIniProduccion) {
        this.fechaIniProduccion = fechaIniProduccion;
    }

    public Long getListaCorte() {
        return listaCorte;
    }

    public void setListaCorte(Long listaCorte) {
        this.listaCorte = listaCorte;
    }

    public String getProceso() {
        return proceso;
    }

    public void setProceso(String proceso) {
        this.proceso = proceso;
    }

    public Long getCantidadProducidaNr() {
        return cantidadProducidaNr;
    }

    public void setCantidadProducidaNr(Long cantidadProducidaNr) {
        this.cantidadProducidaNr = cantidadProducidaNr;
    }

    public Long getEsFsc() {
        return esFsc;
    }

    public void setEsFsc(Long esFsc) {
        this.esFsc = esFsc;
    }

    public Long getPorcFsc() {
        return porcFsc;
    }

    public void setPorcFsc(Long porcFsc) {
        this.porcFsc = porcFsc;
    }

    public String getTipoFsc() {
        return tipoFsc;
    }

    public void setTipoFsc(String tipoFsc) {
        this.tipoFsc = tipoFsc;
    }

    

}
