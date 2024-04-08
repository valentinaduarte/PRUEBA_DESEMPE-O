package model;

import database.CRUD;
import database.ConfigDB;
import entity.Cliente;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteModel implements CRUD {

    public Object insert(Object obj) {
        //Se abre conexión
        Connection objConnection = ConfigDB.openConnection();

        Cliente objCliente = (Cliente) obj;

        try {
            String sql = "INSERT INTO cliente (nombre, apellido, email) VALUES (?, ?, ?);";
            PreparedStatement objPrepare =  objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setString(1, objCliente.getNombre());
            objPrepare.setString(2, objCliente.getApellido());
            objPrepare.setString(3, objCliente.getEmail());


            objPrepare.execute();

            ResultSet objResult = objPrepare.getGeneratedKeys();

            while(objResult.next()){
                objCliente.setId(objResult.getInt(1));
            }

            JOptionPane.showMessageDialog(null, "El cliente fue agregado correctamente.");

        } catch (SQLException e) {
            System.out.println("Error >" + e.getMessage());
        }

        ConfigDB.closeConnection();

        return objCliente;
    }

    public List<Object> findAll() {
        //Se abre conexión
        Connection objConnection = ConfigDB.openConnection();

        List<Object> listClientes = new ArrayList<>();

        try {
            String sql = "SELECT * FROM cliente;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            ResultSet objResult = objPrepare.executeQuery();

            while (objResult.next()) {
                Cliente objCliente = new Cliente();

                objCliente.setId(objResult.getInt("id"));
                objCliente.setNombre(objResult.getString("nombre"));
                objCliente.setApellido(objResult.getString("apellido"));
                objCliente.setEmail(objResult.getString("email"));

                listClientes.add(objCliente);
            }
        }catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

        //Se cierra conexión
        ConfigDB.closeConnection();

        return listClientes;
    }

    @Override
    public boolean update(Object obj) {
        //Se abre conexión
        Connection objConnection = ConfigDB.openConnection();

        Cliente objCliente = (Cliente) obj;

        boolean isUpdated = false;

        try {
            String sql = "UPDATE cliente SET nombre = ?, apellido = ?, email = ? WHERE id = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setString(1,objCliente.getNombre());
            objPrepare.setString(2,objCliente.getApellido());
            objPrepare.setString(3,objCliente.getEmail());
            objPrepare.setInt(4,objCliente.getId());

            int totalRowAffected = objPrepare.executeUpdate();
            if (totalRowAffected > 0){
                isUpdated = true;
                JOptionPane.showMessageDialog(null,"El cliente ha sido actualizado correctamente.");
            }
        }catch (SQLException e){
            System.out.println("Error : " + e.getMessage());
        }

        ConfigDB.closeConnection();
        return isUpdated;
    }

    @Override
    public boolean delete(Object obj) {
        //Se abre conexión
        Connection objConnection = ConfigDB.openConnection();

        Cliente objCliente = (Cliente) obj;

        boolean isDeleted = false;

        try {
            String sql = "DELETE FROM cliente WHERE id = ?;";

            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setInt(1, objCliente.getId());

            int totalAffectedRows = objPrepare.executeUpdate();

            if (totalAffectedRows > 0){
                isDeleted = true;

                JOptionPane.showMessageDialog(null,"Cliente eliminado correctamente.");

            }
        }catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }

        ConfigDB.closeConnection();

        return isDeleted;
    }
}
