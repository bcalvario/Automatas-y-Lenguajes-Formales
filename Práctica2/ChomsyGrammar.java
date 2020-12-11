import java.util.HashSet;

public class ChomsyGrammar {
	char[] productions;
	String[] coproduction;
	
	// Ambos arreglos deben tener la misma longitud.
	// La entrada i de productions deriva en la entrada i de coproductions.
	// La entrada 0 contiene la prosucción inicial

	//public HashSet[][] getDerivationTableof(String word) {
	public void getDerivationTableof(String word) {
	
		HashSet[][] derivationTable = new HashSet[1][1];
	}

	//public HashSet<String>[][] derivationTableRec(int i, HashSet<String>[][] tableBefore) {
	public void derivationTableRec(int i, HashSet<String>[][] tableBefore) {
	
		if (i == tableBefore.length) {
			
		}
	}

	public static void main (String[] args) {
		GrammarReader gram = new GrammarReader(args);
		System.out.println(gram.aCadena());
	}
}