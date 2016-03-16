package mv.instruction.aritmeticas;

import mv.cpu.Cpu;
import mv.excepciones.Excepciones;
import mv.instruction.*;

/**
 * @Autor Christian Alvarez y Luis Arroyo
 * 
 *        Operaciones aritmeticas(Sum,Res,Mul,Div) entre la cima y subcima
 *        almacenando el resultado en la cima de la pila
 */

public abstract class Aritmeticas implements Instruction {

	public void execute(Cpu cpu) throws Excepciones {
		Integer operando1 = cpu.desapilar();
		Integer operando2 = cpu.desapilar();
		cpu.apilar(operacion(operando1, operando2, cpu));
	}

	protected abstract Instruction tipoDeClase();

	/**
	 * Parsea la cadena pasada como instrucci—n y mira si la instruccion tiene
	 * solo un elemento. Despues buscara en todos los toString de sus clases
	 * hijas para ver si coincide con el nombre de la instruccion que hemos
	 * introducido.
	 * 
	 * @return Devuelve un objeto de la instruccion introducida
	 */
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

	public abstract Integer operacion(Integer operando1, Integer operando2, Cpu cpu)
			throws Excepciones;

}
