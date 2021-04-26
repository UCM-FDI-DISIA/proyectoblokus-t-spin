package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.GameObserver;
import model.Jugador;


public class FichasPanel extends JPanel implements GameObserver{

	private static final long serialVersionUID = 1L;
	private int player;
	JPanel pn= new JPanel();
	public FichasPanel() {	
	}
	public FichasPanel(int player ) {
		
		this.player=player;
		inf();
		
	}

	public JScrollPane inf() {
		
		
		
        
        
        JScrollPane s = new JScrollPane(pn, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        s.setPreferredSize(new Dimension(0,200));
        System.out.println(this.player);
       // JLabel buttonRed = new JLabel((Icon) new ImageIcon(((new ImageIcon("resources/icons/RedPLayer.png")).getImage()).getScaledInstance(150, 130, java.awt.Image.SCALE_SMOOTH)));
       // pn.add(buttonRed);
        if(this.player==1 ||this.player==0 ) {
        	 JLabel buttonRed = new JLabel((Icon) new ImageIcon(((new ImageIcon("resources/icons/RedPLayer.png")).getImage()).getScaledInstance(150, 130, java.awt.Image.SCALE_SMOOTH)));
        	 pn.add(buttonRed);
        	
            			
		}
		if(this.player==2) {
			
			JLabel buttonBlue = new JLabel((Icon) new ImageIcon(((new ImageIcon("resources/icons/BluePLayer.png")).getImage()).getScaledInstance(150, 130, java.awt.Image.SCALE_SMOOTH)));
			pn.add(buttonBlue);
			
			
		
		}
		if(this.player==3) {
			
			JLabel buttonGreen = new JLabel((Icon) new ImageIcon(((new ImageIcon("resources/icons/GreenPLayer.png")).getImage()).getScaledInstance(150, 130, java.awt.Image.SCALE_SMOOTH)));
			pn.add(buttonGreen);
		
		}
		if(this.player==4) {
			
			 JLabel buttonYellow = new JLabel((Icon) new ImageIcon(((new ImageIcon("resources/icons/YellowPLayer.png")).getImage()).getScaledInstance(150, 130, java.awt.Image.SCALE_SMOOTH)));
			 pn.add(buttonYellow);
        
			
		}
      
        	
        
        
        
        for(int i=0;i<21;i++) {
        	 JButton forma = new JButton((Icon) new ImageIcon(((new ImageIcon("resources/ficha.png")).getImage()).getScaledInstance(150, 130, java.awt.Image.SCALE_SMOOTH)));
        	
            forma.setPreferredSize(new Dimension(200,180));
            pn.add(forma);
        }


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
		
		
		 if(d==1 ||d==0 ) {
        	 JLabel buttonRed = new JLabel((Icon) new ImageIcon(((new ImageIcon("resources/icons/RedPLayer.png")).getImage()).getScaledInstance(150, 130, java.awt.Image.SCALE_SMOOTH)));
        	 pn.add(buttonRed);
        	System.out.println("EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE");
            			
		}
		if(d==2) {
			
			JLabel buttonBlue = new JLabel((Icon) new ImageIcon(((new ImageIcon("resources/icons/BluePLayer.png")).getImage()).getScaledInstance(150, 130, java.awt.Image.SCALE_SMOOTH)));
			pn.add(buttonBlue);
			System.out.println("0000000000000000000000000000000000000000000000000");
			
		
		}
		if(d==3) {
			
			JLabel buttonGreen = new JLabel((Icon) new ImageIcon(((new ImageIcon("resources/icons/GreenPLayer.png")).getImage()).getScaledInstance(150, 130, java.awt.Image.SCALE_SMOOTH)));
			pn.add(buttonGreen);
		
		}
		if(d==4) {
			
			 JLabel buttonYellow = new JLabel((Icon) new ImageIcon(((new ImageIcon("resources/icons/YellowPLayer.png")).getImage()).getScaledInstance(150, 130, java.awt.Image.SCALE_SMOOTH)));
			 pn.add(buttonYellow);
        
			
		}
		
	}
	
	
	
}
