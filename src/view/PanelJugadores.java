package view;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelJugadores extends JPanel{

	private static int totalPlayers;
	
	public PanelJugadores(int totalPlayers) {
		this.totalPlayers=totalPlayers;
	}
	
	public JPanel numJugadores() {
		
		JLabel titulo= new JLabel(lineBreak("PUNTUACION"));
		JLabel ju1 = new JLabel(lineBreak("Jugador 1: "));
		JLabel ju2 = new JLabel(lineBreak("Jugador 2: "));
		JLabel ju3 = new JLabel(lineBreak("Jugador 3: "));
		JLabel ju4 = new JLabel(lineBreak("Jugador 4: "));
	
		JPanel supPanel = new JPanel(new FlowLayout());
		supPanel.setPreferredSize(new Dimension(100,300));
		supPanel.add(titulo);
		supPanel.add(ju1);
		
		if(totalPlayers==2) {
			
		supPanel.add(ju2);
			
		}
		if(totalPlayers==3) {
			
			supPanel.add(ju2);
			supPanel.add(ju3);
			
		}
		
		if(totalPlayers==4) {
			supPanel.add(ju2);
			supPanel.add(ju3);
			supPanel.add(ju4);
		}
		
		return supPanel;
	}
	
	private String lineBreak(String text) {
		return "<html><p style=\"width:150px\">" + text + "</p></html>";
	}
}
