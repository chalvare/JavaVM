package mv.instruction.salto;

import mv.cpu.Cpu;
import mv.excepciones.ErrorMemoria;
import mv.excepciones.Excepciones;
import mv.instruction.Instruction;

public class Bt extends Condicional {

	public Bt(int valorSalto) {
		super(valorSalto);

	}

	@Override
	public void execute(Cpu cpu) throws Excepciones {
		if (cpu.desapilar() != 0) {
			if (this.valorSalto >= 0) {
				if (this.valorSalto <= cpu.recuperarProgramInstrucciones()) {
					cpu.actualizarNextPc(this.valorSalto);
				} else
					cpu.modificatHalt(true);
			} else {
				throw new ErrorMemoria(toString()
						+ " | Imposible acceder a una posici—n negativa");
			}
		} else {
			cpu.actualizarNextPc(cpu.recuperarNextPc() + 1);
		}
	}

	
	@Override
	public String toStringAux() {
		return "BT";
	}

	@Override
	protected Instruction tipoDeClase(int valorSalto) {
		return new Bt(valorSalto);
	}

}
