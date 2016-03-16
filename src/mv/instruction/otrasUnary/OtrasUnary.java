package mv.instruction.otrasUnary;

import mv.instruction.Instruction;

public abstract class OtrasUnary implements Instruction {

	protected abstract Instruction tipoDeClase();

	public Instruction parseOp(String cadena) {
		String instruccion[] = cadena.split(" ");

		if (instruccion.length == 1) {
			if (instruccion[0].equalsIgnoreCase(this.toString())) {
				return tipoDeClase();
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

}
