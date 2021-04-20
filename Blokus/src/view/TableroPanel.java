package view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
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
	
	private JButton tablero[][];
	private Image _casillaVacia;
	private Image _casillaRoja;
	private Image _casiilaAzul;
	private Image _casillaVerde;
	private Image _casillaAmarilla;
	
	
	public TableroPanel(Controller ctrl) {
		initGUI();
		ctrl.addObserver(this);
	}


	private void initGUI() {
		// TODO Auto-generated method stub
		_casillaVacia = loadImage("casilla_vacia");
		_casillaRoja = loadImage("casilla_roja");
		_casiilaAzul = loadImage("casilla_azul");
		_casillaVerde = loadImage("casilla_verde");
		_casillaAmarilla = loadImage("casilla_amarilla");
		tablero = new JButton[20][20]; //Hardcodeado
	}

	//Nunca llamamos a esta funcion directamente, el sistema la llama por nosotros.
	public void paintComponent(Graphics g) {
		g.fillRect(100, 100, 400, 400);
		g.clearRect(100, 100, 50, 50);
	
	}
	
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
