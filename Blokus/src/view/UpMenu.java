package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
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
	
	
	
	public UpMenu()  {
		 
		 archivo = new JMenu("Archivo");
		 ayudas = new JMenu("Ayuda");
		 salir = new JMenu("Salir");
		
		
		this.add(archivo);
		this.add(ayudas);
		this.add(new JSeparator());
		this.add(salir);
		
		NPartida = new JMenuItem("Nueva Partida");
		NPartida.addActionListener(this);
		archivo.add(NPartida);	
	
		instrucciones = new JMenuItem("Instrucciones");
		instrucciones.addActionListener(this);
		ayudas.add(instrucciones);
		
		Rpartida = new JMenuItem("Reiniciar Partida");
		Rpartida.addActionListener(this);
		ayudas.add(Rpartida);
		
		 
		SalirE = new JMenuItem("Salir al escritorio");
		SalirE.addActionListener(this);
		salir.add(SalirE);	
		
		VolverP = new JMenuItem("Volver al menu principal");
		VolverP.addActionListener(this);
		salir.add(VolverP);
		
					
	
		}
		
			@Override
		public void actionPerformed(ActionEvent e) {
			
			
			
			if (e.getSource().equals(NPartida)) {
				JOptionPane.showMessageDialog(null, "Nueva Partida");
			}
		
			if(e.getSource().equals(SalirE)) {
				System.exit(WIDTH);
			}
			if(e.getSource().equals(instrucciones)) {
				JOptionPane.showMessageDialog(null, ayuda);
			}
			if(e.getSource().equals(Rpartida)) {
				//Llamada al m�todo reiniciarPartida();
				JOptionPane.showMessageDialog(null, "Reiniciar Partida");
			}
			
			if(e.getSource().equals(VolverP)) {
				//Llamada al m�todo reiniciarPartida();
				JOptionPane.showMessageDialog(null, "Volver a menu");
			}
			
			
		}
		
		
	}




