package model;

import exceptions.GameException;

public class JugadorIA extends Jugador{
	//[1 facil: 2 medio: 3 dificil]
	private int level;
	
	public JugadorIA(int id, int level) {
		super(id);
		this.level = level;
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public boolean computerAction(Game game) {
		
		if(game.getPrimeraRonda()) {
			
			if(getId()==2) {
				game.jugarPrimeraRonda(0,19,0);
				return true;
				
			}
			if(getId()==3) {
				game.jugarPrimeraRonda(0,19,19);
				return true;
			}
			if(getId()==4) {
				game.jugarPrimeraRonda(0, 0, 0);
				return true;
			}
			
			
				
			
			
		}else {
			
			if(game.getdificultad()==1) {
				for(int i = 0; i < 20; i++) {
				for(int j = 0; j < 20; j++) {					
					
					try {
						if(game.anadirFicha(0, j, i)) {return true;}
					} catch (GameException e) {
						// TODO Auto-generated catch block
					
					}

				}
			}}
			
			else {
				if(game.getTurno()%game.getdificultad()==0) {
				
				for(int i = 0; i < 20; i++) {
				for(int j = 0; j < 20; j++) {					
					
					try {
						if(game.anadirFicha(0, j, i)) {return true;}
					} catch (GameException e) {
						// TODO Auto-generated catch block
					
					}

				}
			}}
			}
			
			
			
		}
		
		
		
		return true;
	}

}
