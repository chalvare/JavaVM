package mv.instruction.aritmeticas;

import mv.cpu.Cpu;

public class Add extends Aritmeticas {

	public Add() {
		super();
	}

	public Integer operacion(Integer operando1, Integer operando2, Cpu cpu) {

		int valor = operando1 + operando2;
		return valor;

	}

	protected Aritmeticas tipoDeClase() {
		return new Add();
	}

	@Override
	public String toString() {
		return "ADD";
	}

}
