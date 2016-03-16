package mv.instruction.salto;

import mv.cpu.Cpu;
import mv.excepciones.Excepciones;
import mv.instruction.Instruction;

public abstract class Salto implements Instruction {

	public abstract void execute(Cpu cpu) throws Excepciones;

	public abstract String toStringAux();

	protected abstract Instruction tipoDeClase(int valorSalto);

	public Instruction parseOp(String cadena) {
		String instruccion[] = cadena.split(" ");

		if (instruccion.length == 2) {
			if (instruccion[0].equalsIgnoreCase(this.toStringAux())
					&& esNumerico(instruccion[1])) {
				return tipoDeClase(Integer.parseInt(instruccion[1]));
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	protected static boolean esNumerico(String cad) {
		boolean esNumerico = true;
		int i = 0;
		if (cad.charAt(0) == '-' && cad.length() > 1) {
			i++;
		}
		for (; i < cad.length(); i++) {
			if (!Character.isDigit(cad.charAt(i))) {
				esNumerico = false;
			}
		}
		return esNumerico;
	}
}
