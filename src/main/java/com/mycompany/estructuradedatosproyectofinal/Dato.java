
package com.mycompany.estructuradedatosproyectofinal;


public class Dato {
    private String cedula;
    private String nombre;
    private String apellido;
    private int edad;
    private int codigo;
    private String voto;
    private Dato abajo;

    public Dato(String cedula, String nombre, String apellido, int edad, int codigo, String voto) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.codigo = codigo;
        this.voto = voto;
        this.abajo = null;
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

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
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

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getVoto() {
        return voto;
    }

    public void setVoto(String voto) {
        this.voto = voto;
    }

    public Dato getAbajo() {
        return abajo;
    }

    public void setAbajo(Dato abajo) {
        this.abajo = abajo;
    }

    @Override
    public String toString() {
        return "PERSONA: El nombre de la persona es " + nombre 
                + " " + apellido + "|\n " + abajo;
    }
    
    
    
}
