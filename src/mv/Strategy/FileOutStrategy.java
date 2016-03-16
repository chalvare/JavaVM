package mv.Strategy;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * 
 * @author Christian çlvarez y Luis Arroyo
 *	La Clase FileOutStrategy. Escribe un caracter de un fichero. 
 *	Open abre el fichero
 *	Close Cierra el fichero
 */
public class FileOutStrategy implements OutStrategy {
	private FileWriter fichero;
	private String fname;

	public FileOutStrategy(String fname) {
		this.fname = fname;
	}

	@Override
	public void open() {

		try {
			fichero = new FileWriter(fname);
		} catch (IOException e) {
			e.getMessage();
		}

	}

	@Override
	public void write(int x) {
		PrintWriter pw = new PrintWriter(fichero);
		pw.print((char) x);
	}

	@Override
	public void close() {
		try {
			fichero.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
	}

}
