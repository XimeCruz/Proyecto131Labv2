/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras.Listas;

/**
 *
 * @author Jeloska Chavez
 */
public class LDNormal extends LDoble {

    public LDNormal() {
        super();
    }

    public boolean esVacia() {
        return super.esVacia();
    }


    public void adiFin(Object da) {
        NodoD x, z;
        z = new NodoD();
        z.setDato(da);
        if (esVacia()) {
            p = z;
        } else {
            x = p;
            while (x.getSig() != null) {
                x = x.getSig();
            }
            z.setAnt(x);
            x.setSig(z);
        }
    }

    public void adiPrimero(Object da) {
        NodoD x, z;
        z = new NodoD();
        z.setDato(da);
        if (!esVacia()) {
            z.setSig(p);
            p.setAnt(z);
        }
        p = z;
    }

    public Object eliPrimero() {
        Object da = null;
        if (esVacia()) {
            System.out.println("Lista vacia...");
        } else {
            da = p.getDato();
            if (p.getSig() != null) {
                p = p.getSig();
                p.setAnt(null);
            } else {
                p = null;
            }
        }
        return da;
    }

    public Object eliFin() {
        Object da = null;
        NodoD r;
        if (esVacia()) {
            System.out.print("Lista vacia...");
        } else {
            r = p;
            while (r.getSig() != null) {
                r = r.getSig();
            }
            da = r.getDato();
            if (r == p) {
                p = null;
            } else {
                (r.getAnt()).setSig(null);
            }
        }
        return da;
    }

    public int nElem() {
        NodoD x;
        int i = 0;
        if (!esVacia()) {
            i = 1;
            x = p;
            while (x.getSig() != null) {
                x = x.getSig();
                i++;
            }
        }
        return i;
    }

    public void mostrar() {
        NodoD x;
        int ne, i;
        if (!esVacia()) {
            x = p;
            while (x != null) {
                System.out.print(x.getDato() + "\t");
                x = x.getSig();
            }
        } else {
            System.out.println("lista vacia...");
        }
    }

    public NodoD getP() {
        return p;
    }

    public void setP(NodoD p) {
        this.p = p;
    }
    
    



}
