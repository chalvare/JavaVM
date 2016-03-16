package mv.Strategy;
/**
 * 
 * @author Christian çlvarez y Luis Arroyo
 *	Interfaz que define las funciones de salida para la ejecucion del programa
 */
public interface OutStrategy {

	public void open();
	public void write(int x);
	public void close();
}
