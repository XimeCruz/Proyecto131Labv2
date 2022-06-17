/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estruc.sala;

import estruc.produccion.LSProduccion;

/**
 *
 * @author Ximena Cruz
 */
public class Sala {
    
    private String idSala;
    private String nombre;
    private int capacidad;
    private LSProduccion listaProducciones;
    

    public Sala(String nombre, String idSala, int capacidad) {
        this.nombre = nombre;
        this.idSala = idSala;
        this.capacidad = capacidad;
        this.listaProducciones = new LSProduccion();
    }

   
    public Sala(){
        nombre = null;
        idSala = null;
        capacidad = -1;
        listaProducciones = new LSProduccion();
    }


    public String getIdSala() {
        return idSala;
    }

    public void setIdSala(String idSala) {
        this.idSala = idSala;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public LSProduccion getListaProducciones() {
        return listaProducciones;
    }

    public void setListaProducciones(LSProduccion listaProducciones) {
        this.listaProducciones = listaProducciones;
    }
    
    /*public void mostrar() {
        System.out.println("--------|Sala|----------");
        System.out.printf("idSala: %s, nombre: %s, capacidad %s \n", idSala,nombre,capacidad);
        listaProducciones.mostrar();
    }*/
    
}
