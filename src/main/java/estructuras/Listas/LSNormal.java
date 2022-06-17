/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras.Listas;

/**
 *
 * @author Jeloska Chavez
 */
public class LSNormal extends LSimple {

    public LSNormal() {
        super();
    }

    public boolean esVacia() {
        return (super.esVacia());
    }

    public NodoS getCabecera() {
        return p;
    }

    public void setCabecera(NodoS q) {
        p = q;
    }

    public void adiFin(Object da) {
        NodoS x, u;
        x = new NodoS();
        x.setDato(da);
        if (esVacia()) {
            p = x;
        } else {
            u = p;
            while (u.getSig() != null) {
                u = u.getSig();
            }
            u.setSig(x);
        }
    }

    public void adiPrimero(Object da) {
        NodoS y;
        y = new NodoS();
        y.setDato(da);
        y.setSig(p);
        p = y;
    }

    public Object eliFin() {
        NodoS au = null, y, u;
        Object Da = null;
        if (esVacia()) {
            System.out.println("Lista vacia");
        } else {
            u = p;
            while (u.getSig() != null) {
                au = u;
                u = u.getSig();
            }
            Da = u.getDato();
            if (p == u) {
                p = null;
            } else {
                au.setSig(null);
            }
        }
        return Da;
    }

    public int nElem() {
        NodoS x;
        int cont;
        if (esVacia()) {
            cont = 0;
        } else {
            x = p;
            cont = 1;
            while (x.getSig() != null) {
                cont++;
                x = x.getSig();
            }
        }
        return cont;
    }

    public Object eliPrimero() {
        Object da = null;
        if (!esVacia()) {
            da = p.getDato();
            p = p.getSig();
        } else {
            System.out.println("Lista vacia...");
        }
        return da;
    }

    public void mostrar() {
        NodoS y;
        if (esVacia()) {
            System.out.println("Lista vacia");
        } else {
            y = p;
            while (y != null) {
                System.out.print("\t" + y.getDato());
                y = y.getSig();
            }
        }
    }
}
