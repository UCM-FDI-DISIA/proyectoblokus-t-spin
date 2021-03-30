package Commands;

import Exception.CommandParseException;
import model.Game;


public class Pasar extends Command{
	private static final String nombre = "pass";
	private static final String shortcut = "p";

	private static final String help = "Pass the turn.";
	
	public Pasar() {
		super(nombre, shortcut,  help);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(Game game) {
		System.out.println("LLega a pass");
		//game.pasar();
		
		return true;
	}

	@Override
	public Command parse(String[] commandWords) {
		// TODO Auto-generated method stub
		if (shortcut.equals(commandWords[0]) || nombre.equals(commandWords[0])) {
			if(commandWords.length == 1)
				return new Pasar();
			else {
				throw new CommandParseException("Command Reset: Incorrect number of arguments");
			}
			
		}
		else {
			return null;
		}
	}


}
