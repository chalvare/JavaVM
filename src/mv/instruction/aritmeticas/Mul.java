package mv.instruction.aritmeticas;

import mv.cpu.Cpu;

public class Mul extends Aritmeticas {

	public Mul() {
		super();
	}

	public Integer operacion(Integer operando1, Integer operando2, Cpu cpu) {

		int valor = operando2 * operando1;
		return valor;
	}

	protected Aritmeticas tipoDeClase() {
		return new Mul();
	}

	@Override
	public String toString() {
		return "MUL";
	}

}
