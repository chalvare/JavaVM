package mv.instruction.booleanas;

import mv.instruction.Instruction;

/**
 * @Autor Christian Alvarez y Luis Arroyo
 * 
 *        Operaciones booleanas realizadas entre cima y subcima de la pila o
 *        simplemente cima(NOT)
 */

public abstract class Booleanas implements Instruction {

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
