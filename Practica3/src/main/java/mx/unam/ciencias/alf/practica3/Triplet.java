package mx.unam.ciencias.alf.practica3;

public class Triplet {

    private String state;
    private char input;
    private char movement;

    Triplet(String state, char input, char movement) {
        this.state = state;
        this.input = input;
        this.movement = movement;
    }

    public String getState() {
        return state;
    }

    public char getInput() {
        return input;
    }

    public char getMovement() {
        return movement;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void setInput(char input) {
        this.input = input;
    }

    public void setMovement() {
        this.movement = movement;
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