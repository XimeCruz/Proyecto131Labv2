/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estruc.sala;

/**
 *
 * @author Ximena Cruz
 */
public class NodoS {
    
    private Sala sala;
    private NodoS sig;

    public NodoS() {
       sig=null;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public NodoS getSig() {
        return sig;
    }

    public void setSig(NodoS sig) {
        this.sig = sig;
    }
    
    
    
}
