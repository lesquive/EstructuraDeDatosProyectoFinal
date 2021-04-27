package com.mycompany.estructuradedatosproyectofinal;

import javax.swing.JOptionPane;
import java.util.Arrays;

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
        Pila pilaAtentidos = new Pila();
        Elementos opcionVotacion[] = null;
        int contadorOpcionVotacion[] = null;
        String opcionesVotacion = "";
        boolean codigoAsertado = false;

        boolean salir = false; //Condicional que permite al programa continuar su ejecucion. 

        while (salir == false) {

//Menú principal con 6 opciones que permite al administrador del programa 
//ejecutar todas las tareas disponibles. 
            String menu
                    = "MENU\n"
                    + "1) Ingresar Opciones para Votación           \n"
                    + "2) Registrar Votante                         \n"
                    + "3) Iniciar Votación                          \n"
                    + "4) Generar Resultados                        \n"
                    + "5) Confirmar Voto                            \n"
                    + "6) Salir                                     \n";

            try {
                int opcion = Integer.parseInt(JOptionPane.showInputDialog(menu + "\nEscoja una opcion del 1 al 6: "));
//El menu de 6 opciones dentro del While 
                if (opcion > 0 && opcion <= 6) {

                    switch (opcion) {

                        case 1:

                            String elemento;
                            JOptionPane.showMessageDialog(null, "Bienvenido al sistema de eleccion.\nA continuación escoja la opciones por la que desea votar: ");

                            try {

                                int elementosVotacion = Integer.parseInt(JOptionPane.showInputDialog("Digite la cantidad de elementos de votación que desea: "));
//Definimos las opciones por las cuales el usuario desea votar
                                opcionVotacion = new Elementos[elementosVotacion];
                                contadorOpcionVotacion = new int [elementosVotacion];
//Le enviamos al arreglo la cantidad de opciones de votacion que tendra este arreglo
//y agregamos un arreglo donde podamos almacenar la cantidad de votos de cada elemento
                                for (int i = 0; i < opcionVotacion.length; i++) {
                                    contadorOpcionVotacion[i] = 0;
                                    elemento = JOptionPane.showInputDialog("Digite su opción número " + (i + 1) + " : ");
                                    opcionesVotacion += (i + 1) + "." + elemento + "\n";
                                    opcionVotacion[i] = new Elementos(elemento);
//Le damos Nombre a cada elemento de votacion con un ciclo 
//Dependiendo de la cantidad que se haya digitado antes 
                                }

                            } catch (Exception e) {

                                JOptionPane.showMessageDialog(null, "Las opciones digitadas no son válidas intentelo de nuevo.");
                                Menu.ejecutar();
//con una validacion de try and catch verificamos que no haya errores en 
//el codigo ingresando los datos de votacion
                            }
                            break;

                        case 2:
                            String cedula = JOptionPane.showInputDialog("Digite la cédula de la persona.");
                            String nombre = JOptionPane.showInputDialog("Digite el nombre de la persona.");
                            String apellido = JOptionPane.showInputDialog("Digite el apellido de la persona.");
                            int edad;
//Se le pide al usuario digite sus datos personales para brindarle su codigo de votacion  
                            do {
                                edad = Integer.parseInt(JOptionPane.showInputDialog("Digite la edad de la persona."));
                                if (edad < 18) {
                                    JOptionPane.showMessageDialog(null, "Edad incorrecta, intente de nuevo");
                                }
                            } while (edad < 18);

                            Persona votante = new Persona(cedula, nombre, apellido, edad);                           
                            int codigo = votante.getCodigo();
                            
                            int tipoUsuario;
//Verificamos si el usuario es mayor de 65 años esto para 
//agregarlo a la cola prioridad en caso de ser necesario
                            if (edad >= 65) {
                                colaPrioridad.encola(new NodoC(votante));
                                JOptionPane.showMessageDialog(null, "Votante añadido a la cola de prioridad. Su codigo para votar es: " + codigo);
                            } else {
//Le preguntamos al usuario si la persona si posee alguna discapacidad para 
//agregarlo a la cola prioridad o a la cola regular                                
                                do {
                                    tipoUsuario = Integer.parseInt(JOptionPane.showInputDialog("¿La persona padece de alguna discapacidad?.\n1. Sí\n2. No"));
                                    switch (tipoUsuario) {
                                        case 1:
                                            colaPrioridad.encola(new NodoC(votante));
                                            JOptionPane.showMessageDialog(null, "Votante añadido a la cola de prioridad. El codigo para votar es: " + codigo);
                                            break;
                                        case 2:
                                            colaRegular.encola(new NodoC(votante));
                                            JOptionPane.showMessageDialog(null, "Votante añadido a la cola regular. El codigo para votar es: " + codigo);
                                            break;
                                        default:
                                            break;
//Con un while verificamos que los datos ingresados sean correctos                                              
                                    }
                                } while (tipoUsuario != 1 && tipoUsuario != 2);
                            }

                            break;

                        case 3:
                            int cuentaColaPrioridad = 0;
                            NodoC atendido = null;
                            Dato atendidoPila = null;
                            while (colaPrioridad.colaVacia() == false || colaRegular.colaVacia() == false) {
//Se inicia la votacion en la cual se iran contando los votos de las cola
                                codigoAsertado = false;

                                if (colaPrioridad.colaVacia()) {
                                    atendido = colaRegular.atiende();
//verificamos con el metodo cola vacia que la cola prioridad este 
//vacia de ser asi atendemos a alguien de la cola regular
                                    JOptionPane.showMessageDialog(null, "Atendiendo a " + atendido.getVotante().getNombre() + " " + atendido.getVotante().getApellido());
                                    int codigoIngresado = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite su código asignado para la votación"));
//Atendemos al primer usuario de la cola
                                    while (codigoAsertado == false) {

                                        if (codigoIngresado == atendido.getVotante().getCodigo()) {
                                            int opcionIngresada = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite el número de la opción por la que desea votar: \n" + opcionesVotacion));
                                            atendidoPila = new Dato(
                                                    atendido.getVotante().getCedula(),
                                                    atendido.getVotante().getNombre(),
                                                    atendido.getVotante().getApellido(),
                                                    atendido.getVotante().getEdad(),
                                                    atendido.getVotante().getCodigo(),
                                                    opcionVotacion[opcionIngresada - 1].getElemento());
                                            contadorOpcionVotacion[opcionIngresada - 1] = contadorOpcionVotacion[opcionIngresada - 1] + 1;
                                            codigoAsertado = true;
                                            pilaAtentidos.push(atendidoPila);
                                            JOptionPane.showMessageDialog(null, "El voto ha sido emitido correctamente.");
//Verificamos el codigo de usuario que esta en la cola con el que
//se le brindo a usuario en caso de ser igual se procede a tomar el voto                                             
                                        } else {
                                            JOptionPane.showMessageDialog(null, "El código ingresado no es correcto");
                                            codigoIngresado = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite su código asignado para la votación"));
                                        }

                                    }

                                } else if (cuentaColaPrioridad < 2) {
                                    atendido = colaPrioridad.atiende();
                                    JOptionPane.showMessageDialog(null, "Atendiendo a " + atendido.getVotante().getNombre() + " " + atendido.getVotante().getApellido());
                                    int codigoIngresado = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite su código asignado para la votación"));
//En caso de que la cola prioridad tenga menos de dos personas a atender se les tomara el voto  
                                    while (codigoAsertado == false) {

                                        if (codigoIngresado == atendido.getVotante().getCodigo()) {
                                            int opcionIngresada = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite el número de la opción por la que desea votar: \n" + opcionesVotacion));
                                            atendidoPila = new Dato(
                                                    atendido.getVotante().getCedula(),
                                                    atendido.getVotante().getNombre(),
                                                    atendido.getVotante().getApellido(),
                                                    atendido.getVotante().getEdad(),
                                                    atendido.getVotante().getCodigo(),
                                                    opcionVotacion[opcionIngresada - 1].getElemento());
                                            contadorOpcionVotacion[opcionIngresada - 1] = contadorOpcionVotacion[opcionIngresada - 1] + 1;
                                            codigoAsertado = true;
                                            pilaAtentidos.push(atendidoPila);
                                            JOptionPane.showMessageDialog(null, "El voto ha sido emitido correctamente.");
                                            cuentaColaPrioridad ++;
//Cada vez que atiende uno suma 1 a cuenta cola prioridad para atender 2 de la cola prioridad y 
//luego atender a uno de la cola regular                                              
                                        } else {
                                            JOptionPane.showMessageDialog(null, "El código ingresado no es correcto");
                                            codigoIngresado = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite su código asignado para la votación"));
                                        }

                                    }

                                } else {
                                    atendido = colaRegular.atiende();
                                    JOptionPane.showMessageDialog(null, "Atendiendo a " + atendido.getVotante().getNombre() + " " + atendido.getVotante().getApellido());
                                    int codigoIngresado = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite su código asignado para la votación"));

                                    while (codigoAsertado == false) {

                                        if (codigoIngresado == atendido.getVotante().getCodigo()) {
                                            int opcionIngresada = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite el número de la opción por la que desea votar: \n" + opcionesVotacion));
                                            atendidoPila = new Dato(
                                                    atendido.getVotante().getCedula(),
                                                    atendido.getVotante().getNombre(),
                                                    atendido.getVotante().getApellido(),
                                                    atendido.getVotante().getEdad(),
                                                    atendido.getVotante().getCodigo(),
                                                    opcionVotacion[opcionIngresada - 1].getElemento());
                                            contadorOpcionVotacion[opcionIngresada - 1] = contadorOpcionVotacion[opcionIngresada - 1] + 1;
                                            codigoAsertado = true;
                                            pilaAtentidos.push(atendidoPila);
                                            JOptionPane.showMessageDialog(null, "El voto ha sido emitido correctamente.");
                                            cuentaColaPrioridad = 0;
//Una vez atentido el usuario de la cola regular el contador de cuenta cola prioridad llega a 
//0 para que atiende a las personas en la cola prioridad 
                                        } else {
                                            JOptionPane.showMessageDialog(null, "El código ingresado no es correcto");
                                            codigoIngresado = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite su código asignado para la votación"));
                                        }

                                    }
                                }
                            }
                            break;

                        case 4:
                                                    
                            int max = 0;
                            String ganador = null;
                            
                            for (int i = 0; i < contadorOpcionVotacion.length; i++) {
                                if (contadorOpcionVotacion[i] > max) {
                                    max = contadorOpcionVotacion[i];
                                    ganador = opcionVotacion[i].getElemento();
                                }
                            }
                            
//Ciclo for donde asignamos a la variable ganador el elemento con mayot votos                              
                            
                            JOptionPane.showMessageDialog(null, "El Ganador es: " + ganador + " con un total de " + max + " votos.");

                            break;

                        case 5:
                            int codigoBuscar = Integer.parseInt(JOptionPane.showInputDialog("Digite el código que utilizó al votar."));
                            pilaAtentidos.buscaVotante(pilaAtentidos.getTop(), codigoBuscar);
                            break;
//Se le pide el codigo a usuario y luego se recorre la pila hasta encontrar y                           
//avisar al usuario que su voto esta resgitrado                             
                        case 6:
//Se Utiliza el case 6 cuando se finaliza el programa.  
//La variable global salir cambia a true, y termina el while loop.
                            JOptionPane.showMessageDialog(null, "Gracias por utilizar el sistema.");
                            salir = true;
                            break;

                    }

                } else {
                    System.out.println("Por favor ingrese un numero del 1 al 6"); 
//Si el Administrador del programa no escoge una opción del 1 al 6, el menu se repite.      
                }
            } catch (Exception e) {
            }

        }

    }

}
