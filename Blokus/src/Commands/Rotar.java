package Commands;

import Exception.CommandExecuteException;
import Exception.CommandParseException;


public class Rotar extends Command{
	private static final String nombre = "rotate";
	private static final String shortcut = "ro";
	private static final String help = "rotate the angle the token";//--------------------------------------------------------
	private int posicion;
	private int angulo;
	
	
	public Rotar(int posicion, int angulo) {
		super(nombre, shortcut,  help);
		this.posicion=posicion;
		this.angulo=angulo;
	}
		

	
	@Override
	public boolean execute() {
		if(this.posicion>=0 && this.posicion < 90 && this.angulo>=0 && this.angulo<361) {//CAMPIAR 90 POR EL ARRAY DE PIEZAS JUGADOR
			//Game.anadirFicha();
			System.out.println("LLega a rotar");
		}
		else {
			throw new CommandExecuteException("No ha sido posible rotar", "rotate token");
			
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
					this.posicion = Integer.parseInt(commandWords[1]);
					this.angulo = Integer.parseInt(commandWords[2]);
					return new Rotar(posicion, angulo);	
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