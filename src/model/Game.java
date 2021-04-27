package model;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import view.FichasPanel;
import view.GamePanel;
import exceptions.GameException;
//import javafx.beans.InvalidationListener;
//import javafx.beans.Observable;

import java.util.HashMap;

public class Game{
    
	public final static int DIM_BOARD = 20;
	
	private boolean primeraRonda;
	private boolean juegoTerminado;
    private List<Jugador> jugadores;  
    private HashMap<String, Integer> mapaCasillas;
    private List<GameObserver> go;
    
    public int currentPlayer = 0;
    
    

    public Game(int numJugadores) {
    	// Inicializo los atributos de la clase en el constructor
    	this.primeraRonda = true;
    	this.juegoTerminado = false;
    	this.jugadores = new ArrayList<Jugador>();
    	this.mapaCasillas = new HashMap<String, Integer>();
    	this.go = new ArrayList<GameObserver>();  	
    	
    	initJugadores(2,1);
    }
    
       
    public void initJugadores(int p, int ia) {
    	for(int i = 0; i < p; i++) {
    		jugadores.add(new Jugador(i+1));
    	}
    	for(int i = p; i < p+ia; i++) {
    		jugadores.add(new JugadorIA(i+1));    		
    	}
    	
    }
    

     
    public void update() {    	
    	 	   	
    	currentPlayer++;

    	if(currentPlayer >= jugadores.size()) {
			currentPlayer = 0;
			primeraRonda = false;
		}

    	
    	for(GameObserver o : go) {    		
			o.updateIcono(currentPlayer);
		}

    	if(jugadores.get(currentPlayer).computerAction(this)) {    		
        	update();
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
        	    	
        	    	throw new GameException("Posición no válida.\n");
        		}
        		
        		if(mapaCasillas.containsKey(Arrays.toString(posicion))) { //Si estÃ¡ ocupada
        			throw new GameException("Posición no válida.\n");
        		}
        	}
    		
    		for(int i = 0; i < ficha.getNumCasillas(); i++){
    			posicion[0] = ficha.getFichaX(i);posicion[1] = ficha.getFichaY(i);
    			mapaCasillas.put(Arrays.toString(posicion), Integer.valueOf(ficha.getEquipo()));
    			
    			for(GameObserver o : go) {
    				o.onFichaAnadida(ficha.getEquipo(), ficha.getFichaX(i), ficha.getFichaY(i));
    			}
    		}
    		jugadores.get(currentPlayer).borrarPieza(f);
    		fichaAnadida = true;
    	}
    	else {
    		throw new GameException("La primera ficha debe colocarse en una de las esquinas\n");
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
    			mapaCasillas.put(Arrays.toString(posicion), Integer.valueOf(ficha.getEquipo()));
    			for(GameObserver o : go) {
    				o.onFichaAnadida(ficha.getEquipo(), ficha.getFichaX(i), ficha.getFichaY(i));
    			}
    		}
    		//Llamar a jugador para quitarle la ficha que acaba de colocar
    		if ((jugadores.get(currentPlayer).getNumFichas() == 1) && (ficha.getNumCasillas() == 1)) {
    			jugadores.get(currentPlayer).puntUltimoCuadrado();
    		}
			jugadores.get(currentPlayer).borrarPieza(f);
			

    	} 
    	else {
    		throw new GameException("Posición no válida.\n");
    	}
    	return fichaAnadida;
    }
    
    public boolean cumpleReglas(Ficha ficha) {
    	Integer[] pos = {0,0};
    	Integer equipo = ficha.getEquipo();
    	boolean casillaValida = false;
    	//checkea si vacia y contiguas
    	
    	for(int i = 0; i < ficha.getNumCasillas(); i++) {    		
    		
    		pos[0] = Integer.valueOf(ficha.getFichaX(i)); pos[1] = Integer.valueOf(ficha.getFichaY(i));
    		
    		if(pos[0] < 0 || pos[0] > DIM_BOARD-1 || pos[1] < 0 || pos[1] > DIM_BOARD-1) {    			    			
    			
    			return false;
    		}
    		
    		if(mapaCasillas.containsKey(Arrays.toString(pos))) { //Si estÃ¡ ocupada    			    			
    			
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
    
    private boolean checkDiagonal(Integer[]pos, int equipo) {
    	boolean casillaValida = false;

    	
    	//	|1| |2|
    	//	| |P| |
    	//	|3| |4|
    	
    	Integer[] auxPos = {0,0};auxPos[0] = pos[0];auxPos[1] = pos[1];
    	auxPos[0] += 1; auxPos[1] += 1;
    	
    	if(mapaCasillas.get(Arrays.toString(auxPos)) == Integer.valueOf(equipo)) { //1
    		casillaValida = true;    		
    	}//else {System.out.println("\n1: "+ equipo+mapaCasillas.get(Arrays.toString(auxPos)));}
    	
    	auxPos[0] = pos[0];auxPos[1] = pos[1];
    	auxPos[0] += 1; auxPos[1] -= 1;    	
    	if(mapaCasillas.get(Arrays.toString(auxPos)) == Integer.valueOf(equipo)) { //2
    		casillaValida = true;    		
    	}
    	
    	auxPos[0] = pos[0];auxPos[1] = pos[1];
    	auxPos[0] -= 1; auxPos[1] += 1;
    	if(mapaCasillas.get(Arrays.toString(auxPos)) == Integer.valueOf(equipo)) { //3
    		casillaValida = true;    		
    	}
    	
    	auxPos[0] = pos[0];auxPos[1] = pos[1];
    	auxPos[0] -= 1; auxPos[1] -= 1; 	
    	if(mapaCasillas.get(Arrays.toString(auxPos)) == Integer.valueOf(equipo)) { //4
    		casillaValida = true;    		
    	}
    	return casillaValida;
    }

    private boolean checkContiguaNoDiagonal(Integer[]pos, int equipo) {
    	boolean casillaValida = true;
   	
    	//	| |1| |
    	//	|4|P|2|
    	//	| |3| |
    	
    	Integer[] auxPos = {0,0};auxPos[0] = pos[0];auxPos[1] = pos[1];
    	auxPos[1] += 1;
    	if(mapaCasillas.get(Arrays.toString(auxPos)) == Integer.valueOf(equipo)) { //1
    		casillaValida = false;
    	}
    	
    	auxPos[0] = pos[0];auxPos[1] = pos[1];
    	auxPos[0] += 1;
    	if(mapaCasillas.get(Arrays.toString(auxPos)) == Integer.valueOf(equipo)) { //2
    		casillaValida = false;
    	}
    	
    	auxPos[0] = pos[0];auxPos[1] = pos[1];
    	auxPos[1] -= 1;
    	if(mapaCasillas.get(Arrays.toString(auxPos)) == Integer.valueOf(equipo)) { //3
    		casillaValida = false;
    	}
    	
    	auxPos[0] = pos[0];auxPos[1] = pos[1];
    	auxPos[0] -= 1; 	
    	if(mapaCasillas.get(Arrays.toString(auxPos)) == Integer.valueOf(equipo)) { //4
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
		return ""; //arreglar
		//return (mapaCasillas.containsKey(Arrays.toString(pos))) ? mapaCasillas.get(Arrays.toString(pos)) : " ";
		
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
		
	public void reset() {
		//TODO Falta resetear las fichas de los jugadores
		currentPlayer=0;
		mapaCasillas.clear();
	}
	public void remaining() {
		jugadores.get(currentPlayer).getNumFichas();
	}
	
	public void rotate(int numFicha, int rotacion) {
		jugadores.get(currentPlayer).getFicha(numFicha).rotar(rotacion);
	}
	
	public int dim (int i) {
		return jugadores.get(currentPlayer).getNumCasillas(i);
	}

	public void addObserver(GameObserver o) {
		go.add(o);
	}
	






}
