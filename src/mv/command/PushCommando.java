package mv.command;

import mv.cpu.Cpu;

public class PushCommando extends CommandInterpreter {

	private int operando;

	PushCommando(int operando) {
		this.operando = operando;
	}

	@Override
	/**
	 * Ejecuta el push en cualquier momento durante la ejecucion
	 */
	public void executeCommand(Cpu cpu) {
		cpu.apilar(this.operando);
	}

	public Command parseCo(String cadena) {
		String comando[] = cadena.split(" ");
		if (comando.length == 2 && esNumerico(comando[1])) {
			if (comando[0].equalsIgnoreCase(this.toString())) {
				this.operando = Integer.parseInt(comando[1]);
				return tipoDeComando(this.operando);
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	public Command tipoDeComando(int valor) {
		return new PushCommando(valor);
	}

	public String toString() {
		return "PUSH";
	}

	@Override
	public Command tipoDeComando() {

		return null;
	}

}
