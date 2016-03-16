package mv.instruction.comparacion;

public class GT extends Comparacion {

	public GT() {
		super();
	}

	public Integer operacion(int operando1, int operando2) {

		if (operando1 < operando2)
			return 1;
		else
			return 0;

	}

	protected Comparacion tipoDeClase() {
		return new GT();
	}

	@Override
	public String toString() {
		return "GT";
	}

}