public class ChomsyGrammar {
	Char[] productions;
	String[] coproduction;
	// Ambos arreglos deben tener la misma longitud.
	// La entrada i de productions deriva en la entrada i de coproductions.
	// La entrada 0 contiene la prosucción inicial

	public HashSet[][] getDerivationTableof(String word) {
		HashSet[][] derivationTable = new HashSet[][]
	}

	public HashSet<String>[][] derivationTableRec(int i, 
		                             HashSet<String>[][] tableBefore) {
		if (i == tableBefore.length) {
			
		}
	}
}