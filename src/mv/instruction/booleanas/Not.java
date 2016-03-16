package mv.instruction.booleanas;

import mv.cpu.Cpu;
import mv.excepciones.Excepciones;

public class Not extends Booleanas {

	public Not() {
		super();
	}

	@Override
	public void execute(Cpu cpu) throws Excepciones {

		int cima = cpu.desapilar();

		if (cima != 0) {
			cpu.apilar(0);
		} else {
			cpu.apilar(1);
		}

	}

	protected Booleanas tipoDeClase() {
		return new Not();
	}

	@Override
	public String toString() {
		return "NOT";
	}

}
