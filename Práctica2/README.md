# Práctica 2

## Integrantes:
- Calvario González Berenice.
- Reyes Gutiérrez Jesús Alberto.

## Para compilar:
Para compilar desde la terminal nos ubicamos en la carpeta que contiene los
archivos fuente y compilamos el Main con:
```
$ javac Main.java
```

Al correr el programa se deben pasar dos cadenas, la primera debe ser la 
dirección del archivo txt que contiene la gramática (la cual debe cumplir
con las condiciones de la siguiente sección); la segunda cadena es la palabra
que se quiere determinar si pertenece a la gramática o no. En la carpeta
grammarsExp  se incluyen algunas gramáticas de ejemplos vistos en las notas.
Por ejemplo:
```
$ java Main grammarExp/grammar1.txt abba
```

## Archivo Gramática:
Para el correcto funcionamiento del programa es necesario que la gramática
esté en la forma normal de Chomsky. Se asume que las mayúsculas son símbolos
no terminales y las minúsculas son símbolos terminales, la primera produccion
del archivo sera tomada como el símbolo inicial. Sabemos que las producciones
tienen sólo uno o dos caracteres, en caso de que tenga sólo uno se debe poner
un espacio blanco antes y en cada línea puede haber sólo una producción (no 
se usa el |). Un ejemplo de archivo correcto es:
```
S->AB
S-> a
A->SS
B-> b
```

## ChomskyGrammar:
La clase _ChomskyGrammar_ es utilizada para trabajar con gramáticas libres de
contexto en la forma normal de Chomsky. A través de _GrammarReader_ se lee 
el archivo de texto que cumpla las especificaciones y se transforma en un 
objeto de tipo _ChomskyGrammar_. Esta clase tiene tres arreglos de caracteres
que deben ser de la misma longitud *n*, los arreglos _productions_,
_coproduct1_ y _coproduct2_ se deben entender como:
```
production[i]->coproduc[i]coproduc2[i]
```
que es cada una de las producciones proporcionadas en el archivo de texto.