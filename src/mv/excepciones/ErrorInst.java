package mv.excepciones;

public class ErrorInst extends Excepciones{

	/**
	 * Clase que controla las excepciones lanzadas por una ejecucion erronea de la instrucci—n.
	 */
	private static final long serialVersionUID = 1L;

	public ErrorInst(String e) {
		super(e);
	}

	@Override
	public String toString() {
		
		return "Error al ejecutar la instrucci—n: ";
	}

}
