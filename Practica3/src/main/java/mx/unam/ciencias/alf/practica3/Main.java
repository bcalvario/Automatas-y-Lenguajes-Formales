package mx.unam.ciencias.alf.practica3;

import com.google.gson.Gson;

public class Main {

    public static void main(String[] args) {
        MaquinaDeTuring mt = MTReader.readTM("src/main/java/mx/unam/ciencias/alf/practica3/tm.json");
        mt.imprimeEjecución("010");
    }

}
