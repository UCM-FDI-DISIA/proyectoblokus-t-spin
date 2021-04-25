package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

	private static final int SQUARESIZE = 40;
	//private List<CasillaPanel> tablero;
	private CasillaPanel[][] tablero;
	

	private int width = 20, height = 20;
	Controller ctrl;
	
	
	public TableroPanel(Controller ctrl) {
		super(new GridLayout(20, 20));
		tablero = new CasillaPanel[20][20];
		this.setPreferredSize(new Dimension(width * SQUARESIZE, height
				* SQUARESIZE));
		
		initGUI();
		
		ctrl.addObserver(this);
		this.ctrl = ctrl; 
	}

	
	
	private void initGUI() {		
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				
				CasillaPanel casilla = new CasillaPanel(j,i);
				
				casilla.addActionListener(new ActionListener() {					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						ctrl.anadirFicha(casilla.getXPos(), casilla.getYPos());					
					}
				});
				this.add(casilla);

				casilla.setVisible(true);
				tablero[i][j] = casilla;
			}
		}
	}
	
	@Override
	public void onReset(List<Jugador> jugadores, HashMap<String, String> mapaCasillas) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFichaAnadida(String color, int x, int y) {
		// TODO Auto-generated method stub
		if(color == "1") {
			tablero[x][y].toggle(Color.red);	
		}
		else if(color == "2") {
			tablero[x][y].toggle(Color.blue);
		}
		else if(color == "3") {
			tablero[x][y].toggle(Color.yellow);
		}
		else {
			tablero[x][y].toggle(Color.green);
		}
		
		
	}
}
