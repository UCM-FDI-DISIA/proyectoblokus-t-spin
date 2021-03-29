import java.util.ArrayList;
import java.util.List;

import java.util.HashMap;

public class Game {
    private boolean juegoTerminado = false;

    private List<Jugador> jugadores = new ArrayList<Jugador> ();
    
    private HashMap<Integer[], String> mapaCasillas = new HashMap<Integer[], String>();

    public Game() {
    
    }
    
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



}
