
package com.mycompany.estructuradedatosproyectofinal;

import javax.swing.JOptionPane;

/**
 * ESTUDIANTES:
 * 
 * LAGUNA CONDEGA JEYSUS ADONIS 
 * ESQUIVEL BLANCO LUIS JOSE
 * ERICK GUILLEN
 * CHAVARRIA GAMBOA GUSTAVO JOSUE
 * 
 * Proyecto Final Estructura de Datos
 * 1 Cuatrimestre 2021
 * Prof. ROMERO NAVARRO MICHAEL
 */

public class Menu {
    
    public static void ejecutar (){
    
        boolean salir = false; //Condicional que permite al programa continuar su ejecucion. 
        
        while (salir == false){
        
            //Menú principal con 11 opciones que permite al administrador del programa ejecutar todas las tareas disponibles. 
            
            String menu = "\n"+
                          "+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-\n" +
                          "|                  -MENU-                      |\n" +
                          "| 1) Ingresar Opciones para Votación           |\n" +
                          "| 2) Registrar Usuario                         |\n" +
                          "| 3) Iniciar Votación                          |\n" +
                          "| 4) Generar Resultados                        |\n" +
                          "| 5) Confirmar Voto                            |\n" +
                          "| 6) Salir                                     |\n" +
                          "+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-\n";
        
            System.out.println(menu);
            
            int opcion = Integer.parseInt(JOptionPane.showInputDialog("Escoja una opcion del 1 al 6: "));
            
            if (opcion > 0 && opcion <= 6){
            
            
                switch (opcion){
                
                case 1:
                
                    break;
                    
                case 2:
                
                    break;
                    
                case 3:
                
                    break;
                    
                case 4:
                
                    break;
                    
                case 5:
                
                    break;
                
                case 6:

                    //Se Utiliza el case 11 cuando se finaliza el programa.  
                    //La variable global salir cambia a true, y termina el while loop.  

                    System.out.println("El Programa ha terminado.");
                    System.out.println("");
                    salir = true;
                    break;  
                
                }
            
            }else {
                System.out.println("Porfavor ingrese un numero del 1 al 6"); //Si el Administrador del programa no escoge una opción del 1 al 6, el menu se repite.  
                    }
        
        }
    
    
    }
    
}
