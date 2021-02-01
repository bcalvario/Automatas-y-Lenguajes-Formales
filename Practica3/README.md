# Práctica 3

## Integrantes
- Berenice Calvario González.
- Jesús Alberto Reyes Gutiérrez.

## Para correr
Ejecutar los siguientes comandos desde la terminal estando en _Practica3/_.
Para compilar:
```
mvn package
```
Para correr:
```
mvn -q exec:java -Dexec.mainClass=mx.unam.ciencias.alf.practica3.Main
```
El programa pedirá la dirección del archivo JSON del cuál se extraerá la
información de la Máquina de Turing. Nuestra implementación de la MT requerida
en la práctica (0^n1^n) está en la carpeta _examples/_ y se llama
_0^n1^n.json_, en esta carpeta también se encuentra _M.json_ que es la
máquina de Turing que está como ejemplo en la especificación de la práctica.
Un ejemplo de ejecución es:
```
Archivo con la descripcion de la MT : examples/0^n1^n.json
Inserte la cadena de entrada : 0011
```

## Consideraciones
  - Para leer los archivos JSON utilizamos la biblioteca "json-simple".
  - Suponemos que la Máquina de Turing registrada en el archivo JSON está bien
definida, queriendo decir con esto que los elementos en las trasiciones
forman parte de los estados o la cinta según sea el caso.
  - El algoritmo sí revisa que la cadena proporcionada en la ejecución 
forme parte del lenguaje del alfabeto de la máquina de Túring.