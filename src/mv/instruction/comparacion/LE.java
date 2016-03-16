package mv.instruction.comparacion;

public class LE extends Comparacion {

	public LE() {
		super();
	}

	public Integer operacion(int operando1, int operando2) {

		if (operando2 <= operando1)
			return 1;
		else
			return 0;

	}

	protected Comparacion tipoDeClase() {
		return new LE();
	}

	@Override
	public String toString() {
		return "LE";
	}

}