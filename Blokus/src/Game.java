import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.HashMap;

public class Game {
    
	public final static int DIM_BOARD = 20;
	
	private boolean juegoTerminado = false;
    private List<Jugador> jugadores = new ArrayList<Jugador> ();  
    private HashMap<String, String> mapaCasillas = new HashMap<String, String>();

    public Game() {
    	
    }
    public Game(Ficha ficha) {
    	//test
    	mapaCasillas.put("[0, 0]", ficha.getEquipo());
    	//mapaCasillas.put("[1, 0]", ficha.getEquipo());
    }
    
    public void anadirFicha(Ficha ficha, int x, int y) {
    	
    	ficha.moverFicha(x, y);
    	Integer[] posicion = {0,0};
    	
    	if(cumpleReglas(ficha)) {
    		for(int i = 0; i < ficha.getNumCasillas(); i++){
    			posicion[0] = ficha.getFichaX(i);posicion[1] = ficha.getFichaY(i);
    			mapaCasillas.put(Arrays.toString(posicion), ficha.getEquipo());	
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
    	boolean casillaValida = false;
    	//checkea si vacia y contiguas
    	
    	for(int i = 0; i < ficha.getNumCasillas(); i++) {    		
    		pos[0] = Integer.valueOf(ficha.getFichaX(i)); pos[1] = Integer.valueOf(ficha.getFichaY(i));
    		
    		if(pos[0] < 0 || pos[0] > DIM_BOARD || pos[1] < 0 || pos[1] > DIM_BOARD) {
    			return false;
    		}
    		
    		if(mapaCasillas.containsKey(Arrays.toString(pos))) { //Si está ocupada
    			return false;
    		}
    		
    		if(checkDiagonal(pos, equipo)) { //Si no tiene casillas del equipo en diagonal
    			casillaValida = true;
    		}
    		
    		if(!checkContiguaNoDiagonal(pos, equipo)) { //Si tiene casillas del equipo contiguas no diagonales
    			return false;
    		}
    		
    	}
		return casillaValida;
    }
    
    private boolean checkDiagonal(Integer[]pos, String equipo) {
    	boolean casillaValida = false;

    	
    	//	|1| |2|
    	//	| |P| |
    	//	|3| |4|
    	
    	Integer[] auxPos = {0,0};auxPos[0] = pos[0];auxPos[1] = pos[1];
    	auxPos[0] -= 1; auxPos[1] -= 1;
    	if(mapaCasillas.get(Arrays.toString(auxPos)) == (equipo)) { //1
    		casillaValida = true;
    	}//else {System.out.println("\n1: "+ equipo+mapaCasillas.get(Arrays.toString(auxPos)));}
    	
    	auxPos[0] = pos[0];auxPos[1] = pos[1];
    	auxPos[0] -= 1; auxPos[1] += 1;    	
    	if(mapaCasillas.get(Arrays.toString(auxPos)) == (equipo)) { //2
    		casillaValida = true;
    	}
    	
    	auxPos[0] = pos[0];auxPos[1] = pos[1];
    	auxPos[0] -= 1; auxPos[1] += 1;
    	if(mapaCasillas.get(Arrays.toString(auxPos)) == (equipo)) { //3
    		casillaValida = true;
    	}
    	
    	auxPos[0] = pos[0];auxPos[1] = pos[1];
    	auxPos[0] += 1; auxPos[1] += 1; 	
    	if(mapaCasillas.get(Arrays.toString(auxPos)) == (equipo)) { //4
    		casillaValida = true;
    	}
    	return casillaValida;
    }

    private boolean checkContiguaNoDiagonal(Integer[]pos, String equipo) {
    	boolean casillaValida = true;
   	
    	//	| |1| |
    	//	|4|P|2|
    	//	| |3| |
    	
    	Integer[] auxPos = {0,0};auxPos[0] = pos[0];auxPos[1] = pos[1];
    	auxPos[1] += 1;
    	if(mapaCasillas.get(Arrays.toString(auxPos)) == (equipo)) { //1
    		casillaValida = false;
    	}
    	
    	auxPos[0] = pos[0];auxPos[1] = pos[1];
    	auxPos[0] += 1;
    	if(mapaCasillas.get(Arrays.toString(auxPos)) == (equipo)) { //2
    		casillaValida = false;
    	}
    	
    	auxPos[0] = pos[0];auxPos[1] = pos[1];
    	auxPos[1] -= 1;
    	if(mapaCasillas.get(Arrays.toString(auxPos)) == (equipo)) { //3
    		casillaValida = false;
    	}
    	
    	auxPos[0] = pos[0];auxPos[1] = pos[1];
    	auxPos[0] -= 1; 	
    	if(mapaCasillas.get(Arrays.toString(auxPos)) == (equipo)) { //4
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
