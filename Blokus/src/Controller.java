import java.util.Scanner;

import Commands.Command;
import Commands.CommandGenerator;

public class Controller {
    private Game game;
    private Scanner in;
	GamePrinter printer;
	
    //public Command command;
	boolean printGame = true;
	
    public Controller(Game game, Scanner scanner) {
    	this.game = game;
		in = scanner;
		//game
		//printer = PrinterTypes.BOARDPRINTER.getObject();
    	   	
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
		}
    }

    private void draw() {
		// TODO Auto-generated method stub
		System.out.println("AAAAA");
	}


}
