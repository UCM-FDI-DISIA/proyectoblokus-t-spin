package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;

import controller.Controller;

public class MainMenu  extends JPanel {
	

	JLabel titulo =new JLabel();
	JButton p1=new JButton();
	JButton p2=new JButton();
	JButton p3=new JButton();
	JButton p4=new JButton();
	private Controller _controller;
	private JPanel _previousPanel;
	private MainWindow _mainWindow;

	
	public MainMenu(Controller controller, JPanel previousPanel, MainWindow mainWindow) {
		//super("Blockus");
		_controller=controller;
		_previousPanel = previousPanel;
		_mainWindow = mainWindow;
		initGUI();
	}
	private void initGUI(){

	    this.creaElementos();
	    this.setLayout(null);
	    this.setSize(_previousPanel.getSize());

	    
	}
	
	

	public void creaElementos(){
		
		titulo.setBounds(400,250,2000,30);
		titulo.setFont(new Font("comic-sans", 1, 21));
		titulo.setText("Numero de Jugadores");
		//this.getContentPane().add(titulo);
		this.add(titulo);

		p1.setBounds(440,300,120,30);
		p1.setText("2 Jugadores");
		//this.getContentPane().add(p1);
		this.add(p1);

		p2.setBounds(440,350,120,30);
		p2.setText("3 Jugadores");
		//this.getContentPane().add(p2);
		this.add(p2);
		
		p3.setBounds(440,400,120,30);
		p3.setText("4 Jugadores");
		//this.getContentPane().add(p3);
		this.add(p3);

		p4.setBounds(440,450,120,30);
		p4.setText("Salir");
		//this.getContentPane().add(p4);
		this.add(p4);

		p1.addActionListener(new PlayersButtonListener(2));
		p2.addActionListener(new PlayersButtonListener(3));
		p3.addActionListener(new PlayersButtonListener(4));
		p4.addActionListener(new ExitButtonListener());

	}

	class PlayersButtonListener implements ActionListener {
		
		int _numPlayers;
		
		public PlayersButtonListener(int numPlayers) {
			super();
			_numPlayers = numPlayers;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			_mainWindow.newGame(_numPlayers, _previousPanel);
		}
	}

	class ExitButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.exit(WIDTH);
		}
		
	}
}



