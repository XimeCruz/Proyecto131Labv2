/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package museo;
import java.io.Serializable;

/**
 *
 * @author W10
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

    public void adiFinal(Viaje v) {
        NodoV nue = new NodoV();
        nue.setViaje(v);
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
        System.out.println("---------- Lista de Museos ---------------");
        if (q != null) {
            while (q != null) {
                q.getViaje().mostrar();
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
