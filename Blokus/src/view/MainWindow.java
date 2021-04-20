package view;

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
import javax.swing.JSeparator;

import controller.Controller;

public class MainWindow extends JFrame implements ActionListener{
	private String ayuda="El objetivo es colocar la mayor cantidad de las 21 piezas en el tablero. Cada pieza debe tocar al menos\r\n" + 
			"otra del mismo color, pero s�lo por una de las esquinas. El juego termina cuando ning�n jugador\r\n" + 
			"puede colocar una pieza. ";
	JLabel titulo =new JLabel();
	JButton p1=new JButton();
	JButton p2=new JButton();
	JButton p3=new JButton();
	JButton p4=new JButton();
	private JMenuBar menuBar;
	private JMenu menu1,menu3, menuA, menuB,menuC;
	private JMenuItem menuItem21, menuItem22, menuItem31, menuItem32,menuItemB1,menuItemB2,menuItemA2,menuItemA1;

private Controller _controller;

public MainWindow(Controller controller) {
	super("Blockus");
	
	_controller=controller;
	initGUI();
}

private void initGUI(){
	this.setTitle("Blokus");
    this.setSize(800,800);
    this.setResizable(false);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.creaElementos();
    this.setLayout(null);
    this.setVisible(true);
	this.barraSuperior();
}

public void creaElementos(){

	titulo.setBounds(310,250,2000,30);
	titulo.setFont(new Font("comic-sans", 1, 21));
	titulo.setText("Numero de Jugadores");
	this.getContentPane().add(titulo);


	p1.setBounds(350,300,120,30);
	p1.setText("2 Jugadores");
	this.getContentPane().add(p1);

	p2.setBounds(350,350,120,30);
	p2.setText("3 Jugadores");
	this.getContentPane().add(p2);

	p3.setBounds(350,400,120,30);
	p3.setText("4 Jugadores");
	this.getContentPane().add(p3);


	p4.setBounds(350,450,120,30);
	p4.setText("Salir");
	this.getContentPane().add(p4);

	p1.addActionListener(this);
	p2.addActionListener(this);
	p3.addActionListener(this);
	p4.addActionListener(this);

}
public void barraSuperior() {
	menuBar=new JMenuBar();
	setJMenuBar(menuBar);
	
	/* Creamos el primer JMenu y lo pasamos como par�metro al JMenuBar mediante el m�todo add */
	menu1=new JMenu("Menu");
	menuA = new JMenu("Ayuda");
	menuB = new JMenu("Salir");
	menuC=new JMenu("Ventana");
	menuBar.add(menuA);
	menuBar.add(menu1);
	menuBar.add(menuC);
	menuBar.add(new JSeparator());
	menuBar.add(menuB);
	
	/* Creamos el segundo y tercer objetos de la clase JMenu y los asociamos con el primer JMenu creado */
	
	menu3=new JMenu("Color de fondo");
	menu1.add(menu3);

	/* Creamos los dos primeros objetos de la clase JMenuItem y los asociamos con el segundo JMenu */
	menuItem21=new JMenuItem("640*480");
	menuC.add(menuItem21);
	menuItem21.addActionListener(this);
	menuItem22=new JMenuItem("1024*768");
	menuC.add(menuItem22);
	menuItem22.addActionListener(this);
	
	menuItemB1=new JMenuItem("Regresar al esritorio");
	menuItemB2=new JMenuItem("Volver al menu principal");
	menuB.add(menuItemB2);
	menuB.add(menuItemB1);
	menuItemB1.addActionListener(this);
	menuItemB2.addActionListener(this);
	
	menuItemA1=new JMenuItem("Instrucciones");
	menuItemA2=new JMenuItem("Reiniciar partida");
	menuA.add(menuItemA1);
	menuA.add(menuItemA2);
	menuItemA1.addActionListener(this);
	menuItemA2.addActionListener(this);
	

	/* Creamos los otros dos objetos de la clase JMenuItem y los  asociamos con el tercer JMenu */
	menuItem31=new JMenuItem("Rojo");
	menu3.add(menuItem31);
	menuItem31.addActionListener(this);
	menuItem32=new JMenuItem("Verde");
	menu3.add(menuItem32);
	menuItem32.addActionListener(this);
}



@Override
public void actionPerformed(ActionEvent e) {
	if (e.getSource()==menuItem21) {
		setSize(640,480);
	}
	if (e.getSource()==menuItem22) {
		setSize(1024,768);
	}
	if (e.getSource()==menuItem31) {
		getContentPane().setBackground(new Color(255,0,0));
	}
	if (e.getSource()==menuItem32) {
		getContentPane().setBackground(new Color(0,255,0));
	}
	if(e.getSource()==menuItemB1) {
		System.exit(WIDTH);
	}
	if(e.getSource()==menuItemA1) {
		JOptionPane.showMessageDialog(null, ayuda);
	}
	if(e.getSource()==menuItemA2) {
		//Llamada al m�todo reiniciarPartida();
		JOptionPane.showMessageDialog(null, "Reiniciar Partida");
	}
	
	if(e.getSource()==menuItemB2) {
		//Llamada al m�todo reiniciarPartida();
		JOptionPane.showMessageDialog(null, "Volver a menu");
	}
	
	if(e.getSource()==p1){
		//tablero para dos jugadores
		//v1.setVisible(true);
	}
	if(e.getSource()==p2){
		//tablero para Tres jugadores
		//v2.setVisible(true):
	}
	if(e.getSource()==p3){
		//tablero para cuatro jugadores
		//v3.setVisible(true):
	}
	if(e.getSource()==p4){
		System.exit(WIDTH);
	}
	
}
}

