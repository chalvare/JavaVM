package mv.instruction.otrasBinary;

import mv.cpu.Cpu;

public class Push extends OtrasBinary {

	public Push(int valor) {
		super(valor);
	}

	@Override
	public void execute(Cpu cpu) {
		cpu.apilar(this.operando);
	}

	protected OtrasBinary tipoDeClase(int valor) {
		return new Push(valor);
	}

	@Override
	public String toStringAux() {
		return "PUSH";
	}

}
