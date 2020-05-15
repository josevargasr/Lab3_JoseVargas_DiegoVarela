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
public class Locales {
 private String nombre;
 private ArrayList<Empleados>empleados=new ArrayList();
 private ArrayList<Productos>productos=new ArrayList();
 private Empleados gerente;

    public Locales(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    public Empleados getGerente() {
        return gerente;
    }

    public void setGerente(Empleados gerente) {
        this.gerente = gerente;
    }

    @Override
    public String toString() {
        return "Locales{" + "nombre=" + nombre + '}';
    }
 
}
