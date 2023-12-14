### Proceso de Creación de Dataset

#### Toma de Fotos:

En esta fase del proceso, se capturan imágenes de una cámara en un bucle continuo. El usuario tiene la capacidad de definir áreas de interés mediante un rectángulo, y tiene la opción de almacenar esas regiones seleccionadas como imágenes al presionar la tecla 's'. El bucle de captura se interrumpe si el usuario presiona la tecla 'a'.

#### Estandarizar Tamaño:

Después de la captura de imágenes, se lleva a cabo un proceso de estandarización. Cada imagen se abre y recorta para formar un cuadrado centrado en la región de interés original. Posteriormente, estas imágenes se redimensionan uniformemente a un tamaño objetivo de 100x100 píxeles y se almacenan en un nuevo directorio.

#### Aplicar Filtros:

En esta etapa, se generan distintas versiones de las imágenes procesadas. Se guardan las versiones originales, así como las imágenes convertidas a escala de grises y al espacio de color HSV. Además, el código implementa manejo de errores para asegurar la integridad del proceso, especialmente al abrir imágenes.

#### Rotar Imágenes:

Cada imagen capturada experimenta rotaciones en intervalos de 15 grados, y las versiones rotadas se almacenan en un directorio separado. Si la rotación es diferente de 0, 90, 180 o 270 grados, se realiza un recorte para preservar el centro de la imagen.

#### Renombrar:

Finalmente, las imágenes resultantes se renombran de manera secuencial en el directorio correspondiente. Cada imagen recibe un nombre específico, comenzando con 'rostro' seguido por un número que refleja su orden en el conjunto de datos.

Estos pasos en conjunto forman un proceso integral para la generación y preparación de un conjunto de datos destinado a aplicaciones de aprendizaje automático.

## Toma de la fotos

```python
import cv2
import numpy as np
import imutils
import os              

Datos = 'dataset'
if not os.path.exists(Datos):
    print('Carpeta creada: ', Datos)
    os.makedirs(Datos)

cap = cv2.VideoCapture(0,cv2.CAP_DSHOW)

x1, y1 = 200, 100
x2, y2 = 500, 400

count = 0
while True:

    ret, frame = cap.read()
    if ret == False:  break
    imAux = frame.copy()
    cv2.rectangle(frame,(x1,y1),(x2,y2),(255,0,0),2)

    objeto = imAux[y1:y2,x1:x2]
    objeto = imutils.resize(objeto, width=100)
    # print(objeto.shape)

    k = cv2.waitKey(1)
    if k == ord('s'):
        cv2.imwrite(Datos+'/FotoNegativaOT_{}.jpg'.format(count),objeto)
        print('Imagen almacenada: ', 'objeto_{}.jpg'.format(count))
        count = count + 1
    if k == ord('a'): 
        break

    cv2.imshow('frame',frame)
    cv2.imshow('objeto',objeto)

cap.release()
cv2.destroyAllWindows()
```
## Estandarizar Tamaño

```python
from PIL import Image
import os
input_dir = '.\dataset'
output_dir = '.\dataset\datasetmod'
os.makedirs(output_dir, exist_ok=True)
target_size = (100, 100)
input_files = os.listdir(input_dir)
for input_file in input_files:
    input_path = os.path.join(input_dir, input_file)
    output_path = os.path.join(output_dir, input_file)
    img = Image.open(input_path)
    width, height = img.size
    size = min(width, height)
    left = (width - size) / 2
    upper = (height - size) / 2
    right = (width + size) / 2
    lower = (height + size) / 2
    square_img = img.crop((left, upper, right, lower))
    square_img.thumbnail(target_size)
    small_img = Image.new('RGB', target_size, (255, 255, 255))
    offset = ((target_size[0] - square_img.width) // 2, (target_size[1] - square_img.height) // 2)
    small_img.paste(square_img, offset)
    small_img.save(output_path)
print(f"Images saved to '{output_dir}'")
```

## Aplicar Filtros  

```python
from PIL import Image
import os
import cv2
input_dir = '.\datasets\datasetmod'
output_dir = '.\datasets\datasetfilt'
os.makedirs(output_dir, exist_ok=True)
input_files = os.listdir(input_dir)
for input_file in input_files:
    input_path = os.path.join(input_dir, input_file)
    output_path_original = os.path.join(output_dir, input_file)
    try:
        img = Image.open(input_path)
    except Exception as e:
        print(f"Error processing {input_file}: {str(e)}")
        continue
    filename, _ = os.path.splitext(input_file)
    img.save(output_path_original)
    grayscale_img = img.convert('L')
    grayscale_filename = f"{filename}_grayscale"
    grayscale_img.save(os.path.join(output_dir, f"{grayscale_filename}.jpg"))
    img_array = cv2.imread(input_path)
    hsv_img = cv2.cvtColor(img_array, cv2.COLOR_BGR2HSV)
    hsv_img = Image.fromarray(hsv_img)
    hsv_filename = f"{filename}_hsv"
    hsv_img.save(os.path.join(output_dir, f"{hsv_filename}.jpg"))
print(f"Images saved in '{output_dir}' with original, grayscale, and HSV versions.")

```

## Rotar Imagenes

```python
from PIL import Image
import os
input_dir = '.\datasets\datasetfilt'
output_dir = '.\datasets\datasetrot'
os.makedirs(output_dir, exist_ok=True)
input_files = os.listdir(input_dir)
for input_file in input_files:
    input_path = os.path.join(input_dir, input_file)
    img = Image.open(input_path)
    for i in range(0, 360, 15):
        rotated_img = img.rotate(i, expand=True):
        if i not in (0, 90, 180, 270):
            width, height = rotated_img.size
            if width > height:
                new_width = height // 2
                new_height = height // 2
            else:
                new_width = width // 2
                new_height = width // 2
            left = (width - new_width) // 2
            upper = (height - new_height) // 2
            right = left + new_width
            lower = upper + new_height
            rotated_img = rotated_img.crop((left, upper, right, lower))
            rotated_img = rotated_img.resize((100, 100))
        output_filename = f"rotated_{i}_degrees_{input_file}"
        output_path = os.path.join(output_dir, output_filename)
        rotated_img.save(output_path)
print(f"Images saved in '{output_dir}' with rotations at 15-degree intervals.")

```

## Renombrar

```python
import os
input_dir = '.\datasets\datasetrot'
output_name = 'rostro'
input_files = os.listdir(input_dir)
input_files.sort()
counter = 1
for input_file in input_files:
    if input_file.lower().endswith(('.png', '.jpg', '.jpeg', '.gif')):
        file_extension = os.path.splitext(input_file)[1]
        new_name = f"{output_name}{counter}{file_extension}"
        os.rename(os.path.join(input_dir, input_file), os.path.join(input_dir, new_name))
        counter += 1
print(f"Images renamed to '{output_name}1', '{output_name}2', ... '{output_name}{counter - 1}'.")

```