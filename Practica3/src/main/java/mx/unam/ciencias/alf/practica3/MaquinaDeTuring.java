package mx.unam.ciencias.alf.practica3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaquinaDeTuring {
    String[] Estados;
    char[] Entrada;
    char[] Cinta;
    String Inicial;
    char Blanco;
    String[] Finales;
    String[][] Transiciones;

    public MaquinaDeTuring() {}

    public int delta(String estado, char símbolo) {
        for (int i = 0; i < Transiciones.length; i++) {
            if (Transiciones[i][0].equals(estado) &&
                    Transiciones[i][1].charAt(0) == símbolo)
                return i;
        }
        return -1;
    }

    public boolean isFinal(String estado) {
        return Arrays.asList(Finales).contains(estado);
    }

    public void imprimeConf(List cinta, String estado, int posicion) {
        for (int i = 0; i < posicion; i++)
            System.out.print(cinta.get(i));
        System.out.print("|" + estado + "|");
        for (int i = posicion; i < cinta.size(); i++)
            System.out.print(cinta.get(i));
        System.out.println();
    }

    public boolean imprimeEjecucion(String palabra) {
        List<Character> cinta = new ArrayList<>(palabra.length());
        for (int i = 0; i < palabra.length(); i++)
            cinta.add(palabra.charAt(i));
        int posicion = 0;
        String act = Inicial;
        try {
            while (!isFinal(act)) {
                imprimeConf(cinta, act, posicion);
                int deltaAct = delta(act,cinta.get(posicion));
                if (deltaAct == -1){
                    System.out.println("La cadena fue rechazada1");
                    return false;
                } else {
                    cinta.set(posicion, Transiciones[deltaAct][3].charAt(0));
                    if (Transiciones[deltaAct][4].charAt(0) == 'R') {
                        posicion++;
                        if (posicion >= cinta.size()) {
                            cinta.add(Blanco);
                        }
                    } else {
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
            System.out.println("La palabra fue rechazada");
            return false;
        } catch (Exception e) {
            System.err.println("El programa falló");
            return false;
        }
    }

}
