/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Modelo.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Reaper
 */
public class TransfucionDonacionDAO {
     public void registrarTranDon(Transfuciones_Donaciones tr) {
        Conexion conex = new Conexion();
        Connection cn = conex.getConexion();
        try {
            PreparedStatement orden = cn.prepareStatement("INSERT INTO TransfucionDonacion (usu_codigo, cli_cedula, pin_codigo, paciente, fecha, tipo) VALUES (?,?,?,?,?,?)");
            orden.setString(1, tr.getUsuCod());
            orden.setString(2, tr.getCliCod());
            orden.setString(3, tr.getPinCod());
            orden.setString(4, tr.getPaciente());
            orden.setDate(5, tr.getFecha());
            orden.setString(6, tr.getTipo());
            orden.executeUpdate();            
            
            JOptionPane.showMessageDialog(null, "Registro completo");
        } catch (SQLException e) {
            System.out.println("" + e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
         
     }
    
}
