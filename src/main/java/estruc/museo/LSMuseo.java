/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package estruc.museo;
import java.io.Serializable;

/**
 *
 * @author Ximena Cruz
 */
public class LSMuseo implements Serializable{

    private NodoM p;

    public LSMuseo() {
        p = null;
    }

    public NodoM getP() {
        return p;
    }

    public void setP(NodoM p) {
        this.p = p;
    }

    public void adiFinal(Museo m) {
        NodoM nue = new NodoM();
        nue.setMuseo(m);
        if (getP() == null) {
            setP(nue);
        } else {
            NodoM q = getP();
            while (q.getSig() != null) {
                q = q.getSig();
            }
            q.setSig(nue);
        }
    }

    /*public void mostrar() {
        NodoM q = getP();
        System.out.println("---------- Lista de Museos ---------------");
        if (q != null) {
            while (q != null) {
                q.getMuseo().mostrar();
                q = q.getSig();
            }
        } else {
            System.out.println("Lista vacia");
        }
    }*/

    public NodoM eliFinal() {
        NodoM q = getP();
        if (q != null) {
            if (q.getSig() == null) {
                setP(null);
            } else {
                NodoM r = getP();
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
        NodoM q = getP();
        while(q != null){
            c++;
            q = q.getSig();
        }
        return c;
    }
}
