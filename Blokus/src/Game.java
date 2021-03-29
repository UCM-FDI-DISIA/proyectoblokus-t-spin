import java.util.ArrayList;
import java.util.List;

import java.util.HashMap;

public class Game {
    private boolean juegoTerminado = false;

    private GamePrinter gamePrinter;

    private List<Jugador> jugadores = new ArrayList<Jugador> ();
    
    private HashMap<Integer[], String> mapaCasillas = new HashMap<Integer[], String>();

    public void anadirFicha(Integer[] posicion, String equipo) {
    	mapaCasillas.put(posicion, equipo);
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
    		//Comprueba si está vacía
    		getFichaPos
    		if(mapaCasillas.get(pos) != null) {
    			return false;
    		}
    		if(!checkDiagonal(pos, equipo)) {
    			return false;
    		}
    	}
		return true;
    }
    
    private boolean checkDiagonal(Integer[]pos, String equipo) {
    	boolean casillaValida = false;
    	Integer[] auxPos = pos;
    	auxPos[0] += 1; auxPos[1] += 1;
    	if(mapaCasillas.get(pos) != null) {
    		
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

    public Game() {
    }

}
