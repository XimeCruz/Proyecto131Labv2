/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras.Listas;

/**
 *
 * @author Jeloska Chavez
 */
public class NodoS {

    Object Dato;
    NodoS Sig;

    NodoS() {
        Sig = null;// estado inicial de un nodo
    }

    public Object getDato() {
        return Dato;
    }

    public void setDato(Object dato) {
        Dato = dato;
    }

    public NodoS getSig() {
        return Sig;
    }

    public void setSig(NodoS sig) {
        Sig = sig;
    }
}
