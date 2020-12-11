import java.util.HashSet;

public class ChomsyGrammar {
	char[] productions;
	char[] coproduction1;
	char[] coproduction2;

	// Ambos arreglos deben tener la misma longitud.
	// La entrada i de productions deriva en la entrada i de coproductions.
	// La entrada 0 contiene la prosucción inicial

	public ChomsyGrammar (char[] productions, char[] coproduction1, char[] coproduction2) {
		this.productions = productions;
		this.coproduction1 = coproduction1;
		this.coproduction2 = coproduction2;
	}

	public boolean hasRigthChar (char character, int i) {
		return coproduction2[i] == character;
	}

	public HashSet[][] getDerivationTableof(String word) {
		int length = word.length();

		//Inicializar el arreglo de escalera
		HashSet<Character>[][] derivationTable = new HashSet[length][];
		for (int i = 0; i < length; i++) {
			derivationTable[i] = new HashSet[length - i];
		}

		// Subcadenas de longitud 1
		for (int i = 0; i < length; i++) {
			derivationTable[i][i] = new HashSet<>();
			for (int j = 0; j < productions.length; j++) {
				if (hasRigthChar(word.charAt(i), j))
					derivationTable[i][i].add(productions[j]);
			}
		}

		return  derivationTable;
	}

	public static void main(String[] args) {
		//Ejemplo de gramática en forma de Chamsky
		char[] producciones0 = {'S','S','S','S','S','A','B','C','D'};
		char[] prosucciones1 = {'A','B','S','A','B',' ',' ','S','S'};
		char[] producciones2 = {'B','A','S','C','D','a','b','B','A'};
		ChomsyGrammar grammar = new ChomsyGrammar(producciones0, prosucciones1, producciones2);

		grammar.getDerivationTableof("abba");
	}
}