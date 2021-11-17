package mx.unam.ciencias.alf.practica3;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Esta clase provee de las herramientas necesarias para leer un archivo tipo
 * JSON y convertirlo en un objeto tipo MaquinaDeTuring.
 */
public class MTReader {

    /**
     * Método para convertir un archivo .json a un objeto tipo MaquinaDeTuring
     * @param file es la dirección del archivo.
     * @return la máquina de Turing codificada en el archivo.
     */
    public static MaquinaDeTuring readTM(String file) {
        String json = "";
        try {
            FileReader f = new FileReader(file);
            BufferedReader lector = new BufferedReader(f);
            String linea;
            while ((linea = lector.readLine()) != null) {
                json += linea;
            }
            lector.close();
        } catch (FileNotFoundException e) {
            System.err.println("No se encontró el archivo.");
        } catch (Exception e) {
            System.err.println("La entrada falló.");
        }
        Object obj = JSONValue.parse(json);
        JSONObject tmJson = (JSONObject) obj;
        return parseTM(tmJson);
    }

    /**
     * Lee los datos de un JSONObject y los pasa a un objeto
     * tipo MaquinaDeTuring.
     * @param tmJason es el objeto del que se extraerá la información
     *                de la máquina de Turing.
     * @return la máquina de Turing con los datos correspondientes.
     */
    public static MaquinaDeTuring parseTM(JSONObject tmJason) {
        MaquinaDeTuring mt = new MaquinaDeTuring();
        JSONArray jsonArray = (JSONArray) tmJason.get("Entrada");
        mt.Entrada = new char[jsonArray.size()];
        for (int i = 0; i < jsonArray.size(); i++) {
            mt.Entrada[i] = ((String) jsonArray.get(i)).charAt(0);
        }
        mt.Inicial = (String) tmJason.get("Inicial");
        mt.Blanco = ((String) tmJason.get("Blanco")).charAt(0);
        jsonArray = (JSONArray) tmJason.get("Finales");
        mt.Finales = new String[jsonArray.size()];
        for (int i = 0; i < jsonArray.size(); i++) {
            mt.Finales[i] = (String) jsonArray.get(i);
        }
        jsonArray = (JSONArray) tmJason.get("Transiciones");
        mt.Transiciones = new String[jsonArray.size()][5];
        for (int i = 0; i < jsonArray.size(); i++) {
            for (int j = 0; j < 5; j++) {
                mt.Transiciones[i][j] = (String) ((JSONArray) jsonArray.get(i)).get(j);
            }
        }
        return mt;
    }

}
