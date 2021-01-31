package mx.unam.ciencias.alf.practica3;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MáquinaDeTuring {
    String[] Estados;
    char[] Entrada;
    char[] Cinta;
    String Inicial;
    char Blanco;
    String[] Finales;
    String[][] Transiciones;

    public MáquinaDeTuring() {

    }

    public MáquinaDeTuring(String[] Estados, char[] Entrada, char[] Cinta,
                           String Inicial, char Blanco, String[] Finales,
                           String[][] Trasiciones) {
        this.Estados = Estados;
        this.Entrada = Entrada;
        this.Cinta = Cinta;
        this.Inicial = Inicial;
        this.Blanco = Blanco;
        this.Finales = Finales;
        this.Transiciones = Trasiciones;
    }

    public int delta(String estado, char símbolo) {
        for (int i = 0; i < Transiciones.length; i++) {
            if (Transiciones[i][0] == estado &&
                    Transiciones[i][1].charAt(0) == símbolo)
                return i;
        } return -1;
    }

    public boolean isFinal(String estado) {
        return Arrays.asList(Finales).contains(estado);
    }

    public boolean imprimeEjecución(String palabra) {
        List<Character> cinta = new ArrayList<>(palabra.length());
        for (int i = 0; i < palabra.length(); i++)
            cinta.add(palabra.charAt(i));
        int position = 0;
        String act = Inicial;
        int deltaAct = delta(act,cinta.get(position));
        try {
            while (!isFinal(act) && deltaAct != -1) {
                for (int i = 0; i < position; i++)
                    System.out.print(cinta.get(i));
                System.out.print("|" + act + "|");
                for (int i = position; i < cinta.size(); i++)
                    System.out.print(cinta.get(i));
                System.out.println();
                cinta.set(position, Transiciones[deltaAct][3].charAt(0));
                if (Transiciones[deltaAct][4].charAt(0) == 'R') {
                    position++;
                    if (position > cinta.size()) {
                        cinta.add(Blanco);
                    }
                } else {
                    if (position == 0) {
                        cinta.add(0,Blanco);
                    } else {
                        position--;
                    }
                }
                act = Transiciones[deltaAct][2];
            } if (isFinal(act)) {
                System.out.println("La cadena fue aceptada");
                return true;
            } else {
                System.out.println("La cadena fue rechazada");
                return false;
            }
        } catch (IndexOutOfBoundsException e1) {
            System.out.println("Te pasaste de índice");
            return false;
        }
    }

    public static void main(String[] args) {
        MáquinaDeTuring mt = TMReader.readTM("src/main/java/mx/unam/ciencias/alf/practica3/tm.json");
        mt.imprimeEjecución("010");
    }
}
