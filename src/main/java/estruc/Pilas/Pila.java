/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estruc.Pilas;

/**
 *
 * @author Jeloska Chavez
 */
public class Pila {

    private int tope, max;
    Object v[] = new Object[100];

    public Pila(int cp) {
        tope = 0;
        max = cp;
    }

    public Pila() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    boolean esLlena() {
        return tope == max;
    }

    public boolean esVacia() {
        return tope == 0;
    }

    public void adicionar(Object ele) {
        if (ele != null) {
            if (!esLlena()) {
                tope++;
                v[tope] = ele;
            } else {
                System.out.println("Pila llena");
            }
        }

    }

    public Object eliminar() {
        Object dato;
        if (!esVacia()) {
            dato = v[tope];
            tope = tope - 1;
        } else {
            //System.out.print("Pila vacia");
            dato = null;
        }
        return dato;
    }

    public void mostrar() {
        Pila aux = new Pila(max);
        Object ele;
        while (!esVacia()) {
            aux.adicionar(eliminar());
        }
        while (!aux.esVacia()) {
            ele = aux.eliminar();
            System.out.print("\t"+ele);
            adicionar(ele);
        }
    }

    public int nElem() {
        return tope;
    }

    public void vaciar(Pila B) {
        while (!B.esVacia()) {
            adicionar(B.eliminar());
        }
    }
}
