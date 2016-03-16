package mv.instruction.otrasBinary;

import mv.cpu.Cpu;
import mv.excepciones.ErrorMemoria;
import mv.excepciones.Excepciones;
import mv.instruction.Instruction;

public class Load extends OtrasBinary {

	public Load(int operando) {
		super(operando);

	}

	@Override
	public void execute(Cpu cpu) throws Excepciones {
		if (operando >= 0) {
			cpu.apilar(cpu.load(operando));
		} else
			throw new ErrorMemoria(toString()
					+ " | Imposible acceder a una posici—n negativa");
	}

	@Override
	protected Instruction tipoDeClase(int valor) {
		return new Load(valor);
	}

	@Override
	public String toStringAux() {
		return "LOAD";
	}

}
