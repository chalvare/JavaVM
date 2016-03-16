package mv.Strategy;

import java.io.IOException;
/**
 * 
 * @author Christian çlvarez y Luis Arroyo
 *	La Clase ConsoleInstrategy lee un caracter desde teclado. Si el caracter es intro(10)
 *	introduce un -1 para que termine la ejecucion
 *	Open abre el fichero
 *	Close Cierra el fichero
 */

public class ConsoleInStrategy implements InStrategy{

	
	@Override 
	public int read(){
		int caracter=-1;
		try {
			caracter =  System.in.read();
			
			if(caracter==10)caracter=-1;
		
		} catch (IOException e) {
			e.getMessage();
		}
		return caracter;
	}

	@Override
	public void open() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public StringBuilder construirBuilder() {
		// TODO Auto-generated method stub
		return null;
	}

}
