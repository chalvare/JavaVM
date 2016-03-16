package mv.excepciones;

public class ErrorInstrFichero extends Excepciones{

	/**
	 * Clase que controla las excepciones lanzadas por una ejecucion erronea de la instrucci—n.
	 */
	private static final long serialVersionUID = 1L;

	public ErrorInstrFichero(String e) {
		super(e);
	}

	@Override
	public String toString() {
		return "Error al leer la instrucci—n del fichero. Instruccion no valida ";
	}

}
