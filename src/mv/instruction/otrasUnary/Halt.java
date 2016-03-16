package mv.instruction.otrasUnary;

import mv.cpu.Cpu;
import mv.instruction.Instruction;

public class Halt extends OtrasUnary {

	@Override
	public void execute(Cpu cpu) {
		cpu.modificatHalt(true);

	}

	@Override
	public String toString() {
		return "HALT";
	}

	@Override
	protected Instruction tipoDeClase() {
		return new Halt();
	}

}
