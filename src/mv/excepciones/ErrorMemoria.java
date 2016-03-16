package mv.excepciones;

public class ErrorMemoria extends Excepciones{

	/**
	 *  Clase que controla las excepciones lanzadas por una ejecucion erronea de la instrucci—n de Memoria.
	 */
	private static final long serialVersionUID = 1L;

	public ErrorMemoria(String e) {
		super(e);
		
	}

	@Override
	public String toString() {
		
		return "Error de tipo Memoria en la instrucci—n: ";
	}

}
