package controller;

import entity.Producto;
import entity.Tienda;
import model.ProductoModel;
import utils.Utils;

import javax.swing.*;
import java.util.List;

public class ProductoController {
    public static void getAll() {
        String list = String.valueOf(getAll(instanceModel().findAll()));

        JOptionPane.showMessageDialog(null, list);
    }

    public static String getAll(List<Object> list){
        String listString = "LISTA DE PRODUCTOS: \n";

        for (Object temp: list) {
            Producto objProducto = (Producto) temp;
            listString+= objProducto.toString() + "\n";
        }
        return listString;
    }

    public static void delete(){
        Object[] options  = Utils.listToArray(instanceModel().findAll());

        Producto objProducto = (Producto) JOptionPane.showInputDialog(
                null,
                "Selecciona el producto a eliminar: ",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        instanceModel().delete(objProducto);
    }

    public static void insert(){
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del producto: ");
        Double precio = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el precio del producto: "));
        int stock = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el stock del producto: "));


        Object[] optionsTiendas = Utils.listToArray(TiendaController.instanceModel().findAll());

        Tienda objTienda = (Tienda) JOptionPane.showInputDialog(
                null,
                "Selecciona la tienda a la cual desea ingresar el producto:",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                optionsTiendas,
                optionsTiendas[0]
        );
        instanceModel().insert(new Producto(nombre,precio,stock,objTienda.getId(),objTienda));
    }

    public static void update() {
        Object[] options = Utils.listToArray(instanceModel().findAll());
        Producto objProducto = (Producto) JOptionPane.showInputDialog(
                null,
                "Selecciona un producto para actualizar: ",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        objProducto.setNombre(JOptionPane.showInputDialog("Ingrese el nuevo nombre del producto: "));
        objProducto.setPrecio(Double.valueOf(JOptionPane.showInputDialog("Ingrese el nuevo precio del producto: ")));
        objProducto.setStock(Integer.parseInt(JOptionPane.showInputDialog("Ingrese el nuevo stock del producto:  ")));


        Object[] optionsTiendas  = Utils.listToArray(TiendaController.instanceModel().findAll());

        Tienda objTienda = (Tienda) JOptionPane.showInputDialog(
                null,
                "Selecciona la tienda donde deseas actualizar el producto:",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                optionsTiendas,
                optionsTiendas[0]
        );

        objProducto.setIdTienda(objProducto.getObjTienda().getId());
        instanceModel().update(objProducto);
    }




    public static  ProductoModel instanceModel(){
        return new ProductoModel();
    }
}
