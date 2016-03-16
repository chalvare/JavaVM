package mv.instruction.otrasUnary;

import mv.cpu.Cpu;
import mv.excepciones.Excepciones;
import mv.instruction.Instruction;

public class Dup extends OtrasUnary {

	@Override
	public void execute(Cpu cpu) throws Excepciones {

		int dup = cpu.desapilar();
		cpu.apilar(dup);
		cpu.apilar(dup);
	}

	@Override
	public String toString() {
		return "DUP";
	}

	@Override
	protected Instruction tipoDeClase() {
		return new Dup();
	}

}
