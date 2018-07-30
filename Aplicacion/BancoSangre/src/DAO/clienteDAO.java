/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.Cliente;
import Modelo.Conexion;
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
public class clienteDAO {
    public boolean registrarCliente(Cliente cli) {
        Conexion conex = new Conexion();
        Connection cn = conex.getConexion();
        try {
            PreparedStatement orden = cn.prepareStatement("INSERT INTO Cliente VALUES (?,?,?,?,?,?,?,?,?,?,?)");
            orden.setString(1, cli.getCedula());
            orden.setString(2, cli.getNombre());
            orden.setString(3, cli.getApellido());
            orden.setString(4, cli.getDireccion());
            orden.setString(5, cli.getTelefono());
            orden.setString(6, cli.getSexo());
            orden.setFloat(7, cli.getPeso());
            orden.setFloat(8, cli.getTalla());
            orden.setString(9, cli.getSangre());
            orden.setString(10, cli.getPresion());
            orden.setString(11, cli.getObservaciones());
            orden.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro completo");
            return true;
        } catch (SQLException e) {
            System.out.println("" + e.getMessage());
            JOptionPane.showMessageDialog(null, "No se registró!!");
            return false;
        }
    }   
    
    
    public void modificarCliente(Cliente cli)
    {
        Conexion conex = new Conexion();
        try {
            String sentencia = "UPDATE Cliente SET cli_nombre = ?, cli_apellido = ?, cli_direccion = ?, cli_telefono = ?, cli_sexo = ?, cli_peso = ?, cli_talla = ?, cli_sangre = ?, cli_presion = ?, cli_observaciones = ? "
                    + "WHERE cli_cedula=?";
            PreparedStatement orden = conex.getConexion().prepareStatement(sentencia);
            orden.setString(11, cli.getCedula());
            orden.setString(1, cli.getNombre());
            orden.setString(2, cli.getApellido());
            orden.setString(3, cli.getDireccion());
            orden.setString(4, cli.getTelefono());
            orden.setString(5, cli.getSexo());
            orden.setFloat(6, cli.getPeso());
            orden.setFloat(7, cli.getTalla());
            orden.setString(8, cli.getSangre());
            orden.setString(9, cli.getPresion());
            orden.setString(10, cli.getObservaciones());

            orden.executeUpdate();JOptionPane.showMessageDialog(null, "Modificado correctamente");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Error al modificar");
        }
    }
    
    
    public void eliminarCliente(String codigo) {
        Conexion conex = new Conexion();
        try {
            Statement estatuto = conex.getConexion().createStatement();
            estatuto.executeUpdate("DELETE FROM Cliente WHERE cli_cedula='" + codigo + "'");
            JOptionPane.showMessageDialog(null, "Se ha eliminado correctamente");
            estatuto.close();
            conex.desconectar();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se ha eliminado");
            System.out.println(e.getMessage());
        }
    }
    
    public String[] getDatosCliente(String codigo)
    {
        Conexion conex = new Conexion();//crear un objeto de la clase coneccion
        Connection cn = conex.getConexion();
        String[] datos = null;
       
        try {
            Statement stmt = cn.createStatement();
            String query = "SELECT * FROM Cliente WHERE cli_cedula = '"+codigo +"'";
            ResultSet res = stmt.executeQuery(query);
            while (res.next()) {
                datos = new String[11];                
                datos[0] = codigo;
                datos[1] = res.getString("cli_nombre");
                datos[2] = res.getString("cli_apellido");
                datos[3] = res.getString("cli_direccion");
                datos[4] = res.getString("cli_telefono");
                datos[5] = res.getString("cli_sexo");
                datos[6] = res.getString("cli_peso");
                datos[7] = res.getString("cli_talla");
                datos[8] = res.getString("cli_sangre");
                datos[9] = res.getString("cli_presion");
                datos[10] = res.getString("cli_observaciones");
            }
            
            if(datos == null)
            {
                JOptionPane.showMessageDialog(null, "Sin coincidencias");
            }
        } catch (SQLException e) {
            System.out.println("" + e.getMessage());
            JOptionPane.showMessageDialog(null, "No se puede obtener los datos del cliente");
        }
        return datos;
    }
    
    public String getNombreCliente(String codigo)
    {
        Conexion conex = new Conexion();//crear un objeto de la clase coneccion
        Connection cn = conex.getConexion();
        String[] datos = null;
        String nombre = null;
       
        try {
            Statement stmt = cn.createStatement();
            String query = "SELECT cli_nombre,cli_apellido FROM Cliente WHERE cli_cedula = '"+codigo +"'";
            ResultSet res = stmt.executeQuery(query);
            while (res.next()) {
                datos = new String[2];    
                datos[0] = res.getString("cli_nombre");
                datos[1] = res.getString("cli_apellido");
                nombre = datos[0]+" "+datos[1];
            }
            
            if(datos == null)
            {
                JOptionPane.showMessageDialog(null, "Sin coincidencias");
            }
        } catch (SQLException e) {
            System.out.println("" + e.getMessage());
            JOptionPane.showMessageDialog(null, "No se puede obtener los datos del cliente");
        }
        return nombre;
    }
}
