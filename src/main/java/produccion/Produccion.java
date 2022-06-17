/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package produccion;

import estructuras.Colas.CSNormal;
import estructuras.Listas.LSNormal;
import estructuras.Pila.Pila;
import horario.Horario;

/**
 *
 * @author Jeloska Chavez
 */
public class Produccion {

    private String nombre, tipo, fecha, hora;
    private Pila pilaVisitantes;
    private LSNormal listaArtistas;
    private int nroEntradas;//total
    private double precio;

    public Produccion() {
    }

    public Produccion(String nombre, String fecha, String hora, String tipo, int nroEntradas, double precio) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.pilaVisitantes = new Pila(nroEntradas);
        this.listaArtistas = new LSNormal();
        this.fecha = fecha;
        this.hora = hora;
        this.nroEntradas = nroEntradas;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Pila getPilaVisitantes() {
        return pilaVisitantes;
    }

    public void setPilaVisitantes(Pila pilaVisitantes) {
        this.pilaVisitantes = pilaVisitantes;
    }

    public LSNormal getListaArtistas() {
        return listaArtistas;
    }

    public void setListaArtistas(LSNormal listaArtistas) {
        this.listaArtistas = listaArtistas;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getNroEntradas() {
        return nroEntradas;
    }

    public void setNroEntradas(int nroEntradas) {
        this.nroEntradas = nroEntradas;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

}
