/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estruc.produccion;

import java.io.Serializable;

/**
 *
 * @author Ximena Cruz
 */
public class NodoP implements Serializable{
    
    private Produccion produccion;
    private NodoP sig;

    public NodoP() {
       sig=null;
    }

    public Produccion getProduccion() {
        return produccion;
    }

    public void setProduccion(Produccion produccion) {
        this.produccion = produccion;
    }

    public NodoP getSig() {
        return sig;
    }

    public void setSig(NodoP sig) {
        this.sig = sig;
    }
    
    
    
}
