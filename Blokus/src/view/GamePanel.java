package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

import controller.Controller;
import model.GameObserver;
import model.Jugador;

public class GamePanel extends JPanel implements GameObserver {

	private static final long serialVersionUID = -9060831481452731983L;
	private static int numPlayers;
	TableroPanel tablero;
	PanelJugadores panelJ;
	/*
	private PuntuationPanel puntPanel;
	private PassButton passButton;
	private RotateButton rotateButton;
	private PlayerPanel playerPanel;
	*/
	Controller ctrl;
	
	public GamePanel(Controller ctrl, int numPlayers) {
		super(new BorderLayout());
		this.numPlayers = numPlayers;
		this.ctrl = ctrl;
		initGui();
	}
	
	
	public void initGui() {
		//Añadir panel del tablero
		tablero = new TableroPanel(ctrl);
		panelJ = new PanelJugadores(numPlayers);
		//Añadir panel de puntuacion dejugadores
		//Añadir panel de pasar turno
		//Añadir panel de rotar
		//Añadir panel de fichas del jugador	
		
		
		//Test del layout para que veais como queda cada panel
		// Sustituid cada JButton de ejemplo por el vuestro
		// Si es un panel, eliminad el JButton y sustituid el JPanel de ejemplo
		JButton passButton = new JButton("Pasar tuno");
		JButton rotateButton = new JButton("Rotar");
		FichasPanel pfichas =  new FichasPanel();
		
		JPanel eastPanel = new JPanel();
		
		
		eastPanel.setLayout(new BorderLayout(20, 30));
		eastPanel.add(panelJ.numJugadores(), BorderLayout.NORTH);
		eastPanel.add(passButton, BorderLayout.CENTER);
		eastPanel.add(rotateButton, BorderLayout.SOUTH);
		
		this.add(eastPanel, BorderLayout.EAST);
		this.add(pfichas.inf(), BorderLayout.SOUTH);
		this.add(tablero, BorderLayout.CENTER);
	}

	@Override
	public void onReset(List<Jugador> jugadores, HashMap<String, String> mapaCasillas) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onFichaAnadida(String color, int x, int y) {
		// TODO Auto-generated method stub
		
	}
	
}

