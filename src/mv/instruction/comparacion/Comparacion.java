package mv.instruction.comparacion;

import mv.cpu.Cpu;
import mv.excepciones.Excepciones;
import mv.instruction.*;

/**
 * @Autor Christian Alvarez y Luis Arroyo
 * 
 *        Comparacion, compara cima y subcima, y dependiendo de la condicion
 *        almacena 0 o 1 en la cima
 */

public abstract class Comparacion implements Instruction {

	public abstract Integer operacion(int operando1, int operando2);

	protected abstract Instruction tipoDeClase();

	public void execute(Cpu cpu) throws Excepciones {

		int operando1 = cpu.desapilar();//cima 
		int operando2 = cpu.desapilar();//subcima

		cpu.apilar(operacion(operando1, operando2));

	}

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