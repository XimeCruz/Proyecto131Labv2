/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estruc.produccion;

import produccion.LSArtista;
import produccion.LSVisitante;

/**
 *
 * @author Ximena Cruz
 */
public class Produccion {
    
    private String nombre, tipo, fecha, hora;
    private LSVisitante listaVisitantes;
    private LSArtista listaArtistas;
    private int nroEntradas;//total
    private double precio;

    public Produccion(String nombre, String tipo, String fecha, String hora, LSVisitante listaVisitantes, LSArtista listaArtistas, int nroEntradas, double precio) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.fecha = fecha;
        this.hora = hora;
        this.listaVisitantes = listaVisitantes;
        this.listaArtistas = listaArtistas;
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

    public LSVisitante getListaVisitantes() {
        return listaVisitantes;
    }

    public void setListaVisitantes(LSVisitante listaVisitantes) {
        this.listaVisitantes = listaVisitantes;
    }

    public LSArtista getListaArtistas() {
        return listaArtistas;
    }

    public void setListaArtistas(LSArtista listaArtistas) {
        this.listaArtistas = listaArtistas;
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
    
     public void mostrar() {
        System.out.println("--------|Produccion|----------");
        System.out.printf("nombre: %s, tipo: %s, fecha: %s, hora: %s, nroEntradas: %s, precio: %s \n", nombre, tipo,fecha,hora,nroEntradas,precio);
        System.out.println("");
        listaArtistas.mostrar();
        listaVisitantes.mostrar();
    }
    
    
}
