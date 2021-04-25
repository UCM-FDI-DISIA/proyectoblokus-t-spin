package view;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelJugadores extends JPanel{

	private static int numPlayers;
	
	public PanelJugadores(int numPlayers) {
		this.numPlayers=numPlayers;
		numJugadores();
	}
	
public JPanel numJugadores() {
		
		JLabel titulo= new JLabel("PUNTUACIÓN");
		JLabel ju1 = new JLabel("Jugador 1: ");
		JLabel ju2 = new JLabel("Jugador 2: ");
		JLabel ju3 = new JLabel("Jugador 3: ");
		JLabel ju4 = new JLabel("Jugador 4: ");
	
	
		JPanel supPanel = new JPanel(new FlowLayout());
		supPanel.setPreferredSize(new Dimension(100,300));
		supPanel.add(titulo);
		supPanel.add(ju1);
		
		if(numPlayers==2) {
			
		supPanel.add(ju2);
			
		}
		if(numPlayers==3) {
			
			supPanel.add(ju2);
			supPanel.add(ju3);
			
		}
		
		if(numPlayers==4) {
			supPanel.add(ju2);
			supPanel.add(ju3);
			supPanel.add(ju4);
		}
		
		return supPanel;
	}
}
