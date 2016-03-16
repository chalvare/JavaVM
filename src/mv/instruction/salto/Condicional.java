package mv.instruction.salto;

import mv.cpu.Cpu;
import mv.excepciones.Excepciones;
import mv.instruction.Instruction;

/**
 * @Autor Christian Alvarez y Luis Arroyo
 * 
 *        Si se cumple la condicion(en la cima de la pila un "1" o un "0") el
 *        contador de programa cambiara a la posicion indicada
 */

public abstract class Condicional extends Salto {

	protected int valorSalto;

	public abstract void execute(Cpu cpu) throws Excepciones;

	public abstract String toStringAux();

	protected abstract Instruction tipoDeClase(int valorSalto);

	Condicional(int valorSalto) {
		this.valorSalto = valorSalto;
	}

	public String toString() {

		return toStringAux() + " " + this.valorSalto;
	}

}
