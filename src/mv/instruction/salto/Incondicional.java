package mv.instruction.salto;

import mv.cpu.Cpu;
import mv.excepciones.Excepciones;
import mv.instruction.Instruction;

/**
 * @Autor Christian Alvarez y Luis Arroyo
 * 
 *        Salto incondicional cambia el contador de programa a la linea que se
 *        le indique
 */

public abstract class Incondicional extends Salto {

	protected int valorSalto;

	public abstract void execute(Cpu cpu) throws Excepciones;

	public abstract String toStringAux();

	protected abstract Instruction tipoDeClase(int valorSalto);

	Incondicional(int valorSalto) {
		this.valorSalto = valorSalto;
	}

	Incondicional() {
	}

	public String toString() {

		return toStringAux() + " " + this.valorSalto;
	}

}
