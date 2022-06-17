/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package produccion;

/**
 *
 * @author PC-01
 */

import java.io.Serializable;

/**
 *
 * @author Alan Apaza
 */
public class LSArtista implements Serializable{

    private NodoA p;

    public LSArtista() {
        p = null;
    }

    public NodoA getP() {
        return p;
    }

    public void setP(NodoA p) {
        this.p = p;
    }

    public void adiFinal(Artista t) {
        NodoA nue = new NodoA();
        nue.setDato(t);
        if (getP() == null) {
            setP(nue);
        } else {
            NodoA q = getP();
            while (q.getSig() != null) {
                q = q.getSig();
            }
            q.setSig(nue);
        }
    }

    public void mostrar() {
        NodoA q = getP();
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
    public NodoA eliFinal() {
        NodoA q = getP();
        if (q != null) {
            if (q.getSig() == null) {
                setP(null);
            } else {
                NodoA r = getP();
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
        NodoA q = getP();
        while(q != null){
            c++;
            q = q.getSig();
        }
        return c;
    }
}