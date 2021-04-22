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
	

	private int width = 20, height = 20;
	
	
	public TableroPanel(/*Controller ctrl*/) {
		super(new GridLayout(20, 20));
		this.setPreferredSize(new Dimension(width * SQUARESIZE, height
				* SQUARESIZE));
		
		initGUI();

		//ctrl.addObserver(this);
	}


	private void initGUI() {		
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {				
				CasillaPanel casilla = new CasillaPanel(i,j);
				this.add(casilla);

				casilla.setVisible(true);
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
}
