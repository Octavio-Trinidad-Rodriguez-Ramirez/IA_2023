# Num. 7. Heurística.

* Alumno :  Rodriguez Ramírez Octavio Trinidad
* Materia: Inteligencia Artificial
* Maestro: Alcaráz Chavéz Jesús Eduardo
* Fecha  : 07 de Diciembre del 2023

# Problema
• Definir que es la heurística y cual es su papel en la resolución de
problemas

• Resolver con recursividad, programar.

• Proponer Algoritmo de Solución, programar.

• Describir el punto anterior.

![Imagen](/IA/Octavio/TAREA_07/Lab.png)



# Heurística:
La RAE define la heurística como *la manera de buscar la solución de un problema mediante métodos no rigurosos, como por tanteo, reglas empíricas, etc.*



# Solución
1. Crear el mapa de 9 filas por 9 columnas con 0s como camino y 1s como obstaculos.
2. Marcar en el mapa la meta con un 3.
3. Crear una función mostrar para ver el mapa.

Para poder ver el camino que recorrio el personaje o camino.

4. Crear una función que revise si una casilla existe.

    Se crea la función casillaExiste para asegurarse que no se están analizando casillas inválidas o fuera de rango

6. Crear la función recursiva que reciba una posición [a][b]

7. Revisar que exista la casilla[a][b] y ponerla en 5 para indicar que ya sé camino por ahí

8. El algoritmo empieza por revisar si la **Izquierda** esta disponible (por medio de ifs) y llamarse a sí misma.

9. Cuando la **Izquierda** no esta disponible, busca ir hacia **Abajo**.

10. Cuando **Abajo** esta disponible se llama a sí mismo.

11. Cuando **Abajo** no esta disponible busca la **Derecha**.

12. Cuando la **Derecha** esta disponible se llama a sí misma.

13. Cuando la **Derecha** no esta disponble busca ir **Arriba**.

14. Si **Arriba** no esta disponible, es que no tiene ningún nuevo camino. intenta regresar por la **Izquierda**.

15. Si no puede regresar por la **Izquierda**, debe regresar bajando o subiendo.

Este algoritmo encuentra la respuesta de este laberinto muy rápido porque de antemano ya sabía que la salida del mapa esta hacia abajo y a la izquirda, sin embargo este algortimo podría resolver cualquier laberinto, incluso si la

![Sofware output](/IA/Octavio/TAREA_07/Resultado.png)