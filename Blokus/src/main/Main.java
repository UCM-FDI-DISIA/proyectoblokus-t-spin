package main;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import controller.Controller;
import model.Game;

public class Main {

	public static void main(String[] args)  {
    		
    	Controller controller;
    	Game game;
    	Scanner scanner;
    	   
    	scanner = new Scanner(System.in);
    	game = new Game(1);
    	controller = new Controller(game, scanner);
    	controller.run(); //Ejecuta el juego
    	
    	System.out.print("adios mundo");
    	//TEST ZONE
    	/*
 	
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
    	System.out.print(" adios mundo");*/
    	//TEST ZONE
    }

}
