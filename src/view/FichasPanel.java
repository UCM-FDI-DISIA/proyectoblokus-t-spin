package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.Controller;
import model.GameObserver;
import model.Jugador;


public class FichasPanel extends JPanel implements GameObserver{

	private static final long serialVersionUID = 1L;
	
	JPanel pn= new JPanel();
	JLabel buttonRed;
	ArrayList<JButton> botones=new ArrayList<JButton>();
	JButton forma = new JButton();
	
	public FichasPanel(Controller ctrl) {		
		//inf();
		ctrl.addObserver(this);
		for(int i=0;i<21;i++) {
			
			botones.add(new JButton());
		}
	}

	public JScrollPane inf() {	
		
		
        JScrollPane s = new JScrollPane(pn, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        s.setPreferredSize(new Dimension(0,200));
        

		buttonRed = new JLabel(new ImageIcon(((new ImageIcon("resources/icons/RedPLayer.png")).getImage()).getScaledInstance(150, 130, java.awt.Image.SCALE_SMOOTH)));
		
		pn.add(buttonRed);
	
		 
		for(int i=0;i<21;i++) {
			botones.get(i).setIcon(new ImageIcon(((new ImageIcon("resources/ficha.png")).getImage()).getScaledInstance(150, 130, java.awt.Image.SCALE_SMOOTH)));
			 forma.setPreferredSize(new Dimension(200,180));
	         pn.add(botones.get(i));
		}
			 	
			   /* forma.setIcon(new ImageIcon(((new ImageIcon("resources/ficha.png")).getImage()).getScaledInstance(150, 130, java.awt.Image.SCALE_SMOOTH)));
	            forma.setPreferredSize(new Dimension(200,180));
	            pn.add(forma);*/
	        
        
        

        return s;
    }
	@Override
	public void onReset(List<Jugador> jugadores, HashMap<String, String> mapaCasillas) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void onFichaAnadida(int color, int x, int y) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void updateIcono(int d) {
		 
		if(d==0) {
        	
			 buttonRed.setIcon(new ImageIcon(((new ImageIcon("resources/icons/RedPLayer.png")).getImage()).getScaledInstance(150, 130, java.awt.Image.SCALE_SMOOTH)));
			 for(int i=0;i<21;i++) {
					botones.get(i).setIcon(new ImageIcon(((new ImageIcon("resources/ficha.png")).getImage()).getScaledInstance(150, 130, java.awt.Image.SCALE_SMOOTH)));
					 forma.setPreferredSize(new Dimension(200,180));
			         pn.add(botones.get(i));
				}
		        
		}
		if(d==1) {
			buttonRed.setIcon(new ImageIcon(((new ImageIcon("resources/icons/BluePLayer.png")).getImage()).getScaledInstance(150, 130, java.awt.Image.SCALE_SMOOTH)));
			
			for(int i=0;i<21;i++) {
				botones.get(i).setIcon(new ImageIcon(((new ImageIcon("resources/fichaBlue.png")).getImage()).getScaledInstance(150, 130, java.awt.Image.SCALE_SMOOTH)));
				 forma.setPreferredSize(new Dimension(200,180));
		         pn.add(botones.get(i));
			}
	        
		}
		if(d==2) {
			buttonRed.setIcon(new ImageIcon(((new ImageIcon("resources/icons/YellowPLayer.png")).getImage()).getScaledInstance(150, 130, java.awt.Image.SCALE_SMOOTH)));
			
			for(int i=0;i<21;i++) {
				botones.get(i).setIcon(new ImageIcon(((new ImageIcon("resources/fichaBlue.png")).getImage()).getScaledInstance(150, 130, java.awt.Image.SCALE_SMOOTH)));
				 forma.setPreferredSize(new Dimension(200,180));
		         pn.add(botones.get(i));
			}
	        
		}
		if(d==3) {
			buttonRed.setIcon(new ImageIcon(((new ImageIcon("resources/icons/GreenPLayer.png")).getImage()).getScaledInstance(150, 130, java.awt.Image.SCALE_SMOOTH)));
			
			for(int i=0;i<21;i++) {
				botones.get(i).setIcon(new ImageIcon(((new ImageIcon("resources/fichaBlue.png")).getImage()).getScaledInstance(150, 130, java.awt.Image.SCALE_SMOOTH)));
				 forma.setPreferredSize(new Dimension(200,180));
		         pn.add(botones.get(i));
			}
	        
			
		}
		
	}
	
	
	
}
