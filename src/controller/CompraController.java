package controller;

import entity.Cliente;
import entity.Compra;
import entity.Producto;
import model.CompraModel;
import utils.Utils;

import javax.swing.*;
import java.util.List;

public class CompraController {
    public static void insert() {

        int cantidad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de la compra: "));
        
        Object[] optionsClientes = Utils.listToArray(ClienteController.instanceModel().findAll());
        Object[] optionsProductos = Utils.listToArray(ProductoController.instanceModel().findAll());

        Producto ProductoSelected = (Producto) JOptionPane.showInputDialog(
                null,
                "Selecciona el producto que desea agregar a la compra: ",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                optionsProductos,
                optionsProductos[0]
        );

        Cliente clienteSelected = (Cliente) JOptionPane.showInputDialog(
                null,
                "Selecciona el cliente que realiza la compra: ",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                optionsClientes,
                optionsClientes[0]
        );

        instanceModel().insert(new Compra(cantidad,ProductoSelected.getId(), clienteSelected.getId(), clienteSelected, ProductoSelected));

    }


    public static CompraModel instanceModel () {
        return new CompraModel();
    }

    public static void getAll() {
        String list = getAll(instanceModel().findAll());

        JOptionPane.showMessageDialog(null, list);
    }

    public static String getAll(List<Object> list){
        String listString = "LISTA DE COMPRAS: \n";

        for (Object temp: list) {
            Compra objCompra = (Compra) temp;
            listString+= objCompra.toString() + "\n";
        }
        return listString;
    }

    public static void delete(){
        Object[] options  = Utils.listToArray(instanceModel().findAll());

        Compra CompraSelected = (Compra) JOptionPane.showInputDialog(
                null,
                "Selecciona la compra a eliminar a eliminar: ",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        instanceModel().delete(CompraSelected);
    }

    public static void update(){
        Object[] options = Utils.listToArray(instanceModel().findAll());
        Compra CompraSelected = (Compra) JOptionPane.showInputDialog(
                null,
                "Selecciona la compra que desea actualizar: ",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        CompraSelected.setFechaCompra(JOptionPane.showInputDialog("Ingrese la fecha de la cita: YYYY-MM-dd "));
        CompraSelected.setCantidad(Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad del producto a comprar:")));


        Object[] optionsClientes = Utils.listToArray(ClienteController.instanceModel().findAll());
        Object[] optionsProductos = Utils.listToArray(ProductoController.instanceModel().findAll());

        CompraSelected.setObjProducto( (Producto) JOptionPane.showInputDialog(
                null,
                "Selecciona el producto a actualizar: ",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                optionsProductos,
                optionsProductos[0]
        ));


        CompraSelected.setIdProducto(CompraSelected.getObjProducto().getId());


        CompraSelected.setObjCliente( (Cliente) JOptionPane.showInputDialog(
                null,
                "Selecciona el cliente a actualizar: ",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                optionsClientes,
                optionsClientes[0]
        ));

        CompraSelected.setIdCliente(CompraSelected.getObjCliente().getId());

        instanceModel().update(CompraSelected);
    }

}
