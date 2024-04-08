package model;

import database.CRUD;
import database.ConfigDB;
import entity.Compra;
import entity.Cliente;
import entity.Producto;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompraModel implements CRUD {
    public Object insert(Object obj) {
        Connection objConnection = ConfigDB.openConnection();

        Compra objCompra = (Compra) obj;

        try {
            String sql = "INSERT INTO compra (fecha_compra, cantidad, id_cliente , id_producto) VALUES (? ,? ,? ,?);";
            PreparedStatement objPrepare =  objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setString(1, objCompra.getFechaCompra());
            objPrepare.setInt(2, objCompra.getCantidad());
            objPrepare.setInt(3, objCompra.getIdCliente());
            objPrepare.setInt(4, objCompra.getIdProducto());

            objPrepare.execute();

            ResultSet objResult = objPrepare.getGeneratedKeys();

            while(objResult.next()){
                objCompra.setId(objResult.getInt(1));
            }

            JOptionPane.showMessageDialog(null, "La compra fue realizada correctamente.");

        } catch (SQLException e) {
            System.out.println("Error >" + e.getMessage());
        }

        ConfigDB.closeConnection();

        return objCompra;
    }

    public List<Object> findAll() {
        List<Object> listCompras = new ArrayList<>();
        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "SELECT * FROM compra \n" + "INNER JOIN cliente ON cliente.id = compra.id_cliente \n" + "INNER JOIN producto ON producto.id = compra.id_producto;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            ResultSet objResult = objPrepare.executeQuery();

            while (objResult.next()) {
                Compra objCompra = new Compra();
                Cliente objCliente = new Cliente();
                Producto objProducto = new Producto();

                objCompra.setId(objResult.getInt("compra.id"));
                objCompra.setFechaCompra(objResult.getString("compra.fecha_compra"));
                objCompra.setCantidad(objResult.getInt("compra.cantidad"));
                objCompra.setIdCliente(objResult.getInt("compra.id_cliente"));
                objCompra.setIdProducto(objResult.getInt("compra.id_producto")) ;


                objProducto.setNombre(objResult.getString("producto.nombre"));
                objCliente.setNombre(objResult.getString("cliente.nombre"));
                objCliente.setApellido(objResult.getString("cliente.apellido"));
                objCliente.setEmail(objResult.getString("cliente.email"));

                objCompra.setObjCliente(objCliente);
                objCompra.setObjProducto(objProducto);

                listCompras.add(objCompra);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

        ConfigDB.closeConnection();
        return listCompras;
    }

    @Override
    public boolean update(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Compra objCompra = (Compra) obj;
        boolean isUpdated = false;

        try {
            String sql = "UPDATE compra SET fecha_compra = ?, cantidad = ?, id_cliente = ?, id_producto = ? WHERE id = ? ";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setString(1, objCompra.getFechaCompra());
            objPrepare.setInt(2, objCompra.getCantidad());
            objPrepare.setInt(3, objCompra.getIdCliente());
            objPrepare.setInt(4, objCompra.getIdProducto());;

            int totalRowAffected = objPrepare.executeUpdate();

            if (totalRowAffected > 0){
                isUpdated = true;
                JOptionPane.showMessageDialog(null,"Compra actualizada correctamente.");
            }
        }catch (SQLException e){
            System.out.println("Error : " + e.getMessage());
        }

        ConfigDB.closeConnection();
        return isUpdated;
    }

    @Override
    public boolean delete(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Compra objCompra = (Compra) obj;

        boolean isDeleted = false;

        try {
            String sql = "DELETE FROM compra WHERE id = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setInt(1, objCompra.getId());

            int totalAffectedRows = objPrepare.executeUpdate();

            if (totalAffectedRows > 0){
                isDeleted = true;

                JOptionPane.showMessageDialog(null,"Compra eliminado correctamente.");

            }
        }catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }

        ConfigDB.closeConnection();

        return isDeleted;
    }
}
