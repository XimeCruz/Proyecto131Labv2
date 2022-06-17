/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estruc.sala;

/**
 *
 * @author Ximena Cruz
 */
public class LSSala {
    
    private NodoS p;

    public LSSala() {
        p = null;
    }

    public NodoS getP() {
        return p;
    }

    public void setP(NodoS p) {
        this.p = p;
    }

    public void adiFinal(Sala s) {
        NodoS nue = new NodoS();
        nue.setSala(s);
        if (getP() == null) {
            setP(nue);
        } else {
            NodoS q = getP();
            while (q.getSig() != null) {
                q = q.getSig();
            }
            q.setSig(nue);
        }
    }

    /*public void mostrar() {
        NodoS q = getP();
        System.out.println("---------- Lista de Salas ---------------");
        if (q != null) {
            while (q != null) {
                q.getSala().mostrar();
                q = q.getSig();
            }
        } else {
            System.out.println("Lista vacia");
        }
    }*/

    public NodoS eliFinal() {
        NodoS q = getP();
        if (q != null) {
            if (q.getSig() == null) {
                setP(null);
            } else {
                NodoS r = getP();
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
        NodoS q = getP();
        while (q != null) {
            c++;
            q = q.getSig();
        }
        return c;
    }
}
