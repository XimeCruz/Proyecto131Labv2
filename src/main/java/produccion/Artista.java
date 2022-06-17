/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package produccion;

import java.io.Serializable;

/**
 *
 * @author Alan Apaza
 */
public class Artista extends Persona implements Serializable {

    private String tipo;

    public Artista() {

    }

    public Artista(int ci, String nombre, String apellido, String genero, String tipo) {
        super(ci, nombre, apellido, genero);
        this.tipo = null;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    void mostrar(){
        super.mostrar();
        System.out.println("tipo : "+tipo);
    }
}
