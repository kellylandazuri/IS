/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;

/**
 *
 * @author Dennys
 */
public class Transfuciones_Donaciones {
    private String usuCod, cliCod, pinCod, paciente, tipo; 
    private Date fecha;

    public Transfuciones_Donaciones(String usuCod, String cliCod, String pinCod, String paciente, String tipo, Date fecha) {
        this.usuCod = usuCod;
        this.cliCod = cliCod;
        this.pinCod = pinCod;
        this.paciente = paciente;
        this.tipo = tipo;
        this.fecha = fecha;
    }

    public String getUsuCod() {
        return usuCod;
    }

    public void setUsuCod(String usuCod) {
        this.usuCod = usuCod;
    }

    public String getCliCod() {
        return cliCod;
    }

    public void setCliCod(String cliCod) {
        this.cliCod = cliCod;
    }

    public String getPinCod() {
        return pinCod;
    }

    public void setPinCod(String pinCod) {
        this.pinCod = pinCod;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
     
    
    
}