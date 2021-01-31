package mx.unam.ciencias.alf.practica3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Esta clase representa una máquina de Turing.
 */
public class MaquinaDeTuring {
    String[] Estados;
    char[] Entrada;
    char[] Cinta;
    String Inicial;
    char Blanco;
    String[] Finales;
    String[][] Transiciones;

    /**
     * Constructor vacío, es necesario para la ejecución de Gson.
     */
    public MaquinaDeTuring() {}

    /**
     * Este método representa la función delta de la máquina.
     * @param estado entrada para la función delta.
     * @param símbolo entrada para la función delta.
     * @return un entero mayor o igual a cero con la posicion de
     * la transicion buscada en Transiciones, -1 si la funcion no
     * esta definida para los valores de entrada.
     */
    public int delta(String estado, char símbolo) {
        for (int i = 0; i < Transiciones.length; i++) {
            if (Transiciones[i][0].equals(estado) &&
                    Transiciones[i][1].charAt(0) == símbolo)
                return i;
        }
        return -1;
    }

    /**
     * Para ver si un estado es final.
     * @param estado de entrada.
     * @return true si el estado de entrada es final, false en otro caso.
     */
    public boolean isFinal(String estado) {
        return Arrays.asList(Finales).contains(estado);
    }

    /**
     * Dados los valores de entrada imprime la configuración
     * de esta máquina de Turing.
     * @param cinta los valores en la cinta.
     * @param estado el estado actual.
     * @param posicion posición del estado actual en la cinta.
     */
    public void imprimeConf(List cinta, String estado, int posicion) {
        for (int i = 0; i < posicion; i++)
            System.out.print(cinta.get(i));
        System.out.print("|" + estado + "|");
        for (int i = posicion; i < cinta.size(); i++)
            System.out.print(cinta.get(i));
        System.out.println();
    }

    /**
     * Revisa que el valor de entrada forma parte del alfabeto.
     * @param elem elemento a ser revisado.
     * @return true si el elemento forma parte del alfabeto.
     */
    public boolean entradaContiene(char elem) {
        for (char letra : Entrada) {
            if (letra == elem)
                return true;
        }
        return false;
    }

    /**
     * Imprime la ejecución de esta máquina de Turing con
     * la cadena dada.
     * @param cadena a ser ejecutada.
     * @return true si la cadena forma parte del lenguaje de esta
     * máquina de Turing, false en otro caso.
     */
    public boolean imprimeEjecucion(String cadena) {
        System.out.println("Las configuraciones son las siguientes:");
        List<Character> cinta = new ArrayList<>(cadena.length());
        for (int i = 0; i < cadena.length(); i++) {
            if (entradaContiene(cadena.charAt(i)))
                cinta.add(cadena.charAt(i));
            else {
                System.out.println("La cadena fue rechazada1");
                return false;
            }
        }
        int posicion = 0;
        String act = Inicial;
        try {
            while (!isFinal(act)) {
                imprimeConf(cinta, act, posicion);
                int deltaAct = delta(act,cinta.get(posicion));
                if (deltaAct < 0){
                    System.out.println("La cadena fue rechazada2");
                    return false;
                } else {
                    cinta.set(posicion, Transiciones[deltaAct][3].charAt(0));
                    if (Transiciones[deltaAct][4].charAt(0) == 'R') {
                        posicion++;
                        if (posicion >= cinta.size()) {
                            cinta.add(Blanco);
                        }
                    } else if (Transiciones[deltaAct][4].charAt(0) == 'L'){
                        if (posicion == 0) {
                            cinta.add(0, Blanco);
                        } else {
                            posicion--;
                        }
                    }
                    act = Transiciones[deltaAct][2];
                }
            }
            imprimeConf(cinta,act,posicion);
            System.out.println("La cadena fue aceptada");
            return true;
        } catch (RuntimeException r) {
            System.out.println("La cadena fue rechazada3");
            return false;
        } catch (Exception e) {
            System.err.println("El programa falló");
            return false;
        }
    }

}
