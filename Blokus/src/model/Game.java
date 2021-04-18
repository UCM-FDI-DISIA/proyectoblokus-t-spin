package model;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Exception.GameException;


import java.util.HashMap;

public class Game {
    
	public final static int DIM_BOARD = 20;
	
	private boolean primeraRonda;
	private boolean juegoTerminado;
    private List<Jugador> jugadores;  
    private HashMap<String, String> mapaCasillas;
    private List<GameObserver> go;
    
    public int currentPlayer = 0;

    public Game(int numJugadores) {
    	// Inicializo los atributos de la clase en el constructor
    	this.primeraRonda = true;
    	this.juegoTerminado = false;
    	this.jugadores = new ArrayList<Jugador>();
    	this.mapaCasillas = new HashMap<String, String>();
    	this.go = new ArrayList<GameObserver>();  	
    	
    	initPrueba();
    	
    }
    
    private void initPrueba() {
    	
    	//CONSTRUCTOR DE PRUBA, FICHAS CARGADAS DE FORMA MANUAL
    	Ficha ficha;
    	Ficha ficha2;
    	List<Casilla> arrayCasillas = new ArrayList<Casilla> ();
    	List<Casilla> arrayCasillas2 = new ArrayList<Casilla> ();
    	List<Ficha> arrayFichas = new ArrayList<Ficha>();
    	List<Ficha> arrayFichas2 = new ArrayList<Ficha>();
    	arrayCasillas.add(new Casilla(0,0));
    	arrayCasillas.add(new Casilla(0,0));
    	arrayCasillas.add(new Casilla(0,0));
    	arrayCasillas2.add(new Casilla(0,0));
    	arrayCasillas2.add(new Casilla(0,0));
    	arrayCasillas2.add(new Casilla(0,0));
    	int[][] forma = {{1,0},{1,0}};
    	Jugador jugador;
    	Jugador jugador2;
    	
    	ficha = new Ficha(forma, arrayCasillas, "A");
    	for(int i = 0; i < 10; i++) {
    		arrayFichas.add(ficha);	
    	}
    	jugador = new Jugador(arrayFichas);
    	jugadores.add(jugador);
    	
    	
    	ficha2 = new Ficha(forma, arrayCasillas2, "B");
    	for(int i = 0; i < 10; i++) {
    		arrayFichas2.add(ficha2);	
    	}    	
    	jugador2 = new Jugador(arrayFichas2);
    	jugadores.add(jugador2);
    	
    	/*for(int i = 0; i < numJugadores; i++) {
    		jugadores.add(jugador);
    	}*/
    }
    
    public void update() {
    	currentPlayer++;
    	if(currentPlayer >= jugadores.size()) {
			currentPlayer = 0;
		}	
    }
    
    
    
    public boolean jugarPrimeraRonda(int f, int y, int x) {
    	boolean fichaAnadida = false;
    	Ficha ficha;
    	ficha = jugadores.get(currentPlayer).getFicha(f);
    	ficha.moverFicha(x, y);
    	Integer[] posicion = {0,0};
    	
    	
    	if(jugadorPuedeColocar(currentPlayer) && checkEsquinas(ficha)) {
    		for(int i = 0; i < ficha.getNumCasillas(); i++) {    		
    			posicion[0] = Integer.valueOf(ficha.getFichaX(i)); posicion[1] = Integer.valueOf(ficha.getFichaY(i));
        		
        		if(posicion[0] < 0 || posicion[0] > DIM_BOARD || posicion[1] < 0 || posicion[1] > DIM_BOARD) {
        			return false;
        		}
        		
        		if(mapaCasillas.containsKey(Arrays.toString(posicion))) { //Si est√° ocupada
        			return false;
        		}
        	}
    		
    		for(int i = 0; i < ficha.getNumCasillas(); i++){
    			posicion[0] = ficha.getFichaX(i);posicion[1] = ficha.getFichaY(i);
    			mapaCasillas.put(Arrays.toString(posicion), ficha.getEquipo());	
    		}
    		jugadores.get(currentPlayer).borrarPieza(f);
    		fichaAnadida = true;
    	}
    	else {
    		throw new GameException("La primera ficha debe colocarse en una de las esquinas\n");
    	}
    	if(currentPlayer >= jugadores.size()-1) {
    		primeraRonda = false;
    	}
    	return fichaAnadida;
    }
    
    public boolean checkEsquinas(Ficha ficha) {// comprueba que la ficha se coloca en alguna de las esquinas
		Integer[] esquina1 = { 0, 0 }, esquina2 = { DIM_BOARD - 1, 0 }, esquina3 = { 0, DIM_BOARD - 1 },
				esquina4 = { DIM_BOARD - 1, DIM_BOARD - 1 };
		Integer[] casilla = { 0, 0 };
		for (int i = 0; i < ficha.getNumCasillas(); ++i) {
			casilla[0] = ficha.getFichaX(i);
			casilla[1] = ficha.getFichaY(i);
			if (casilla[0] == esquina1[0] && casilla[1] == esquina1[1]) {
				return true;
			} else if (casilla[0] == esquina2[0] && casilla[1] == esquina2[1]) {
				return true;
			} else if (casilla[0] == esquina3[0] && casilla[1] == esquina3[1]) {
				return true;
			} else if (casilla[0] == esquina4[0] && casilla[1] == esquina4[1]) {
				return true;
			}
		}
		return false;
	}
    //------------
 
    public boolean jugadorPuedeColocar(int jugador) {
    	//llama a jugador para ver si tiene piezas y ver si puede colocar
    	return jugadores.get(jugador).puedeJugar();
    }
    
    public boolean anadirFicha(int f, int y, int x) {
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
    		//Llamar a jugador para quitarle la ficha que acaba de colocar
    		if ((jugadores.get(currentPlayer).getNumFichas() == 1) && (ficha.getNumCasillas() == 1)) {
    			jugadores.get(currentPlayer).puntUltimoCuadrado();
    		}
			jugadores.get(currentPlayer).borrarPieza(f);
    	} 
    	else {
    		throw new GameException("PosiciÛn no v·lida.\n");
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
    		
    		if(mapaCasillas.containsKey(Arrays.toString(pos))) { //Si est√° ocupada
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
		
		jugadores.get(currentPlayer).getFicha(numFicha).rotar(rotacion);

	}
	
	public int dim (int i) {
		return jugadores.get(currentPlayer).getNumCasillas(i);
	}

}
