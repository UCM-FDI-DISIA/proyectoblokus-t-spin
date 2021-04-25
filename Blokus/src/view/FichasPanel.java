package view;

import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.Jugador;

public class FichasPanel extends JPanel{

	
	public FichasPanel() {
		inf();
	}

	public JScrollPane inf() {
        JPanel pn= new JPanel();
        JScrollPane s = new JScrollPane(pn, JScrollPane.VERTICAL_SCROLLBAR_NEVER, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        s.setPreferredSize(new Dimension(0,200));
        Jugador pj = new Jugador(1);
        
        for(int i=0;i<21;i++) {
        	JButton A=new JButton("Forma");
            A.setPreferredSize(new Dimension(200,180));
            pn.add(A);
        }


        return s;
    }
}
