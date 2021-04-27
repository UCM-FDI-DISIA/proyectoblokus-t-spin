package model;

import java.util.concurrent.TimeUnit;

public class JugadorIA extends Jugador{

	public JugadorIA(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void computerAction(Game game) {
		System.out.println("Beep boop");
		
		game.update();
	}

}
