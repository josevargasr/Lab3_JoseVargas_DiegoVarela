/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3_josevargas_diegovarel;

/**
 *
 * @author diego
 */
public class Juguetes extends Productos{
    private String descripcion;

    public Juguetes( String descripcion, String nombre, int precio) {
        super(descripcion, nombre, precio);
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
