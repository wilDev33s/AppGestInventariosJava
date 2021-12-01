/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Categoria;
import Modelo.Producto;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author user
 */
public class ControlCategoria {
    //ATRIBUTO: 
    private Categoria objCategoria = new Categoria(); 
    
    public ArrayList cargarCbox(){
        try{
            ResultSet consulta = objCategoria.consultarCategoria(); 
            ArrayList<Categoria> listaCategoria = new ArrayList<>(); 
            
            while(consulta.next()){
                 objCategoria = new Categoria(); 
                 objCategoria.setNombre(consulta.getString(1));
                 
                 listaCategoria.add(objCategoria); 
            }
            
            return listaCategoria;  
        }
        catch(Exception error){
            JOptionPane.showMessageDialog(null, "ERROR: "+error);
        }
        
        return null; 
    }
}
