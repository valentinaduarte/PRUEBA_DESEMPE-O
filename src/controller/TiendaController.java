package controller;

import entity.Tienda;
import model.TiendaModel;

import javax.swing.*;
import java.util.List;

public class TiendaController {
    public static void getAll() {
        String list = String.valueOf(getAll(instanceModel().findAll()));

        JOptionPane.showMessageDialog(null, list);
    }

    public static String getAll(List<Object> list){
        String listString = "LISTA DE TIENDAS: \n";

        for (Object temp: list) {
            Tienda objTienda = (Tienda) temp;
            listString+= objTienda.toString() + "\n";
        }
        return listString;
    }
    public static TiendaModel instanceModel(){
        return new TiendaModel();
    }
}
