package mx.unam.ciencias.alf.practica3;

import com.google.gson.Gson;
import java.io.BufferedReader;
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
        String json = "";
        try {
            FileReader f = new FileReader(file);
            BufferedReader lector = new BufferedReader(f);
            String linea;
            while ((linea = lector.readLine()) != null) {
                json += linea;
            }
            lector.close();
        } catch (Exception e) {
            System.err.println("No se encontró el archivo");
        }
        Gson gson = new Gson();
        return gson.fromJson(json, MaquinaDeTuring.class);
    }

}
