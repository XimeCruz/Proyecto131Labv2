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
public class NodoM implements Serializable{
    private Museo museo;
    private NodoM sig;
    public NodoM(){
        sig = null;
    }

    public Museo getMuseo() {
        return museo;
    }

    public void setMuseo(Museo museo) {
        this.museo = museo;
    }

    public NodoM getSig() {
        return sig;
    }

    public void setSig(NodoM sig) {
        this.sig = sig;
    }
    
}
