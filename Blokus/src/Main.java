import java.util.ArrayList;
import java.util.List;

public class Main {
    //private Controller controller;

    public void main() {
    	System.out.print("hola mundo");
    	//TEST ZONE
    	Game game = new Game();
    	Ficha ficha;
    	
    	int[][] forma = {{0,1},{0,1}};
    	List<Casilla> arrayCasillas = new ArrayList<Casilla> ();
    	arrayCasillas.add(new Casilla(1,1));
    	arrayCasillas.add(new Casilla(0,0));
    	arrayCasillas.add(new Casilla(0,0));
    	ficha = new Ficha(forma, arrayCasillas);
    	game.anadirFicha(ficha);
    	
    	//TEST ZONE
    }

}
