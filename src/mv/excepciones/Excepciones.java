package mv.excepciones;

public abstract class Excepciones extends Exception{

	/**
	 * Clase padre de las excepciones.
	 */
	private static final long serialVersionUID = 1L;

	public Excepciones(String e)
	{
		super(e);
	}

	public abstract String toString();
};
