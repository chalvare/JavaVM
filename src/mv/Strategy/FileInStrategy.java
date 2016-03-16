package mv.Strategy;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import mv.main.MyOptions;

public class FileInStrategy implements InStrategy {

	private FileReader fichero;
	private String fname;

	/**
	 * 
	 * @author Christian çlvarez y Luis Arroyo La Clase FileInStrategy. Lee un
	 *         caracter de un fichero. Open abre el fichero Close Cierra el
	 *         fichero
	 */
	public FileInStrategy(String fname) {
		this.fname = fname;
	}

	public void open() throws FileNotFoundException {
		fichero = new FileReader(fname);
	}

	public void close() {
		try {
			fichero.close();
		} catch (NullPointerException e) {
			e.getMessage();
		} catch (IOException e) {
			e.getMessage();
		}
	}

	public int read() {
		int a = -1;
		try {
			if (fichero.ready())
				a = fichero.read();
		} catch (NullPointerException e) {
			e.getMessage();
		} catch (IOException e) {
			e.getMessage();
		}

		return a;
	}

	@Override
	public StringBuilder construirBuilder() {
		StringBuilder texto = new StringBuilder();
		try {
			fichero = new FileReader(MyOptions.getI());
			int caract = fichero.read();
			while (caract != -1) {
				texto.append((char) caract);
				caract = fichero.read();
			}
		} catch (Exception e) {
			System.err.println("Error de lectura del fichero de entrada");
		}
		return texto;
	}

}
