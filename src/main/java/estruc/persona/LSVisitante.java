/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estruc.persona;

import java.io.Serializable;

/**
 *
 * @author PC-01
 */
public class LSVisitante implements Serializable{

    private NodoV p;

    public LSVisitante() {
        p = null;
    }

    public NodoV getP() {
        return p;
    }

    public void setP(NodoV p) {
        this.p = p;
    }

    public void adiFinal(Visitante t) {
        NodoV nue = new NodoV();
        nue.setDato(t);
        if (getP() == null) {
            setP(nue);
        } else {
            NodoV q = getP();
            while (q.getSig() != null) {
                q = q.getSig();
            }
            q.setSig(nue);
        }
    }

    public void mostrar() {
        NodoV q = getP();
        System.out.println("Lista de Turistas");
        if (q != null) {
            while (q != null) {
                q.getDato().mostrar();
                q = q.getSig();
            }
        } else {
            System.out.println("Lista vacia");
        }
    }
    public NodoV eliFinal() {
        NodoV q = getP();
        if (q != null) {
            if (q.getSig() == null) {
                setP(null);
            } else {
                NodoV r = getP();
                while (q.getSig() != null) {
                    r = q;
                    q = q.getSig();
                }
                r.setSig(null);
            }
        }
        return q;
    }
    public int nroNodos(){
        int c = 0;
        NodoV q = getP();
        while(q != null){
            c++;
            q = q.getSig();
        }
        return c;
    }
}