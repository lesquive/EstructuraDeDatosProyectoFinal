/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.estructuradedatosproyectofinal;

/**
 *
 * @author Alegu
 */

//Clase persona definimos las propiedades de la clase persona y en la muy importante 
//en la parte de set codigo se llama a metodo numero aleatorio para asignarle su codigo

public class Persona {

    private String cedula;
    private String nombre;
    private String apellido;
    private int edad;
    private int codigo;

    public Persona(String cedula, String nombre, String apellido, int edad) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        setCodigo();
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo() {
        int codigoNuevo = NumeroAleatorio.NumeroAleatorio();
        this.codigo = codigoNuevo;
    }

}
