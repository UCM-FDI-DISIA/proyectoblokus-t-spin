package view;

import java.util.HashMap;
import java.util.List;

import javax.swing.JPanel;

import controller.Controller;
import model.GameObserver;
import model.Jugador;

public class TableroPanel extends JPanel implements GameObserver{
	private static final long serialVersionUID = 1L;
	
	
	TableroPanel(Controller ctrl) {
		initGUI();
		ctrl.addObserver(this);
	}


	private void initGUI() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onReset(List<Jugador> jugadores, HashMap<String, String> mapaCasillas) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onFichaAnadida(List<Jugador> jugadores, HashMap<String, String> mapaCasillas) {
		// TODO Auto-generated method stub
		
	}

}
