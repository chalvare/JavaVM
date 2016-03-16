package mv.instruction.aritmeticas;

import mv.cpu.Cpu;
import mv.excepciones.ErrorAritmeticas;
import mv.excepciones.Excepciones;

public class Div extends Aritmeticas {

	public Integer operacion(Integer operando1, Integer operando2, Cpu cpu)
			throws Excepciones {

			if (operando1 != 0) {
				return operando2 / operando1;
			} else {
				cpu.apilar(operando2);
				cpu.apilar(operando1);
				throw new ErrorAritmeticas("");
			}
		

	}

	protected Aritmeticas tipoDeClase() {
		return new Div();
	}

	@Override
	public String toString() {
		return "DIV";
	}

}
