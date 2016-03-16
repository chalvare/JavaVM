package mv.instruction.booleanas;

import mv.cpu.Cpu;
import mv.excepciones.Excepciones;

public class Or extends Booleanas {

	public Or() {
		super();
	}

	@Override
	public void execute(Cpu cpu) throws Excepciones {

		int cima = cpu.desapilar();
		int subCima = cpu.desapilar();

		if (cima != 0 || subCima != 0) {
			cpu.apilar(1);
		} else {
			cpu.apilar(0);
		}

	}

	protected Booleanas tipoDeClase() {
		return new Or();
	}

	@Override
	public String toString() {
		return "OR";
	}

}
