package controller;
import java.util.Scanner;

import Commands.Command;
import Commands.CommandGenerator;
import model.Game;
import view.BoardPrinter;

public class Controller {
    private model.Game game;
    private Scanner in;
	BoardPrinter printer = new BoardPrinter();
	
    //public Command command;
	boolean printGame = true;
	
    public Controller(Game game, Scanner scanner) {
    	this.game = game;
		in = scanner;
		for(int i = 0; i < game.getNumJugadores(); i++) {
			//game.jugarPrimeraRonda();	
		}
		
    }
   
	public void run() {
		while(!game.getJuegoTerminado()) {
			if(printGame)
			{
				draw();
			}
			printGame = true;
			
			System.out.print("Command > ");
			String[] words = in.nextLine().toLowerCase().trim().split("\\s+");
			
			Command command = CommandGenerator.parse(words);
			
			if (command != null)
			{
				if (!command.execute(game))
				{
					printGame = false;
				}
			}
			else
			{
				System.out.format("Comando desconocido.");
				printGame = false;
			}
			
			System.out.println("Turno > "+game.turno);
			game.turno++;
		}
    }

    private void draw() {
		// TODO Auto-generated method stub
		System.out.println(printer.toString(game));
		
	}


}
