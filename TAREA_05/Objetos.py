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
