# Num. 4. Islas


* Alumno    : Rodriguez Ramírez Octavio Trinidad
* Materia   : Inteligencia Artificial
* Profesor  : Alcaráz Chavéz Jésus Eduardo
* Fecha     : 07 de Diciembre del 2023

# Introducción

A continuación se muestra la solución al ejercicio #4 planteado por el profesor  Alcaráz Chavéz Jésus Eduardo; este ejercicio incluye la programación de código que descubra cuantas islas hay en una matriz y la explicación de como funciona el mismo. Más información sobre el problema a resolver se puede encontrar en la sección **Problema** En la sección de **Lógica** se detalla como se llegó a la solución y como se planteó el algoritmo de solución; por último están las secciones de **Código** y **Conclusiones** que muestran el código en sí y las conclusiones personales del problema.

# Problema
Se trata de contar el numero de elementos (islas) contenidos en la siguiente imagen, se requiere lo siguiente.

• Hacer un programa que pueda contar el numero de elementos que son
del mismo color

• Utilizar método iterativo y recursivo.
Mapa:
|.|.|.|.|.|.|.|.|.|.|.|.|.|.|
|-|-|-|-|-|-|-|-|-|-|-|-|-|-|
|||||||||||||||
|||||||||||||||
||*|*||||||||||||
||*|*|||||*|*|*|*||||
||*|*||||||||||||
|||||||||||||||
|||||||||||||||
|||||||||||||||
||||||||||*|*||||
||||||*|*|||*|*||||
||||||*|*|||*|*||*||
||||||*|*|||*|*||*||
||||||*|*|||*|*||*||
|||||||||||||*||
|||||||||||||*||
|||||||||||||*||
|||||||||||||*||
|||*|*|*|*|||||||*||


# Lógica
Para este problema se utilizo el lenguaje de programación Java y el editor de código Apache Netbeans; se comienza al crear variables estáticas *filas*, *columnas* y la *matriz* que representa el espacio de tierra y mar donde se buscan las islas.

Mar     =0s
Islas   =1s

Para el proceso recursivo se ocupan 3 funciones: main, recursiva, casillaExiste:
1. Main =  Contiene un ciclo que revida casilla por casilla y si encuentra una isla aumenta un contador de islas y llama a la función recursiva para seguir el proceso.Al final imprime e contador de islas

2. CasillaExiste = Función booleana que avisa si la casilla existe. Al revisar las 8 casillas adyacentes a una isla, podemos caer en el problema de que la suma o resta en los indices de la matriz da como resultado casillas que no existen. Esta funcion evita caer en ese error.

3. Recursiva = Funcion recursiva que contiene las condiciones para revisar las 8 casillas adyacentes a una isla, y si encuentra un 1  en alguna de esas casillas lo transforma en 0 y repite el proceso.


Para el proceso iterativo se requiere un cambio de lógica: Si se aplica la lógica recursiva anterior a un proceso iterativo van a salir más islas de las que hay, porque la recursividad se aseguraba que los 1s más alejados del inicial se contaran adentro de la isla.
En este caso, ya no va a transformar los 1 revisados en 0s, sino en 2s; y si la iteración encuentra un 1s adjuntos a un 2, lo  tranformará en 2. Esto resuelve rápidamente el problema de los 1s alejados del inicial, pues ya no sólo checa el 1 inicial, sino los 2 cercanos.

1. Main

2. CasillaExiste = Realiza lo mismo que en el proceso recurisvo, sólo existe para asegurarse

# Código

public class IslasRecursivo {
    
    static int filas       =18;
    static int columnas    =14;
    static int matriz[][] = {
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,1,1,0,0,0,0,0,0,0,0,0,0,0},
			{0,1,1,0,0,0,0,1,1,1,1,0,0,0},
			{0,1,1,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,1,1,0,0,0},
			{0,0,0,0,0,1,1,0,0,1,1,0,0,0},
			{0,0,0,0,0,1,1,0,0,1,1,0,1,0},
			{0,0,0,0,0,1,1,0,0,1,1,0,1,0},
			{0,0,0,0,0,1,1,0,0,1,1,0,1,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,1,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,1,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,1,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,1,0},				
			{0,0,1,1,1,1,0,0,0,0,0,0,1,0},
	};

    

    public static void main(String[] args) {
        //Paso 1 
        int islas=0;
       
       
        for(int i=0;i<filas;i++){
            for(int j=0;j<columnas; j++){
                if(matriz[i][j]==1){
                    islas++;
                    recursiva(i, j);
                }
            }       
        }
        System.out.println("Hay "+islas+" islas en el mapa");
    }

    
    public static boolean casillaExiste(int i, int j){
        return i>= 0 && j>=0 && i<filas && j<columnas;
    }
   
    public static void  recursiva (int i, int j){
        if(casillaExiste(i, j)!= true){
            return;} 

     //Primera fila
      if(casillaExiste(i-1,j-1)== true && matriz[i-1][j-1] ==1 ){
          matriz[i-1][j-1] =0;
          recursiva(i-1,j-1);
      }
      
       if(casillaExiste(i-1,j)== true && matriz[i-1][j] ==1 ){
            matriz[i-1][j] = 0;
            recursiva(i-1,j);
      }
       
        if(casillaExiste(i-1,j+1)== true && matriz[i-1][j+1] ==1 ){
            matriz[i-1][j+1] =0;
            recursiva(i-1,j+1);
      }
      
       //Segunda fila
    
       if(casillaExiste(i,j-1)== true && matriz[i][j-1] ==1 ){
           matriz[i][j-1] =0;
           recursiva(i,j-1);
      }
      
       if(casillaExiste(i,j+1)== true && matriz[i][j+1] ==1 ){
           matriz[i][j+1] =0;
           recursiva(i,j+1);
      }
      
      //Tercera columna    
      if(casillaExiste(i+1,j-1)== true && matriz[i+1][j-1] ==1 ){
          matriz[i+1][j-1] =0;
          recursiva(i+1,j-1);
      }
      
       if(casillaExiste(i+1,j)== true && matriz[i+1][j] ==1 ){
           matriz[i+1][j] =0;
           recursiva(i+1,j);
      }
       
        if(casillaExiste(i+1,j+1)== true && matriz[i+1][j+1] ==1 ){
            matriz[i+1][j+1] =0;
            recursiva(i+1,j+1);
      }    
          
    }

}


public class IslasIterativas {

     static int filas       =18;
    static int columnas    =14;
    static int matriz[][] = {
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,1,1,0,0,0,0,0,0,0,0,0,0,0},
			{0,1,1,0,0,0,0,1,1,1,1,0,0,0},
			{0,1,1,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,1,1,0,0,0},
			{0,0,0,0,0,1,1,0,0,1,1,0,0,0},
			{0,0,0,0,0,1,1,0,0,1,1,0,1,0},
			{0,0,0,0,0,1,1,0,0,1,1,0,1,0},
			{0,0,0,0,0,1,1,0,0,1,1,0,1,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,1,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,1,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,1,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,1,0},				
			{0,0,1,1,1,1,0,0,0,0,0,0,1,0},
	};
    
    public static void main(String[] args) {
       int islas=0;
       
       
        for(int i=0;i<filas;i++){
            for(int j=0;j<columnas; j++){
                if(matriz[i][j]==1){
                    islas++;
                    iterativa(i,j);
                }
                if(matriz[i][j]==2){
                    iterativa(i, j);
                }
                
            }       
        }
        System.out.println("Hay "+islas+" islas en el mapa");
    }
    
    public static boolean casillaExiste(int i, int j){
        return i>= 0 && j>=0 && i<filas && j<columnas;
    }
   
    public static void iterativa(int i, int j){
      
    //Primera fila
      if(casillaExiste(i-1,j-1)== true && matriz[i-1][j-1] ==1 ){
          matriz[i-1][j-1] =2;
       
      }
      
       if(casillaExiste(i-1,j)== true && matriz[i-1][j] ==1 ){
            matriz[i-1][j] = 2;
  
      }
       
        if(casillaExiste(i-1,j+1)== true && matriz[i-1][j+1] ==1 ){
            matriz[i-1][j+1] =2;
        }
      
       //Segunda fila
    
       if(casillaExiste(i,j-1)== true && matriz[i][j-1] ==1 ){
           matriz[i][j-1] =2;
       
      }
      
       if(casillaExiste(i,j+1)== true && matriz[i][j+1] ==1 ){
           matriz[i][j+1] =2;
          
      }
      
      //Tercera columna    
      if(casillaExiste(i+1,j-1)== true && matriz[i+1][j-1] ==1 ){
          matriz[i+1][j-1] =2;
      
      }
      
       if(casillaExiste(i+1,j)== true && matriz[i+1][j] ==1 ){
             matriz[i+1][j] =2;
      }
       
        if(casillaExiste(i+1,j+1)== true && matriz[i+1][j+1] ==1 ){
            matriz[i+1][j+1] =0;
            
      }    
          
        
      
      
    //iterativa
    }
    
   
}



# Conclusiones: 
Este problema es mucho más sencillo de manera recursiva, sin embargo es interesante ver la manera iterativa de resolverlo sólo por tener diferentes opciones de cómo resilverlo. También es bueno que podamos usar cualquier lenguaje de programación en el ejercicio porque Java es un lenguaje con el que tengo mayor experiencia; aunque cualquier otro lenguaje de programación de alto nivel que acepte matrices o vectores bidimensionales serviría para resolver este problema.