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
	
	ArrayList<JButton> botones;
	
	ArrayList<ImageIcon> redFichas;
	ArrayList<ImageIcon> blueFichas;
	ArrayList<ImageIcon> yellowFichas;
	ArrayList<ImageIcon> greenFichas;
	
	ArrayList<ArrayList<ImageIcon>> colors;
	
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
		
	}
	
	
	public JScrollPane inf() {	
		
		pn = new JPanel();
		
		botones = new ArrayList<JButton>();
		
        JScrollPane s = new JScrollPane(pn, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        s.setPreferredSize(new Dimension(0,200));
        
        // He cambiado el tamaño del button aquí 150,130
        playerIcon = new JLabel(redPlayer);
		
		pn.add(playerIcon);
	
		 
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
	public void onFichaAnadida(int color, int x, int y, int f) {
		// TODO Elimino la ficha f de la lista color
		colors.get(color).remove(f);
	}
	@Override
	public void updateIcono(int d) {
		 
		if(d==0) {
        	
			playerIcon.setIcon(redPlayer);
			 for(int i=0;i<21;i++) {
				 botones.get(i).setIcon(colors.get(d).get(i));
			       //  pn.add(botones.get(i));
				}
		        
		}
		if(d==1) {
			playerIcon.setIcon(bluePlayer);
			
			for(int i=0;i<21;i++) {
				botones.get(i).setIcon(colors.get(d).get(i));
		      //   pn.add(botones.get(i));
			}
	        
		}
		if(d==2) {
			playerIcon.setIcon(yellowPlayer);
			
			for(int i=0;i<21;i++) {
				botones.get(i).setIcon(colors.get(d).get(i));
		        // pn.add(botones.get(i));
			}
	        
		}
		if(d==3) {
			playerIcon.setIcon(greenPlayer);
			
			for(int i=0;i<21;i++) {
				botones.get(i).setIcon(colors.get(d).get(i));
		    //     pn.add(botones.get(i));
			}
	        
			
		}
		
	}		
	
}
