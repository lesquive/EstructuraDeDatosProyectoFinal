
package com.mycompany.estructuradedatosproyectofinal;

import javax.swing.JOptionPane;

public class Pila {
    private Dato top;

    public Dato getTop() {
        return top;
    }
    
    
    public void push(Dato objetoNuevo){
        objetoNuevo.setAbajo(top);
        top = objetoNuevo;
    }
    
    public Dato pop(){
        Dato auxiliar = null;
        if(PilaVacia()){
            System.out.println("La pila está vacia!");
        }else{
            auxiliar = top;
            top = top.getAbajo();
            auxiliar.setAbajo(null);
        }
        return auxiliar;
    }
    
    public boolean PilaVacia(){
        if(top == null){
            return true;
        }else{
            return false;
        }
    }
    
    public void buscaVotante(Dato nodo, int codigo){
        
        
        if(nodo != null){
            if (nodo.getCodigo() == codigo){
                JOptionPane.showMessageDialog(null, "Hola " + nodo.getNombre() + " " 
                        + nodo.getApellido() + "\nCédula: " + nodo.getCedula() 
                        + "\n\nSu voto ha sido emitido correctamente. Usted votó por: " 
                        + nodo.getVoto()); 
                
                
            } else{
                buscaVotante(nodo.getAbajo(), codigo);
            }
        }else {
            JOptionPane.showMessageDialog(null, "No se encontró su voto.");           
        }
        
    }
    
    @Override
    public String toString() {
        return "Pila{" + "top=" + top + '}';
    }
    
    
    
    
}
