package objects;
import java.util.ArrayList;
import java.util.List;

public class Jugador {
    private int puntuacion = 0;
    private boolean ultimoCuadrado = false;
    private List<Ficha> arrayFichas = new ArrayList<Ficha> ();

    public Jugador(List<Ficha> arrayFichas) {
    	this.arrayFichas = arrayFichas;
    }
    
    public Ficha getFicha(int i) {
    	return arrayFichas.get(i);
    }
    
    public int getPuntuacion() {
    	// Buscamos si faltan casillas o no. 
    	// Si faltan restamos, sino sumamos puntos
    	
    	if (getNumFichas() > 0) {
    		for (int i = 0; i < getNumFichas(); i++) {
    			for (int j = 0; j < getNumCasillas(i); j++) {
    				puntuacion--;
    			}
    		}
    	}
    	else {
    		puntuacion += 15;
    		
    		if (ultimoCuadrado) {
    			puntuacion += 5;
    		}
    	}
    	
    	return puntuacion;
    }
    
    public void puntUltimoCuadrado() {
    	ultimoCuadrado = true;
    }

    public void borrarPieza(int pieza) {
    	arrayFichas.remove(pieza);
    }

    public boolean puedeJugar() { 
    	if (getNumFichas() > 0) {
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    public int getNumFichas() {
    	return arrayFichas.size();
    }
    
    public int getNumCasillas(int ficha) {
    	return arrayFichas.get(ficha).getNumCasillas();
    }
    
}
