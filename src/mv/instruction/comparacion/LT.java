package mv.instruction.comparacion;

public class LT extends Comparacion {

	public LT() {
		super();
	}

	public Integer operacion(int operando1, int operando2) {

		if (operando2 < operando1)
			return 1;
		else
			return 0;

	}

	protected Comparacion tipoDeClase() {
		return new LT();
	}

	@Override
	public String toString() {
		return "LT";
	}

}