package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import controller.Controller;

public class UpMenu extends JMenuBar implements ActionListener{
	private String ayuda="El objetivo es colocar la mayor cantidad de las 21 piezas en el tablero. Cada pieza debe tocar al menos\r\n" + 
			"otra del mismo color, pero solo por una de las esquinas. El juego termina cuando ningun jugador\r\n" + 
			"puede colocar una pieza. ";
	private JMenu archivo, ayudas, ventana, salir;
	private JMenuItem NPartida, instrucciones, Rpartida, tam1,tam2,SalirE,VolverP;
	private Controller _controller;
	
	
	public UpMenu(Controller controller)  {
		_controller=controller;
		menuS();
		this.setVisible(true);
		
		}
	
	public void menuS(){
	   
	    //JMenuBar this= new JMenuBar();
		JMenu archivo = new JMenu("Archivo");
		JMenu ayudas = new JMenu("Ayuda");
		JMenu ventana = new JMenu("Ventana");
		JMenu salir = new JMenu("Salir");
		
		JMenuItem NPartida = new JMenuItem("Nueva Partida");
		
		JMenuItem instrucciones = new JMenuItem("Instrucciones");
		JMenuItem Rpartida = new JMenuItem("Reiniciar Partida");
		
		JMenuItem tam1 = new JMenuItem("640*480");
		JMenuItem tam2 = new JMenuItem("1024*768");
		
		JMenuItem SalirE = new JMenuItem("Salir al escritorio");
		JMenuItem VolverP = new JMenuItem("Volver al menu principal");
		
		archivo.add(NPartida);
		
		ayudas.add(instrucciones);
		ayudas.add(Rpartida);
		
		ventana.add(tam1);
		ventana.add(tam2);
		
		salir.add(SalirE);
		salir.add(VolverP);
		
		
		
		this.add(archivo);
		this.add(ayudas);
		this.add(ventana);
		this.add(new JSeparator());
		this.add(salir);

		//add(this);
		
	}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource()==tam1) {
				setSize(640,480);
			}
			if (e.getSource()==tam2) {
				setSize(1024,768);
			}
			if (e.getSource()==NPartida) {
				JOptionPane.showMessageDialog(null, "Nueva Partida");
			}
		
			if(e.getSource()==salir) {
				System.exit(WIDTH);
			}
			if(e.getSource()==instrucciones) {
				JOptionPane.showMessageDialog(null, ayuda);
			}
			if(e.getSource()==Rpartida) {
				//Llamada al m�todo reiniciarPartida();
				JOptionPane.showMessageDialog(null, "Reiniciar Partida");
			}
			
			if(e.getSource()==VolverP) {
				//Llamada al m�todo reiniciarPartida();
				JOptionPane.showMessageDialog(null, "Volver a menu");
			}
			
			
		}
		
		
	}




