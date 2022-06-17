/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras.Listas;

/**
 *
 * @author Jeloska Chavez
 */
public class LDCircular extends LDoble {

    LDCircular() {
        super();
    }

    boolean esVacia() {
        return (super.esVacia());
    }

    NodoD getCabecera() {
        return p;
    }

    void setCabecera(NodoD q) {
        p = q;
    }

    Object eliPrimero() {
        Object dato = null;
        if (esVacia()) {
            System.out.println("Lista vacia");
        } else {
            dato = p.getDato();
            if (nElem() == 1) {
                p = null;
            } else {
                (p.getAnt()).setSig(p.getSig());
                (p.getSig()).setAnt(p.getAnt());
                p = p.getSig();
            }
        }
        return dato;
    }

    int nElem() {
        int c = 0;
        if (!esVacia()) {
            NodoD x = p;
            c = 1;
            while (x.getSig() != p) {
                x = x.getSig();
                c++;
            }
        }
        return c;
    }

    void mostrar() {
        NodoD x;
        int n, i;
        if (esVacia()) {
            System.out.println("Lista vacia");
        } else {
            n = nElem();
            x = p;
            for (i = 1; i <= n; i++) {
                System.out.println(x.getDato());
                x = x.getSig();
            }
        }
    }

    Object eliFin() {
        Object dato = null;
        NodoD u;
        if (!esVacia()) {
            u = p.getAnt();
            dato = u.getDato();
            if (u == p) {
                p = null;
            } else {
                (u.getAnt()).setSig(p);
                p.setAnt(u.getAnt());
            }

        } else {
            System.out.println("Lista vacía");
        }
        return (dato);

    }

    void adiFin(Object da) {
        NodoD x;
        x = new NodoD();
        x.setDato(da);
        if (esVacia()) {
            x.setSig(x);
            x.setAnt(x);
            p = x;
        } else {
            x.setSig(p);
            x.setAnt(p.getAnt());
            p.setAnt(x);
            (x.getAnt()).setSig(x);
        }
    }

    void adiPrimero(Object da) {
        NodoD x;
        x = new NodoD();
        x.setDato(da);
        if (esVacia()) {
            x.setSig(x);
            x.setAnt(x);
        } else {
            x.setSig(p);
            x.setAnt(p.getAnt());
            p.setAnt(x);
            (x.getAnt()).setSig(x);
        }
        p = x;
    }
}
