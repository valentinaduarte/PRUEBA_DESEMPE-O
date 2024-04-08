package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigDB {
    public static Connection objConnection = null;

    public static Connection openConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String url = "jdbc:mysql://bia7rex7lojv47f6wwbo-mysql.services.clever-cloud.com:3306/bia7rex7lojv47f6wwbo";
            String user = "udbijitipuoh7vpl";
            String password = "WaSdecZLiAQZDXORNR0G";

            //Establecer la conexión
            objConnection = DriverManager.getConnection(url,user,password);
            System.out.println("CONEXIÓN EXITOSA.");

        } catch (ClassNotFoundException e) {
            System.out.println("Error > Driver no instalado" + e.getMessage());
        }catch (SQLException e){
            System.out.println("Error > Al conectar a la base de datos" + e.getMessage());
        }

        return objConnection;
    }

    public static void closeConnection(){
        try{
            if(objConnection != null){
                objConnection.close();
                System.out.println("CONEXIÓN FINALIZADA");
            }
        } catch (SQLException e) {
            System.out.println("Error : " + e.getMessage());
        }
    }
}
