package mv.instruction.otrasUnary;

import mv.cpu.Cpu;
import mv.excepciones.Excepciones;
import mv.instruction.Instruction;

public class Neg extends OtrasUnary {

	@Override
	public void execute(Cpu cpu) throws Excepciones {
		cpu.apilar(cpu.desapilar() * -1);
	}

	@Override
	public String toString() {
		return "NEG";
	}

	@Override
	protected Instruction tipoDeClase() {
		return new Neg();
	}

}
