package mv.instruction.otrasUnary;

import mv.cpu.Cpu;
import mv.excepciones.ErrorInst;
import mv.excepciones.Excepciones;
import mv.instruction.Instruction;

public class Loadind extends OtrasUnary {

	@Override
	public void execute(Cpu cpu) throws Excepciones {
		if (cpu.mostrarCima() >= 0) {
			int operando = cpu.desapilar();

			if (operando >= 0) {
				cpu.apilar(cpu.load(operando));
			} else
				throw new ErrorInst(
						toString()
								+ " - Imposible acceder a una posici—n de memoria negativa");
		} else {
			throw new ErrorInst(toString() + "- Falta operando en la pila");
		}
	}

	@Override
	public String toString() {
		return "Loadind";
	}

	@Override
	protected Instruction tipoDeClase() {
		return new Loadind();
	}

}
