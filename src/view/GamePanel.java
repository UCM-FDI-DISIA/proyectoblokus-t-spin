package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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
	private TableroPanel tablero;
	private PanelJugadores panelJ;
	private PlayerMove move;
	private FichasPanel pFichas;
	private Controller ctrl;
	
	public GamePanel(Controller ctrl) {
		super(new BorderLayout());
		this.ctrl = ctrl;
		initGui();
	}
	
	
	private void initGui() {
		
		tablero = new TableroPanel(ctrl);
		panelJ = new PanelJugadores(ctrl);
		move = new PlayerMove(ctrl);
		pFichas =  new FichasPanel(ctrl);
		
		JPanel eastPanel = new JPanel();
		eastPanel.setLayout(new BorderLayout(0, 0));
		eastPanel.setPreferredSize(new Dimension(420,500));
		eastPanel.add(panelJ.numJugadores(), BorderLayout.NORTH);
		eastPanel.add(move, BorderLayout.SOUTH);
	
		this.add(eastPanel, BorderLayout.EAST);
		this.add(pFichas.inf(), BorderLayout.SOUTH);
		//this.add(pFichas.inf(_ctrl.getCurrentPlayer()), BorderLayout.SOUTH);
		this.add(tablero, BorderLayout.CENTER);
	}

	@Override
	public void onReset(List<Jugador> jugadores, HashMap<String, String> mapaCasillas) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onFichaAnadida(int x, int y, int f, Jugador jugador) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void update(Jugador jugador) {
		// TODO Auto-generated method stub
		
	}
	
}

