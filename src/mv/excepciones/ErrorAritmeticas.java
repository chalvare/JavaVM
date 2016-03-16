package mv.excepciones;

public class ErrorAritmeticas extends Excepciones{

	/**
	 * Clase de excepciones que controla las excepciones de las operaciones aritmeticas
	 */
	private static final long serialVersionUID = 1L;

	public ErrorAritmeticas(String e) {
		super(e);

	}

	public String toString() {
		return "Division por cero ";
	}
	
}
