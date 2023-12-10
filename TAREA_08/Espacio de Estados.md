# Num. 7. Espacio de Estados.

* Alumno :  Rodriguez Ramírez Octavio Trinidad
* Materia: Inteligencia Artificial
* Maestro: Alcaráz Chavéz Jesús Eduardo
* Fecha  : 07 de Diciembre del 2023


# Problema
1. Generar el espacio de estados de los siguientes problemas

El juego consiste en pasar las 3 ranas verdes a la derecha y las 3 ranas
marrones a la izquierda. Las ranas pueden saltar a una piedra vacía que
tengan delante, o saltar por encima de otra rana si en medio de ambas hay
una piedra vacía. Pulsa sobre la rana que quieres que salte.

Tres misioneros se perdieron explorando una jungla. Separados de sus
compañeros, sin alimento y sin radio, solo sabían que para llegar a su destino debían ir siempre hacia adelante. Los tres misioneros se detuvieron
frente a un río que les bloqueaba el paso, preguntándose que podían hacer.
De repente, aparecieron tres caníbales llevando un bote, pues también ellos querían cruzar el río. Ya anteriormente se habían encontrado grupos de
misioneros y caníbales, y cada uno respetaba a los otros, pero sin confiar
en ellos. Los caníbales se daban un festín con los misioneros cuando les
superaban en número.
Los tres caníbales deseaban ayudar a los misioneros a cruzar el río, pero
su bote no podía llevar más de dos personas a la vez y los misioneros no
querían que los caníbales les superaran en número.
¿Cómo puede resolverse el problema, sin que en ningún momento haya
más caníbales que misioneros en cualquier orilla del río? recuerda que un
misionero y un caníbal en una orilla del río más uno o dos caníbales en el
bote al mismo lado, significa que los misioneros tendrán problemas.

# Ranas

>El juego consiste en pasar las 3 ranas verdes a la derecha y las 3 ranas
marrones a la izquierda. Las ranas pueden saltar a una piedra vacía que
tengan delante, o saltar por encima de otra rana si en medio de ambas hay
una piedra vacía. Pulsa sobre la rana que quieres que salte.

**Solución en 21 pasos**
La siguiente tabla muestra el espacio de estados utilizado para alacanzar la solución en 21 pasos.

|.|R|A|N|A|S|.|
|----|---|---|---|---|---|---|
|RV|RV|RV|.|RM|RM|RM|
|RV|RV|RV|RM|.|RM|RM|
|RV|RV|.|RM|RV|RM|RM|
|RV|RV|RM|.|RV|RM|RM|
|RV|.|RM|RV|RV|RM|RM|
|RV|RM|.|RV|RV|RM|RM|
|.|RM|RV|RV|RV|RM|RM|
|RM|.|RV|RV|RV|RM|RM|
|RM|RV|RV|.|RV|RM|RM|
|RM|RV|RV|RM|RV|.|RM|
|RM|RV|RV|RM|RV|RM|.|
|RM|RV|RV|RM|.|RM|RV|
|RM|RV|.|RM|RV|RM|RV|
|RM|RV|RM|.|RV|RM|RV|
|RM|.|RM|RV|RV|RM|RV|
|RM|RM|.|RV|RV|RM|RV|
|RM|RM|RV|.|RV|RM|RV|
|RM|RM|RV|RM|RV|.|RV|
|RM|RM|RV|RM|.|RV|RV|
|RM|RM|.|RM|RV|RV|RV|
|RM|RM|RM|.|RV|RV|RV|


# Misioneros

>Tres misioneros se perdieron explorando una jungla. Separados de sus
compañeros, sin alimento y sin radio, solo sabían que para llegar a su destino debían ir siempre hacia adelante. Los tres misioneros se detuvieron
frente a un río que les bloqueaba el paso, preguntándose que podían hacer.
De repente, aparecieron tres caníbales llevando un bote, pues también ellos querían cruzar el río. Ya anteriormente se habían encontrado grupos de
misioneros y caníbales, y cada uno respetaba a los otros, pero sin confiar
en ellos. Los caníbales se daban un festín con los misioneros cuando les
superaban en número.
Los tres caníbales deseaban ayudar a los misioneros a cruzar el río, pero
su bote no podía llevar más de dos personas a la vez y los misioneros no
querían que los caníbales les superaran en número.
¿Cómo puede resolverse el problema, sin que en ningún momento haya
más caníbales que misioneros en cualquier orilla del río? recuerda que un
misionero y un caníbal en una orilla del río más uno o dos caníbales en el
bote al mismo lado, significa que los misioneros tendrán problemas.


La siguiente tabla muestra la solución a este problema, al utilizar un sistema binario con 0 indicando que el elemento(ya sea misionario o canibal) sigue del lado original del rio y el 1 indicando que ya cruzo el rio. La letra M representa a los misionarios y la letra C representa a los canibales.

|M|M|M|C|C|C|
|-|-|-|-|-|-|
|0|0|0|0|0|0|
|0|0|0|0|1|1|
|0|0|0|0|1|0|
|0|0|0|1|1|1|
|0|0|0|0|1|1|
|1|1|0|0|1|1|
|1|0|0|0|0|1|
|1|1|1|0|0|1|
|1|1|1|0|0|0|
|1|1|1|1|1|0|
|1|1|1|0|1|0|
|1|1|1|1|1|1|













