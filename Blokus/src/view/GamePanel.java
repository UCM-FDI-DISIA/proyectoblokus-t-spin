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
	private TableroPanel tablero;
	private PanelJugadores panelJ;
	private PlayerMove move;
	private FichasPanel pFichas;
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
	
	
	private void initGui() {
		
		tablero = new TableroPanel(ctrl);
		panelJ = new PanelJugadores(numPlayers);
		move = new PlayerMove(ctrl);
		pFichas =  new FichasPanel();
		
		JPanel eastPanel = new JPanel();
		
		
		eastPanel.setLayout(new BorderLayout(20, 30));
		eastPanel.add(panelJ.numJugadores(), BorderLayout.NORTH);
		eastPanel.add(move, BorderLayout.CENTER);
	
		this.add(eastPanel, BorderLayout.EAST);
		this.add(pFichas.inf(), BorderLayout.SOUTH);
		this.add(tablero, BorderLayout.CENTER);
	}

	@Override
	public void onReset(List<Jugador> jugadores, HashMap<String, String> mapaCasillas) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onFichaAnadida(int color, int x, int y) {
		// TODO Auto-generated method stub
		
	}
	
}

