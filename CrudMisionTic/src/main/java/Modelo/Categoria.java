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
public class Categoria {
    //ATRIBUTOS: 
    private int id; 
    private String nombre; 
    
    //CONSTRUCTOR: 
    public Categoria() {
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
    
    //METODO: 
    public ResultSet consultarCategoria(){
        Conexion objConectar = new Conexion(); 
        objConectar.conectar();
        
        try{
            String sql = "SELECT nombreCategoria FROM categoria;"; 
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
}
