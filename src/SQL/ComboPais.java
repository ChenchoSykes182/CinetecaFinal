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
public class ComboPais {
    private int id;
    private String pais;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }
     public String toString(){
        
        return this.pais;
    }
    
    public Vector<ComboPais> mostrarPaises(){
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = Conexion.getConexion();
        
        Vector<ComboPais> datos = new Vector<ComboPais>();
        ComboPais dat = null;
        
        try{
            String sql = "select * from Paises order by 2";
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            dat = new ComboPais();
            dat.setId(0);
            dat.setPais("Seleccione un Pais");
            datos.add(dat);
            
            while(rs.next()){
                
                dat = new ComboPais();
                dat.setId(rs.getInt("Id_Pais"));
                dat.setPais(rs.getString("Pais"));
                datos.add(dat);
            }
            
            rs.close();
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null,e.toString());
        }
        return datos;
    }
}

