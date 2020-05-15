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
public class Tiendas extends Locales{
    private ArrayList<Ropa>ropa=new ArrayList();

    public Tiendas(String nombre) {
        super(nombre);
    }

    public ArrayList<Ropa> getRopa() {
        return ropa;
    }

    public void setRopa(ArrayList<Ropa> ropa) {
        this.ropa = ropa;
    }

   
    
}
