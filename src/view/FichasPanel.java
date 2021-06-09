package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.Controller;
import model.GameObserver;
import model.Jugador;
import view.MainMenu.ExitButtonListener;
import view.MainMenu.PlayersButtonListener;


public class FichasPanel extends JPanel implements GameObserver{

	private static final long serialVersionUID = 1L;
	private Controller _ctrl;
	
	private JPanel _previousPanel;
	private GamePanel _gamePanel;
	
	private ImageIcon redPlayer;
	private ImageIcon bluePlayer;
	private ImageIcon yellowPlayer;
	private ImageIcon greenPlayer;
	
	
	JLabel playerIcon;
	
	private ArrayList<JButton> botones;
	
	
	
	private ArrayList<ArrayList<ImageIcon>> colors;
	private ArrayList<ImageIcon> icons;
	
	
	public FichasPanel(Controller ctrl, JPanel previousPanel, GamePanel gamePanel, ArrayList<ArrayList<ImageIcon>> colors) {		
		_ctrl = ctrl;
		_ctrl.addObserver(this);
		_previousPanel = previousPanel;
		_gamePanel = gamePanel;
		
		this.colors = new ArrayList<ArrayList<ImageIcon>>(colors);
		
		initIcons();
		initGUI(_ctrl.getCurrentPlayer());
	}

	private void initIcons() {
		
		redPlayer = new ImageIcon(((new ImageIcon("resources/icons/RedPLayer.png")).getImage()).getScaledInstance(80, 65, java.awt.Image.SCALE_SMOOTH));
		bluePlayer = new ImageIcon(((new ImageIcon("resources/icons/BluePLayer.png")).getImage()).getScaledInstance(80, 65, java.awt.Image.SCALE_SMOOTH));
		yellowPlayer = new ImageIcon(((new ImageIcon("resources/icons/YellowPLayer.png")).getImage()).getScaledInstance(80, 65, java.awt.Image.SCALE_SMOOTH));
		greenPlayer = new ImageIcon(((new ImageIcon("resources/icons/GreenPLayer.png")).getImage()).getScaledInstance(80, 65, java.awt.Image.SCALE_SMOOTH));
		
		
		icons = new ArrayList<ImageIcon>();
		icons.add(redPlayer);
		icons.add(bluePlayer);
		icons.add(yellowPlayer);
		icons.add(greenPlayer);
		
	}
	
	
	private void initGUI(int jugador) {
				
		botones = new ArrayList<JButton>();
		
        
        playerIcon = new JLabel(icons.get(jugador));
		
		this.add(playerIcon);
		
		for(int i=0; i<_ctrl.remaining(); i++) {
			
			JButton b = new JButton();
			b.setIcon(colors.get(jugador).get(i));
			b.addActionListener(new FichaButtonListener(i));
			
			botones.add(b);
			this.add(b);
		}

	}
	 	    
        
	class FichaButtonListener implements ActionListener {
		
		int _indexFicha;
		
		public FichaButtonListener(int indexFicha) {
			super();
			_indexFicha = indexFicha;
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			_ctrl.setCurrentFicha(_indexFicha);
		}
	}

	@Override
	public void onReset(List<Jugador> jugadores, HashMap<String, String> mapaCasillas) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void onFichaAnadida(int x, int y, int f, Jugador jugador) {
		// TODO Elimino la ficha f de la lista color
		
	}
	
	@Override
	public void update(Jugador jugador) {

		_gamePanel.cargarFichasJugador(this);
		
	}
	
//	private void limpiarBotones(JPanel pn, ArrayList<JButton> botones) {
//		for(int i = 0; i < botones.size(); i++) {
//			pn.remove(botones.get(i));
//			botones.remove(i);
//		}
//	}
	
}
