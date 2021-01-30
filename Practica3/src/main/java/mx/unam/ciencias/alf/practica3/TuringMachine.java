package mx.unam.ciencias.alf.practica3;

import java.util.Arrays;
import java.util.HashMap;

public class TuringMachine {

    class State {
        String name;
        boolean isFinal;

        public State(String name, boolean isFinal){
            this.name = name;
            this.isFinal = isFinal;
        }

        @Override
        public String toString() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            State state = (State) o;
            return isFinal == state.isFinal &&
                    name.equals(state.name);
        }
    }

    private char[] alphabet;
    private State initial;
    private char blank;
    private HashMap<Tuple, Triplet> delta;

    public TuringMachine (String[] Estados, char[] Entrada, char[] Cinta,
                          String Inicial, char Blanco, String[] Finales,
                          String[][] Transiciones) {
        alphabet = Entrada;
        initial = new State(Inicial,Arrays.asList(Finales).contains(Inicial));
        blank = Blanco;
        delta = new HashMap<>(Transiciones.length);
        for (int i = 0; i < Transiciones.length; i++) {
            Tuple input = new Tuple(new State(Transiciones[i][0],
                    Arrays.asList(Finales).contains(Transiciones[i][0])),
                    Transiciones[i][1].charAt(0));
            Triplet output = new Triplet(new State(Transiciones[i][2],
                    Arrays.asList(Finales).contains(Transiciones[i][2])),
                    Transiciones[i][3].charAt(0),Transiciones[i][4].charAt(0));
            delta.put(input, output);
        }
    }

    public static void main(String[] args) {
        TuringMachine tm = TMReader.readTM("src/main/java/mx/unam/ciencias/alf/practica3/tm.json");
        char[] cinta = args[0].toCharArray();
        int position = 0;
        State act = tm.initial;
        Triplet deltaAct = tm.delta.get(new Tuple(act, cinta[position]));
        System.out.println(tm.initial.name);
        try {
            while (!act.isFinal && deltaAct != null) {
                for (int i = 0; i < position; i++)
                    System.out.print(cinta[i]);
                System.out.print("|" + act.name + "|");
                for (int i = position; i < cinta.length; i++)
                    System.out.print(cinta[i]);
                System.out.println();
                cinta[position] = deltaAct.getInput();
                if (deltaAct.getMovement() == 'R') {
                    position++;
                } else {
                    position--;
                }
                act = deltaAct.getState();
            } if (act.isFinal) {
                System.out.println("La cadena fue aceptada");
            } else {
                System.out.println("La cadena fue rechazada");
            }
        } catch (IndexOutOfBoundsException e1) {
            System.out.println("Te pasaste de índice");
        }
    }
}