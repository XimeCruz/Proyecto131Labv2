/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras.Listas;

/**
 *
 * @author Jeloska Chavez
 */
public class NodoD {

    private NodoD Ant, Sig;
    private Object Dato;

    NodoD() {
        Ant = null;
        Sig = null;
    }

    public NodoD getAnt() {
        return Ant;
    }

    public void setAnt(NodoD ant) {
        Ant = ant;
    }

    public NodoD getSig() {
        return Sig;
    }

    public void setSig(NodoD sig) {
        Sig = sig;
    }

    public Object getDato() {
        return Dato;
    }

    public void setDato(Object dato) {
        Dato = dato;
    }
}
