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

    public List consultar1(String P) {
   
        ArrayList<Persona> list= new ArrayList<>();
        String sql="select * from Productos where tipo='"+P+"' and disp>0";
        try {
            con=cn.getConnection();
            st=con.createStatement();
            rs=st.executeQuery(sql);
            
            while(rs.next()){
                Persona per= new Persona();
                per.setCR(rs.getString("img"));
                per.setNombre(rs.getString("Nombre"));
                per.setContraseña(rs.getString("Precio"));
                per.setId(Integer.parseInt(rs.getString("id")));
                list.add(per);
            }
            
            
        } catch (Exception e) {
            System.err.println("Error"+e);
        }
        
        
        return list;
    }
    
        public List consultar2() {
   
        ArrayList<Persona> list= new ArrayList<>();
        String sql="select * from Productos order by id Desc limit 1";
        try {
            con=cn.getConnection();
            st=con.createStatement();
            rs=st.executeQuery(sql);
            
            while(rs.next()){
                Persona per= new Persona();
                per.setId(Integer.parseInt(rs.getString("id")));
                list.add(per);
            }
            
            
        } catch (Exception e) {
            System.err.println("Error"+e);
        }
        
        
        return list;
    }
        
    public List consultar3(String Id) {  
        ArrayList<Persona> list= new ArrayList<>();
        String sql="select * from Productos where id='"+Id+"'";
        try {
            con=cn.getConnection();
            st=con.createStatement();
            rs=st.executeQuery(sql);
            
            while(rs.next()){
                Persona per= new Persona();
                per.setNombre(rs.getString("Nombre"));
                per.setCR(rs.getString("img"));
                per.setApellido(rs.getString("Descrip"));
                per.setContraseña(rs.getString("Precio"));
                per.setUsuario(rs.getString("Disp"));
                per.setVendedor(rs.getString("Vendedor"));
                list.add(per);
            }
            
            
        } catch (Exception e) {
            System.err.println("Error"+e);
        }
        
        
        return list;
    }
    
        public List consultar4(String Us) {  
        ArrayList<Persona> list= new ArrayList<>();
        String sql="select * from Usuarios where nombre='"+Us+"'";
        try {
            con=cn.getConnection();
            st=con.createStatement();
            rs=st.executeQuery(sql);
            
            while(rs.next()){
                Persona per= new Persona();
                per.setNombre(rs.getString("Nombre"));
                per.setCR(rs.getString("email"));
                per.setContraseña(rs.getString("Contra"));
                per.setId(Integer.parseInt(rs.getString("fondos")));
                list.add(per);
            }
            
            
        } catch (Exception e) {
            System.err.println("Error"+e);
        }
        
        
        return list;
    }
        
    public List consultar5(String Us) {  
        ArrayList<Persona> list= new ArrayList<>();
        String sql="select * from Productos where Vendedor='"+Us+"'";
        try {
            con=cn.getConnection();
            st=con.createStatement();
            rs=st.executeQuery(sql);
            
            while(rs.next()){
                Persona per= new Persona();
                per.setNombre(rs.getString("Nombre"));
                per.setCR(rs.getString("img"));
                per.setApellido(rs.getString("Descrip"));
                per.setContraseña(rs.getString("Precio"));
                per.setUsuario(rs.getString("Disp"));
                per.setVendedor(rs.getString("Vendedor"));
                per.setId(Integer.parseInt(rs.getString("id")));
                list.add(per);
            }
            
            
        } catch (Exception e) {
            System.err.println("Error"+e);
        }
        
        
        return list;
    }
    
    public List consultar6(String Us,String Id) {  
        ArrayList<Persona> list= new ArrayList<>();
        String sql="select * from Carrito where Id='"+Id+"' and comprador='"+Us+"'";
        try {
            con=cn.getConnection();
            st=con.createStatement();
            rs=st.executeQuery(sql);
            
            while(rs.next()){
                Persona per= new Persona();
                per.setId(Integer.parseInt(rs.getString("cantidad")));
                list.add(per);
            }
            
            
        } catch (Exception e) {
            System.err.println("Error"+e);
        }
        
        
        return list;
    }
    
    public List consultar7(String Us) {  
        ArrayList<Persona> list= new ArrayList<>();
        String sql="select * from Carrito where comprador='"+Us+"'";
        try {
            con=cn.getConnection();
            st=con.createStatement();
            rs=st.executeQuery(sql);
            
            while(rs.next()){
                Persona per= new Persona();
                per.setUsuario(rs.getString("Id"));
                per.setId(Integer.parseInt(rs.getString("cantidad")));
                list.add(per);
            }
            
            
        } catch (Exception e) {
            System.err.println("Error"+e);
        }
        
        
        return list;
    }
    
    public List consultar8(String Us) {
   
        ArrayList<Persona> list= new ArrayList<>();
        String sql="select * from Usuarios where nombre='"+Us+"'";
        try {
            con=cn.getConnection();
            st=con.createStatement();
            rs=st.executeQuery(sql);
            
            while(rs.next()){
                Persona per= new Persona();
                per.setContraseña(rs.getString("Contra"));
                per.setNombre(rs.getString("Nombre"));
                per.setId(Integer.parseInt(rs.getString("Fondos")));
                list.add(per);
            }
            
            
        } catch (Exception e) {
            System.err.println("Error"+e);
        }
        
        
        return list;
    }
    
    public List consultar9(String Ven) {  
        ArrayList<Persona> list= new ArrayList<>();
        String sql="select * from Ventas order by NV Desc limit 1";
        try {
            con=cn.getConnection();
            st=con.createStatement();
            rs=st.executeQuery(sql);
            
            while(rs.next()){
                Persona per= new Persona();
                per.setId(Integer.parseInt(rs.getString("NV")));
                list.add(per);
            }
            
            
        } catch (Exception e) {
            System.err.println("Error"+e);
        }
        
        
        return list;
    }
    
        public List consultar10(String Comp) {  
        ArrayList<Persona> list= new ArrayList<>();
        String sql="select * from Ventas where Comprador='"+Comp+"'";
        try {
            con=cn.getConnection();
            st=con.createStatement();
            rs=st.executeQuery(sql);
            
            while(rs.next()){
                Persona per= new Persona();
                per.setNombre1(rs.getString("NombreP"));
                per.setVendedor(rs.getString("Vendedor"));
                per.setNombre(rs.getString("Fecha"));
                per.setId(Integer.parseInt(rs.getString("Cantidad")));
                per.setId2(Integer.parseInt(rs.getString("PrecioF")));
                per.setNV(Integer.parseInt(rs.getString("NV")));
                list.add(per);
            }
            
            
        } catch (Exception e) {
            System.err.println("Error"+e);
        }
        
        
        return list;
    }
    
    public List consultar11(String Us, String Em) {
   
        ArrayList<Persona> list= new ArrayList<>();
        String sql="select * from Usuarios where nombre='"+Us+"' or email='"+Em+"'";
        try {
            con=cn.getConnection();
            st=con.createStatement();
            rs=st.executeQuery(sql);
            
            while(rs.next()){
                Persona per= new Persona();
                per.setContraseña(rs.getString("Contra"));
                per.setNombre(rs.getString("Nombre"));
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
        String sql="insert into Usuarios(nombre,email,contra,nivel,fondos) values('"+per.getNombre()+"','"+per.getCR()+"','"+per.getContraseña()+"','"+1+"','"+0+"')";
        try{
        con=cn.getConnection();
        ps=con.prepareStatement(sql);
        
        ps.executeUpdate();
        }catch(Exception e){
            System.err.println("Error"+e);
        }
        return false;
    
    }
    
    public boolean registrarP(Persona per) {
        String sql="insert into Productos(Vendedor,nombre,img,Descrip,Precio,Disp,tipo,id) values('"+per.getVendedor()+"','"+per.getNombre()+"','"+per.getCR()+"','"+per.getApellido()+"','"+per.getContraseña()+"','"+per.getNombre1()+"','"+per.getUsuario()+"','"+per.getId()+"')";
        try{
        con=cn.getConnection();
        ps=con.prepareStatement(sql);
        
        ps.executeUpdate();
        }catch(Exception e){
            System.err.println("Error"+e);
        }
        return false;
    
    }
    
        public boolean registrarC(Persona per) {
        String sql="insert into Carrito(id,cantidad,comprador) values('"+per.getVendedor()+"','"+per.getId()+"','"+per.getNombre()+"')";
        try{
        con=cn.getConnection();
        ps=con.prepareStatement(sql);
        
        ps.executeUpdate();
        }catch(Exception e){
            System.err.println("Error"+e);
        }
        return false;
    
    }
        
    public boolean registrarCompra(Persona per) {
        String sql="insert into Ventas(NombreP,Vendedor,Fecha,Cantidad,PrecioF,NV,Comprador) values('"+per.getNombre1()+"','"+per.getVendedor()+"','"+per.getApellido()+"','"+per.getId()+"','"+per.getId2()+"','"+per.getNV()+"','"+per.getUsuario()+"')";
        try{
        con=cn.getConnection();
        ps=con.prepareStatement(sql);
        
        ps.executeUpdate();
        }catch(Exception e){
            System.err.println("Error"+e);
        }
        return false;
    
    }
    
        public boolean editarP(Persona per) {
        String sql="update Productos set Vendedor='"+per.getVendedor()+"', nombre='"+per.getNombre()+"', img='"+per.getCR()+"', Descrip='"+per.getApellido()+"', Precio='"+per.getContraseña()+"', Disp='"+per.getNombre1()+"', tipo='"+per.getUsuario()+"' where id='"+per.getId()+"'";
        try{
        con=cn.getConnection();
        ps=con.prepareStatement(sql);
        
        ps.executeUpdate();
        }catch(Exception e){
            System.err.println("Error"+e);
        }
        return false;
    
    }
        
        public boolean editarC(Persona per) {
        String sql="update Carrito set Cantidad='"+per.getId()+"' where id='"+per.getVendedor()+"' and Comprador='"+per.getNombre()+"'";
        try{
        con=cn.getConnection();
        ps=con.prepareStatement(sql);
        ps.executeUpdate();
        }catch(Exception e){
            System.err.println("Error"+e);
        }
        return false;
    
    }
        
        public boolean editarDis(Persona per) {
        String sql="update Productos set Disp='"+per.getId2()+"' where id='"+per.getVendedor()+"'";
        try{
        con=cn.getConnection();
        ps=con.prepareStatement(sql);
        
        ps.executeUpdate();
        }catch(Exception e){
            System.err.println("Error"+e);
        }
        return false;
    
    }
        
    public boolean editarF(int F,String U) {
        String sql="update Usuarios set Fondos='"+F+"' where nombre='"+U+"'";
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
        String sql="select nivel from usuarios where nombre='"+usuario+"'and contra='"+contra+"'";
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


    public boolean editar(Persona per) {
        String sql="update usuarios set contra='"+per.getContraseña()+"', Email='"+per.getCR()+"', Fondos='"+per.getUsuario()+"' where nombre='"+per.getNombre1()+"'";
        try{
        con=cn.getConnection();
        ps=con.prepareStatement(sql);
        
        ps.executeUpdate();
        }catch(Exception e){
            System.err.println("Error"+e);
        }
        return false;
    }
    
    public boolean editar2(Persona per) {
        String sql="update productos set Vendedor='"+per.getNombre()+"' where Vendedor='"+per.getNombre1()+"'";
        try{
        con=cn.getConnection();
        ps=con.prepareStatement(sql);
        
        ps.executeUpdate();
        }catch(Exception e){
            System.err.println("Error"+e);
        }
        return false;
    }

    public boolean EliminarC(Persona per) {
        String sql="delete from Carrito where Comprador='"+per.getUsuario()+"' and Id='"+per.getNombre()+"'";
        try{
        con=cn.getConnection();
        ps=con.prepareStatement(sql);
        
        ps.executeUpdate();
        }catch(Exception e){
            System.err.println("Error"+e);
        }
        return false;
    }


    public boolean Restablecer(String Id,int Can) {
        String sql="update Productos set Disp='"+Can+"' where id='"+Id+"'";
        try{
        con=cn.getConnection();
        ps=con.prepareStatement(sql);
        
        ps.executeUpdate();
        }catch(Exception e){
            System.err.println("Error"+e);
        }
        return false;
    
    }
    
    public boolean EliminarCP(String Id,String Comp) {
        String sql="delete from Carrito where Comprador='"+Comp+"' and Id='"+Id+"'";
        try{
        con=cn.getConnection();
        ps=con.prepareStatement(sql);
        
        ps.executeUpdate();
        }catch(Exception e){
            System.err.println("Error"+e);
        }
        return false;
    }
}
