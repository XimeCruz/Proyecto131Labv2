/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras.Listas;

/**
 *
 * @author Jeloska Chavez
 */
public abstract class LDoble {

    protected NodoD p;

    LDoble() {
        p = null;
    }

    boolean esVacia() {
        return p == null;
    }

    abstract void adiFin(Object da);

    abstract void adiPrimero(Object da);

    abstract Object eliFin();

    abstract Object eliPrimero();

    abstract int nElem();

    abstract void mostrar();
    
  
}
