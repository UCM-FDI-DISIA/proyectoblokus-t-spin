import java.util.ArrayList;
import java.util.List;

public class Ficha {
    private String equipo;

    private int[] forma;

    private List<Casilla> arrayCasillas = new ArrayList<Casilla> ();

    public Ficha(List<Integer> forma, List<Casilla> arrayCasillas) {
    }
    
    public void rotar(int rotacion) {
    }

    public void setForma() {
    }


    
    //-----
    public String getEquipo() {
    	return equipo;
    }
    
    public int getFichaX(int i) {
    	
    	return arrayCasillas.get(i).getX();
    }
    
    public int getFichaY(int i) {
    	
    	return arrayCasillas.get(i).getY();
    }
    
    public int getNumCasillas() {
    	return arrayCasillas.size();
    }
//-----
}
