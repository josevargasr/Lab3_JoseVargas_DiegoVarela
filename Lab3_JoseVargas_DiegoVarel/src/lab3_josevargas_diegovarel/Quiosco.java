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
public class Quiosco extends Locales{
private ArrayList<Productos>produc=new ArrayList();

    public Quiosco(String nombre) {
        super(nombre);
    }

    public ArrayList<Productos> getProduc() {
        return produc;
    }

    public void setProduc(ArrayList<Productos> produc) {
        this.produc = produc;
    }


}
