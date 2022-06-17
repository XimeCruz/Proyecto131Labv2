/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuras.Colas;

/**
 *
 * @author Jeloska Chavez
 */
public abstract class ColaSimple {

    protected int ini, fin, max;
    protected Object v[] = new Object[100];

    ColaSimple(int ca) {
        ini = 0;
        fin = 0;
        max = ca;
    }

    abstract boolean esVacia();

    abstract boolean esLlena();

    abstract void adicionar(Object ele);

    abstract Object eliminar();

    abstract void mostrar();

    abstract int nElem();

    public int getIni() {
        return ini;
    }

    public void setIni(int ini) {
        this.ini = ini;
    }

    public int getFin() {
        return fin;
    }

    public void setFin(int fin) {
        this.fin = fin;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public Object[] getV() {
        return v;
    }

    public void setV(Object[] v) {
        this.v = v;
    }

}
