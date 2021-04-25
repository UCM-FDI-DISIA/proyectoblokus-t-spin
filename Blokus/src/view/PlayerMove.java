package view;


import java.util.HashMap;
import java.util.List;
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
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JButton rotateB = new JButton("Rotar ficha");		// TODO Remove string after adding icon
		rotateB.setToolTipText("Rotar ficha");
		rotateB.setBounds(0, 0, 100, 100);					//TODO Resize? check size, add icon
		//rotateB.setIcon(new ImageIcon("src/icons/rotate.png"));

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
		
		JButton passB = new JButton("Pasar turno"); 		// TODO Remove string after adding icon
		passB.setToolTipText("Pasar turno");
		passB.setBounds(0, 0, 100, 100);					//TODO Resize? check size, add icon
		//passB.setIcon(new ImageIcon("src/icons/pass.png"));

		// passB listener using an anonymus inner class
		passB.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent a) {
				
				try{_ctrl.passTurn();}
				catch (IllegalArgumentException e) {
			    	 showExceptionMessage("No se ha podido pasar el turno");
			     }
			}
			
		});
		
		JSeparator sep = new JSeparator(SwingConstants.VERTICAL);
		
		this.add(rotateB);
		this.add(sep);
		this.add(passB);	
		
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
