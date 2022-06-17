/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras.Colas;

/**
 *
 * @author Jeloska Chavez
 */
public class CSCircular extends ColaSimple {

    CSCircular(int ca) {
        super(ca);
    }

    boolean esVacia() {
        return nElem() == 0;
    }

    boolean esLlena() {
        return nElem() == (max - 1);
    }

    void adicionar(Object x) {
        if (!esLlena()) {
            fin = (fin + 1) % max;
            v[fin] = x;
        } else {
            System.out.println("Cola llena...");
        }
    }

    Object eliminar() {
        Object x = null;
        if (!esVacia()) {
            ini = (ini + 1) % max;
            x = v[ini];
        } else {
            System.out.println("Cola vacia...");
        }
        return x;
    }

    void mostrar() {
        Object x;
        int n = nElem();
        if (!esVacia()) {
            while (n > 0) {
                x = eliminar();
                n--;
                System.out.print("\t" + x);
                adicionar(x);
            }
        } else {
            System.out.println("Cola vacia...");
        }
    }

    void vaciar(CSCircular B) {
        while (!B.esVacia()) {
            adicionar(B.eliminar());
        }
    }

    int nElem() {
        return ((fin - ini + max) % max);
    }

    boolean buscar(Object x) {
        boolean ban = false;
        Object ele;
        int n = nElem();
        while ((n > 0) && (ban == false)) {
            ele = eliminar();
            n--;
            if (x.equals(ele)) {
                ban = true;
            }
            adicionar(ele);
        }
        while (n > 0) {
            adicionar(eliminar());
            n--;
        }
        return ban;
    }

}
