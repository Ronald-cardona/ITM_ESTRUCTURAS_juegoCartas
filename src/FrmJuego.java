import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class FrmJuego extends JFrame {
    
    JPanel pnlJugador1; // lo declaramos global para que lo reconozca en otros metodos
    JPanel pnlJugador2; 
    JTabbedPane tpJugadores;

    public FrmJuego() {
        setSize(700, 250);
        setTitle("Juguemos al apuntado!");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);

        //boton repartir
        JButton btnRepartir = new JButton("Repartir"); //funcion para  el texto  del boton
        btnRepartir.setBounds(10, 10, 100, 25); //lugar donde el boton estara
        getContentPane().add(btnRepartir); //funcion para agregar el boton 

        //boton verificar 
        JButton btnVerificar = new JButton("Grupos");
        btnVerificar.setBounds(120, 10, 100, 25);
        getContentPane().add(btnVerificar);

        //boton de puntaje total
        JButton btnPuntaje =  new JButton("Puntaje total");
        btnPuntaje.setBounds(340, 10, 120, 25);  
        getContentPane().add(btnPuntaje);

        //boton escaleras
        JButton btnEscalera = new JButton ("Escaleras");
        btnEscalera.setBounds(230, 10, 100, 25);
        getContentPane().add(btnEscalera);



        tpJugadores = new JTabbedPane();
        tpJugadores.setBounds(10, 40, 650, 150);
        getContentPane().add(tpJugadores);

        //panel para el jugador 1 (pestaña)
        pnlJugador1 = new JPanel(); 
        pnlJugador1.setBackground(new Color(25, 25, 115)); //fondo de color para el jugador 
        pnlJugador1.setLayout(null);

        //panel para el jugador 2 (pestaña)
        pnlJugador2 = new JPanel(); 
        pnlJugador2.setBackground(new Color(10, 130, 50));
        pnlJugador2.setLayout(null); 

        tpJugadores.addTab("Martín Estrada Contreras", pnlJugador1); //nombre para el panel 1
        tpJugadores.addTab("Raúl Vidal", pnlJugador2); // nombre para el panel 2

        btnRepartir.addActionListener(new ActionListener() { //escuchador de repartir cartas
            @Override
            public void actionPerformed(ActionEvent e) { //cada escuchador tiene este metodo por defecto
                repartirCartas();
            }
        });

        btnVerificar.addActionListener(new ActionListener() {  //escuchador de verificar cartas
            @Override
            public void actionPerformed(ActionEvent e) {  
                verificarGrupos();
            }
        });

        btnPuntaje.addActionListener(new ActionListener() { //escuchador boton puntaje 

            @Override
            public void actionPerformed(ActionEvent e) {
               puntajeTotal();
            }
            
        });

        btnEscalera.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
               escalera();
            }
            
        });

    
    }

    Jugador jugador1 = new Jugador(); //instanciamos jugador para que se repartan las cartas
    Jugador jugador2 = new Jugador();

    //metodo para traer los metodos repartir y mostrar de la clase jugador
    private void repartirCartas() {
        jugador1.repartir();//repartir jugador 1
        jugador1.mostrar(pnlJugador1); //mostrar cartas 1
        

        jugador2.repartir(); //repartir jugador 2
        jugador2.mostrar(pnlJugador2);//mostrar cartas jugador 2
       
    }

    private void verificarGrupos() {
        int pestañaSeleccionada  = tpJugadores.getSelectedIndex();

        //menu 
        switch (pestañaSeleccionada) {
            case 0:
                JOptionPane.showMessageDialog(null, jugador1.getGrupos());
                
                break;
        
            case 1:
                JOptionPane.showMessageDialog(null, jugador2.getGrupos());
        
                break;
        }

    }

    private void escalera(){
        int pestañaSeleccionada = tpJugadores.getSelectedIndex();

        switch (pestañaSeleccionada) {
            case 0:
            JOptionPane.showMessageDialog(null, jugador1.mostrarEscalera());
                
                break;
        
            case 1:
            JOptionPane.showMessageDialog(null, jugador2.mostrarEscalera());
                break;
        }
    }

    private void puntajeTotal(){
        int pestañaSeleccionada = tpJugadores.getSelectedIndex();

        switch (pestañaSeleccionada) {
            case 0:
                JOptionPane.showMessageDialog(null, jugador1.puntuacion());
                
                break;
        
            case 1:
                JOptionPane.showMessageDialog(null, jugador2.puntuacion());

                break;
        }


    }

}
