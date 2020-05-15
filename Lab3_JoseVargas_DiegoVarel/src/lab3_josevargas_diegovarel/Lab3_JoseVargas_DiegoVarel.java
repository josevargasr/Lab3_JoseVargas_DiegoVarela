/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3_josevargas_diegovarel;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author josevargas
 */
public class Lab3_JoseVargas_DiegoVarel {

    static Scanner entrada = new Scanner(System.in);
    static boolean admin = false;
    static boolean cliente = false;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Usuario admin = admim / Contraseña admin = claudia99");
        ArrayList<Locales> locales = new ArrayList();
        ArrayList<Clientes> clientes = new ArrayList();
        ArrayList<Empleados> empleados = new ArrayList();
        boolean valid = true;
        while (valid) {
            System.out.println("----Shopping Mall----\n"
                    + "1]Sign up\n"
                    + "2]Login\n"
                    + "3]Opciones de Administrador\n"
                    + "4]Shop\n"
                    + "Ingrese una opcion: ");
            int opcion = entrada.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese su ID: ");
                    int id = entrada.nextInt();
                    System.out.println("Ingrese su username: ");
                    String username = entrada.next();
                    System.out.println("Ingrese una contraseña: ");
                    String contraseña = entrada.next();
                    System.out.println("Ingrese su correo electronico: ");
                    String correo = entrada.next();
                    System.out.println("Ingrese su nombre completo: ");
                    String nombre = entrada.nextLine();
                    nombre = entrada.nextLine();
                    System.out.println("Ingrese su fecha de nacimiento(dd/MM/yyyy): ");
                    String fecha = entrada.next();
                    System.out.println("Ingrese la cantidad de dinero(Lempiras): ");
                    int dinero = entrada.nextInt();
                    clientes.add(new Clientes(dinero, id, username, contraseña, correo, nombre, fecha));
                    System.out.println("El usuario fue creado con exito!");
                    System.out.println("");
                    break;
                case 2:
                    System.out.println("Ingrese el username: ");
                    String user = entrada.next();
                    System.out.println("Ingrese la contraseña: ");
                    String pass = entrada.next();
                    if (user.equals("admin") && pass.equals("claudia99")) {
                        System.out.println("Se ingreso sesion correctamente como administrador!");
                        admin = true;
                    } else {
                        for (int i = 0; i < clientes.size(); i++) {
                            if (user.equals(clientes.get(i).getUsername()) && pass.equals(clientes.get(i).getContraseña())) {
                                System.out.println("Se inicio sesion correctamente!");
                                cliente = true;
                                break;
                            }
                        }
                        if (cliente) {

                        } else {
                            System.out.println("El usuario o contraseña es incorrecto");
                        }
                    }
                    System.out.println();
                    break;
                case 3:
                    if (admin) {
                        System.out.println("1] Agregar Local\n"
                                + "2] Agregar Empleados\n"
                                + "3] Agregar Productos\n"
                                + "4] Modificar Algo\n"
                                + "5] Eliminar Algo\n"
                                + "Ingrese la opcion que desea: ");
                        int opcion2 = entrada.nextInt();
                        switch (opcion2) {
                            case 1:
                                System.out.println("1] Tienda\n"
                                        + "2] Quiosco\n"
                                        + "3] Bar\n"
                                        + "Ingrese un local para agregar: ");
                                int opcion3 = entrada.nextInt();
                                String nom;
                                if (opcion3 == 1) {
                                    System.out.println("Ingrese el nombre de la tienda: ");
                                    nom = entrada.next();
                                    locales.add(new Tiendas(nom));
                                } else if (opcion3 == 2) {
                                    for (Object o : locales) {
                                        if (o instanceof Tiendas) {
                                            System.out.println("[" + (locales.indexOf(o)) + "] " + o);
                                        }
                                    }
                                    System.out.println("Ingrese la posicion de la tienda de la cual quiere hacer un quiosco: ");
                                    int pos = entrada.nextInt();
                                    locales.add(new Quiosco(locales.get(pos).getNombre()));
                                } else {
                                    System.out.println("Ingrese el nombre del bar: ");
                                    nom = entrada.next();
                                    locales.add(new Bares(nom));
                                }
                                System.out.println("Se agrego el local con exito!");
                                System.out.println();
                                break;
                            case 2:

                                for (Locales lo : locales) {
                                    System.out.println(lo);
                                }
                                System.out.println("Ingrese la posicion del local a la cual deseas agregar un empleado:");
                                int pos = entrada.nextInt();
                                System.out.println("Ingrese su ID: ");
                                int id2 = entrada.nextInt();
                                System.out.println("Ingrese su username: ");
                                String username2 = entrada.next();
                                System.out.println("Ingrese una contraseña: ");
                                String contraseña2 = entrada.next();
                                System.out.println("Ingrese su correo electronico: ");
                                String correo2 = entrada.next();
                                System.out.println("Ingrese su nombre completo: ");
                                String nombre2 = entrada.nextLine();
                                nombre = entrada.nextLine();
                                System.out.println("Ingrese su fecha de nacimiento(dd/MM/yyyy): ");
                                String fecha2 = entrada.next();
                                boolean existe = false;
                                for (Empleados empleado : empleados) {
                                    if (empleado.getUsername().equals(username2) && empleado.getId() == id2) {
                                        existe = true;
                                    }
                                }

                                if (existe == false) {
                                    if (locales.get(pos) instanceof Bares) {
                                        int empleado = locales.get(pos).getEmpleados().size();
                                        if (empleado < 4) {
                                            locales.get(pos).getEmpleados().add(new Empleados(correo2, id2, username2, contraseña2, correo2, nombre2, fecha2));
                                            System.out.println("Empleado agregado con exito");
                                        } else {
                                            System.out.println("Ha llegado al maximo de empleados en este Bar lo sentimos :(");
                                        }
                                    }

                                } else {
                                    System.out.println("El id y el username ya han sido utilizados, porfavor cambielos");
                                    System.out.println("Ingrese su ID: ");
                                    id2 = entrada.nextInt();
                                    System.out.println("Ingrese su username: ");
                                    username2 = entrada.next();
                                    locales.get(pos).getEmpleados().add(new Empleados(correo2, id2, username2, contraseña2, correo2, nombre2, fecha2));
                                    System.out.println("Empleado agregado con exito");
                                }
                                break;
                            case 3:
                                for (Locales lo : locales) {
                                    System.out.println(lo);
                                }
                                System.out.println("Ingrese la posicion del local a la cual deseas agregar un producto:");
                                int po = entrada.nextInt();
                                System.out.println("Que producto desea agregar:");
                                System.out.println("1) Comida");
                                System.out.println("2) Ropa");
                                System.out.println("3) Juguetes");
                                int op = entrada.nextInt();
                                switch (op) {
                                    case 1:
                                        if (locales.get(po) instanceof Bares) {
                                            System.out.println("Ingrese el nombre:");
                                            String nomb = entrada.next();
                                            System.out.println("Ingrese la descripcion:");
                                            String desc = entrada.nextLine();
                                            desc = entrada.nextLine();
                                            System.out.println("Ingrese el precio:");
                                            int precio = entrada.nextInt();
                                            System.out.println("Ingrese la fecha de caducidad(dd/MM/yyyy):");
                                            String caduc = entrada.next();
                                            System.out.println("Ingrese el tipo de comida:"
                                                    + "1) Bebida"
                                                    + "2) Comida");
                                            int com = entrada.nextInt();
                                            String tipo = "";
                                            switch (com) {
                                                case 1:
                                                    tipo = "Bebida";
                                                    break;
                                                case 2:
                                                    tipo = "Comida";
                                                    break;
                                            }
                                            locales.get(po).getProductos().add(new Comida(tipo, caduc, desc, nomb, precio));
                                        } else {
                                            System.out.println("No se le puede agregar comida a una Tienda o Quiosco");
                                        }
                                        break;
                                    case 2:
                                        System.out.println("Ingrese el nombre:");
                                        String nomb = entrada.next();
                                        System.out.println("Ingrese la descripcion:");
                                        String desc = entrada.nextLine();
                                        desc = entrada.nextLine();
                                        System.out.println("Ingrese el precio:");
                                        int precio = entrada.nextInt();
                                        System.out.println("Ingrese el tipo de ropa:"
                                                + "1) Hombre"
                                                + "2) Mujer");
                                        int com = entrada.nextInt();
                                        String tipo = "";
                                        switch (com) {
                                            case 1:
                                                tipo = "Hombre";
                                                break;
                                            case 2:
                                                tipo = "Mujer";
                                                break;
                                        }
                                        System.out.println("Ingrese la talla:"
                                                + "1) XS"
                                                + "2) S"
                                                + "3) M"
                                                + "4) L");
                                        int tal = entrada.nextInt();
                                        String talla = "";
                                        switch (tal) {
                                            case 1:
                                                talla = "XS";
                                                break;
                                            case 2:
                                                talla = "S";
                                                break;
                                            case 3:
                                                talla = "M";
                                                break;
                                            case 4:
                                                talla = "L";
                                                break;

                                        }
                                        if (locales.get(po) instanceof Quiosco) {
                                            int des = precio / 2;
                                            locales.get(po).getProductos().add(new Ropa(tipo, talla, desc, nomb, des));
                                        } else {
                                            locales.get(po).getProductos().add(new Ropa(tipo, talla, desc, nomb, precio));
                                        }
                                        break;
                                    case 3:
                                        System.out.println("Ingrese el nombre:");
                                        String nombr = entrada.next();
                                        System.out.println("Ingrese la descripcion:");
                                        String descu = entrada.nextLine();
                                        desc = entrada.nextLine();
                                        System.out.println("Ingrese el precio:");
                                        int prize = entrada.nextInt();
                                        if (locales.get(po) instanceof Quiosco) {
                                            int des = prize / 2;
                                            locales.get(po).getProductos().add(new Juguetes(descu, nombr, des));
                                        } else {
                                            locales.get(po).getProductos().add(new Juguetes(descu, nombr, prize));
                                        }
                                        break;
                                }
                                break;
                            case 4:
                                break;
                            case 5:
                                break;
                        }
                    } else {
                        System.out.println("No se ha ingresado sesion como administrador");
                    }
                    System.out.println();
                    break;
                case 4:
                    if (cliente) {
                        System.out.println("Locales: ");
                        for (int i = 0; i < locales.size(); i++) {
                            System.out.println("[" + i + "] " + locales.get(i));
                        }
                        System.out.println("Ingrese el local que desea visitar: ");
                        int posi = entrada.nextInt();
                        System.out.println("Bienvenido al local " + locales.get(posi).getNombre());
                        System.out.println("1] Ver Productos\n"
                                + "2] Salir\n"
                                + "Ingrese una opcion: ");
                        int opt = entrada.nextInt();
                        if (opt == 1) {
                            for (int i = 0; i < locales.get(posi).getProductos().size(); i++) {
                                System.out.println("[" + i + "] " + locales.get(posi).getProductos().get(i));
                            }
                            System.out.println("Ingrese la posicion del articulo que desea comprar: ");
                            int compra = entrada.nextInt();
                            if ((clientes.get(0).getDinero() - locales.get(posi).getProductos().get(compra).getPrecio()) < 0) {
                                System.out.println("Sus fondos son insuficientes para completar esta compra");
                            } else {
                                clientes.get(0).getComprados().add(locales.get(posi).getProductos().get(compra));
                                clientes.get(0).setDinero(clientes.get(0).getDinero() - locales.get(posi).getProductos().get(compra).getPrecio());
                                System.out.println("El articulo fue comprado con exito!");
                            }
                        } else {
                            
                        }
                        System.out.println("Gracias por visitarnos, vuelva pronto!");
                    }else {
                        System.out.println("No se ha ingresado sesion todavia");
                    }
            System.out.println();
            break;

        }
    }
}

}
