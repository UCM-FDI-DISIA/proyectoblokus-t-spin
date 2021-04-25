package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = -9060831481452731983L;
	private static int numPlayers;
	TableroPanel tablero;
	/*
	private PuntuationPanel puntPanel;
	private PassButton passButton;
	private RotateButton rotateButton;
	private PlayerPanel playerPanel;
	*/
	
	public GamePanel(int numPlayers) {
		super(new BorderLayout());
		this.numPlayers = numPlayers;
		initGui();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	public void initGui() {
		//Añadir panel del tablero
		tablero = new TableroPanel();
		//Añadir panel de puntuacion dejugadores
		//Añadir panel de pasar turno
		//Añadir panel de rotar
		//Añadir panel de fichas del jugador
		
		
		
		
		//Test del layout para que veais como queda cada panel
		// Sustituid cada JButton de ejemplo por el vuestro
		// Si es un panel, eliminad el JButton y sustituid el JPanel de ejemplo
		JButton puntButton = new JButton("Puntuacion");
		JButton passButton = new JButton("Pasar tuno");
		JButton rotateButton = new JButton("Rotar");
		JButton playerButton = new JButton("Fichas del jugador");
		
		JPanel eastPanel = new JPanel();
		JPanel playerPanel = new JPanel();
		playerPanel.add(playerButton);
		
		eastPanel.setLayout(new BorderLayout(20, 30));
		eastPanel.add(puntButton, BorderLayout.NORTH);
		eastPanel.add(passButton, BorderLayout.CENTER);
		eastPanel.add(rotateButton, BorderLayout.SOUTH);
		
		this.add(eastPanel, BorderLayout.EAST);
		this.add(playerPanel, BorderLayout.SOUTH);
		this.add(tablero, BorderLayout.CENTER);
	}
	
}

