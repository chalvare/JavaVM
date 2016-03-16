package mv.instruction;


import mv.cpu.Cpu;
import mv.excepciones.Excepciones;

	/** 
	 * @Autor Christian Alvarez y Luis Arroyo
	 * 
	 * Interfaz de instrucciones desde la que colgaran todos los tipos de instrucciones
	 */

public interface Instruction {

	public abstract void execute(Cpu cpu) throws Excepciones;

	public abstract Instruction parseOp(String cadena);

	public abstract String toString();
}
