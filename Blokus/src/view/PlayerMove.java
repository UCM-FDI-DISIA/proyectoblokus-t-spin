package view;


import java.util.HashMap;
import java.util.List;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

import controller.Controller;
import model.GameObserver;
import model.Jugador;

public class PlayerMove extends JPanel implements GameObserver{

	private Controller _ctrl;
	
	public PlayerMove(Controller ctrl) {
		_ctrl = ctrl;
		initGUI();
		_ctrl.addObserver(this);
	}
	
	private void initGUI() {
		
		// BOTONES:
		//	1. Rotar ficha
		//	2. Pasar turno
		
		// Layout
		this.setLayout(new BorderLayout());
		JButton rotateB = new JButton(new ImageIcon("Blokus/resources/rotate.png"));		// TODO Remove string after adding icon
		rotateB.setText("\n Rotar ficha");

		// rotateB listener using an anonymus inner class
		rotateB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent a) {
				
				try{_ctrl.rotate();}
				catch (IllegalArgumentException e) {
			    	 showExceptionMessage("No se ha podido rotar la ficha");
			     }
			}
			
		});
		// rotateB listener using a nested class
		// rotateB.addActionListener(new RotarListener());
		
		JButton skipB = new JButton(new ImageIcon("Blokus/resources/skip.png")); 		// TODO Remove string after adding icon
		skipB.setText("\n Pasar turno");

		// passB listener using an anonymus inner class
		skipB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent a) {
				
				try{_ctrl.passTurn();}
				catch (IllegalArgumentException e) {
			    	 showExceptionMessage("No se ha podido pasar el turno");
			     }
			}
			
		});

		this.add(rotateB, BorderLayout.NORTH);
		//this.add(sep);
		this.add(skipB, BorderLayout.SOUTH);	
		
	}
	
//    private class RotateListener implements ActionListener{
//
//        @Override
//        public void actionPerformed(ActionEvent e) {
//
//        }
//    }
	
	private void showExceptionMessage(String message) {
		JOptionPane.showMessageDialog(this, message,
	    		  "Exception Message",
	    		  JOptionPane.WARNING_MESSAGE);
	}
	
	@Override
	public void onReset(List<Jugador> jugadores, HashMap<String, String> mapaCasillas) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFichaAnadida(String color, int x, int y) {
		// TODO Auto-generated method stub
		
	}

}
