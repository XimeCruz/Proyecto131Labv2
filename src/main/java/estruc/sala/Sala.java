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
    
    private int idSala;
    private String nombre;
    private int capacidad;
    private LSProduccion listaProducciones;

    public Sala(int idSala, String nombre, int capacidad, LSProduccion listaProducciones) {
        this.idSala = idSala;
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.listaProducciones = listaProducciones;
    }

    public int getIdSala() {
        return idSala;
    }

    public void setIdSala(int idSala) {
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
    
    public void mostrar() {
        System.out.println("--------|Sala|----------");
        System.out.printf("idSala: %s, nombre: %s, capacidad %s \n", idSala,nombre,capacidad);
        listaProducciones.mostrar();
    }
    
}
