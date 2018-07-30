/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

//Reportes
//https://www.youtube.com/watch?v=KSdHTGhHrIU
//Reportes
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author ASUS_01
 */
public class Conexion {
    static String bd="bdsangre"; //nombre de la base
    static String login="root"; //de la base del equipo
    static String password="";
    static String url="jdbc:mysql://localhost/"+bd;
    
    Connection conn=null;
    
    public Conexion()
    {
      try
      {
          //obtener el driver para mysql
          Class.forName("com.mysql.jdbc.Driver");
          //obtener la conexion
          conn=DriverManager.getConnection(url, login,password);
          if(conn!=null)
              System.out.println("Conexion a base de datos " + bd + " establecida!!");
      }
      catch(Exception e)
      {
          System.out.println(e.getMessage());
      }
    }
    public Connection getConexion()
    {
        return conn;
    }
    public void desconectar()
    {
        conn=null;
    }
}
