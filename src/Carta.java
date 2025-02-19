import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Carta {
    private int indice; //atributo 

    //metodo donde declaramos como va a funcionar el indice 
    public Carta(Random r) { //le generamos un random al metodo porque siempre sera aleatorio 
        indice = r.nextInt(52) + 1; //son 52 cartas en total 
    }
    //metodo para obtener la pinta
    public Pinta getPinta() {
        if (indice <= 13) { // si el indice es menor o igual a 13
            return Pinta.TREBOL; //retornaremos del enumerado Pinta, el trebol
        } else if (indice <= 26) {
            return Pinta.PICA;
        } else if (indice <= 39) {
            return Pinta.CORAZON;
        } else {                    // si ninguna de las condiciones anteriores se cumplen la pinta sera diamante
            return Pinta.DIAMANTE;
        }
    }

    public NombreCarta getNombre() {
        int posicion = indice % 13;
        if (posicion == 0) {
            posicion = 13;
        }
        return NombreCarta.values()[posicion - 1];
    }
    //metodo para mostrar carta
    public void mostrar(JPanel pnl, int x, int y) {
        String nombreArchivo = "/imagenes/CARTA" + String.valueOf(indice) + ".jpg"; //la imagen depende del indice
        ImageIcon imagen = new ImageIcon(getClass().getResource(nombreArchivo)); //llama a la imagen como un recurso

        JLabel lbl = new JLabel(imagen);
        lbl.setBounds(x, y, imagen.getIconWidth(), imagen.getIconHeight());
        pnl.add(lbl);
    }
}
