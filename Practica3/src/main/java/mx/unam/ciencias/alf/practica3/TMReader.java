package mx.unam.ciencias.alf.practica3;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Esta clase provee de las herramientas necesarias para leer un archivo tipo
 * JSON y convertirlo en un objeto tipor TuringMachine.
 */
public class TMReader {
    /**
     * Clase auxiliar, sirve para pasar el archivo JSON a un objeto con los atributos
     * establecidos en la práctica.
     */
    public class TM {
        String[] Estados;
        char[] Entrada;
        char[] Cinta;
        String Inicial;
        char Blanco;
        String[] Finales;
        String[][] Transiciones;
    }

    public static TuringMachine readTM(String file) {
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
        TM tm = gson.fromJson(json, TM.class);
        return new TuringMachine(tm.Estados,tm.Entrada,tm.Cinta,tm.Inicial,tm.Blanco,
                tm.Finales,tm.Transiciones);
    }
}
