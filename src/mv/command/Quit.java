package mv.command;

import mv.cpu.Cpu;

public class Quit extends CommandInterpreter {
	@Override
	/**
	 * Modifica el quit a true cuando el usuario introduce el comando quit, con lo cual saldr‡ de la ejecucion del programa
	 */
	public void executeCommand(Cpu cpu) {
		modificatQuit(true);
	}

	public Command tipoDeComando() {
		return new Quit();
	}

	public String toString() {
		return "QUIT";
	}

}
