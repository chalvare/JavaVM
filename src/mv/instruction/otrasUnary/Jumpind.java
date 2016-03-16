package mv.instruction.otrasUnary;

import mv.cpu.Cpu;
import mv.excepciones.ErrorMemoria;
import mv.excepciones.Excepciones;
import mv.instruction.Instruction;

public class Jumpind extends OtrasUnary {

	public Jumpind() {

	}

	public void execute(Cpu cpu) throws Excepciones {

		int salto = cpu.desapilar();
		if (salto >= 0) {
			if (salto <= cpu.recuperarProgramInstrucciones()) {
				cpu.actualizarNextPc(salto);

			} else {
				cpu.modificatHalt(true);
			}
		} else {

			throw new ErrorMemoria(toString()
					+ " | Imposible acceder a una posici—n negativa");
		}

	}

	@Override
	public String toString() {

		return "JUMPIND";
	}

	@Override
	protected Instruction tipoDeClase() {

		return new Jumpind();

	}

}
