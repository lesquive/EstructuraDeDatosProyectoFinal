/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.estructuradedatosproyectofinal;

/**
 *
 * @author Alejandro
 */

//Clase donde generamos el numero aleatorio para el codigo de cada persona votante

public class NumeroAleatorio {
    public static int NumeroAleatorio(){
        
        int min = 1000;
        int max = 9999;

 

        //Genere un valor int aleatorio de 1000 a 9999
        //https://www.educative.io/edpresso/how-to-generate-random-numbers-in-java
        int random_int = (int)Math.floor(Math.random()*(max-min+1)+min);
        return random_int;
        
    }
}
