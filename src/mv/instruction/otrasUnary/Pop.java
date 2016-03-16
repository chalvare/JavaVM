package mv.instruction.otrasUnary;

import mv.cpu.Cpu;
import mv.excepciones.Excepciones;
import mv.instruction.Instruction;

public class Pop extends OtrasUnary {

	@Override
	public void execute(Cpu cpu) throws Excepciones {
	
			cpu.desapilar();

	

	}

	@Override
	public String toString() {
		return "POP";
	}

	@Override
	protected Instruction tipoDeClase() {
		return new Pop();
	}

}
