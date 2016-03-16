package mv.command;

import mv.cpu.Cpu;
import mv.excepciones.Excepciones;

public class Steps extends Step {

	private int numeroDeInstrucciones = 0;

	Steps(int numeroDeInstrucciones) {
		this.numeroDeInstrucciones = numeroDeInstrucciones;
	}

	@Override
	/**
	 * Ejecuta cpu.step() el numero de pasos que el ususario le haya introducido.
	 */
	public void executeCommand(Cpu cpu) throws Excepciones {
		while ((cpu.recuperarNextPc() < cpu.recuperarProgramInstrucciones())
				&& this.numeroDeInstrucciones > 0) {
			cpu.step();
			this.numeroDeInstrucciones--;
		}
	}

	public Command parseCo(String cadena) {
		String comando[] = cadena.split(" ");

		if (comando.length == 2 && esNumerico(comando[1])&& Integer.parseInt(comando[1])>=0) {
			if (comando[0].equalsIgnoreCase(this.toString())) {
				this.numeroDeInstrucciones = Integer.parseInt(comando[1]);
				return tipoDeComando(this.numeroDeInstrucciones);
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	public Command tipoDeComando(int valor) {
		return new Steps(valor);
	}

	public String toString() {
		return "STEP";
	}
}
