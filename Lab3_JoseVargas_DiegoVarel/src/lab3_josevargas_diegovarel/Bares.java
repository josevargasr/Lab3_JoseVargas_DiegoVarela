/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3_josevargas_diegovarel;

import java.util.ArrayList;

/**
 *
 * @author diego
 */
public class Bares extends Locales {
    private ArrayList<Empleados>empleados=new ArrayList();
    private ArrayList<Productos> productos=new ArrayList();

    public Bares(String nombre) {
        super(nombre);
    }

    public ArrayList<Empleados> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArrayList<Empleados> empleados) {
        this.empleados = empleados;
    }

    public ArrayList<Productos> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Productos> productos) {
        this.productos = productos;
    }
    
}
