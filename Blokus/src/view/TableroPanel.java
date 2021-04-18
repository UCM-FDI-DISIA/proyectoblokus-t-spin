package view;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import controller.Controller;
import model.GameObserver;
import model.Jugador;

public class TableroPanel extends JPanel implements GameObserver{
	private static final long serialVersionUID = 1L;
	
	private Image _casillaVacia;
	private Image _casillaRoja;
	private Image _casiilaAzul;
	private Image _casillaVerde;
	private Image _casillaAmarilla;
	
	TableroPanel(Controller ctrl) {
		initGUI();
		ctrl.addObserver(this);
	}


	private void initGUI() {
		// TODO Auto-generated method stub
		_casillaVacia = loadImage("");
		_casillaRoja = loadImage("");
		_casiilaAzul = loadImage("");
		_casillaVerde = loadImage("");
		_casillaAmarilla = loadImage("");
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
