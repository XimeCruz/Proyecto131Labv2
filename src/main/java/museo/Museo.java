/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package museo;

import estructuras.Listas.LSNormal;
import java.io.Serializable;

/**
 *
 * @author Jeloska Chavez
 */
public class Museo implements Serializable{

    private String nombre, tipo, direccion, circuito, id;
    private LSNormal listaSalas;

    public Museo() {
        nombre = null;
        tipo = null;
        direccion = null;
        circuito = null;
        id = null;
    }

    public Museo(String nombre, String tipo, String direccion, String circuito, String id) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.direccion = direccion;
        this.circuito = circuito;
        this.id = id;
        this.listaSalas = new LSNormal();
    }

    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCircuito() {
        return circuito;
    }

    public void setCircuito(String circuito) {
        this.circuito = circuito;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LSNormal getListaSalas() {
        return listaSalas;
    }

    public void setListaSalas(LSNormal listaSalas) {
        this.listaSalas = listaSalas;
    }
    
    

}
