import java.util.HashSet;

public class ChomsyGrammar {
	char[] productions;
	char[] coproduct1;
	char[] coproduct2;

	public ChomsyGrammar (char[] productions, char[] coproduct1, char[] coproduct2) {
		this.productions = productions;
		this.coproduct1 = coproduct1;
		this.coproduct2 = coproduct2;
	}

	public boolean hasRightChar (char character, int i) {
		return coproduct2[i] == character;
	}

	public HashSet<Character>[][] getDerivationTableOf(String word) {
		int length = word.length();

		HashSet[][] derivationTable = new HashSet[length][];
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