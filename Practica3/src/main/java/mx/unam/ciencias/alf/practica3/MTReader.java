package mx.unam.ciencias.alf.practica3;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Esta clase provee de las herramientas necesarias para leer un archivo tipo
 * JSON y convertirlo en un objeto tipor MaquinaDeTuring.
 */
public class MTReader {

    /**
     * Método para convertir un archivo .json a un objeto tipo MaquinaDeTuring
     * @param file es la dirección del archivo.
     * @return la máquina de Turing codificada en el archivo.
     */
    public static MaquinaDeTuring readTM(String file) {
        JSONParser jsonParser = new JSONParser();
        try {
            FileReader reader = new FileReader(file);

            Object obj = jsonParser.parse(reader);
            JSONObject tmJason = (JSONObject) obj;

            return parseTM(tmJason);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static MaquinaDeTuring parseTM(JSONObject tmJason) {
        MaquinaDeTuring mt = new MaquinaDeTuring();

        return mt;
    }

    public static void main(String[] args) {
        MaquinaDeTuring mt = readTM("examples/0^n1^n.json");
    }

}
