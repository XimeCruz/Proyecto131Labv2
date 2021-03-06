/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estruc.museo;

import estruc.sala.LSSala;
import java.io.Serializable;

/**
 *
 * @author Jeloska Chavez
 */
public class Museo implements Serializable{

    private String nombre, tipo, direccion, circuito, id;
    private LSSala listaSalas;

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
        this.listaSalas = new LSSala();
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

    public LSSala getListaSalas() {
        return listaSalas;
    }

    public void setListaSalas(LSSala listaSalas) {
        this.listaSalas = listaSalas;
    }
    
    public void mostrar() {
        System.out.println("--------|Museo|----------");
        System.out.printf("Nombre: %s, Tipo: %s, Direccion:  %s, Circuito:  %s, Id:  %s \n", nombre, tipo, direccion,circuito,id);
        System.out.println("Salas: ");
        listaSalas.mostrar();
    }
    
    

}
