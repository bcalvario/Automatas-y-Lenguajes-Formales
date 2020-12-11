import java.util.HashSet;

/**
 * La clase representa una gramática libre de contexto G
 * en forma normal de Chomsky
 */
public class ChomskyGrammar {
	char[] productions;
	char[] coproduct1;
	char[] coproduct2;

	/**
	 * Constructor de una gramática en forma normal de Chomsky.
	 * @param productions es un arreglo de elementos no terminal.
	 * @param coproduct1 es un arreglo con primer elemento del producto.
	 * @param coproduct2 es un arreglo con el segundo elemento del producto.
	 */
	public ChomskyGrammar(char[] productions, char[] coproduct1,
						  char[] coproduct2) {
		this.productions = productions;
		this.coproduct1 = coproduct1;
		this.coproduct2 = coproduct2;
	}

	/**
	 * Es usado para determinar si una producción tiene un carácter en
	 * la derecha.
	 * @param character será buscado.
	 * @param production es la que se analizará.
	 * @return true si la producción tiene a character en la derecha.
	 */
	public boolean hasRightChar (char character, int production) {
		return coproduct2[production] == character;
	}

	/**
	 * El método calcula la tabla de derivación proporcionada por el
	 * Algoritmo CKY.
	 * @param word es la palabra a la que se le aplicará el algoritmo.
	 * @return la tabla de derivación del algoritmo.
	 */
	public HashSet<Character>[][] getDerivationTableOf(String word) {
		int length = word.length();

		HashSet<Character>[][] derivationTable = new HashSet[length][];
		for (int i = 0; i < length; i++) {
			derivationTable[i] = new HashSet[i+1];
		}

		for (int i = 0; i < length; i++) {
			derivationTable[i][i] = new HashSet<>();
			for (int j = 0; j < productions.length; j++) {
				if (hasRightChar(word.charAt(i), j))
					derivationTable[i][i].add(productions[j]);
			}
		}

		for (int m = 2; m <= length; m++) {
			for (int i = 0; i <= length-m; i++) {
				derivationTable[i+m-1][i] = new HashSet<>();
				for (int j = i+1; j < i+m; j++) {
					for (int k = 0; k < productions.length; k++) {
						if (derivationTable[j-1][i].contains(coproduct1[k]) &&
								derivationTable[i+m-1][j].contains(coproduct2[k]))
							derivationTable[i+m-1][i].add(productions[k]);
					}
				}
			}
		}

		return  derivationTable;
	}
}