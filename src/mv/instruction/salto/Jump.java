package mv.instruction.salto;

import mv.cpu.Cpu;
import mv.excepciones.ErrorMemoria;
import mv.excepciones.Excepciones;
import mv.instruction.Instruction;

public class Jump extends Incondicional {

	public Jump(int valorSalto) {
		super(valorSalto);
	}

	/**
	 * Si el valor introducido es menor que el numero de las instrucciones del
	 * programa entonces cambia el contados nextPC
	 * 
	 * @return verdadero si ejecuta el salto
	 * @return false si no se ejecuta.
	 * @throws Excepciones
	 */
	@Override
	public void execute(Cpu cpu) throws Excepciones {

		if (this.valorSalto >= 0) {
			if (this.valorSalto <= cpu.recuperarProgramInstrucciones()) {
				cpu.actualizarNextPc(this.valorSalto);

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

		return "JUMP";
	}

	@Override
	protected Instruction tipoDeClase(int valorSalto) {

		return new Jump(valorSalto);
	}

}
