import java.util.ArrayList;
import java.util.List;

public class Main {
    //private Controller controller;

	public static void main(String[] args)  {
    	System.out.print("hola mundo");
    	//TEST ZONE
    	//Game game = new Game();
    	Ficha ficha;
    	Ficha ficha2;
    	
    	int[][] forma = {{1,0},{1,0}};
    	List<Casilla> arrayCasillas = new ArrayList<Casilla> ();
    	List<Casilla> arrayCasillas2 = new ArrayList<Casilla> ();
    	
    	arrayCasillas2.add(new Casilla(1,0));
    	
    	ficha2 = new Ficha(forma, arrayCasillas, "A");
    	Game game = new Game(ficha2);
    	
    	arrayCasillas.add(new Casilla(0,0));
    	arrayCasillas.add(new Casilla(0,0));
    	arrayCasillas.add(new Casilla(0,0));
    	
    	ficha = new Ficha(forma, arrayCasillas, "A");
    	
    	game.anadirFicha(ficha, 1, 1);
    	System.out.print("adios mundo");
    	//TEST ZONE
    }

}
