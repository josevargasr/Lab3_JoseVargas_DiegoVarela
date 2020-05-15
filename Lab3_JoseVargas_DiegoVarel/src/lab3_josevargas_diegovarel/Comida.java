/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3_josevargas_diegovarel;

import java.util.Date;

/**
 *
 * @author diego
 */
public class Comida extends Productos {
    private String tipo;
    private String caducidad;

    public Comida(String tipo, String caducidad, String descripcion, String nombre, int precio) {
        super(descripcion, nombre, precio);
        this.tipo = tipo;
        this.caducidad = caducidad;
    }


    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCaducidad() {
        return caducidad;
    }

    public void setCaducidad(String caducidad) {
        this.caducidad = caducidad;
    }

   
    
}
