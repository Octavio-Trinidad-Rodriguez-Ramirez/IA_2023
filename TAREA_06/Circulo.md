# Num. 6. Circulo de matanza


* Alumno    : Rodriguez Ramírez Octavio Trinidad
* Materia   : Inteligencia Artificial
* Profesor  : Alcaráz Chavéz Jésus Eduardo
* Fecha     : 07 de Diciembre del 2023

# Problema

La historia que sigue es una versión adaptada de lo que –supuestamente— sucedió durante el siglo I. Sí, el siglo uno. Suena raro, ¿no? Más aún: esa
historia dio origen a un problema clásico de la matemática/computación que
sobrevivió el paso del tiempo. Se lo conoce con el nombre del “Problema de
Josephus”, ya que se supone que fue Flavius Josephus, un historiador judío
nacido en Jerusalén, quien describió la situación que vivieron él y 40 soldados
que lo acompañaban.

En un momento determinado de la guerra judeo-romana, Josephus y
su grupo cayeron en una emboscada y quedaron atrapados en una caverna
rodeada de soldados enemigos. Después de debatir cómo proceder, optaron
por suicidarse antes de ser capturados. Sin embargo, Josephus no estuvo
de acuerdo con la propuesta y para que nadie tuviera que quitarse la vida,
propuso el siguiente método:

“Sentémonos todos en un círculo. Alguno de nosotros empezará primero
y matará a quien tenga sentado a la izquierda y así vamos a seguir hasta que
–claramente— quedará nada más que uno solo de nosotros con vida. Ese
será el único que tendrá que suicidarse”.

Allí están las cuarenta y un posiciones numeradas en forma creciente.
Supongamos que empieza el que está sentado en la posición número 1. Ese
soldado matará al 2. Luego, el 3 matará al 4, el 5 al 6. . . y así siguiendo.
Como usted advierte, llegará un momento en el que habrán muerto todos los
que están sentados en las posiciones que llevan un número par. Pero cuando
muera el último de ellos, el número 40 (a manos del 39), el 41 estará vivo
aún y ahora, el que tiene sentado a la izquierda es el número 1 quien había
empezado con los asesinatos.
De acuerdo con las reglas, el 41 matará al 1, el 3 matará al 5, etc. Creo
que ahora está claro que van a morir todos hasta que quede solamente uno
con vida.

Es aquí donde aparece una parte interesante de la historia de Josephus.
En principio, habrían de morir todos los soldados que estaban con Josephus
en la caverna, pero la diferencia es que quien quedara último tendría que
suicidarse. . . Más aún: el sobreviviente tendría que quitarse la vida y no
habría ningún otro integrante del grupo que estuviera vivo para verificar que
lo hiciera.

Como usted se imagina, Josephus eligió un lugar particular del círculo y
se sentó allí. El sabía que siguiendo las reglas escritas más arriba, él habría
de quedar como único sobreviviente. Esperó que todos estuvieran muertos,
y en lugar de suicidarse, salió de la caverna y se entregó al enemigo.
Pregunta: ¿en qué lugar se sentó Josephus?

El problema es muy conocido en el mundo de la matemática y los programadores, y es por eso que hay muchísima literatura escrita sobre el tema,
pero no hace falta saber nada particular para poder pensarlo. La versión
que figura más arriba es solo una de las posibles variantes (la más sencilla
y si yo estuviera junto a usted, le sugeriría que no empiece con el caso de
los 41 soldados, sino que intente con números más pequeños (de soldados) de manera tal de ver si le es posible intuir o imaginar una estrategia para determinar al ganador o sobreviviente a medida que va incrementando el número de soldados.
De la misma forma, una vez que hayamos resuelto el problema para
41 soldados, sería interesante pensar en una estrategia que permita deducir cuál será la posición ganadora en el caso general, es decir, independizarse del número 41 y encontrar alguna estrategia o fórmula que permita deducir el número que hay que elegir sin tener que recorrer todos los pasos intermedios.


# Solución

Para encontrar quién será el sobreviviente en este problema siempre se puede hacer el calculo manual, el cual da cómo resultado 19.Sin embargo, esto no ayuda a la hora de encontrar una manera matemática generalizada de encontrar la solución.

La solución generalizada se encuentra después de analizar poco la siguiente tabla, en ella se puede ver la cantidad de personas en el circulo y la posición final o superviviente del circulo de matanza.

**Formula** muestra la descomposición matemática de la posición final, de manera que la posición, de manera que es visible ver ciertos ciclos o repeticiones en la posición final.

Se encuentran así algunas reglas
1. Si la cantidad es multiplo de 2, la posición final es 0.
2. La ecuación para descubrir la posición final es (2*Indice)+1
3. Antes de poder aplicar la formula se tiene que descubir el indice

|Cantidad|Posición final|Formula|Indice|
|--------|-------------|-------|------|
|1|1|(2*0)+1|0|
|2|1|(2*0)+1|0|
|3|3|(2*1)+1|1|
|4|1|(2*0)+1|0|
|5|3|(2*1)+1|1|
|6|5|(2*2)+1|2|
|7|7|(2*3)+1|3|
|8|1|(2*0)+1|0|
|9|3|(2*1)+1|1|
|10|5|(2*2)+1|2|
|11|7|(2*3)+1|3|
|12|9|(2*4)+1|4|
|13|11|(2*5)+1|5|
|14|13|(2*6)+1|6|
|15|15|(2*7)+1|7|
|16|1|(2*0)+1|0|
|17|3|(2*1)+1|1|
|18|5|(2*2)+1|2|
|19|7|(2*3)+1|3|
|20|9|(2*4)+1|4|
|21|11|(2*5)+1|5|
|22|13|(2*6)+1|6|
|23|15|(2*7)+1|7|
|24|17|(2*8)+1|8|
|25|19|(2*9)+1|9|
|26|21|(2*10)+1|10|
|27|23|(2*11)+1|11|
|28|25|(2*12)+1|12|
|29|27|(2*13)+1|13|
|30|29|(2*14)+1|14|
|31|31|(2*15)+1|15|
|32|1|(2*0)+1|0|
|33|3|(2*1)+1|1|
|34|5|(2*2)+1|2|
|35|7|(2*3)+1|3|
|36|9|(2*4)+1|4|
|37|11|(2*5)+1|5|
|38|13|(2*6)+1|6|
|39|15|(2*7)+1|7|
|40|17|(2*8)+1|8|
|41|19|(2*9)+1|9|


Para descubir el valor del **Indice** hay que notar los siguientes aspectos:
1. El indice es un entero positivo incluyendo el 0
2. El indice aumenta de 1 en 1
3. El indice se reinicia a 0 cada vez que hay un múltiplo de 2.

Entonces el indice se peude saber al caclular la distancia entre la cantidad y el multiplo de 2 menor y más cercano

**Indice = Cantidad - (Multiplo de 2 más cercano y menor)**

**Posición final = 2*(Indice)+1**

Regresando al problema de Josephius, la única información que te dicen es que había 41 soldados, entonces:

Cantidad    = 41
Indice      = ??
Posición final =??

El multiplo de 2 menor a 41 pero más cercano es el 32
**Indice = 41-32 = 9**
**Posición final = 2*9 +1**

Cantidad        = 41
Indice          = 9
Posición final  = 19

