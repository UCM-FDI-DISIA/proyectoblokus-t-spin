package Commands;

import java.util.Scanner;

import Exception.*;


public class CommandGenerator {
	

	private static int posicion;
	private static int angulo;
	private static int fila;
	private static int columna;
	private static Command[] availableCommands = {
			new AddCommand(fila, columna),
			new HelpCommand(),
			new ResetCommand(),
			new ExitCommand(),
			new Restantes(),
			new Rotar(posicion,angulo),
			new Pasar(),
			
			
			};

	
	 /*public static void main(String[ ] commandWords) {
		 Scanner scanner=new Scanner(System.in);
		String s = scanner.nextLine();
		
 		String[] parameters = s.toLowerCase().trim().split(" ");
 		System.out.println("[DEBUG] Executing: " + s);
 		parse(parameters);
		
		 
		  
		 
	 }*/

	public static Command parse(String[ ] commandWords) throws CommandParseException {
		
		Command comando=null;
		for(int i=0;i<availableCommands.length;i++) {
			
			if(availableCommands[i].parse(commandWords) != comando) {
				 comando=availableCommands[i].parse(commandWords);
				 comando.execute();
				 return comando;
			}
		}
			 throw new CommandParseException("unknownCommandMsg");

	
	}
	
	public static String commandHelp() {
		String help = null;
		for(int i=0;i<availableCommands.length;i++) {
			if(availableCommands[i].helpText()==help) {
				help=availableCommands[i].helpText();
				break;
			}
		}
		return help;
		
	}
}
