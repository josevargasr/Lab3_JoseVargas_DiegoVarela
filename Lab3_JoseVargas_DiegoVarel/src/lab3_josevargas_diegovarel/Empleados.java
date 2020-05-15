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
public class Empleados extends Personas {
    private String horario;
    private ArrayList<Productos> vendidos=new ArrayList();

    public Empleados(String horario, int Id, String username, String contraseña, String correo, String nombre, String nacimiento) {
        super(Id, username, contraseña, correo, nombre, nacimiento);
        this.horario = horario;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public ArrayList<Productos> getVendidos() {
        return vendidos;
    }

    public void setVendidos(ArrayList<Productos> vendidos) {
        this.vendidos = vendidos;
    }
    
}
