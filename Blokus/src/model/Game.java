package model;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import objects.Casilla;
import objects.Ficha;
import objects.Jugador;

import java.util.HashMap;

public class Game {
    
	public final static int DIM_BOARD = 20;
	
	private boolean primeraRonda = true;
	private boolean juegoTerminado = false;
    private List<Jugador> jugadores = new ArrayList<Jugador> ();  
    private List<Ficha> token=new ArrayList<Ficha>();
    private HashMap<String, String> mapaCasillas = new HashMap<String, String>();
    public int currentPlayer = 0;

    public Game(int numJugadores) {
    	Ficha ficha;
    	List<Casilla> arrayCasillas = new ArrayList<Casilla> ();
    	arrayCasillas.add(new Casilla(0,0));
    	arrayCasillas.add(new Casilla(0,0));
    	arrayCasillas.add(new Casilla(0,0));
    	int[][] forma = {{1,0},{1,0}};
    	ficha = new Ficha(forma, arrayCasillas, "A");
    		
    	List<Ficha> arrayFichas = new ArrayList<Ficha>();
    	arrayFichas.add(ficha);
    	//
    	Jugador jugador = new Jugador(arrayFichas);
    	for(int i = 0; i < numJugadores; i++) {
    		jugadores.add(jugador);
    	}
    }
    
    public void update() {
    	currentPlayer++;
    	if(currentPlayer >= jugadores.size()) {
			currentPlayer = 0;
		}	
    }
    
    /*public void ejecutaJuego(int ficha, int x, int y) {
    	if(primeraRonda) {
    		jugarPrimeraRonda(ficha, x, y);
    	}
    	else {
    		if(currentPlayer >=4) {
    			currentPlayer = 0;
    			
    		}
    		currentPlayer++;
    		for(Jugador j : jugadores) {
    			if(jugadorPuedeColocar(j)) {
    				anadirFicha(ficha, x, y);
    			}
    		}
    	}
    }*/
    
    public void jugarPrimeraRonda(int ficha, int x, int y) {
    	if(jugadorPuedeColocar(currentPlayer) && checkEsquinas(x, y)) {
    			anadirFicha(ficha, x, y);
    	}
    	primeraRonda = false;
    }
    
    public boolean checkEsquinas(int x, int y) {// comprueba que la ficha se coloca en alguna de las esquinas
    	Integer[] esquina1 = {0, 0}, esquina2 = {DIM_BOARD-1, 0}, 
    			esquina3 = {0, DIM_BOARD-1}, esquina4 = {DIM_BOARD-1, DIM_BOARD-1};
    	Integer[] casilla = {x, y};
    	return casilla.equals(esquina1) || casilla == esquina2 
    			|| casilla == esquina3 || casilla == esquina4;
    }
    //------------
 
    public boolean jugadorPuedeColocar(int jugador) {
    	//llama a jugador para ver si tiene piezas y ver si puede colocar
    	return jugadores.get(jugador).puedeJugar();
    }
    
    public boolean anadirFicha(int f, int x, int y) {
    	Ficha ficha;
    	ficha = jugadores.get(currentPlayer).getFicha(f);
    	ficha.moverFicha(x, y);
    	Integer[] posicion = {0,0};
    	boolean fichaAnadida = false;
    	
 
    	if(fichaAnadida = cumpleReglas(ficha)) {
    		for(int i = 0; i < ficha.getNumCasillas(); i++){
    			posicion[0] = ficha.getFichaX(i);posicion[1] = ficha.getFichaY(i);
    			mapaCasillas.put(Arrays.toString(posicion), ficha.getEquipo());	
    		}
    		//Llamar a jugardor para quitarle la ficha que acaba de colocar
    		//jugadores.get(1).borrarPieza(1); //esta linea está mal, arreglar
    	}   
    	return fichaAnadida;
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
    
    public void obtenerPuntuacion(int jugador) {
    	//Llama a player getPuntuacion
    	int punt = jugadores.get(jugador).getPuntuacion();
    	System.out.println(punt);
    }

    public boolean getJuegoTerminado() {
    	//bucle lista jugadores puedeColocar() 	
    	for(int i = 0; i < jugadores.size(); i++) {// si el bucle termina y ninguno puede colocar el juego ha terminado
    		if(!jugadores.get(i).puedeJugar()) {
    			juegoTerminado = true;
    		}
    	}
    	return juegoTerminado;
    }

	public String positionToString(int x, int y) {
		
		Integer[] pos = {x,y};
		return (mapaCasillas.containsKey(Arrays.toString(pos))) ? mapaCasillas.get(Arrays.toString(pos)) : " ";
		
	}

	public int getNumJugadores() {
		return jugadores.size();
	}
	
	public boolean getPrimeraRonda() {
		return primeraRonda;
	}
	
	public void exit() {
		juegoTerminado = true;
		
	}
		
	public void Reset() {
		currentPlayer=0;
		mapaCasillas.clear();	
	}
	public void Remaining() {
		jugadores.get(currentPlayer).getNumFichas();
	}
	
	public void Rotate(int numFicha, int rotacion) {
		
		jugadores.get(currentPlayer).get(numFicha).rotar(rotacion);

	}

}
