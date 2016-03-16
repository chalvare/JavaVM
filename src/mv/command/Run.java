package mv.command;

import mv.cpu.Cpu;
import mv.excepciones.Excepciones;

public class Run extends Step {

	@Override
	/**
	 * Ejecuta cpu.step() mientras nextPc no halla llegado al final del programa.
	 * Ejecuta todo el programa hasta el final.
	 */
	public void executeCommand(Cpu cpu) throws Excepciones {

		cpu.run();
	}

	public Command tipoDeComando() {
		return new Run();
	}

	public String toString() {
		return "RUN";
	}

}
