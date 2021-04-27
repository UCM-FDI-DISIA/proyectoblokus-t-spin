package model;

import exceptions.GameException;

public class JugadorIA extends Jugador{

	public JugadorIA(int id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean computerAction(Game game) {
		System.out.println("Beep boop");
		if(game.getPrimeraRonda()) {
			game.jugarPrimeraRonda(0, 19, 19);
		}else {
			for(int i = 0; i < 20; i++) {
				for(int j = 0; j < 20; j++) {					
					
					try {
						if(game.anadirFicha(0, j, i)) {return true;}
					} catch (GameException e) {
						// TODO Auto-generated catch block
					
					}

				}
			}
			
		}
		
		
		return true;
	}

}
