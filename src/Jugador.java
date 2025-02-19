import java.util.Random;

import javax.swing.JPanel;

public class Jugador {
    private int TOTAL_CARTAS=10; //Atributo para las cartas

    private int DISTANCIA=40; //numero para posicion de  las cartas en el panel
    private int MARGEN = 10; //numero para posicion de  las cartas en el panel
    private Carta[] cartas = new Carta[TOTAL_CARTAS]; // vector para las 10 cartas
    private Random r = new Random();// atributo random que  metodo Carta lo pide

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
                    mensaje += Grupo.values()[contador] + " de "+ NombreCarta.values()[posicion]  + "\n";
                   
                }
                posicion ++;
            }
            
        }

        return mensaje;
    }
}


