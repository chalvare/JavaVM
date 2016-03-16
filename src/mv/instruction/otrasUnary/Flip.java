package mv.instruction.otrasUnary;

import mv.cpu.Cpu;

import mv.excepciones.Excepciones;
import mv.instruction.Instruction;

public class Flip extends OtrasUnary {

	@Override
	public void execute(Cpu cpu) throws Excepciones {

		int valor1 = cpu.desapilar();
		int valor2 = cpu.desapilar();
		cpu.apilar(valor1);
		cpu.apilar(valor2);

	}

	@Override
	public String toString() {
		return "FLIP";
	}

	@Override
	protected Instruction tipoDeClase() {
		return new Flip();
	}

}
