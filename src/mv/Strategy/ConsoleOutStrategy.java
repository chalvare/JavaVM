package mv.Strategy;
/**
 * 
 * @author Christian çlvarez y Luis Arroyo
 *	La Clase ConsoleOutstrategy Imprime por consola un caracter. 
 *	Open abre el fichero
 *	Close Cierra el fichero
 */

public class ConsoleOutStrategy implements OutStrategy{

	@Override
	public void open() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void write(int x){
		
		System.out.print((char)x);
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

}
