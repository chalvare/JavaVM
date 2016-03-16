package mv.instruction.salto;

import mv.cpu.Cpu;
import mv.excepciones.ErrorMemoria;
import mv.excepciones.Excepciones;
import mv.instruction.Instruction;

/**
 * @Autor Christian Alvarez y Luis Arroyo
 * 
 *        Salto incondicional que incrementa el contador de programa el numero
 *        de pisiciones que indique el segundo parametro
 */

public class Rjump extends Incondicional {

	int incremento = valorSalto;

	public Rjump(int incremento) {
		super(incremento);
	}

	@Override
	public void execute(Cpu cpu) throws Excepciones {
		int aux = this.incremento + cpu.recuperarNextPc();
		if (aux >= 0) {
			if (aux <= cpu.recuperarProgramInstrucciones()) {
				cpu.actualizarNextPc(aux);
			} else {
				cpu.modificatHalt(true);
			}
		} else {
			throw new ErrorMemoria(toString()
					+ " | Imposible acceder a una posici—n negativa");
		}
	}

	@Override
	public String toStringAux() {

		return "RJUMP";
	}

	protected Instruction tipoDeClase(int incremento) {

		return new Rjump(incremento);
	}

}
