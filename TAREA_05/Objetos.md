# Num. 5. Objetos rojos


* Alumno    : Rodriguez Ramírez Octavio Trinidad
* Materia   : Inteligencia Artificial
* Profesor  : Alcaráz Chavéz Jésus Eduardo
* Fecha     : 07 de Diciembre del 2023

# Introducción

A continuación se muestra la solución al ejercicio #4 planteado por el profesor  Alcaráz Chavéz Jésus Eduardo; este ejercicio incluye la programación de código que descubra cuantos objetos de color rojo hay en una imagen y la explicación de como funciona el mismo. Más información sobre el problema a resolver se puede encontrar en la sección **Problema** En la sección de **Lógica** se detalla como se llegó a la solución y como se planteó el algoritmo de solución; por último están las secciones de **Código** y **Conclusiones** que muestran el código en sí y las conclusiones personales del problema.

# Problema
Una vez que se resolvió el algoritmo de las islas en la siguiente imagen
contar los elementos que tienen el color rojo.

 ![Imagen con objetos rojos](/IA/Octavio/TAREA_05/Imagen.jpg)

# Lógica
Lista de pasos para resolver el problema, utilizando el lenguaje de programación Python y su librería OpenCV.

1. Importar la librería CV
2. Extraer la imagen.
3. Transformar la imagen  al modelo de color HSV.
4. Crear los umbrales de color.
Cómo se pide del color rojo, y el modelo de color HSV tiene el rojo en sus orillas, hay 2 umbrales de color a considerar. Si se usa sólo uno se van a encontrar menos objetos, y como prueba de ello se calcularan 2 veces los objetos, una vez usando sólo 1 umbral y la segunda vez utilizando los 2.

<code>
bajo1       = (0,100, 20)
alto1       = (7,255,255)
bajo2       = (175,100,20)
alto2       = (179,255,255)
</code>

5. Se crean las máscaras de color con los umbrales anteriores.
6. Se aplican las máscaras sobre las imagenes
7. Se calculan los contornos de los objetos.
    <code>
    contornos1  = cv2.findContours(mascara1, cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_SIMPLE)[0]
    contornos2  = cv2.findContours(mascara2, cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_SIMPLE)[0]
    </code>
8. Se calculan la cantidad de contornos que hay en ambos casos
    <code>
    print(len(contornos1))
    print(len(contornos2))
</code>

Respuesta: 

**1125** objetos usando ambos umbrales de color
**511** Usando sólo 1

# Código
import cv2

imagen      = cv2.imread('IA\Octavio\TAREA_05\Imagen.jpg',1)
imagenHSV   = cv2.cvtColor(imagen, cv2.COLOR_BGR2HSV)

bajo1       = (0,100, 20)
alto1       = (7,255,255)
bajo2       = (175,100,20)
alto2       = (179,255,255)

mascara1    = cv2.inRange(imagenHSV, bajo1, alto1)
mascara2    = cv2.inRange(imagenHSV, bajo2, alto2)
mascara3    = mascara1 + mascara2

conMascara1 = cv2.bitwise_and(imagen, imagen, mask= mascara3)
conMascara2 = cv2.bitwise_and(imagen, imagen, mask= mascara2)
contornos1  = cv2.findContours(mascara1, cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_SIMPLE)[0]
contornos2  = cv2.findContours(mascara2, cv2.RETR_EXTERNAL, cv2.CHAIN_APPROX_SIMPLE)[0]

print(len(contornos1))
print(len(contornos2))
cv2.imshow('Imagen con ambas máscaras', conMascara1)
cv2.imshow('Imagen con sólo una',       conMascara2)
cv2.waitKey(0)
cv2.destroyAllWindows()

# Conclusiones

Este programa es bastante corto en comparación con los códigos de otras tareas y es muy autodesciptivo porque en la materia ya se había utilizado la libería OpenCV y Python como herramientas de trabajo, además de que se nos proporciono un libro especícamente de eso, por lo que no fue complicado de realizar. Sea djunta en la entrega el archivo original en python y la imagen que se utillizó