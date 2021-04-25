package view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class CasillaPanel extends JButton{
	private static final long serialVersionUID = 1L;
	private int _x, _y;
	
	public CasillaPanel(int x, int y) {
		this._x = x;
		this._y = y;
		
		this.setOpaque(true);				
		this.setBackground(Color.white);
		this.setBorderPainted(true);
		
		/*
		this.addActionListener(new ActionListener() {					
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//anadirFicha(getXPos(), getYPos());
				toggle();
				
				System.out.println("------------------------");
				System.out.println("x: " + getXPos());
				System.out.println("y: " + getYPos());
			}
		});*/
		
	}
	
	public void toggle() {
		setBackground(Color.red);
		setFocusPainted(false);
		setBorderPainted( false );
	}
	
	public int getXPos() {
		return _x;
	}
	
	public int getYPos() {
		return _y;
	}
}
