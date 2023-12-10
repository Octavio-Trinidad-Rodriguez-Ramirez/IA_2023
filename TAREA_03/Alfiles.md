# Num. 3. Alfiles


* Alumno    : Rodriguez Ramírez Octavio Trinidad
* Materia   : Inteligencia Artificial
* Profesor  : Alcaráz Chavéz Jésus Eduardo
* Fecha     : 07 de Diciembre del 2023

# Introducción

Este documento tiene como propósito mostrar la solución al problema #3 planteado por el profesor Alcaráz Chavéz Jésus Eduardo que consiste en reorganizar una serie de alfiles blancos y negros; más detalles de este ejercicio en la sección *Problema*.
En la sección *Lógica* se muestra la lógica y el razonamiento necesario para resolver el problema planteado, así como el tablero de ajedrez utilizado para representar los alfiles. *Recursos de ayuda* indica las herramientas que fueron utilizadas como apoyo para llegar a la solución
 Por último en la sección de *Solución* se muestra la respuesta conseguida y los movimientos que se utilizaron.

# Problema

Coloca ocho alfiles cuatro negros y cuatro blancos en un tablero de
ajedrez reducido de 4x5. El problema consiste en hacer
que los alfiles negros intercambien sus posiciones con los blancos, ningún alfil
debe atacar en ningún momento otro del color opuesto. Se deben alternar
los movimientos, primero uno blanco, luego uno negro, luego uno blanco y
así sucesivamente. ¿Cuál es el mínimo número de movimientos en que se
puede conseguir?

# Lógica

Para poder continuar con el problema, lo primero que se plantea es una notación que defina el tablero de ajedrez y los alfiles que lo componen.

### El tablero
Identifica a cada celda con un número.
|||||
|-|-|-|-|
|1|2|3|4|
|5|6|7|8|
|9|10|11|12|
|13|14|15|16|
|17|18|19|20|

## Los alfiles

La letra X representa un alfin negro, mientras que la letra O representa un alfil blanco.

|||||
|-|-|-|-|
|X|X|X|X|
| | | | |
| | | | |
| || | |
|O|O|O|O|

Los movimientos se definen como un par de números:
> (a,b)

donde a es la casilla de origen y b es la casilla de destino

# Recursos de ayuda
Para llegar a la solución se utilizó la página  [Swap Bishops](https://games.dtco.ru/mirror/checkmate/swap-bishops.htm), esta página te permite jugar con los alfiles hasta llegar a la solución, y agiliza el proceso de conseguir la solución porque sólo muestra los caminos dónde ningún alfil se entre pone con otro.Esta página incluso específica quién fue el autor original del problema planteado: Henry Dudeney, un matemático del siglo XX que se especializó en puzzles y juegos de lógica.

La otra mitad de la solución se consigue haciendo un grafo que recorra todos los caminos posibles para ganar y de él seleccionar el camino más corto. Se adjunta el grafó propuesto junto con esta tarea, sin embargo se menciona que hay muchos *caminos redundantes* que fueron abreviados para poder conseguir la respuesta.

Otra consideración a tomar es evitar a toda costa las siguientes configuraciones:

|||||
|-|-|-|-|
|X|||X|
| |X | X| |
| | | | |
| |O|O | |
|O|||O|

Y

|||||
|-|-|-|-|
||X|X||
| |X | X| |
| | | | |
| |O|O | |
||O|O||

Porque no llevan a ningún camnino ni a ninguna solución, 


# Solución

No hay multiples soluciones, la solución de Dudeney es la única viable. Con el grafo es muy fácil ver que la mayoría de las decisiones llevan a ciclos, o que deshacen el movimiento pasado, lo cual sólo consiguen 

**Movimientos = 36**
|Casilla origen|Casilla Destino|
|-------|------|
|18|15|
|3|6|
|17|8|
|4|13|
|19|14|
|2|7|
|15|5|
|6|16|
|8|3|
|13|18|
|14|9|
|7|12|
|5|10|
|16|11|
|9|19|
|12|2|
|10|4|
|11|7|
|20|10|
|1|11|
|3|9|
|18|12|
|10|13|
|11|8|
|19|16|
|2|5|
|16|1|
|5|20|
|9|6|
|12|15|
|13|17|
|8|14|
|6|3|
|15|18|
|7|2|
|14|19|

#### Versión Espejo
Al aplicarse la inversa del algoritmo anterior, también aparece una solución al problema. Las diferencias empiezan desde el primer movimiento, y el resto son los movimientos en espejo del anterior.

**Movimientos = 36**
|Casilla origen|Casilla Destino|
|-------|------|
|19|14|
|2|7|
|20|5|
|1|16|
|18|5|
|3|6|
|14|8|
|7|13|
|5|2|
|16|19|
|15|12|
|6|9|
|8|11|
|13|10|
|12|18|
|9|3|
|11|1|
|10|20|
|17|11|
|4|10|
|2|12|
|19|9|
|11|16|
|10|5|
|18|13|
|3|8|
|13|4|
|8|17|
|12|7|
|9|14|
|16|6|
|5|15|
|7|2|
|14|19|
|6|3|
|15|18|