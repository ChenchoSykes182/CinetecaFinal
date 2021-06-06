/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author chenc_000
 */
public class ComboEstatus {
    int id;
    String nombre;

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
    
    public String toString(){
        
        return this.nombre;
    }
    
    public Vector<ComboEstatus> mostrarEstatus(){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = Conexion.getConexion();
        
        Vector<ComboEstatus> datos = new Vector<ComboEstatus>();
        ComboEstatus dat = null;
        
        try{
            String sql = "select * from Estatus";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            dat = new ComboEstatus();
            dat.setId(0);
            dat.setNombre("Seleccione el Estatus");
            datos.add(dat);
            
            while(rs.next()){
                
                dat = new ComboEstatus();
                dat.setId(rs.getInt("Id_Estatus"));
                dat.setNombre(rs.getString("Descripcion"));
                datos.add(dat);
            }
            
            rs.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.toString());
        }
        return datos;
    }
}
