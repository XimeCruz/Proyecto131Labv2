/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estruc.produccion;

/**
 *
 * @author Ximena Cruz
 */
public class LSProduccion {
    private NodoP p;

    public LSProduccion() {
        p = null;
    }

    public NodoP getP() {
        return p;
    }

    public void setP(NodoP p) {
        this.p = p;
    }

    public void adiFinal(Produccion p) {
        NodoP nue = new NodoP();
        nue.setProduccion(p);
        if (getP() == null) {
            setP(nue);
        } else {
            NodoP q = getP();
            while (q.getSig() != null) {
                q = q.getSig();
            }
            q.setSig(nue);
        }
    }

    public void mostrar() {
        NodoP q = getP();
        System.out.println("---------- Lista de Producciones ---------------");
        if (q != null) {
            while (q != null) {
                q.getProduccion().mostrar();
                q = q.getSig();
            }
        } else {
            System.out.println("Lista vacia");
        }
    }

    public NodoP eliFinal() {
        NodoP q = getP();
        if (q != null) {
            if (q.getSig() == null) {
                setP(null);
            } else {
                NodoP r = getP();
                while (q.getSig() != null) {
                    r = q;
                    q = q.getSig();
                }
                r.setSig(null);
            }
        }
        return q;
    }

    public int nroNodos() {
        int c = 0;
        NodoP q = getP();
        while (q != null) {
            c++;
            q = q.getSig();
        }
        return c;
    }
	
}
