package mv.command;

import mv.cpu.Cpu;
import mv.excepciones.Excepciones;

public class Write extends CommandInterpreter {

	private int operando;
	private int posicion;

	Write(int posicion, int operando) {
		this.operando = operando;
		this.posicion = posicion;
	}

	@Override
	/**
	 * Escribe en memoria en la posicion, que debe ser mayor que 0, el operando.
	 */
	public void executeCommand(Cpu cpu) throws Excepciones {
		if( this.posicion>=0){
			cpu.store(this.posicion, this.operando);
			
		}
	}

	public Command parseCo(String cadena) {
		String comando[] = cadena.split(" ");

		if (comando.length == 3 && esNumerico(comando[1])
				&& esNumerico(comando[2])) {
			if (comando[0].equalsIgnoreCase(this.toString())) {
				this.posicion = Integer.parseInt(comando[1]);
				this.operando = Integer.parseInt(comando[2]);
				return tipoDeComando(this.posicion, this.operando);
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	public Command tipoDeComando(int posicion, int valor) {
		return new Write(posicion, valor);
	}

	public String toString() {
		return "WRITE";
	}

	@Override
	public Command tipoDeComando() {

		return null;
	}

}
