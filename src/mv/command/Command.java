package mv.command;

import mv.cpu.Cpu;
import mv.excepciones.Excepciones;
/**
 * 
 * @author Christian Alvarez y Luis Arroyo
 *Interfaz de los comandos
 *Tendra el metodo que ejecuta el comando y el que lo parsea
 */
public interface Command {
	public abstract void executeCommand(Cpu cpu) throws Excepciones;

	public abstract Command parseCo(String cadena);

	public abstract String toString();

}
