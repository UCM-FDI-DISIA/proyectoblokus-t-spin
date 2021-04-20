package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

import controller.Controller;
import model.GameObserver;
import model.Jugador;

public class TableroPanel extends JPanel implements GameObserver{
	private static final long serialVersionUID = 1L;

	private static final Color _COLOR_FONDO = Color.WHITE;
	
	private static final int SQUARESIZE = 40;
	private JButton tablero[][];
	private Image _casillaVacia;
	private Image _casillaRoja;
	private Image _casiilaAzul;
	private Image _casillaVerde;
	private Image _casillaAmarilla;
	private int width = 20, height = 20;
	
	
	public TableroPanel(Controller ctrl) {
		super(new GridLayout(20, 20));
		this.setPreferredSize(new Dimension(width * SQUARESIZE, height
				* SQUARESIZE));
		tablero = new JButton[height][width];
		
		initGUI();

		ctrl.addObserver(this);
	}


	private void initGUI() {

		_casillaVacia = loadImage("casilla_vacia.png");
		_casillaRoja = loadImage("casilla_roja.png");
		_casiilaAzul = loadImage("casilla_azul.png");
		_casillaVerde = loadImage("casilla_verde.png");
		_casillaAmarilla = loadImage("casilla_amarilla.png");
		//tablero = new JButton[20][20]; //Hardcodeado
		
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				//this.add(new JButton());
				
				JButton casilla = new JButton();
				casilla.setOpaque(true);
				casilla.setBorderPainted(false);
				tablero[i][j] = casilla;
				casilla.setBackground(_COLOR_FONDO);
				casilla.setBorderPainted(true);
				
				
				this.add(casilla);
			}
		}
	}
/*
	//Nunca llamamos a esta funcion directamente, el sistema la llama por nosotros.
	public void paintComponent(Graphics g) {
		g.fillRect(100, 100, 400, 400);
		g.clearRect(100, 100, 50, 50);
	
	}*/
	
	@Override
	public void onReset(List<Jugador> jugadores, HashMap<String, String> mapaCasillas) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onFichaAnadida(List<Jugador> jugadores, HashMap<String, String> mapaCasillas) {
		// TODO Auto-generated method stub
		
	}
	
	private Image loadImage(String img) {
		Image i = null;
		try {
			return ImageIO.read(new File("resources/" + img));
		} catch (IOException e) {
		}
		return i;
	}

}
