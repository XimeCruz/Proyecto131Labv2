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
public class Persona implements Serializable {

    protected int ci;
    protected String nombre, apellido, genero;

    public Persona() {
        nombre = null;
        apellido = null;
        genero = null;
    }

    public Persona(int ci, String nombre, String apellido, String genero) {
        this.ci = ci;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
    }

    public int getCi() {
        return ci;
    }

    public void setCi(int ci) {
        this.ci = ci;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    void mostrar(){
        System.out.println("ci: "+ci+" nombre: "+nombre+" apellido: "+apellido+" genero: "+genero);
    }
}
