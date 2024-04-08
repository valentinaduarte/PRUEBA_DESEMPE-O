import controller.ClienteController;
import controller.CompraController;
import controller.ProductoController;

import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
            int option = 0, option2 = 2;

            do {
                option = Integer.parseInt(JOptionPane.showInputDialog("""
                    CENTRO COMERCIAL DE MODA OUTLET
                    MENU GESTIÓN DE OPERACIONES DE LA TIENDA X:
                    
                    1. Gestionar Clientes.
                    2. Gestionar Productos.
                    3. Gestionar Compras.
                    5. Salir.
                    
                    Ingrese una opción:
                    """));

                switch (option) {
                    case 1:
                        do {
                            option2 = Integer.parseInt(JOptionPane.showInputDialog("""
                                MENU GESTIÓN DE CLIENTES DE LA TIENDA:
                                
                                1. Listar Clientes.
                                2. Crear Clientes.
                                3. Eliminar Clientes.
                                4. Actualizar Clientes.
                                5. Salir.
                                
                                Ingrese una opcion:
                                """));

                            switch (option2) {
                                case 1:
                                    ClienteController.getAll();
                                    break;
                                case 2:
                                    ClienteController.insert();
                                    break;
                                case 3:
                                    ClienteController.delete();
                                    break;
                                case 4:
                                    ClienteController.update();
                                    break;
                            }
                        } while (option2 != 5);
                        break;

                    case 2:
                        do {
                            option2 = Integer.parseInt(JOptionPane.showInputDialog(
                                    """
                                    MENU GESTIÓN DE PRODUCTOS DE LA TIENDA:
                                    
                                    1. Listar Productos.
                                    2. Crear Producto.
                                    3. Eliminar Producto.
                                    4. Actualizar Producto.
                                    5. Salir.
                                    """));
                            switch (option2){
                                case 1:
                                    ProductoController.getAll();
                                    break;
                                case 2:
                                    ProductoController.insert();
                                    break;
                                case 3:
                                    ProductoController.delete();
                                    break;
                                case 4:
                                    ProductoController.update();
                                    break;
                            }
                        } while (option2 != 5);
                        break;

                    case 3:
                        do {
                            option2 = Integer.parseInt(JOptionPane.showInputDialog(
                                    """
                                    MENU GESTION DE COMPRAS DE LA TIENDA:
                                    
                                    1. Listar Compras.
                                    2. Crear Compra.
                                    3. Eliminar Compra.
                                    4. Actualizar Compras.
                                    5. Salir.
                                    """));
                            switch (option2){
                                case 1:
                                    CompraController.getAll();
                                    break;
                                case 2:
                                    CompraController.insert();
                                    break;
                                case 3:
                                    CompraController.delete();
                                    break;
                                case 4:
                                    CompraController.update();
                                    break;
                            }
                        } while (option2 != 5);
                        break;

                }
            } while (option != 5);
        }
    }
