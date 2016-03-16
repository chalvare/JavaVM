package mv.command;

import mv.cpu.Cpu;
import mv.excepciones.Excepciones;

public class PopCommando extends CommandInterpreter {

	@Override
	/**
	 * Ejecuta el pop en cualquier momento durante la ejecucion
	 */
	public void executeCommand(Cpu cpu) throws Excepciones {
			cpu.desapilar();
	}

	@Override
	public Command tipoDeComando() {

		return new PopCommando();
	}

	public String toString() {
		return "POP";
	}

}
