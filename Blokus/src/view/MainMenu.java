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

public class MainMenu  extends JPanel implements ActionListener {
	

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
		//this.setTitle("Blokus");
	    //this.setSize(800,800);
	    //this.setResizable(false);
	    //this.setLocationRelativeTo(null);
	    //this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	    this.creaElementos();
	    this.setLayout(null);
	    //this.setVisible(true);
	    //this.menuSuperior();
	    
	}
	
	

	public void creaElementos(){
		
		titulo.setBounds(310,250,2000,30);
		titulo.setFont(new Font("comic-sans", 1, 21));
		titulo.setText("Numero de Jugadores");
		//this.getContentPane().add(titulo);
		this.add(titulo);

		p1.setBounds(350,300,120,30);
		p1.setText("2 Jugadores");
		//this.getContentPane().add(p1);
		this.add(p1);

		p2.setBounds(350,350,120,30);
		p2.setText("3 Jugadores");
		//this.getContentPane().add(p2);
		this.add(p2);
		
		p3.setBounds(350,400,120,30);
		p3.setText("4 Jugadores");
		//this.getContentPane().add(p3);
		this.add(p3);

		p4.setBounds(350,450,120,30);
		p4.setText("Salir");
		//this.getContentPane().add(p4);
		this.add(p4);

		p1.addActionListener(this);
		p2.addActionListener(this);
		p3.addActionListener(this);
		p4.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==p1){
			_mainWindow.newGame(2, _previousPanel);
			
		}
		else if(e.getSource()==p2){
			_mainWindow.newGame(3, _previousPanel);
			
		}
		else if(e.getSource()==p3){
			_mainWindow.newGame(4, _previousPanel);
			
		}
		else if(e.getSource()==p4){
			System.exit(WIDTH);
		}
		
		
	}
}

