import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.print("Faltan argumentos.\n");
        } else {
            ChomskyGrammar grammar = GrammarReader.readChomskyGrammar(args[0]);
            HashSet[][] table = grammar.getDerivationTableOf(args[1]);

            System.out.println("Resultado:");
            if (table[args[1].length()-1][0].contains(grammar.productions[0])) {
                System.out.println(args[1] + " sí está en L(G).");
            } else {
                System.out.println(args[1] + " no está en L(G).");
            }
            System.out.println();

            System.out.println("La tabla de posibles derivaciones es:");
            for (int i = 0; i < args[1].length(); i++) {
                for (int j = 0; j < i; j++) {
                    System.out.print(table[i][j] + ",");
                }
                System.out.println(table[i][i]);
            }
        }
    }
}
