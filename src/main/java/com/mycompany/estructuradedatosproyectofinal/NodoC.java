/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.estructuradedatosproyectofinal;

/**
 *
 * @author lesquive
 */
public class NodoC {
    private Persona votante;
    private NodoC atras;

    public NodoC(Persona votante) {
        this.votante = votante;
        this.atras = null;
    }

    public Persona getvotante() {
        return votante;
    }

    public void setvotante(Persona votante) {
        this.votante = votante;
    }

    public NodoC getAtras() {
        return atras;
    }

    public void setAtras(NodoC atras) {
        this.atras = atras;
    }

    @Override
    public String toString() {
        return "Votante: " + votante;
    }
      
}
