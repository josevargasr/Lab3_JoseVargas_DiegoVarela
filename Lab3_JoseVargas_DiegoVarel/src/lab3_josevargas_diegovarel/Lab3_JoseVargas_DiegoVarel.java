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
        ArrayList<Locales> locales = new ArrayList();
        ArrayList<Clientes> clientes = new ArrayList();
        boolean valid = true;
        while(valid){
            System.out.println("----Shopping Mall----\n"
                    + "1]Sign up\n"
                    + "2]Login\n"
                    + "3]Opciones de Administrador\n"
                    + "4]Shop\n"
                    + "Ingrese una opcion: ");
            int opcion = entrada.nextInt();
            switch(opcion){
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
                    clientes.add(new Clientes(dinero, id, username,  contraseña,  correo,  nombre, new Date()));
                    System.out.println("El usuario fue creado con exito!");
                    System.out.println("");
                    break;
                case 2:
                    System.out.println("Ingrese el username: ");
                    String user = entrada.next();
                    System.out.println("Ingrese la contraseña: ");
                    String pass = entrada.next();
                    if(user.equals("admin")&& pass.equals("claudia99")){
                        System.out.println("Se ingreso sesion correctamente como administrador!");
                        admin = true;
                    }else{
                        for(int i = 0; i < clientes.size(); i++){
                            if(user.equals(clientes.get(i).getUsername()) && pass.equals(clientes.get(i).getContraseña())){
                                System.out.println("Se inicio sesion correctamente!");
                                cliente = true;
                                break;
                            }
                        }
                        if(cliente){
                            
                        }else{
                            System.out.println("El usuario o contraseña es incorrecto");
                        }
                    }
                    System.out.println();
                    break;
                case 3:
                    if(admin){
                        System.out.println("1] Agregar Local\n"
                                + "2] Agregar Empleados\n"
                                + "3] Agregar Productos\n"
                                + "4] Modificar Algo\n"
                                + "5] Eliminar Algo\n"
                                + "Ingrese la opcion que desea: ");
                        int opcion2 = entrada.nextInt();
                        switch(opcion2){
                            case 1:
                                System.out.println("1] Tienda\n"
                                        + "2] Quiosco\n"
                                        + "3] Bar\n"
                                        + "Ingrese un local para agregar: ");
                                int opcion3 = entrada.nextInt();
                                String nom ;
                                if(opcion3 == 1){
                                    System.out.println("Ingrese el nombre de la tienda: ");
                                    nom = entrada.next();
                                    locales.add(new Tiendas(nom));
                                }else if(opcion3 == 2){
                                    for (Object o : locales) {
                                        if(o instanceof Tiendas){
                                            System.out.println("[" + (locales.indexOf(o)) + "] " + o);
                                        }
                                    }
                                    System.out.println("Ingrese la posicion de la tienda de la cual quiere hacer un quiosco: ");
                                    int pos = entrada.nextInt();
                                    locales.add(new Quiosco(locales.get(pos).getNombre()));
                                }else{
                                    System.out.println("Ingrese el nombre del bar: ");
                                    nom = entrada.next();
                                    locales.add(new Bares(nom));
                                }
                                System.out.println("Se agrego el local con exito!");
                                System.out.println();
                                break;
                            case 2:
                                
                                break;
                            case 3:
                                break;
                            case 4:
                                break;
                            case 5:
                                break;
                        }
                    }else{
                        System.out.println("No se ha ingresado sesion como administrador");
                    }
                    System.out.println();
                    break;
                case 4:
                    if(cliente){
                        
                    }else{
                        System.out.println("No se ha ingresado sesion todavia");
                    }
                    System.out.println();
                    break;
                
            }
        }
    }
    
}
