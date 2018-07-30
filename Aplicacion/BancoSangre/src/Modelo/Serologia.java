/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Reaper
 */
public class Serologia {
    private String cedula, observaciones;
    private boolean vdrl, chagas, toxo, p24, hiv, hepb, dai, wenner;

    public Serologia(String cedula, String observaciones, boolean vdrl, boolean chagas, boolean toxo, boolean p24, boolean hiv, boolean hepb, boolean dai, boolean wenner) {
        this.cedula = cedula;
        this.observaciones = observaciones;
        this.vdrl = vdrl;
        this.chagas = chagas;
        this.toxo = toxo;
        this.p24 = p24;
        this.hiv = hiv;
        this.hepb = hepb;
        this.dai = dai;
        this.wenner = wenner;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public boolean isVdrl() {
        return vdrl;
    }

    public void setVdrl(boolean vdrl) {
        this.vdrl = vdrl;
    }

    public boolean isChagas() {
        return chagas;
    }

    public void setChagas(boolean chagas) {
        this.chagas = chagas;
    }

    public boolean isToxo() {
        return toxo;
    }

    public void setToxo(boolean toxo) {
        this.toxo = toxo;
    }

    public boolean isP24() {
        return p24;
    }

    public void setP24(boolean p24) {
        this.p24 = p24;
    }

    public boolean isHiv() {
        return hiv;
    }

    public void setHiv(boolean hiv) {
        this.hiv = hiv;
    }

    public boolean isHepb() {
        return hepb;
    }

    public void setHepb(boolean hepb) {
        this.hepb = hepb;
    }

    public boolean isDai() {
        return dai;
    }

    public void setDai(boolean dai) {
        this.dai = dai;
    }

    public boolean isWenner() {
        return wenner;
    }

    public void setWenner(boolean wenner) {
        this.wenner = wenner;
    }
    
    
}
