package main;
import java.util.Scanner;

import controller.Controller;
import model.Game;

public class Main {

	public static void main(String[] args)  {
    		
    	Controller controller;
    	Game game;
    	Scanner scanner;
    	int numJugadores = 2;
    	//TEST
    	if (args.length == 1) {
        	numJugadores = Integer.parseInt(args[0]);
    	}    	
    	//TEST
    	scanner = new Scanner(System.in);
    	game = new Game(numJugadores);
    	controller = new Controller(game, scanner);
    	controller.run(); //Ejecuta el juego
    	
    	System.out.print("Game closed.");
    	//TEST ZONE

    	//TEST ZONE
    }

}
