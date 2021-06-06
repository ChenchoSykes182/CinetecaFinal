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
public class ControlPeliculas {
    
     Sentencias_sql sensql;
    public ControlPeliculas() 
    {
        sensql = new Sentencias_sql();
    }
    
     public boolean agregarPelicula(String Titulo, String Titulo2, String Anio, String Estatus, String Pais, String Director)
    {               
        String datos[] = {Titulo,Titulo2,Anio,Estatus,Pais,Director};           
        return sensql.insertar(datos, "{CALL SP_AltaPelicula(?,?,?,?,?,?)}");                         
    }
     
      public boolean eliminarPelicula(String Id_Pelicula)
    {
        String campos[] = {Id_Pelicula};           
        return sensql.insertar(campos, "{CALL BajasPeliculas(?)}");
    } 
      
     public Object[][] mostrarPeliculas()
    {
        String[] columnas={"Id_Pelicula","Titulo","Titulo_Exihibicion","Anio","Estatus","Pais","Director"};
        Object[][] datos = sensql.GetTabla(columnas, "View_Productos", "{CALL SP_Mostrar_Productos}",false);
        return datos;
    }
}
