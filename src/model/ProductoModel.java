package model;

import database.CRUD;
import database.ConfigDB;
import entity.Producto;
import entity.Tienda;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoModel implements CRUD {
    @Override
    public Object insert(Object obj) {
        Connection objConnection = ConfigDB.openConnection();

        Producto objProducto = (Producto) obj;

        try {
            String sql = "INSERT INTO producto (nombre , precio,id_tienda,stock ) VALUES (?, ?, ?, ?);";
            PreparedStatement objPrepare =  objConnection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            objPrepare.setString(1, objProducto.getNombre());
            objPrepare.setDouble(2, objProducto.getPrecio());
            objPrepare.setInt(3, objProducto.getIdTienda());
            objPrepare.setInt(4, objProducto.getStock());


            objPrepare.execute();

            ResultSet objResult = objPrepare.getGeneratedKeys();

            while(objResult.next()){
                objProducto.setId(objResult.getInt(1));
            }

            JOptionPane.showMessageDialog(null, "El producto fue agregado correctamente.");

        } catch (SQLException e) {
            System.out.println("Error >" + e.getMessage());
        }

        ConfigDB.closeConnection();

        return objProducto;

    }

    @Override
    public List<Object> findAll() {
        List<Object> listProductos = new ArrayList<>();
        Connection objConnection = ConfigDB.openConnection();

        try {
            String sql = "SELECT * FROM producto \n" + "INNER JOIN tienda ON tienda.id = producto.id_tienda;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            ResultSet objResult = objPrepare.executeQuery();

            while (objResult.next()) {
                Producto objProducto = new Producto();
                Tienda objTienda = new Tienda();

                objProducto.setId(objResult.getInt("producto.id"));
                objProducto.setNombre(objResult.getString("producto.nombre"));
                objProducto.setPrecio(objResult.getDouble("producto.precio"));
                objProducto.setStock(objResult.getInt("producto.stock"));

                objTienda.setId(objResult.getInt("tienda.id"));
                objTienda.setNombre(objResult.getString("tienda.nombre"));
                objTienda.setUbicacion(objResult.getString("tienda.ubicacion"));

                objProducto.setObjTienda(objTienda);

                listProductos.add(objProducto);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }

        ConfigDB.closeConnection();
        return listProductos;
    }

    public void updateStock(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Producto objP = (Producto) obj;
        boolean isUpdated = false;

        try {
            String sql = "UPDATE producto SET stock = ? WHERE id = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setInt(1,objP.getStock());
            objPrepare.setInt(2,objP.getId());

            int totalRowAffected = objPrepare.executeUpdate();
            if (totalRowAffected > 0){
                isUpdated = true;
                JOptionPane.showMessageDialog(null,"Producto actualizado correctamente.");
            }
        }catch (SQLException e){
            System.out.println("Error : " + e.getMessage());
        }

        ConfigDB.closeConnection();
    }

    @Override
    public boolean update(Object obj) {
        Connection objConnection = ConfigDB.openConnection();
        Producto objProducto = (Producto) obj;
        boolean isUpdated = false;

        try {
            String sql = "UPDATE producto SET nombre = ?, precio = ?, id_tienda = ?, stock = ? WHERE id = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setString(1,objProducto.getNombre());
            objPrepare.setDouble(2,objProducto.getPrecio());
            objPrepare.setInt(3,objProducto.getIdTienda());
            objPrepare.setInt(4,objProducto.getStock());
            objPrepare.setInt(5,objProducto.getId());

            int totalRowAffected = objPrepare.executeUpdate();
            if (totalRowAffected > 0){
                isUpdated = true;
                JOptionPane.showMessageDialog(null,"Producto actualizado correctamente.");
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
        Producto objProducto = (Producto) obj;

        boolean isDeleted = false;

        try {
            String sql = "DELETE FROM producto WHERE id = ?;";
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);

            objPrepare.setInt(1, objProducto.getId());

            int totalAffectedRows = objPrepare.executeUpdate();

            if (totalAffectedRows > 0){
                isDeleted = true;

                JOptionPane.showMessageDialog(null,"Producto eliminado correctamente.");

            }
        }catch (SQLException e) {
            System.out.println("Error " + e.getMessage());
        }

        ConfigDB.closeConnection();

        return isDeleted;
    }
}
