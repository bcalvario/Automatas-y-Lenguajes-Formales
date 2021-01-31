package mx.unam.ciencias.alf.practica3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);

        System.out.print("Archivo con la descripcion de la MT : ");
        String cadena = scanner.next();
        MaquinaDeTuring mt = MTReader.readTM(cadena);

        System.out.print("Inserte la cadena de entrada : ");
        cadena = scanner.next();
        mt.imprimeEjecucion(cadena);

        scanner.close();
    }

}
