/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package personas;

import java.io.Serializable;

/**
 *
 * @author Jeloska Chavez
 */
public class Visitante extends Persona implements Serializable {

    private int IdTicket;

    public Visitante() {
        IdTicket = -1;
    }

    public Visitante(int ci, String nombre, String apellidos, String genero, int IdTicket) {
        super(ci, nombre, apellidos, genero);
        this.IdTicket = IdTicket;
    }

    public int getIdTicket() {
        return IdTicket;
    }

    public void setIdTicket(int IdTicket) {
        this.IdTicket = IdTicket;
    }

}
