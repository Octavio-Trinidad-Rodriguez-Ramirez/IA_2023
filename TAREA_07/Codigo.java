public class Laberinto {

    static int filas       =9;
    static int columnas    =9;
    static boolean fin     =false;
    static int laberinto[][] = {
			{1,1,1,1,1,1,1,1,1},
			{0,0,0,0,0,0,1,0,1},
			{1,1,1,0,1,1,1,0,1,},
            {1,0,0,0,1,0,1,0,1},
			{1,0,1,1,1,0,1,0,1},
			{1,0,0,0,0,0,0,0,1},
            {1,0,1,1,1,0,1,0,1},
			{3,0,1,0,0,0,1,0,1},
			{1,1,1,1,1,1,1,1,1},
			
                     
	};

    
    
    public static void main(String[] args) {
        System.out.println("Hello World!");
        recursiva(1,0);
        mostrar();
    }
    
    
    public static boolean casillaExiste(int i, int j){
        return i>= 0 && j>=0 && i<filas && j<columnas;
    }
   
    public static void mostrar(){
        for(int i=0;i<filas; i++){
            for(int j=0;j<columnas; j++){
                System.out.print(laberinto[i][j]+"  ");
            }
            System.out.println("");
        }
    }
    
    public static int recursiva(int a,int b){
        
        if(laberinto[a][b]== 3){
            fin=true;
            System.out.println("Has encontrado la salida");
            return 0;}
       
        //La casilla actual existe.
        if(casillaExiste(a,b)){
            laberinto[a][b]=5;
        }
        
        //Izquierda
        if(casillaExiste(a,b-1)){
            if(laberinto[a][b-1]==0){
                System.out.println("Izquierda");
                recursiva(a,b-1);
            }
            if(laberinto[a][b-1]==3){
                recursiva(a,b-1);
            }
            if(fin == true){
                return 0;
            }
        }
        
        //Abajo
        if(casillaExiste(a+1,b)){
           
            if(laberinto[a+1][b]==0){
                System.out.println("Abajo");
                recursiva(a+1,b);
            }
            if(laberinto[a+1][b]==3){
                recursiva(a+1,b);
            }
            if(fin == true){
                return 0;
            }
        }
      
        //Derecha
        if(casillaExiste(a,b+1)){
            
            if(laberinto[a][b+1]==0){
                System.out.println("Derecha");
                recursiva(a,b+1);
            }
            if(laberinto[a][b+1]==3){
                recursiva(a,b+1);
            }
            if(fin == true){
                return 0;
            }
        }
        
        
        
        
        //Arriba
        if(casillaExiste(a-1,b)){
             
            if(laberinto[a-1][b]==0){
                System.out.println("Arriba");
                recursiva(a-1,b);
            }
            if(laberinto[a-1][b]==3){
                recursiva(a-1,b);
            }
            if(fin == true){
                return 0;
            }
        }
        
        //Izquierdax2
        if(casillaExiste(a,b-1)){
            if(laberinto[a][b-1]==5){
                System.out.println("Regreso por la izquierda");
               return 0;
            }
        }
        
        if(laberinto[a-1][b]==5 || laberinto[a+1][b]==5){
            System.out.println("Regresar de arriba o abajo");
            return 0;
        }
        
        
        return 0;
    }
    
}
