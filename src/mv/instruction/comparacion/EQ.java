package mv.instruction.comparacion;

import mv.cpu.Cpu;
import mv.excepciones.Excepciones;

public class EQ extends Comparacion {

	public EQ() {
		super();
	}

	public Integer operacion(int operando1, int operando2) {

		if (operando1 == operando2)
			return 1;
		else
			return 0;

	}

	public void execute(Cpu cpu) throws Excepciones {
		int cima = cpu.desapilar();
		int subcima = cpu.desapilar();

		if (cima == subcima)
			cpu.apilar(1);
		else
			cpu.apilar(0);

	}

	protected Comparacion tipoDeClase() {
		return new EQ();
	}

	@Override
	public String toString() {
		return "EQ";
	}

}