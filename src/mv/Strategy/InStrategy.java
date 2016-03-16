package mv.Strategy;

import java.io.FileNotFoundException;

/**
 * 
 * @author Christian çlvarez y Luis Arroyo
 *	Interfaz que define las funciones de entrada para la ejecucion del programa
 */
public interface InStrategy {
	public void open() throws FileNotFoundException;
	public void close();
	public int read();
	public StringBuilder construirBuilder();
	
}
