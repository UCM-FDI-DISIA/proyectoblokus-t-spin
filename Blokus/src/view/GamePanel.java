package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = -9060831481452731983L;
	private static int numPlayers;
	TableroPanel tablero;
	/*private TableroPanel tableroPanel;
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
		//A�adir panel del tablero
		tablero = new TableroPanel();
		//A�adir panel de jugadores
		//A�adir panel de pasar turno
		//A�adir panel de rotar
		//A�adir panel de fichas
		
		//Test del layout
		JPanel Panel5 = new JPanel();
		Panel5.setBackground(Color.GREEN);//
		JPanel Panel6 = new JPanel();
		Panel6.setBackground(Color.lightGray);
		JPanel Panel10 = new JPanel();
		Panel10.setBackground(Color.RED);//
		
		this.add(Panel5, BorderLayout.CENTER);
		this.add(Panel6, BorderLayout.EAST);
		this.add(Panel10, BorderLayout.PAGE_END);
		this.add(tablero);
	}
	
}

