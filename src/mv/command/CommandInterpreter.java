package mv.command;

import mv.cpu.Cpu;
import mv.excepciones.Excepciones;

public abstract class CommandInterpreter implements Command {

	protected static Cpu cpu;
	protected static boolean quit = false;

	public abstract void executeCommand(Cpu cpu) throws Excepciones;

	public abstract Command tipoDeComando();

	public static void configureCommandInterpreter(Cpu cpu) {
		CommandInterpreter.cpu = cpu;
	}

	/**
	 * Parsea la cadena pasada como comando y mira si el comando tiene solo un elemento. 
	 * Despues buscara en todos los toString de sus clases hijas para ver si coincide con el nombre del comando 
	 * que hemos introducido.
	 * @return Devuelve un objeto comando de la clase introducida
	 */
	public Command parseCo(String cadena) {
		String comando[] = cadena.split(" ");

		if (comando.length == 1) {
			if (comando[0].equalsIgnoreCase(this.toString())) {
				return tipoDeComando();
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	/**
	 * 
	 * @param quit gestiona la parada del programa en cualquier momento por parte del usuario
	 */
	public static void modificatQuit(boolean quit) {
		CommandInterpreter.quit = quit;
	}

	public static boolean isQuit() {
		return quit;
	}

	protected static boolean esNumerico(String cad) {
		boolean esNumerico = true;
		int i = 0;
		if (cad.charAt(0) == '-' && cad.length() > 1) {
			i++;
		}
		for (; i < cad.length(); i++) {
			if (!Character.isDigit(cad.charAt(i))) {
				esNumerico = false;
			}
		}
		return esNumerico;
	}
}
