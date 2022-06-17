/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estruc.persona;

import java.io.Serializable;

/**
 *
 * @author Alan Apaza
 */
public class NodoV implements Serializable{
    
    Visitante Dato;
    NodoV Sig;

    NodoV() {
        Sig = null;// estado inicial de un nodo
    }

    public Visitante getDato() {
        return Dato;
    }

    public void setDato(Visitante dato) {
        Dato = dato;
    }

    public NodoV getSig() {
        return Sig;
    }

    public void setSig(NodoV sig) {
        Sig = sig;
    }
}
