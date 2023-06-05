/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ModeloDAO;

import Controlador.Controlador;
import Interfaces.Crud;
import Modelo.Persona;
import config.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PersonaDAO implements Crud{
    
    Connection con;
    PreparedStatement ps;
    Statement st;
    ResultSet rs;
    Persona p=new Persona();
    Conexion cn= new Conexion();
    
   
    
    @Override
    public List consultar() {
   
        ArrayList<Persona> list= new ArrayList<>();
        String sql="select * from Usuarios";
        try {
            con=cn.getConnection();
            st=con.createStatement();
            rs=st.executeQuery(sql);
            
            while(rs.next()){
                Persona per= new Persona();
                per.setUsuario(rs.getString("Usuario"));
                per.setContraseña(rs.getString("Contra"));
                per.setNombre(rs.getString("Nombre"));
                per.setApellido(rs.getString("Apellidos"));
                list.add(per);
            }
            
            
        } catch (Exception e) {
            System.err.println("Error"+e);
        }
        
        
        return list;
    }

    @Override
    public List list(String Usu) {
        ArrayList<Persona> list= new ArrayList<>();
          String sql="select * from Usuarios where Usuario='"+Usu+"'";
         try {
            con=cn.getConnection();
            st=con.createStatement();
            rs=st.executeQuery(sql);
            
            while(rs.next()){
                Persona per= new Persona();
                per.setUsuario(rs.getString("Usuario"));
                per.setContraseña(rs.getString("Contra"));
                per.setNombre(rs.getString("Nombre"));
                per.setApellido(rs.getString("Apellidos"));
                per.setCR(rs.getString("Correo"));
                list.add(per);
            }
            
            
        } catch (Exception e) {
            System.err.println("Error"+e);
        }
        
        
        return list;
    }
    

    @Override
    public boolean registrar(Persona per) {
        String sql="insert into Usuarios(nombre,email,contra,nivel) values('"+per.getNombre()+"','"+per.getCR()+"','"+per.getContraseña()+"','"+1+"')";
        try{
        con=cn.getConnection();
        ps=con.prepareStatement(sql);
        
        ps.executeUpdate();
        }catch(Exception e){
            System.err.println("Error"+e);
        }
        return false;
    
    }
    
    public int Login(String usuario,String contra) throws SQLException{
     
        int nivel=0;
        String sql="select nivel from usuarios where email='"+usuario+"'and contra='"+contra+"'";
         try {
            con=cn.getConnection();
            st=con.createStatement();
            rs=st.executeQuery(sql);
        while(rs.next()){
            nivel=rs.getInt(1);
        }
            
        }catch(SQLException e){
            System.out.println("error"+e);
        }
        
        System.out.println(nivel);
        return nivel;
    } 


    public boolean editar() {
        String sql="update usuarios set usuario='', contra='', nombre='', Apellidos='', Correo='' where usuario=''";
        try{
        con=cn.getConnection();
        ps=con.prepareStatement(sql);
        
        ps.executeUpdate();
        }catch(Exception e){
            System.err.println("Error"+e);
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean editar(Persona per) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
