package Commands;

import Exception.CommandExecuteException;
import Exception.CommandParseException;
import model.Game;
import objects.Ficha;



public class AddCommand extends Command{
	private static final String nombre = "add";
	private static final String shortcut = "a";
	private static final String help = "Add a new piece.";//--------------------------------------------------------
	private int fila;
	private int columna;
	private Ficha ficha;
	
	
	public AddCommand(int fila, int columna) {
		super(nombre, shortcut,  help);
		this.fila = fila;
		this.columna = columna;
		this.ficha = ficha;
	}
		

	@Override
	public boolean execute(Game game) throws CommandExecuteException {
		if(this.columna>=0 && this.columna < 20&& this.fila>=0 && this.fila<20) {
			game.anadirFicha(ficha, fila, columna);
			System.out.println("LLega a add");
		}
		else {
			throw new CommandExecuteException("Posicion fuera de rango", "add new piece");
			
		}
		return true;
	}
	

	
	//add 2 3
	@Override
	public Command parse(String[] commandWords) {
		// TODO Auto-generated method stub
		
		if (shortcut.equals(commandWords[0]) || nombre.equals(commandWords[0])) {
			if(commandWords.length == 3) {
				if(isNumeric(commandWords[1]) && isNumeric(commandWords[2])) {
					this.fila = Integer.parseInt(commandWords[1]);
					this.columna = Integer.parseInt(commandWords[2]);
					return new AddCommand(fila, columna);	
				}
				else {
					
					throw new CommandParseException ("NumberFormatException");
					
				}
			}
			else {
				throw new CommandParseException("Command add :Incorrect number of arguments");
				
			}
		}
		return null;
	
	}
	
	private static boolean isNumeric(String commandWords){
		try {
			Integer.parseInt(commandWords);
			return true;
		} catch (NumberFormatException nfe){
			return false;
		}
	}







	
	
}
