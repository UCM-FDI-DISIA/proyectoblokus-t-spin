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
	
	private ImageIcon redPlayer;
	private ImageIcon bluePlayer;
	private ImageIcon yellowPlayer;
	private ImageIcon greenPlayer;
	
	
	JPanel pn;
	JLabel playerIcon;
	
	private ArrayList<JButton> botones;
	
	private ArrayList<ImageIcon> redFichas;
	private ArrayList<ImageIcon> blueFichas;
	private ArrayList<ImageIcon> yellowFichas;
	private ArrayList<ImageIcon> greenFichas;
	
	private ArrayList<ArrayList<ImageIcon>> colors;
	private ArrayList<ImageIcon> icons;
	
	
	public FichasPanel(Controller ctrl) {		
		_ctrl = ctrl;
		_ctrl.addObserver(this);
		initIcons();
	}

	private void initIcons() {
		
		redPlayer = new ImageIcon(((new ImageIcon("resources/icons/RedPLayer.png")).getImage()).getScaledInstance(80, 65, java.awt.Image.SCALE_SMOOTH));
		bluePlayer = new ImageIcon(((new ImageIcon("resources/icons/BluePLayer.png")).getImage()).getScaledInstance(80, 65, java.awt.Image.SCALE_SMOOTH));
		yellowPlayer = new ImageIcon(((new ImageIcon("resources/icons/YellowPLayer.png")).getImage()).getScaledInstance(80, 65, java.awt.Image.SCALE_SMOOTH));
		greenPlayer = new ImageIcon(((new ImageIcon("resources/icons/GreenPLayer.png")).getImage()).getScaledInstance(80, 65, java.awt.Image.SCALE_SMOOTH));
		
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
		
		icons = new ArrayList<ImageIcon>();
		icons.add(redPlayer);
		icons.add(bluePlayer);
		icons.add(yellowPlayer);
		icons.add(greenPlayer);
		
	}
	
	
	public JScrollPane inf() {	
		
		pn = new JPanel();
		
		botones = new ArrayList<JButton>();
		
        JScrollPane s = new JScrollPane(pn, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        s.setPreferredSize(new Dimension(0,200));
        
        // He cambiado el tamaño del button aquí 150,130
        playerIcon = new JLabel(redPlayer);
		
		pn.add(playerIcon);

//		// PRUEBA
//		JButton b = new JButton();
//		b.setIcon(redFichas.get(0));
//		b.addActionListener(new FichaButtonListener(0));
//		
//		botones.add(b);
//		pn.add(b);
		
		 
		for(int i=0;i<21;i++) {
			// y aquí 150,130
			JButton b = new JButton();
			b.setIcon(redFichas.get(i));
			b.addActionListener(new FichaButtonListener(i));
			
			botones.add(b);
			pn.add(b);
		}

		return s;
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
		colors.get(jugador.getId()).remove(f);
	}
	
	@Override
	public void update(Jugador jugador) {

		int id = jugador.getId();
		
		playerIcon.setIcon(icons.get(id));

		for(int i=0; i<jugador.getNumFichas(); i++) {
			botones.get(i).setIcon(colors.get(id).get(i));
			pn.add(botones.get(i));
		}
		
	}
	
//	private void limpiarBotones(JPanel pn, ArrayList<JButton> botones) {
//		for(int i = 0; i < botones.size(); i++) {
//			pn.remove(botones.get(i));
//			botones.remove(i);
//		}
//	}
	
}
