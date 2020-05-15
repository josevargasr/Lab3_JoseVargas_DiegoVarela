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
public class Quiosco extends Locales {

    private ArrayList<Ropa> ropa = new ArrayList();
    private ArrayList<Juguetes> juguetes = new ArrayList();

    public Quiosco(String nombre, Empleados gerente) {
        super(nombre, gerente);
    }

    public ArrayList<Ropa> getRopa() {
        return ropa;
    }

    public void setRopa(ArrayList<Ropa> ropa) {
        this.ropa = ropa;
    }

    public ArrayList<Juguetes> getJuguetes() {
        return juguetes;
    }

    public void setJuguetes(ArrayList<Juguetes> juguetes) {
        this.juguetes = juguetes;
    }


}
