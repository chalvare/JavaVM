package mv.excepciones;

/**
 * Clase hija de MiExcepcion que hace referencia a la excepcion de la ventana de la maquina virtual.
 * 
 * @author Christian çlvarez S‡nchez y Luis Arroyo Lara
 */

@SuppressWarnings("serial")
public class ErrorMV extends Excepciones {
	/**
	 * Constructor con un parámetro, necesario para indicar el mensaje de error
	 * 
	 * @paramn cadena Mensaje de error
	 */

	public ErrorMV(String cadena) {
		super(cadena);
	}

	@Override
	public String toString() {
		
		return null;
	}
}