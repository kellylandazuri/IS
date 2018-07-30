/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Reaper
 */
public class usuarioDAO {
    public String[] ingresarApp(String codigo)
    {
        Conexion conex = new Conexion();//crear un objeto de la clase coneccion
        Connection cn = conex.getConexion();
        String[] datos = null;
       
        try {
            Statement stmt = cn.createStatement();
            String query = "SELECT usu_pass, usu_nombre, usu_apellido FROM usuario WHERE usu_codigo = '"+codigo +"'";
            ResultSet res = stmt.executeQuery(query);
            while (res.next()) {
                datos = new String[2];
                datos[0] = (res.getString("usu_pass"));
                datos[1] = (res.getString("usu_nombre") + " " + res.getString("usu_apellido"));
            }
            
            if(datos == null)
            {
                JOptionPane.showMessageDialog(null, "Sin coincidencias");
            }
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return datos;
    }
    
    public void registrarUsuario(Usuario user) {
        Conexion conex = new Conexion();
        Connection cn = conex.getConexion();
        try {
            PreparedStatement orden = cn.prepareStatement("INSERT INTO Usuario VALUES (?,?,?,?,?,?,?)");
            orden.setString(1, user.getCodigo());
            orden.setString(2, user.getNombre());
            orden.setString(3, user.getApellido());
            orden.setString(4, user.getPass());
            orden.setBoolean(5, user.isTipo());
            orden.setString(6, user.getTelefono());
            orden.setString(7, user.getSexo());
            orden.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro completo");
        } catch (SQLException e) {
            System.out.println("" + e.getMessage());
            JOptionPane.showMessageDialog(null, "No se registró!!");
        }
    }
    
    public boolean comprobarAdmin(String codigo)
    {
        Conexion conex = new Conexion();//crear un objeto de la clase coneccion
        Connection cn = conex.getConexion();
        int admin = 0;
       
        try {
            Statement stmt = cn.createStatement();
            String query = "SELECT usu_tipo FROM usuario WHERE usu_codigo = '" +codigo+"'";
            ResultSet res = stmt.executeQuery(query);
            while (res.next()) {
                admin = (res.getInt("usu_tipo"));
            }
        } catch (SQLException e) {
            System.out.println("" + e.getMessage());
            JOptionPane.showMessageDialog(null, "No se puede ingresar a la app!!");
        }
        if(admin==1)
                return true;
            else
                return false;
    }
    
    public String[] getDatosUsuario(String codigo)
    {
        Conexion conex = new Conexion();//crear un objeto de la clase coneccion
        Connection cn = conex.getConexion();
        String[] datos = null;
       
        try {
            Statement stmt = cn.createStatement();
            String query = "SELECT * FROM Usuario WHERE usu_codigo = '"+codigo +"'";
            ResultSet res = stmt.executeQuery(query);
            while (res.next()) {
                datos = new String[7];
                datos[0] = codigo;
                datos[1] = (res.getString("usu_nombre"));
                datos[2] = (res.getString("usu_apellido"));
                datos[3] = (res.getString("usu_telefono"));
                datos[4] = (res.getString("usu_sexo"));
                datos[5] = (res.getString("usu_pass"));
                datos[6] = (res.getInt("usu_tipo")+"");
            }
            
            if(datos == null)
            {
                JOptionPane.showMessageDialog(null, "Sin coincidencias");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return datos;
    }
    
    public void modificarUsuario(Usuario user)
    {
        Conexion conex = new Conexion();
        try {
            String sentencia = "UPDATE Usuario SET usu_nombre=?, usu_apellido=?, usu_telefono=?, usu_sexo=?, usu_pass=?, usu_tipo=? "
                    + "WHERE usu_codigo=?";
            PreparedStatement estatuto = conex.getConexion().prepareStatement(sentencia);
            estatuto.setString(7, user.getCodigo());
            estatuto.setString(1, user.getNombre());
            estatuto.setString(2, user.getApellido());
            estatuto.setString(3, user.getTelefono());
            estatuto.setString(4, user.getSexo());
            estatuto.setString(5, user.getPass());
            estatuto.setBoolean(6, user.isTipo());

            estatuto.executeUpdate();JOptionPane.showMessageDialog(null, "Modificado correctamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    
    public void eliminarUsuario(String codigo) {
        Conexion conex = new Conexion();
        try {
            Statement estatuto = conex.getConexion().createStatement();
            estatuto.executeUpdate("DELETE FROM Usuario WHERE usu_codigo='" + codigo + "'");
            JOptionPane.showMessageDialog(null, "Se ha eliminado correctamente");
            estatuto.close();
            conex.desconectar();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
}
