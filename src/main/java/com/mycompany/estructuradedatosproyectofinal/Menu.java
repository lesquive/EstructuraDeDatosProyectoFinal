package com.mycompany.estructuradedatosproyectofinal;

import javax.swing.JOptionPane;

/**
 * ESTUDIANTES:
 *
 * LAGUNA CONDEGA JEYSUS ADONIS ESQUIVEL BLANCO LUIS JOSE ERICK GUILLEN
 * CHAVARRIA GAMBOA GUSTAVO JOSUE
 *
 * Proyecto Final Estructura de Datos 1 Cuatrimestre 2021 Prof. ROMERO NAVARRO
 * MICHAEL
 */
public class Menu {

    public static void ejecutar() {
            
        Cola colaRegular = new Cola();
        Cola colaPrioridad = new Cola();
        Elementos opcionVotacion = new Elementos();

        boolean salir = false; //Condicional que permite al programa continuar su ejecucion. 

        while (salir == false) {

            //Menú principal con 11 opciones que permite al administrador del programa ejecutar todas las tareas disponibles. 
            String menu = "\n"
                    + "+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-\n"
                    + "|                  -MENU-                      |\n"
                    + "| 1) Ingresar Opciones para Votación           |\n"
                    + "| 2) Registrar Usuario                         |\n"
                    + "| 3) Iniciar Votación                          |\n"
                    + "| 4) Generar Resultados                        |\n"
                    + "| 5) Confirmar Voto                            |\n"
                    + "| 6) Salir                                     |\n"
                    + "+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-\n";

            System.out.println(menu);

            int opcion = Integer.parseInt(JOptionPane.showInputDialog("Escoja una opcion del 1 al 6: "));

            if (opcion > 0 && opcion <= 6) {

                switch (opcion) {

                    case 1:
                        JOptionPane.showMessageDialog(null, "Bienvenido al sistema de eleccion acontinuacion escoja\n"
                                + " la opciones por la que desea votar: ");

                        String elemento1 = JOptionPane.showInputDialog("Digite su Opcion de numero 1: ");
                        String elemento2 = JOptionPane.showInputDialog("Digite su Opcion de numero 2: ");
                        String elemento3 = JOptionPane.showInputDialog("Digite su Opcion de numero 3: ");
                        String elemento4 = JOptionPane.showInputDialog("Digite su Opcion de numero 4: ");

                        opcionVotacion = new Elementos(elemento1, elemento3, elemento3, elemento4);
                        break;

                    case 2:
                        String cedula = JOptionPane.showInputDialog("Digite la cédula de la persona.");
                        String nombre = JOptionPane.showInputDialog("Digite el nombre de la persona.");
                        String apellido = JOptionPane.showInputDialog("Digite el apellido de la persona.");
                        int edad;
                        do {
                            edad = Integer.parseInt(JOptionPane.showInputDialog("Digite la edad de la persona."));
                            if (edad < 18) {
                                JOptionPane.showMessageDialog(null, "Edad incorrecta, intente de nuevo");
                            }
                        } while (edad < 18);

                        Persona votante = new Persona(cedula, nombre, apellido, opcion);

                        int tipoUsuario;

                        if (edad >= 65) {
                            colaPrioridad.encola( new NodoC (votante));
                        } else {
                            do {
                                tipoUsuario = Integer.parseInt(JOptionPane.showInputDialog("¿La persona padece de alguna discapacidad?.\n1. Sí\n2. No"));
                                switch (tipoUsuario) {
                                    case 1:
                                        colaPrioridad.encola(new NodoC(votante));
                                        break;
                                    case 2:
                                        colaRegular.encola(new NodoC(votante));
                                        break;
                                    default:
                                        break;
                                }
                            } while (tipoUsuario != 1 || tipoUsuario != 2);
                        }

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

            } else {
                System.out.println("Porfavor ingrese un numero del 1 al 6"); //Si el Administrador del programa no escoge una opción del 1 al 6, el menu se repite.  
            }

        }

    }

}
