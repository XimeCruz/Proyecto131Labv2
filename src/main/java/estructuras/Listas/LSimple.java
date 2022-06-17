/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras.Listas;

/**
 *
 * @author Jeloska Chavez
 */
public abstract class LSimple {

    protected NodoS p;

    LSimple() {
        p = null;
    }

    public boolean esVacia() {
        return p == null;
    }

    abstract int nElem();

    abstract void adiFin(Object dato);

    abstract void adiPrimero(Object dato);

    abstract Object eliFin();

    abstract Object eliPrimero();

    abstract void mostrar();
}
