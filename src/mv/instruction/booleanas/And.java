package mv.instruction.booleanas;

import mv.cpu.Cpu;
import mv.excepciones.Excepciones;

public class And extends Booleanas {

	public And() {
		super();
	}

	@Override
	public void execute(Cpu cpu) throws Excepciones {

		int cima = cpu.desapilar();
		int subCima = cpu.desapilar();

		if (cima == 0 || subCima == 0) {
			cpu.apilar(0);
		} else {
			cpu.apilar(1);
		}

	}

	protected Booleanas tipoDeClase() {
		return new And();
	}

	@Override
	public String toString() {
		return "AND";
	}

}
