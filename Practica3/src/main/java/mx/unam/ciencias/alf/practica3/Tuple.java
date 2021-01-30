package mx.unam.ciencias.alf.practica3;

public class Tuple {

    private TuringMachine.State state;
    private char input;

    Tuple(TuringMachine.State state, char input) {
        this.state = state;
        this.input = input;
    }

    public TuringMachine.State getState() {
        return state;
    }

    public char getInput() {
        return input;
    }

    public void setState(TuringMachine.State state) {
        this.state = state;
    }

    public void setInput(char input) {
        this.input = input;
    }

    @Override
    public String toString() {
        return "(" + state.toString() +
                ", " + input +
                ')';
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass())
            return false;

        Tuple Tuple = (Tuple) object;

        if (state.equals(Tuple.getState()) && input == Tuple.getInput())
            return true;
        return false;
    }
}