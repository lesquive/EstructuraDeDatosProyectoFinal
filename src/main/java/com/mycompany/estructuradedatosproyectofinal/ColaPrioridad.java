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
public class ColaPrioridad {
    private NodoC frente;
    private NodoC ultimo;

    public NodoC getFrente() {
        return frente;
    }
    
    
    public void encola(NodoC d){
        if(frente == null){
            frente = d;
            ultimo = d;
        }else{
            ultimo.setAtras(d);
            ultimo = d;
        }
    }
    
    public NodoC atiende(){
        NodoC aux = frente;
        if (frente!=null){
            frente = frente.getAtras();
            aux.setAtras(null);
        }
        return aux;
    }
    
    public void imprimeCola(NodoC persona){
        if(persona.getAtras()==null){
            System.out.println("El nombre del votante es: " + persona.getvotante());
        }else{
            System.out.println("El nombre del votante es: " + persona.getvotante());
            imprimeCola(persona.getAtras());
        }
    }
}
