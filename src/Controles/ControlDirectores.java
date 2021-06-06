/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles;

import SQL.Sentencias_sql;

/**
 *
 * @author alang
 */
public class ControlDirectores {
    
    Sentencias_sql sensql;
    public ControlDirectores() 
    {
        sensql = new Sentencias_sql();
    }
    
     public boolean agregarDirector(String N_Director)
    {               
        String datos[] = {N_Director};           
        return sensql.insertar(datos, "{CALL Alta_Director(?)}");                         
    }
     
     public boolean eliminarPelicula(String Id_Director)
    {
        String campos[] = {Id_Director};           
        return sensql.insertar(campos, "{CALL Baja_Director(?)}");
    } 
     
    
}
