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
public class ComboDirectores {
    private int id;
    private String nombre;

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
    
    public Vector<ComboDirectores> mostrarDirectores(){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = Conexion.getConexion();
        
        Vector<ComboDirectores> datos = new Vector<ComboDirectores>();
        ComboDirectores dat = null;
        
        try{
            String sql = "select * from Directores order by 2";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            dat = new ComboDirectores();
            dat.setId(0);
            dat.setNombre("Selecciona Director");
            datos.add(dat);
            
            while(rs.next()){
                
                dat = new ComboDirectores();
                dat.setId(rs.getInt("Id_Director"));
                dat.setNombre(rs.getString("Director"));
                datos.add(dat);
            }
            
            rs.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.toString());
        }
        return datos;
    }
}
