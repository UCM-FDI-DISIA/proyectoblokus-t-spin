import java.util.ArrayList;
import java.util.List;

import java.util.HashMap;

public class Game {
    
	public final static int DIM_BOARD = 20;
	
	private boolean juegoTerminado = false;
private boolean primeraRonda = true;
    private List<Jugador> jugadores = new ArrayList<Jugador> ();  
    private HashMap<Integer[], String> mapaCasillas = new HashMap<Integer[], String>();

    public Game() {
    
    }

    public void ejecutaJuego() {
    	if(primeraRonda) {
    		jugarPrimeraRonda();
    		primeraRonda = false;
    	}
    	else {
    		for(Jugador j : jugadores) {
    			if(jugadorPuedeColocar(j)) {
    				anadirFicha(/*j.getFicha()*/);// algo similar para ver que ficha coloca
    			}
    		}
    	}
    }
    
    public void jugarPrimeraRonda() {
    	for(Jugador j : jugadores) {
    		if(jugadorPuedeColocar(j) && checkEsquinas(/*j.getFicha()*/)) {
    			anadirFicha(/*j.getFicha()*/);
    		}
    	}
    }
    
    public boolean checkEsquinas(Ficha ficha) {// comprueba que la ficha se coloca en alguna de las esquinas
    	Integer[] esquina1 = {0, 0}, esquina2 = {19, 0}, 
    			esquina3 = {0, 19}, esquina4 = {19, 19};
    	
    	Integer[] casilla = {0, 0};
    	
    	for(int i = 0; i < ficha.getNumCasillas(); i++) {
    		casilla[0] = ficha.getFichaX(i);
    		casilla[1] = ficha.getFichaY(i);
    		if(casilla == esquina1 || casilla == esquina2 || casilla == esquina3 || casilla == esquina4) {
    			return true;
    		}
    	}
    	
    	
    	return false;
    }


    public void anadirFicha(Ficha ficha) {  
    	
    	Integer[] posicion = {0,0};
    	
    	if(cumpleReglas(ficha)) {
    		for(int i = 0; i < ficha.getNumCasillas(); i++){
    			posicion[0] = ficha.getFichaX(i);posicion[1] = ficha.getFichaY(i);
    			mapaCasillas.put(posicion, ficha.getEquipo());	
    		}
    		//Llamar a jugardor para quitarle la ficha que acaba de colocar
    		//jugadores.get(1).borrarPieza(1); //esta linea está mal, arreglar
    	}    	
    }
    
    public boolean jugadorPuedeColocar() {
    	//llama a jugador para ver si tiene piezas y ver si puede colocar
		return true;
    }

    public boolean cumpleReglas(Ficha ficha) {
    	Integer[] pos = {0,0};
    	String equipo = ficha.getEquipo();
    	//checkea si vacia y contiguas
    	
    	for(int i = 0; i < ficha.getNumCasillas(); i++) {    		
    		
    		pos[0] = Integer.valueOf(ficha.getFichaX(i)); pos[1] = Integer.valueOf(ficha.getFichaY(i));
    		
    		if(mapaCasillas.get(pos) != null) { //Si está ocupada
    			return false;
    		}
    		
    		if(!checkDiagonal(pos, equipo)) { //Si no tiene casillas del equipo en diagonal
    			return false;
    		}
    		
    		if(!checkContiguaNoDiagonal(pos, equipo)) { //Si tiene casillas del equipo contiguas no diagonales
    			return false;
    		}
    		
    	}
		return true;
    }
    
    private boolean checkDiagonal(Integer[]pos, String equipo) {
    	boolean casillaValida = false;

    	
    	//	|1| |2|
    	//	| |P| |
    	//	|3| |4|
    	
    	Integer[] auxPos = pos;
    	auxPos[0] -= 1; auxPos[1] += 1;
    	if(mapaCasillas.get(auxPos) != null && mapaCasillas.get(auxPos) == equipo) { //1
    		casillaValida = true;
    	}
    	
    	auxPos = pos;
    	auxPos[0] += 1; auxPos[1] += 1;
    	if(mapaCasillas.get(auxPos) != null && mapaCasillas.get(auxPos) == equipo) { //2
    		casillaValida = true;
    	}
    	
    	auxPos = pos;
    	auxPos[0] -= 1; auxPos[1] -= 1;
    	if(mapaCasillas.get(auxPos) != null && mapaCasillas.get(auxPos) == equipo) { //3
    		casillaValida = true;
    	}
    	
    	auxPos = pos;
    	auxPos[0] += 1; auxPos[1] -= 1; 	
    	if(mapaCasillas.get(auxPos) != null && mapaCasillas.get(auxPos) == equipo) { //4
    		casillaValida = true;
    	}
    	return casillaValida;
    }

    private boolean checkContiguaNoDiagonal(Integer[]pos, String equipo) {
    	boolean casillaValida = true;
   	
    	//	| |1| |
    	//	|4|P|2|
    	//	| |3| |
    	
    	Integer[] auxPos = pos;
    	auxPos[1] += 1;
    	if(mapaCasillas.get(auxPos) == equipo) { //1
    		casillaValida = false;
    	}
    	
    	auxPos = pos;
    	auxPos[0] += 1;
    	if(mapaCasillas.get(auxPos) == equipo) { //2
    		casillaValida = false;
    	}
    	
    	auxPos = pos;
    	auxPos[1] -= 1;
    	if(mapaCasillas.get(auxPos) == equipo) { //3
    		casillaValida = false;
    	}
    	
    	auxPos = pos;
    	auxPos[0] -= 1; 	
    	if(mapaCasillas.get(auxPos) == equipo) { //4
    		casillaValida = false;
    	}
    	return casillaValida;
    	
    }
    
    public void obtenerPuntuacion() {
    	//Llama a player getPuntuacion
    }

    public boolean getJuegoTerminado() {
    	//bucle lista jugadores puedeColocar()
    	return true;
    }

	public String positionToString(int x, int y) {
		
		Integer[] pos = {x,y};
		return (mapaCasillas.containsKey(pos)) ? mapaCasillas.get(pos) : " ";
		
	}

}
