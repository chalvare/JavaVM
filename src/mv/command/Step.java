package mv.command;

import mv.cpu.Cpu;
import mv.excepciones.Excepciones;

public class Step extends CommandInterpreter {

	@Override
	/**
	 * Ejecuta cpu.step() Ejecuta solo la siquiente instrucci—n
	 */
	public void executeCommand(Cpu cpu) throws Excepciones {
		cpu.step();
	}

	public Command tipoDeComando() {
		return new Step();
	}

	public String toString() {
		return "STEP";
	}

}
