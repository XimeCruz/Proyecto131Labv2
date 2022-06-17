/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras.Colas;

/**
 *
 * @author Jeloska Chavez
 */
public class CSNormal extends ColaSimple {

    public CSNormal(int ca) {
        super(ca);
    }

    boolean esVacia() {
        return (ini == 0) && (fin == 0);
    }

    boolean esLlena() {
        return fin == max;
    }

    void adicionar(Object ele) {
        if (!esLlena()) {
            if (esVacia()) {
                ini = 1;
            }
            fin = fin + 1;
            v[fin] = ele;
        } else {
            System.out.println("Cola llena");
        }

    }

    Object eliminar() {
        Object ele = null;
        if (!esVacia()) {
            ele = v[ini];
            ini = ini + 1;
            if (ini > fin) {
                ini = 0;
                fin = 0;
            }
        } else {
            System.out.println("Cola vacia");
        }

        return ele;
    }

    void mostrar() {
        Object ele;
        CSNormal aux = new CSNormal(max);
        if (!esVacia()) {
            while (!esVacia()) {
                ele = eliminar();
                System.out.print(ele);
                aux.adicionar(ele);
            }
            while (!aux.esVacia()) {
                adicionar(aux.eliminar());
            }
        } else {
            System.out.println("Cola vacia");
        }
    }

    int nElem() {
        if (!esVacia()) {
            return (fin - ini + 1);
        }
        return 0;
    }

    void vaciar(CSNormal b) {
        while (!b.esVacia()) {
            adicionar(b.eliminar());
        }
    }

}
