package mv.instruction.otrasBinary;

import mv.cpu.Cpu;
import mv.excepciones.ErrorMemoria;
import mv.excepciones.Excepciones;
import mv.instruction.Instruction;

public class Store extends OtrasBinary {

	public Store(int operando) {
		super(operando);
	}

	@Override
	public void execute(Cpu cpu) throws Excepciones {
		if (!cpu.pilaVacia()) {
			if (operando >= 0) {

				cpu.store(operando, cpu.desapilar());

			} else {
				throw new ErrorMemoria(toString()
						+ " | Imposible acceder a una posici—n negativa");
			}
		} else
			throw new ErrorMemoria(toString() + " | La pila esta vacia");
	}

	@Override
	public String toStringAux() {
		return "STORE";
	}

	@Override
	protected Instruction tipoDeClase(int valor) {
		return new Store(valor);
	}

}
