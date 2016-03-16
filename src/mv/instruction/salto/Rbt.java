package mv.instruction.salto;

import mv.cpu.Cpu;
import mv.excepciones.ErrorMemoria;
import mv.excepciones.Excepciones;
import mv.instruction.Instruction;

public class Rbt extends Condicional {

	private int incremento = valorSalto;

	public Rbt(int incremento) {
		super(incremento);

	}

	@Override
	public void execute(Cpu cpu) throws Excepciones {

		if (cpu.desapilar() != 0) {
			if ((this.incremento + cpu.recuperarActualPc()) >= 0) {
				if ((this.incremento + cpu.recuperarActualPc()) <= cpu
						.recuperarProgramInstrucciones()) {
					cpu.actualizarNextPc(this.incremento
							+ cpu.recuperarActualPc());

				} else
					cpu.modificatHalt(true);
			} else {

				throw new ErrorMemoria(toString()
						+ " | Imposible acceder a una posici—n negativa");
			}
		} else {
			cpu.actualizarNextPc((cpu.recuperarNextPc() + 1));

		}
	}

	@Override
	public String toStringAux() {
		return "Rbt";
	}

	@Override
	protected Instruction tipoDeClase(int incremento) {
		return new Rbt(incremento);
	}

}