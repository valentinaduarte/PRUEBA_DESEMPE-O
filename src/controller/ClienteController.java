package controller;

import entity.Cliente;
import model.ClienteModel;
import utils.Utils;

import javax.swing.*;
import java.util.List;

public class ClienteController {
    public static void insert(){
        String nombre = JOptionPane.showInputDialog( "Ingrese el nombre del cliente: ");
        String apellido = JOptionPane.showInputDialog( "Ingrese el apellido del cliente: ");
        String documento = JOptionPane.showInputDialog( "Ingrese el email del cliente: ");

        instanceModel().insert(new Cliente(nombre, apellido, documento));

    }

    public static void getAll() {
        String list = String.valueOf(getAll(instanceModel().findAll()));

        JOptionPane.showMessageDialog(null, list);
    }

    public static StringBuilder getAll(List<Object> list){
        StringBuilder listString = new StringBuilder("LISTA DE CLIENTES: \n");

        for (Object temp: list) {
            Cliente objCliente = (Cliente)temp;
            listString.append(objCliente.toString()).append("\n");
        }

        return listString;
    }

    public static ClienteModel instanceModel() {
        return new ClienteModel();
    }

    public static void delete(){
        Object[] options  = Utils.listToArray(instanceModel().findAll());

        Cliente objCliente = (Cliente) JOptionPane.showInputDialog(
                null,
                "Selecciona el cliente a eliminar: ",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        instanceModel().delete(objCliente);
    }

    public static void update(){
        Object[] options = Utils.listToArray(instanceModel().findAll());
        Cliente objSelected = (Cliente) JOptionPane.showInputDialog(
                null,
                "Selecciona un cliente a actualizar:",
                "",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        objSelected.setNombre(JOptionPane.showInputDialog(null,"Ingresa el nuevo nombre:",objSelected.getNombre()));
        objSelected.setApellido(JOptionPane.showInputDialog(null,"Ingresa el nuevo apellido:",objSelected.getApellido()));
        objSelected.setEmail(JOptionPane.showInputDialog(null,"Ingresa el nuevo email:",objSelected.getEmail()));

        instanceModel().update(objSelected);
    }
}
