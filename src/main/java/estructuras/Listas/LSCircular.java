/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras.Listas;

/**
 *
 * @author Jeloska Chavez
 */
public class LSCircular extends LSimple {

    LSCircular() {
        super();
    }

    public boolean esVacia() {
        return (super.esVacia());
    }

    NodoS getCabecera() {
        return p;
    }

    void setCabecera(NodoS q) {
        p = q;
    }

    void mostrar() {
        NodoS x;
        if (!esVacia()) {
            x = p;
            while (x.getSig() != p) {
                System.out.print("\t" + x.getDato());
                x = x.getSig();
            }
            System.out.print("\t" + x.getDato());
        } else {
            System.out.println("Lista vacia...");
        }
    }

    void adiFin(Object da) {
        NodoS au, u;
        NodoS z = new NodoS();
        z.setDato(da);
        if (esVacia()) {
            z.setSig(z);
            p = z;
        } else {
            u = p;
            while (u.getSig() != p) {
                u = u.getSig();
            }
            u.setSig(z);
            z.setSig(p);
        }
    }

    void adiPrimero(Object da) {
        NodoS z, u, au = null;
        z = new NodoS();
        z.setDato(da);
        if (esVacia()) {
            z.setSig(z);
        } else {
            z.setSig(p);
            u = p;
            while (u.getSig() != p) {
                u = u.getSig();
            }
            u.setSig(z);
        }
        p = z;
    }

    Object eliFin() {
        NodoS u, au = null;
        Object da = null;
        if (!esVacia()) {
            u = p;
            while (u.getSig() != p) {
                au = u;
                u = u.getSig();
            }
            da = u.getDato();
            if (u == p) {
                p = null;
            } else {
                au.setSig(p);
            }
        } else {
            System.out.println("Lista vacia...");
        }
        return da;
    }

    Object eliPrimero() {
        NodoS u, ap = null;
        Object da = null;
        if (!esVacia()) {
            da = p.getDato();
            u = p;
            while (u.getSig() != p) {
                u = u.getSig();
            }
            if (u == p) {
                p = null;
            } else {
                ap = p;
                p = p.getSig();
                ap.setSig(null);
                u.setSig(p);
                ap = null;
            }
        } else {
            System.out.println("Lista vacia...");
        }
        return da;
    }

    int nElem() {
        NodoS x = null;
        int c = 0;
        if (!esVacia()) {
            x = p;
        }
        c = 1;
        while (x.getSig() != p) {
            c++;
            x = x.getSig();
        }
        return c;
    }
    
}

