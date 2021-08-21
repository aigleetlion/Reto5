package Modelo.dao;

//Estructura de datos
import java.util.ArrayList;

//Librerías para SQL y Base de Datos
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

//Clase para conexión
import Util.JDBCUtilities;

import Modelo.vo.Requerimiento_1;

public class Requerimiento_1Dao {   

    //Obtener los 10 proyectos rankeados según las compras
    public ArrayList<Requerimiento_1> requerimiento1()  throws SQLException {
        
        ArrayList<Requerimiento_1> respuesta = new ArrayList<Requerimiento_1>();
        //Abrimos la comunicacion 
        Connection conexion = JDBCUtilities.getConnection();
        
        try {

            String consulta = "SELECT  ID_Proyecto, Ciudad,  Banco_Vinculado, Constructora, Clasificacion FROM Proyecto WHERE (Fecha_Inicio >='2020-01-01' AND Clasificacion='Condominio');";          
            
            
            

            PreparedStatement stament = conexion.prepareStatement(consulta);
            ResultSet resultSet =stament.executeQuery();

            while(resultSet.next()){

                Requerimiento_1 requerimiento_1 = new Requerimiento_1();

                requerimiento_1.setID_Proyecto(resultSet.getInt("ID_Proyecto"));
                requerimiento_1.setCiudad(resultSet.getString("Ciudad"));
                requerimiento_1.setBanco_Vinculado(resultSet.getString("Banco_Vinculado"));
                requerimiento_1.setConstructora(resultSet.getString("Constructora"));
                requerimiento_1.setClasificacion(resultSet.getString("Clasificacion"));

                respuesta.add(requerimiento_1);
            }
            
            resultSet.close();
            stament.close();
        }catch(SQLException e){
            System.out.println("Error consultando: "+e);
        }finally{
            if(conexion != null){
                conexion.close();
            }
        }
        return respuesta;
    }
}