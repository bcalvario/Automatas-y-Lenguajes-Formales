import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;

public class GrammarReader {

	/**
	 * Método de lectura.
	 * @param file dirección del archivo que será traducido.
	 *             Debe cumplir con las condiciones descritas en
	 *             el README.
	 */
	public static ChomskyGrammar readChomskyGrammar(String file) {
		ArrayList<String> productionsArray = new ArrayList<>();
		try {
			FileReader f = new FileReader(file);
			BufferedReader lector = new BufferedReader(f);
			String linea;
			while ((linea = lector.readLine()) != null) {
				productionsArray.add(linea);
			}
			lector.close();
		} catch (Exception e) {
			System.err.println("No se encontró el archivo");
		}

		int size = productionsArray.size();
		char[] productions = new char[size];
		char[] coproduction1 = new char[size];
		char[] coproduction2 = new char[size];
		for (int i = 0; i < size; i++) {
			productions[i] = productionsArray.get(i).charAt(0);
			coproduction1[i] = productionsArray.get(i).charAt(3);
			coproduction2[i] = productionsArray.get(i).charAt(4);
		}

		return new ChomskyGrammar(productions, coproduction1, coproduction2);
	}

}