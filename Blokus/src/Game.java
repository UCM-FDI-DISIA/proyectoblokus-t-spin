import java.util.ArrayList;
import java.util.List;

import java.util.HashMap;

public class Game {
    private boolean juegoTerminado = false;

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
    		
    		pos[0] = Integer.valueOf(ficha.getFichaX(i)); pos[1] = Integer.valueOf(ficha.getFichaY(i));
    		
    		if(mapaCasillas.get(pos) != null) { //Si est� ocupada
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

    	
    	//	|1| |2|
    	//	| |P| |
    	//	|3| |4|
    	
    	Integer[] auxPos = pos;
    	auxPos[0] -= 1; auxPos[1] += 1;
    	if(mapaCasillas.get(pos) != null) { //1
    		casillaValida = true;
    	}
    	
    	auxPos = pos;
    	auxPos[0] += 1; auxPos[1] += 1;
    	if(mapaCasillas.get(pos) != null) { //2
    		casillaValida = true;
    	}
    	
    	auxPos = pos;
    	auxPos[0] -= 1; auxPos[1] -= 1;
    	if(mapaCasillas.get(pos) != null) { //3
    		casillaValida = true;
    	}
    	
    	auxPos = pos;
    	auxPos[0] += 1; auxPos[1] -= 1; 	
    	if(mapaCasillas.get(pos) != null) { //4
    		casillaValida = true;
    	}
    	return casillaValida;
    }

    private boolean checkContiguaNoDiagonal(Integer[]pos, String equipo) {
    	boolean casillaValida = false;

    	
    	//	| |1| |
    	//	|4|P|2|
    	//	| |3| |
    	
    	Integer[] auxPos = pos;
    	
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
