import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;

public class GrammarReader {

	/** Cadena que contiene el nombre del archivo */
	private String archivo;

	/**
	 * Cadena que contiene la cadena que se analizara si la cadena pertenece o no al
	 * lenguaje generado por la gramatica
	 */
	private String cadena;

	/** Arreglo de cadenas que contiene las */
	private String[] productions;

	/** Arreglo de cadenas que contiene las */
	private String[] coproduction;

	/**
	 * Constructor
	 */
	public GrammarReader(String[] args) {
		readChomsyGrammar(args);
	}

	/**
	 * Método de lectura
	 * 
	 * @param args argumentos
	 */
	public void readChomsyGrammar(String args[]) {
		ArrayList<String> producciones = new ArrayList<String>();
		if (args.length != 2) {
			System.out.print(args.length + "Faltan argumentos\n");
		} else {
			archivo = args[0];
			try {
				FileReader f = new FileReader(archivo);
				BufferedReader lector = new BufferedReader(f);
				String linea;
				while ((linea = lector.readLine()) != null) {
					linea = linea.replace(" ", "");
					linea = linea.trim();
					producciones.add(linea);
				}
				lector.close();
			} catch (Exception e) {
				System.err.println("No se encontro el archivo");
			}

			cadena = args[1];
			productions = new String[producciones.size()];
			coproduction = new String[producciones.size()];

			for (int i = 0; i < producciones.size(); i++) {
				String aux = producciones.get(i);
				aux = aux.substring(0, 1);
				productions[i] = aux;
				aux = producciones.get(i);
				aux = aux.substring(3, aux.length());
				coproduction[i] = aux;
			}
		}
	}

	/**
     * Regresa la cadena con el nombre del archivo.
     * @return archivo El nombre del archivo.
     */
	public String getArchivo() {
		return archivo;
	}

	/**
     * Regresa la cadena con la cadena que se analizará.
     * @return cadena La cadena que se analizará.
     */
	public String getCadena() {
		return cadena;
	}

	/**
     * Regresa el arreglo con las producciones.
     * @return productions El arreglo con las producciones.
     */
	public String[] getProductions() {
		return productions;
	}

	/**
     * Regresa el arreglo con las co-producciones.
     * @return productions El arreglo con las co-producciones.
     */
	public String[] getCoproduction() {
		return coproduction;
	}

	/**
     * Regresa la cadena con las producciones y co-producciones respectivamente.
     * @return cadena La cadena con las producciones y co-producciones respectivamente.
     */
	public String aCadena() {

		String cadena = "";

		for (int i = 0; i < productions.length; i++) {
			cadena += "Produccion: " + productions[i] + ", coproduction: " + coproduction[i] + "\n";
		}

		return cadena;

	}
}