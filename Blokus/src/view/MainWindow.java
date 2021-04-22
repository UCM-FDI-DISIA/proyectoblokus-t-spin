package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import controller.Controller;

public class MainWindow extends JFrame {
	
private static final long serialVersionUID = 1L;

private Controller _controller;
private JPanel mainPanel;

public MainWindow(Controller controller) {
	super ("Blokus");
	_controller=controller;
	initGUI();
}

private void initGUI(){
	this.setTitle("Blokus");
    this.setSize(800,800);
    this.setResizable(false);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setLayout(null);
    this.setVisible(true);

	mainPanel=new JPanel (new BorderLayout());
	this.setContentPane(mainPanel);
	
	this.setJMenuBar(new UpMenu(this, _controller));

	mainPanel.add(new MainMenu(_controller, mainPanel, this),BorderLayout.CENTER);
	
	

	
}

public void openMenu(JPanel previousPanel) {
		previousPanel.setVisible(false);
		mainPanel.setVisible(true);
		this.setContentPane(mainPanel);
	}
public void newGame(int numJugadores, JPanel previousPanel) {
		GamePanel gamePanel = new GamePanel(numJugadores);
		gamePanel.setVisible(true);
		mainPanel.setVisible(false);
		this.setContentPane(gamePanel);
		previousPanel.setVisible(false);
	}
}
