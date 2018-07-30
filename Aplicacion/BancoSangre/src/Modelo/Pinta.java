/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;

/**
 *
 * @author kelog
 */
public class Pinta {
     private String codigo,grupo,factorRh,anticoagulante,situacionBolsa,observaciones;
     private boolean hemoDerivadas;
     private Date fechaVencimiento, fechaIngreso;

    public Pinta() {
    }

    public Pinta(String codigo, String grupo, String factorRrh, String anticoagulante, String situacionBolsa, String observaciones, boolean hemoDerivadas, Date fechaVencimiento, Date fechaIngreso) {
        this.codigo = codigo;
        this.grupo = grupo;
        this.factorRh = factorRrh;
        this.anticoagulante = anticoagulante;
        this.situacionBolsa = situacionBolsa;
        this.observaciones = observaciones;
        this.hemoDerivadas = hemoDerivadas;
        this.fechaVencimiento = fechaVencimiento;
        this.fechaIngreso = fechaIngreso;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getFactorRh() {
        return factorRh;
    }

    public void setFactorRh(String factorRh) {
        this.factorRh = factorRh;
    }

    public String getAnticoagulante() {
        return anticoagulante;
    }

    public void setAnticoagulante(String anticoagulante) {
        this.anticoagulante = anticoagulante;
    }

    public String getSituacionBolsa() {
        return situacionBolsa;
    }

    public void setSituacionBolsa(String situacionBolsa) {
        this.situacionBolsa = situacionBolsa;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public boolean isHemoDerivadas() {
        return hemoDerivadas;
    }

    public void setHemoDerivadas(boolean hemoDerivadas) {
        this.hemoDerivadas = hemoDerivadas;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
     
     

}
