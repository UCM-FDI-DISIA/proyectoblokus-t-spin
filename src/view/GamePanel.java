package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.Controller;
import model.GameObserver;
import model.Jugador;

public class GamePanel extends JPanel implements GameObserver {

	private static final long serialVersionUID = -9060831481452731983L;
	private TableroPanel tablero;
	private PanelJugadores panelJ;
	private PlayerMove move;
	private JPanel pFichas;
	private Controller _ctrl;
	
	private JScrollPane scrollPane;
	
	private ArrayList<ImageIcon> redFichas;
	private ArrayList<ImageIcon> blueFichas;
	private ArrayList<ImageIcon> yellowFichas;
	private ArrayList<ImageIcon> greenFichas;
	private ArrayList<ArrayList<ImageIcon>> colors;
	
	
	
	public GamePanel(Controller _ctrl) {
		super(new BorderLayout());
		this._ctrl = _ctrl;
		this._ctrl.addObserver(this);
		initGui();
	}
	
	
	private void initGui() {
		
		redFichas = new ArrayList<ImageIcon>();
		blueFichas = new ArrayList<ImageIcon>();
		yellowFichas = new ArrayList<ImageIcon>();
		greenFichas = new ArrayList<ImageIcon>();
		
		for (int i=0;i<21;i++) { // TODO check if remaining is equal to 21 when we call it here
			
			redFichas.add(new ImageIcon(((new ImageIcon("resources/FichasRojas/"+i+".png")).getImage()).getScaledInstance(100, 90, Image.SCALE_DEFAULT)));
			blueFichas.add(new ImageIcon(((new ImageIcon("resources/FichasAzules/"+i+".png")).getImage()).getScaledInstance(100, 90, Image.SCALE_DEFAULT)));
			yellowFichas.add(new ImageIcon(((new ImageIcon("resources/FichasAmarillas/"+i+".png")).getImage()).getScaledInstance(100, 90, Image.SCALE_DEFAULT)));
			greenFichas.add(new ImageIcon(((new ImageIcon("resources/FichasVerdes/"+i+".png")).getImage()).getScaledInstance(100, 90, Image.SCALE_DEFAULT)));
		}
		
		colors = new ArrayList<ArrayList<ImageIcon>>();
		colors.add(redFichas);
		colors.add(blueFichas);
		colors.add(yellowFichas);
		colors.add(greenFichas);

		tablero = new TableroPanel(_ctrl);
		panelJ = new PanelJugadores(_ctrl);
		move = new PlayerMove(_ctrl);
		
		pFichas = new JPanel();
		pFichas.add(new FichasPanel(_ctrl, pFichas, this, colors));
		
		scrollPane = new JScrollPane(pFichas, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setPreferredSize(new Dimension(0,200));
		
		JPanel eastPanel = new JPanel();
		eastPanel.setLayout(new BorderLayout(0, 0));
		eastPanel.setPreferredSize(new Dimension(420,500));
		eastPanel.add(panelJ.numJugadores(), BorderLayout.NORTH);
		eastPanel.add(move, BorderLayout.SOUTH);
	
		this.add(eastPanel, BorderLayout.EAST);
		this.add(scrollPane, BorderLayout.SOUTH);
		this.add(tablero, BorderLayout.CENTER);
		
		
	}
	
	public void cargarFichasJugador(JPanel previousPanel) {
		
		previousPanel.setVisible(false);
<<<<<<< HEAD
		pFichas.removeAll();
		pFichas.add(new FichasPanel(ctrl, pFichas, this, colors));
=======
		pFichas.add(new FichasPanel(_ctrl, pFichas, this));
>>>>>>> parent of 2a258a4 (FichasPanel actualiza los botones)
		pFichas.setVisible(true);	
		
	}

	@Override
	public void onReset(List<Jugador> jugadores, HashMap<String, String> mapaCasillas) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onFichaAnadida(int x, int y, int f, Jugador jugador) {
		// TODO Auto-generated method stub
		colors.get(jugador.getId()).remove(f);
		
	}


	@Override
	public void update(Jugador jugador) {

		
	}
	
}

