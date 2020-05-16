/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3_josevargas_diegovarel;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author diego
 */
public class Clientes extends Personas {
    private int dinero;
    private ArrayList<Productos>comprados=new ArrayList();

    public Clientes(int dinero, int Id, String username, String contraseña, String correo, String nombre, Date nacimiento) {
        super(Id, username, contraseña, correo, nombre, nacimiento);
        this.dinero = dinero;
    }

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    public ArrayList<Productos> getComprados() {
        return comprados;
    }

    public void setComprados(ArrayList<Productos> comprados) {
        this.comprados = comprados;
    }
    
}
