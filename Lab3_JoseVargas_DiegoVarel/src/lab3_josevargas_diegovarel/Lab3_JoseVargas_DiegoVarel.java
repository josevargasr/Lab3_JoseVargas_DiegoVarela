/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3_josevargas_diegovarel;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
    static boolean repetido = false;
    static int poscliente = 0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        System.out.println("Usuario admin = admin / Contraseña admin = claudia99");
        ArrayList<Locales> facturacion = new ArrayList();
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
                    + "5]Cerrar Sesion\n"
                    + "6]Facturacion\n"
                    + "7]Salir\n"
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
                    for (Clientes x : clientes) {
                        if (x.getUsername().equals(username) || x.getId() == id) {
                            System.out.println("El nombre de usuario o id ya esta ocupado");
                            repetido = true;
                            break;
                        }
                    }
                    if(repetido){
                        
                    }else{
                        System.out.println("Ingrese su correo electronico: ");
                        String correo = entrada.next();
                        System.out.println("Ingrese su nombre completo: ");
                        String nombre = entrada.nextLine();
                        nombre = entrada.nextLine();
                        System.out.println("Ingrese su fecha de nacimiento(dd/MM/yyyy): ");
                        String fecha = entrada.next();
                        Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(fecha);  
                        System.out.println("Ingrese la cantidad de dinero(Lempiras): ");
                        int dinero = entrada.nextInt();
                        clientes.add(new Clientes(dinero, id, username, contraseña, correo, nombre, date1));
                        System.out.println("El usuario fue creado con exito!");
                    }
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
                                poscliente = i;
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
                                + "6] Listar Locales\n"
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
                                    nom = entrada.nextLine();
                                    nom = entrada.nextLine();
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
                                    nom = entrada.nextLine();
                                    nom = entrada.nextLine();
                                    locales.add(new Bares(nom));
                                }
                                System.out.println("Se agrego el local con exito!");
                                System.out.println();
                                break;
                            case 2:

                                for (Locales lo : locales) {
                                    System.out.println("[" + locales.indexOf(lo) + "] "+lo);
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
                                nombre2 = entrada.nextLine();
                                System.out.println("Ingrese su fecha de nacimiento(dd/MM/yyyy): ");
                                String fecha2 = entrada.next();
                                Date date2=new SimpleDateFormat("dd/MM/yyyy").parse(fecha2);  
                                System.out.println("Ingrese su horario:");
                                String horario = entrada.nextLine();
                                horario = entrada.nextLine();
                                boolean existe = false;
                                for (Empleados empleado : empleados) {
                                    if (empleado.getUsername().equals(username2) || empleado.getId() == id2) {
                                        existe = true;
                                    }
                                }

                                if (existe == false) {
                                    if (locales.get(pos) instanceof Bares) {
                                        int empleado = locales.get(pos).getEmpleados().size();
                                        if (empleado < 4) {
                                            locales.get(pos).getEmpleados().add(new Empleados(correo2, id2, username2, contraseña2, correo2, nombre2, date2));
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
                                    locales.get(pos).getEmpleados().add(new Empleados(horario, id2, username2, contraseña2, correo2, nombre2, date2));
                                    System.out.println("Empleado agregado con exito");
                                }
                                break;
                            case 3:
                                for (Locales lo : locales) {
                                    System.out.println("[" + locales.indexOf(lo) + "] "+lo);
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
                                        System.out.println("Ingrese el tipo de ropa:\n"
                                                + "1) Hombre\n"
                                                + "2) Mujer\n");
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
                                        System.out.println("Ingrese la talla:\n"
                                                + "1) XS\n"
                                                + "2) S\n"
                                                + "3) M\n"
                                                + "4) L\n");
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
                                System.out.println("Que desea modificar");
                                System.out.println("1) Locales");
                                System.out.println("2) Clientes");
                                System.out.println("3) Empleados");
                                int mod = entrada.nextInt();
                                switch (mod) {
                                    case 1:
                                        for (Locales loc : locales) {
                                            System.out.println("[" + locales.indexOf(loc) + "] "+loc);
                                            
                                        }
                                        System.out.println("Ingrese la tienda que desea modificar:");
                                        int tien = entrada.nextInt();
                                        System.out.println("Que desea modificar?\n");
                                        System.out.println("1) Nombre\n"
                                                + "2) Lista de productos ");
                                        int opcio = entrada.nextInt();
                                        switch (opcio) {
                                            case 1:
                                                System.out.println("Ingrese el nombre :");
                                                String no = entrada.next();
                                                locales.get(tien).setNombre(no);
                                                System.out.println("Modificacion echa con exito!!");
                                                break;
                                            case 2:
                                                locales.get(tien).getProductos().toString();
                                                System.out.println("Ingrese que producto desea cambiar ?");
                                                int pro = entrada.nextInt();
                                                System.out.println("Que desea modificar?");
                                                System.out.println("1) Nombre");
                                                System.out.println("2) Descripcion");
                                                System.out.println("3) Precio");
                                                int change = entrada.nextInt();
                                                switch (change) {
                                                    case 1:
                                                        System.out.println("Ingrese el nombre :");
                                                        String name = entrada.next();
                                                        locales.get(tien).getProductos().get(pro).setNombre(name);
                                                        System.out.println("Modificacion echa con exito!!");
                                                        break;
                                                    case 2:
                                                        System.out.println("Ingrese la descricpion:");
                                                        String descript = entrada.nextLine();
                                                        descript = entrada.nextLine();
                                                        locales.get(tien).getProductos().get(pro).setDescripcion(descript);
                                                        System.out.println("Modificacion echa con exito!!");
                                                        break;
                                                    case 3:
                                                        System.out.println("Ingrese el nuevo precio:");
                                                        int pre = entrada.nextInt();
                                                        locales.get(tien).getProductos().get(pro).setPrecio(pre);
                                                        System.out.println("Modificacion echa con exito!!");
                                                        break;
                                                }
                                                break;
                                        }
                                        break;
                                    case 2:
                                        for (Clientes cli : clientes) {
                                            System.out.println("[" + clientes.indexOf(cli) + "] "+ cli);
                                        }
                                        System.out.println("Cual cliente desea modificar");
                                        int modi = entrada.nextInt();
                                        System.out.println("Que desea modificar?");
                                        System.out.println("1) Id");
                                        System.out.println("2) Username");
                                        System.out.println("3) Contraseña");
                                        System.out.println("4) Correo");
                                        System.out.println("5) Nombre");
                                        System.out.println("6) Fecha de nacimiento");
                                        System.out.println("7) Dinero");
                                        int opt = entrada.nextInt();
                                        switch (opt) {
                                            case 1:
                                                System.out.println("Ingrese el nuevo Id:");
                                                int ide = entrada.nextInt();
                                                clientes.get(modi).setId(ide);
                                                System.out.println("Modificacion hecha con exito!!");
                                                break;
                                            case 2:
                                                System.out.println("Ingrese el nuevo username:");
                                                String uswr = entrada.next();
                                                clientes.get(modi).setUsername(uswr);
                                                System.out.println("Modificacion hecha con exito!!");
                                                break;
                                            case 3:
                                                System.out.println("Ingrese su nueva contraseña:");
                                                String cont = entrada.next();
                                                clientes.get(modi).setContraseña(cont);
                                                System.out.println("Modificacion hecha con exito!!");
                                                break;
                                            case 4:
                                                System.out.println("Ingrese su nuevo correo:");
                                                String mail = entrada.next();
                                                clientes.get(modi).setCorreo(mail);
                                                System.out.println("Modificacion hecha con exito!!");
                                                break;
                                            case 5:
                                                System.out.println("Ingrese su nuevo nombre:");
                                                String name = entrada.next();
                                                clientes.get(modi).setNombre(name);
                                                System.out.println("Modificacion hecha con exito!!");
                                                break;
                                            case 6:
                                                System.out.println("Ingrese su nueva fecha de nacimiento(dd/MM/yyyy):");
                                                String date = entrada.next();
                                                Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(date);  
                                                clientes.get(modi).setNacimiento(date1);
                                                System.out.println("Modificacion hecha con exito!!");
                                                break;
                                            case 7:
                                                System.out.println("Ingrese la nueva cantidad de dinero:");
                                                int diner = entrada.nextInt();
                                                clientes.get(modi).setDinero(diner);
                                                System.out.println("Modificacion hecha con exito!!");
                                                break;
                                        }
                                        break;
                                    case 3:
                                        for (Empleados emp : empleados) {
                                            System.out.println("[" + empleados.indexOf(emp) + "] "+emp);
                                        }
                                        System.out.println("Cual empleado desea modificar");
                                        int modif = entrada.nextInt();
                                        System.out.println("Que desea modificar?");
                                        System.out.println("1) Id");
                                        System.out.println("2) Username");
                                        System.out.println("3) Contraseña");
                                        System.out.println("4) Correo");
                                        System.out.println("5) Nombre");
                                        System.out.println("6) Fecha de nacimiento");
                                        System.out.println("7) Horario");
                                        System.out.println("8) Productos vendidos");
                                        int opti = entrada.nextInt();
                                        switch (opti) {
                                            case 1:
                                                System.out.println("Ingrese el nuevo Id:");
                                                int ide = entrada.nextInt();
                                                empleados.get(modif).setId(ide);
                                                System.out.println("Modificacion echa con exito!!");
                                                break;
                                            case 2:
                                                System.out.println("Ingrese el nuevo username:");
                                                String uswr = entrada.next();
                                                empleados.get(modif).setUsername(uswr);
                                                System.out.println("Modificacion echa con exito!!");
                                                break;
                                            case 3:
                                                System.out.println("Ingrese su nueva contraseña:");
                                                String cont = entrada.next();
                                                empleados.get(modif).setContraseña(cont);
                                                System.out.println("Modificacion echa con exito!!");
                                                break;
                                            case 4:
                                                System.out.println("Ingrese su nuevo correo:");
                                                String mail = entrada.next();
                                                empleados.get(modif).setCorreo(mail);
                                                System.out.println("Modificacion echa con exito!!");
                                                break;
                                            case 5:
                                                System.out.println("Ingrese su nuevo nombre:");
                                                String name = entrada.next();
                                                empleados.get(modif).setNombre(name);
                                                System.out.println("Modificacion echa con exito!!");
                                                break;
                                            case 6:
                                                System.out.println("Ingrese su nueva fecha de nacimiento(dd/MM/yyyy):");
                                                String date = entrada.next();
                                                Date date1=new SimpleDateFormat("dd/MM/yyyy").parse(date);  
                                                empleados.get(modif).setNacimiento(date1);
                                                System.out.println("Modificacion echa con exito!!");
                                                break;
                                            case 7:
                                                System.out.println("Ingrese la nueva cantidad de dinero:");
                                                String horario2 = entrada.nextLine();
                                                horario2 = entrada.nextLine();
                                                ((Empleados) empleados.get(modif)).setHorario(horario2);
                                                System.out.println("Modificacion echa con exito!!");
                                                break;
                                            case 8:
                                                empleados.get(modif).getVendidos().toString();
                                                System.out.println("Ingrese que producto desea modificar?");
                                                int pro = entrada.nextInt();
                                                System.out.println("Que desea modificar?");
                                                System.out.println("1) Nombre");
                                                System.out.println("2) Descripcion");
                                                System.out.println("3) Precio");
                                                int change = entrada.nextInt();
                                                switch (change) {
                                                    case 1:
                                                        System.out.println("Ingrese el nombre :");
                                                        String name2 = entrada.next();
                                                        empleados.get(modif).getVendidos().get(pro).setNombre(name2);
                                                        System.out.println("Modificacion echa con exito!!");
                                                        break;
                                                    case 2:
                                                        System.out.println("Ingrese la descricpion:");
                                                        String descript = entrada.nextLine();
                                                        descript = entrada.nextLine();
                                                        empleados.get(modif).getVendidos().get(pro).setDescripcion(descript);
                                                        System.out.println("Modificacion echa con exito!!");
                                                        break;
                                                    case 3:
                                                        System.out.println("Ingrese el nuevo precio:");
                                                        int pre = entrada.nextInt();
                                                        empleados.get(modif).getVendidos().get(pro).setPrecio(pre);
                                                        System.out.println("Modificacion echa con exito!!");
                                                        break;
                                                }
                                                break;
                                        }
                                }
                                break;
                            case 5:
                                System.out.println("Que desea eliminar?");
                                System.out.println("1) Locales");
                                System.out.println("2) Clientes");
                                System.out.println("3) Empleados");
                                int el = entrada.nextInt();
                                switch (el) {
                                    case 1:
                                        for (Locales loc : locales) {
                                            System.out.println("[" + locales.indexOf(loc) + "] "+loc);
                                        }
                                        System.out.println("Cual tienda desea eliminar?");
                                        int elim = entrada.nextInt();
                                        locales.remove(elim);
                                        break;
                                    case 2:
                                        for (Clientes cli : clientes) {
                                            System.out.println("[" + clientes.indexOf(cli) + "] "+cli);
                                        }
                                        System.out.println("Cual cliente desea eliminar?");
                                        int elimi = entrada.nextInt();
                                        clientes.remove(elimi);
                                        break;
                                    case 3:
                                        for (Empleados emp : empleados) {
                                            System.out.println("[" + empleados.indexOf(emp) + "] "+emp);
                                        }
                                        System.out.println("Cual empleado desea eliminar?");
                                        int elimin = entrada.nextInt();
                                        clientes.remove(elimin);
                                        break;
                                }
                                System.out.println("Se elimino con exito!");
                                break;
                            case 6:
                                for (Locales loc : locales) {
                                    System.out.println("[" + locales.indexOf(loc) + "] "+loc);
                                }
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
                            System.out.println("Su balance es de: Lps. "+ clientes.get(poscliente).getDinero());
                            System.out.println("Ingrese la posicion del articulo que desea comprar: ");
                            int compra = entrada.nextInt();
                            if ((clientes.get(poscliente).getDinero() - locales.get(posi).getProductos().get(compra).getPrecio()) < 0) {
                                System.out.println("Sus fondos son insuficientes para completar esta compra");
                            } else {
                                clientes.get(poscliente).getComprados().add(locales.get(posi).getProductos().get(compra));
                                clientes.get(poscliente).setDinero(clientes.get(poscliente).getDinero() - locales.get(posi).getProductos().get(compra).getPrecio());
                                System.out.println("El articulo fue comprado con exito!");
                                if(locales.get(posi).getContador()==5){
                                    facturacion.add(locales.get(posi));
                                }else{
                                   locales.get(posi).setContador(locales.get(posi).getContador() + 1);
                                }
                                System.out.println("Su dinero restante es: Lps. "+ clientes.get(poscliente).getDinero());
                            }
                        } else {

                        }
                        System.out.println("Gracias por visitarnos, vuelva pronto!");
                    } else {
                        System.out.println("No se ha ingresado sesion todavia");
                    }
                    System.out.println();
                    break;
                case 5:
                    System.out.println("Se cerro sesion con exito!");
                    admin = false;
                    cliente = false;
                    System.out.println();
                    break;
                case 6:
                    for (Locales l : facturacion) {
                        System.out.println("[" + facturacion.indexOf(l) + "] "+l);
                    }
                case 7:
                    System.exit(0);
                    break;
            }
        }
    }

}
