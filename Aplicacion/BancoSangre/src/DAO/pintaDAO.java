/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Conexion;
import Modelo.Pinta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JOptionPane;



/**
 *
 * @author kelog
 */
public class pintaDAO {
    
    public void registrarPinta(Pinta p) {
        Conexion conex = new Conexion();
        Connection cn = conex.getConexion();
        try {
            PreparedStatement orden = cn.prepareStatement("INSERT INTO pintasangre VALUES (?,?,?,?,?,?,?)");
            orden.setString(1, p.getCodigo());
            orden.setString(2, p.getGrupo());
            orden.setString(3, p.getFactorRh());
            orden.setBoolean(4, p.isHemoDerivadas());
            orden.setDate(5, p.getFechaVencimiento());
            orden.setDate(6, p.getFechaIngreso());
            orden.setString(7,p.getAnticoagulante());
            orden.setString(8, p.getSituacionBolsa());
            orden.setString(9, p.getObservaciones());
            orden.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro completo");
        } catch (SQLException e) {
            System.out.println("" + e.getMessage());
            JOptionPane.showMessageDialog(null, "No se registró!!");
        }
    }
    
 
    public void eliminarPinta(String codigo) {
        Conexion conex = new Conexion();
        try {
            Statement estatuto = conex.getConexion().createStatement();
            estatuto.executeUpdate("DELETE FROM pintasangre WHERE pin_codigo='" + codigo + "'");
            JOptionPane.showMessageDialog(null, "Se ha eliminado correctamente");
            estatuto.close();
            conex.desconectar();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se ha eliminado");
            System.out.println(e.getMessage());
        }
    }
    
    public Pinta consultarPintaPorCodigo(String codigo)
    {
        Conexion conex = new Conexion();//crear un objeto de la clase coneccion
        Connection cn = conex.getConexion();
        Pinta pinta= new Pinta();
       
        try {
            Statement stmt = cn.createStatement();
            String query = "SELECT * FROM pintasangre WHERE pin_codigo = '"+codigo +"'";
            ResultSet res = stmt.executeQuery(query);
            while (res.next()) {
                pinta.setCodigo(codigo);
                pinta.setGrupo(res.getString("pin_grupo"));
                pinta.setFactorRh(res.getString("pin_factorrh"));
                pinta.setHemoDerivadas(res.getBoolean("pin_hemoderivas"));
                pinta.setFechaVencimiento(res.getDate("pin_fechavencimiento"));
                pinta.setFechaIngreso(res.getDate("pin_fechaingreso"));
                pinta.setAnticoagulante(res.getString("pin_anticoagulante"));
                pinta.setSituacionBolsa(res.getString("pin_situacionbolsa"));
                pinta.setObservaciones(res.getString("pin_observaciones"));
            }
            
            if(pinta.equals(null))
            {
                JOptionPane.showMessageDialog(null, "Sin coincidencias");
            }
        } catch (SQLException e) {
            System.out.println("" + e.getMessage());
            JOptionPane.showMessageDialog(null, "No se puede obtener los datos del cliente");
        }
        return pinta;
    }
    
    public ArrayList <Pinta>  consultaPorTipo(String tipo)
    {
        Conexion conex = new Conexion();//crear un objeto de la clase coneccion
        Connection cn = conex.getConexion();
        ArrayList <Pinta> lista= new ArrayList<>();
        try {
            Statement stmt = cn.createStatement();
            String query = "SELECT * FROM pintasangre WHERE pin_grupo = '"+tipo +"'";
            ResultSet res = stmt.executeQuery(query);
            while (res.next()) {
                Pinta pinta= new Pinta();
                pinta.setCodigo(res.getString("pin_codigo"));
                pinta.setGrupo(tipo);
                pinta.setFactorRh(res.getString("pin_factorrh"));
                pinta.setHemoDerivadas(res.getBoolean("pin_hemoderivas"));
                pinta.setFechaVencimiento(res.getDate("pin_fechavencimiento"));
                pinta.setFechaIngreso(res.getDate("pin_fechaingreso"));
                pinta.setAnticoagulante(res.getString("pin_anticoagulante"));
                pinta.setSituacionBolsa(res.getString("pin_situacionbolsa"));
                pinta.setObservaciones(res.getString("pin_observaciones"));
                lista.add(pinta);
            }
            if(lista.equals(null))
                JOptionPane.showMessageDialog(null, "Sin coincidencias");
        } catch (SQLException e) {
            System.out.println("" + e.getMessage());
            JOptionPane.showMessageDialog(null, "No se puede obtener los datos de las pintas con este grupo");
        }
        return lista;
    }
    
       public ArrayList <Pinta>  consultaPorFactor(String factor)
    {
        Conexion conex = new Conexion();//crear un objeto de la clase coneccion
        Connection cn = conex.getConexion();
        ArrayList <Pinta> lista= new ArrayList<>();
        try {
            Statement stmt = cn.createStatement();
            String query = "SELECT * FROM pintasangre WHERE pin_factorrh = '"+factor +"'";
            ResultSet res = stmt.executeQuery(query);
            while (res.next()) {
                Pinta pinta= new Pinta();
                pinta.setCodigo(res.getString("pin_codigo"));
                pinta.setGrupo(res.getString("pin_grupo"));
                pinta.setFactorRh(factor);
                pinta.setHemoDerivadas(res.getBoolean("pin_hemoderivas"));
                pinta.setFechaVencimiento(res.getDate("pin_fechavencimiento"));
                pinta.setFechaIngreso(res.getDate("pin_fechaingreso"));
                pinta.setAnticoagulante(res.getString("pin_anticoagulante"));
                pinta.setSituacionBolsa(res.getString("pin_situacionbolsa"));
                pinta.setObservaciones(res.getString("pin_observaciones"));
                lista.add(pinta);
            }
            if(lista.equals(null))
                JOptionPane.showMessageDialog(null, "Sin coincidencias");
        } catch (SQLException e) {
            System.out.println("" + e.getMessage());
            JOptionPane.showMessageDialog(null, "No se puede de las pintas con este factor");
        }
        return lista;
    }
   
}
