/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package museo;

import estructuras.Listas.LDNormal;
import java.io.Serializable;


/**
 *
 * @author Jeloska Chavez
 */
public class Sala implements Serializable{
    private String nombre, idSala;
    private int capacidad;
    private LDNormal listaProducciones;
    
    public Sala(){
        nombre = null;
        idSala = null;
        capacidad = -1;
        listaProducciones = new LDNormal();
    }

    public Sala(String nombre, String idSala, int capacidad) {
        this.nombre = nombre;
        this.idSala = idSala;
        this.capacidad = capacidad;
        this.listaProducciones = new LDNormal();
    }

    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdSala() {
        return idSala;
    }

    public void setIdSala(String idSala) {
        this.idSala = idSala;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public LDNormal getListaProducciones() {
        return listaProducciones;
    }

    public void setListaProducciones(LDNormal listaProducciones) {
        this.listaProducciones = listaProducciones;
    }
    
    
    
    
    
}
