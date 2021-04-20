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

public class MainWindow extends JFrame {
	
private Controller _controller;

public MainWindow(Controller controller) {
	super ("Blokus");
	_controller=controller;
	initGUI();
}

private void initGUI(){

	JPanel mainPanel=new JPanel (new BorderLayout());
	this.setContentPane(mainPanel);
	mainPanel.add(new UpMenu(_controller), BorderLayout.NORTH);
	mainPanel.add(new MainMenu(_controller),BorderLayout.CENTER);
	
	

	
}


}
