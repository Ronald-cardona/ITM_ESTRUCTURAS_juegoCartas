import java.util.Random;

import javax.swing.JPanel;

public class Jugador {
    private int TOTAL_CARTAS=10; //Atributo para las cartas

    private int DISTANCIA=40; //numero para posicion de  las cartas en el panel
    private int MARGEN = 10; //numero para posicion de  las cartas en el panel
    private Carta[] cartas = new Carta[TOTAL_CARTAS]; // vector para las 10 cartas
    private Random r = new Random();// atributo random que  metodo Carta lo pide
    int posicion = 0; //indice del for

    //metodo repartir  cartas que sera publico porque viene de clase carta
    public void repartir(){
        for (int i=0;i<TOTAL_CARTAS; i++) { //for para indicarle que necesitamos 10 cartas para cada jugador
            cartas[i]= new Carta(r); // cada jugador tiene su suerte, genera cartas aleatorias

        }
    }
        //metodo para mostrar las cartas 
        public void mostrar(JPanel pnl){ //necesita un panel 
            pnl.removeAll();
            int x = MARGEN + (TOTAL_CARTAS-1)  * DISTANCIA; // esto es para que la carta quede al derecho
            for(Carta carta : cartas){   //ciclo for objetual. 
                carta.mostrar(pnl, x, MARGEN); // donde estara (pnl) y lugar (x,MARGEN)
                x -= DISTANCIA; //hace parte de la funcion para que la carta quede al derecho

            }
             pnl.repaint(); //esta accion es para actualizar las cartas 

        }
        //metodo para grupos de cartas 
        public String getGrupos(){
            String mensaje = "No se encontraron grupos  ";
            //vector para saber el numero de cartas iguales
            int[] contadores = new int[NombreCarta.values().length];

            for(Carta carta : cartas){   // recorremos el ciclo con el  for objetual. 

                contadores[carta.getNombre().ordinal()] ++; //incrementa en 1 el contador de la carta
            }


            //verificar si hubo grupos
            boolean hayGrupos = false;
            
           // ciclo mientras para recorrer los contadores 
           for (int contador : contadores){
                if( contador >= 2){ 
                    hayGrupos = true;
                    break;
                }
           }

           if(hayGrupos){
            mensaje = "Se encontraron los siguientes grupos:\n";
            int posicion = 0; //indice del for
            for( int contador : contadores){
                if(contador >= 2){
                    mensaje += Grupo.values()[contador] + " de "+ NombreCarta.values()[posicion ]  + "\n";
                   
                }
                posicion ++;
            }
            
        }

        return mensaje;
    }
    //metodo para mostrar la escalera 
    public String mostrarEscalera() {
       String  mensaje = "No se encontraron escaleras de la misma pinta";
       
       // Matriz para contar la cantidad de cartas por pinta y nombre
       int[][] contador = new int[Pinta.values().length][NombreCarta.values().length];
   
       // Llenamos la matriz con la información de las cartas
       for (Carta carta : cartas) {
           contador[carta.getPinta().ordinal()][carta.getNombre().ordinal()]++;
       }
   
       // Revisamos cada pinta para detectar escaleras
       for (int i = 0; i < Pinta.values().length; i++) {
           int consecutivas = 0; // Contador de cartas consecutivas en la misma pinta
           int inicioEscalera = -1; // Para registrar el inicio de la escalera
   
           for (int j = 0; j < NombreCarta.values().length; j++) {
               if (contador[i][j] > 0) {
                   if (inicioEscalera == -1) inicioEscalera = j;
                   consecutivas++;
               } else {
                   if (consecutivas >= 2) break; // Si ya detectamos una escalera, salimos
                   consecutivas = 0; 
                   inicioEscalera = -1; //reiniciamos valores
               }
           }
   
           if (consecutivas >= 2) { 
               if (mensaje.equals("No se encontraron escaleras de la misma pinta")) { //cambia este mensaje cuando encuentra una segunda escalera
                   mensaje = "Se encontraron las siguientes escaleras:\n"; 
               }
               mensaje += "\n"+"Escalera de " + Pinta.values()[i] + " : ";
               
               for (int j = inicioEscalera; j < NombreCarta.values().length && contador[i][j] > 0; j++) {
                   mensaje +=  NombreCarta.values()[j] + ", ";
               }
             
           }
       }
   
       return mensaje;
   
      
    }
    //metodo puntuacion 
    public String puntuacion() {
        String  mensaje = "No tiene puntos" ;
        int puntaje = 0; // acumulador para sumar el puntaje 

        
        //obtener las cartas de los metodos anteriores 
        String grupos = getGrupos();
        String escaleras = mostrarEscalera();

        //vector para conocer las cartas que no pertenecen ni a grupos ni a escaleras
       
        int[] cartasSueltas = new int[NombreCarta.values().length];

        boolean hayPuntos = false;

    // Verificar cada carta
    for (Carta carta : cartas) {
        int indice = carta.getNombre().ordinal();

        // Si la carta no esta en grupos y no esta en escaleras, sera una carta suelta y por consiguiente habra puntos
        if (!grupos.contains(carta.getNombre().name()) && !escaleras.contains(carta.getNombre().name())) { //.name es para que de nombre carta solo me llegue el nombre
            cartasSueltas[indice] = 1;
            hayPuntos = true;
            puntaje += valorCarta(carta.getNombre()); // valor carta se va a sumar y va a quedar en nuestro acumulador 
        }
    }

    
    if (hayPuntos) {
        mensaje = "La puntuacion de las cartas sueltas es:  " + puntaje + " " + " y las cartas son : " + " \n";
       
        String cartasNoPertenecen = "";  //este es nuestro acumulador para las cartas sueltas 

        for (int i = 0; i < cartasSueltas.length; i++) {
            if (cartasSueltas[i] == 1) {
                cartasNoPertenecen += 
                mensaje += NombreCarta.values()[i] + ". " + " \n" ;
                
            }
           
        }

        

        
    }

    return mensaje;  
}
//metodo para tener los valores de las cartas 
private int valorCarta (NombreCarta nombre){

    switch (nombre) { //menu donde utilizaremos el nombre que ya teniamos en NombreCarta
        case DOS: return 2;
        case TRES: return 3;
        case CUATRO: return 4;
        case CINCO: return 5;
        case SEIS: return 6;
        case SIETE: return 7;
        case OCHO: return 8;
        case NUEVE:return 9;
        case DIEZ: return 10;
        case JACK: return 10;
        case QUEEN: return 10;
        case KING: return 10;
        case AS: return 10;
    
        default: return 0;
           
    }



   
}
       

    
}
                      
    



                
    

        

      
    



