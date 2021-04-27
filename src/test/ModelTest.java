package test;

import junit.framework.TestCase;
import model.*;

public class ModelTest extends TestCase{

	/*
	 *  Dejo esta clase de prueba con unos test de prueba sencillos para tenerlos como guía.
	 *  
	 *  Sugiero utilizar un tipo de assert que permita mostrar un mensaje con el resultado del test
	 *  tanto cuando sea favorable, como cuando haya que indicar algún tipo de error.
	 *  
	 *  También he visto que podemos crear el objeto a probar directamente en el método que hace el test,
	 *  es decir, crear el objeto Ficha ficha directamente en el método testConstruirFicha().
	 *  
	 *  Ésto tiene sentido si lo vemos como para qué nos vamos a crear una Casilla y un Jugador si lo que queremos
	 *  probar es la Ficha.
	 */
	
	private Ficha ficha;
	private Casilla casilla;
	private Jugador jugador;
	
	public void init() {
		
		// TODO dar valores correctos a los args para poder hacer bien los test
		this.ficha = new Ficha(null, 0);
		this.casilla = new Casilla(0, 0);
		this.jugador = new Jugador(0);
	}
	
	/**
	 * Prueba si las fichas se crean correctamente.
	 */
	public void testConstruirFicha() {
		init();
		assert(ficha != null);
	}
	
	
	/**
	 * Prueba si las casillas se crean correctamente.
	 */
	public void testConstruirCasilla() {
		init();
		assert(casilla != null);
	}
	
	/**
	 * Prueba si los jugadores se crean correctamente.
	 */
	public void testConstruirJugador() {
		init();
		assert(jugador != null);
	}
	
	
}
