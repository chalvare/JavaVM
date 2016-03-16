package mv.instruction.otrasUnary;

import mv.cpu.Cpu;
import mv.excepciones.ErrorMemoria;
import mv.excepciones.Excepciones;
import mv.instruction.Instruction;

public class Storeind extends OtrasUnary {

	@Override
	public void execute(Cpu cpu) throws Excepciones {

		int valor = cpu.desapilar();
		int pos = cpu.desapilar();

		if (pos >= 0) {
			cpu.store(pos, valor);

		}

		else
			throw new ErrorMemoria(toString() + " | La pila esta vacia");
	}

	@Override
	public String toString() {
		return "Storeind";
	}

	@Override
	protected Instruction tipoDeClase() {
		return new Storeind();
	}

}
