/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class Producto {
    //ATRIBUTOS: 
    private int id; 
    private String nombre; 
    private int cantidad; 
    private Categoria categoria; 
    private int precio; 
    
    //CONSTRUCTORES: 
    public Producto() {
    }
    
    public Producto(String nombre, int cantidad, Categoria categoria, int precio) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.categoria = categoria;
        this.precio = precio;
    }
    
    //ENCAPSULAR: 
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", nombre=" + nombre + ", cantidad=" + cantidad + ", categoria=" + categoria + ", precio=" + precio + '}';
    }
    
    //METODOS: 
    public void crearProducto(){
        Conexion objConector = new Conexion(); 
        objConector.conectar();
        
        try{
            String sql = "INSERT INTO producto"+
                        "(nombreProducto, cantidadProducto, precioProducto, idCategoriaFk)"+
                        "VALUES (?,?,?,?);";
            PreparedStatement stmt; 
            stmt = objConector.conn.prepareStatement(sql); 
            stmt.setString(1, this.nombre);
            stmt.setString(2, String.valueOf(this.cantidad));
            stmt.setInt(3, this.precio);
            stmt.setInt(4, this.categoria.getId());
            stmt.execute(); 
        }
        catch(Exception error){
            JOptionPane.showMessageDialog(null, "ERROR: "+error);
        }
        
        objConector.desconectar();
    }
    
    public ResultSet consultarProducto(){
        Conexion objConectar = new Conexion(); 
        objConectar.conectar();
        
        try{
            String sql = "SELECT * FROM producto"+
                           " WHERE nombreProducto LIKE ?;"; 
            PreparedStatement stmt; 
            stmt = objConectar.conn.prepareStatement(sql); 
            stmt.setString(1, "%"+this.nombre+"%");
            ResultSet consulta = stmt.executeQuery(); 
            return consulta; 
        }
        catch(Exception error){
            JOptionPane.showMessageDialog(null, "ERROR: "+error);
        }
        
        objConectar.desconectar();
        return null; 
    }
    
    public ResultSet listarProductos(){
        Conexion objConectar = new Conexion(); 
        objConectar.conectar();
        
        try{
            String sql = "SELECT * FROM producto"; 
            PreparedStatement stmt; 
            stmt = objConectar.conn.prepareStatement(sql); 
            ResultSet consulta = stmt.executeQuery(); 
            return consulta; 
        }
        catch(Exception error){
            JOptionPane.showMessageDialog(null, "ERROR: "+error);
        }
        
        objConectar.desconectar();
        return null; 
    }
    
    public void actualizarProducto(){
        Conexion objConector = new Conexion(); 
        objConector.conectar();
        
        try{
            String sql =" UPDATE producto SET "+
                        " nombreProducto = ?, "+
                        " cantidadProducto = ?, "+
                        " precioProducto = ? "+
                        " WHERE idProductoPk = ?;";
            PreparedStatement stmt; 
            stmt = objConector.conn.prepareStatement(sql); 
            stmt.setString(1, this.nombre);
            stmt.setString(2, String.valueOf(this.cantidad));
            stmt.setInt(3, this.precio);
            stmt.setInt(4, this.id);
            stmt.execute(); 
        }
        catch(Exception error){
            JOptionPane.showMessageDialog(null, "ERROR: "+error);
        }
        
        objConector.desconectar();
    }
    
    public void eliminarProducto(){
        Conexion objConector = new Conexion(); 
        objConector.conectar();
        
        try{
            String sql =" DELETE FROM producto "+
                        " WHERE idProductoPk = ?;";
            PreparedStatement stmt; 
            stmt = objConector.conn.prepareStatement(sql); 
            stmt.setInt(1, this.id);
            stmt.execute(); 
        }
        catch(Exception error){
            JOptionPane.showMessageDialog(null, "ERROR: "+error);
        }
        
        objConector.desconectar();
    }
}
