import java.util.Random;

import javax.swing.JPanel;

public class Jugador {
    private int TOTAL_CARTAS=10; //Atributo para las cartas

    private int DISTANCIA=40;//numero para mostrar las cartas 
    private int MARGEN = 10;
    private Carta[] cartas = new Carta[TOTAL_CARTAS]; // vector para las 10 cartas
    private Random r = new Random();// atributo random que Carta lo pide

    //metodo repartir  cartas que sera publico porque viene de clase carta
    public void repartir(){
        for (int i=0;i<TOTAL_CARTAS; i++) { //for para indicarle que necesitamos 10 cartas para cada jugador
            cartas[i]= new Carta(r); // cada jugador tiene su suerte, genera cartas aleatorias

        }
    }
        //metodo para mostrar las cartas 
        public void mostrar(JPanel pnl){ //necesita un panel 
            pnl.removeAll();
            int x = MARGEN+ (TOTAL_CARTAS-1)  *DISTANCIA; // esto es para que la carta quede al derecho
            for(Carta carta : cartas){   //ciclo for objetual. 
                carta.mostrar(pnl, x, MARGEN);
                x -= DISTANCIA;

            }
             pnl.repaint();


        }


    }


