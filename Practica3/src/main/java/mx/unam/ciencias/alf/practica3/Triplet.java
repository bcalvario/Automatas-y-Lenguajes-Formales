package mx.unam.ciencias.alf.practica3;

public class Triplet {

    private TuringMachine.State state;
    private char input;
    private char movement;

    Triplet(TuringMachine.State state, char input, char movement) {
        this.state = state;
        this.input = input;
        this.movement = movement;
    }

    public TuringMachine.State getState() {
        return state;
    }

    public char getInput() {
        return input;
    }

    public char getMovement() {
        return movement;
    }

    public void setState(TuringMachine.State state) {
        this.state = state;
    }

    public void setInput(char input) {
        this.input = input;
    }

    public void setMovement() {
        this.movement = movement;
    }

    @Override
    public String toString() {
        return "(" + state.toString() +
                ", " + input +
                ", " + movement +
                ')';
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass())
            return false;

        Triplet Triplet = (Triplet) object;

        if (state.equals(Triplet.getState()) && input == Triplet.getInput() && movement == Triplet.getMovement())
            return true;
        return false;
    }
}
