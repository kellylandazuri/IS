/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Conexion;
import Modelo.Serologia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Reaper
 */
public class SerologiaDAO {
    public boolean registrarSerologia(Serologia ser) {
        Conexion conex = new Conexion();
        Connection cn = conex.getConexion();
        try {
            PreparedStatement orden = cn.prepareStatement("INSERT INTO serologia (cli_cedula, ser_vdrl, ser_chagas, ser_toxo, ser_p24, ser_hiv, ser_hepb, ser_dai, ser_wenner, ser_observaciones) VALUES (?,?,?,?,?,?,?,?,?,?)");
            orden.setString(1, ser.getCedula());
            orden.setBoolean(2, ser.isVdrl());
            orden.setBoolean(3, ser.isChagas());
            orden.setBoolean(4, ser.isToxo());
            orden.setBoolean(5, ser.isP24());
            orden.setBoolean(6, ser.isHiv());
            orden.setBoolean(7, ser.isHepb());
            orden.setBoolean(8, ser.isDai());
            orden.setBoolean(9, ser.isWenner());
            orden.setString(10, ser.getObservaciones());
            orden.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro completo");
            return true;
        } catch (SQLException e) {
            System.out.println("" + e.getMessage());
            JOptionPane.showMessageDialog(null, "No se registró!!");
            return false;
        }
    }
}
