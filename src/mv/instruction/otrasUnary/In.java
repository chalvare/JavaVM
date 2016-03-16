package mv.instruction.otrasUnary;
import mv.cpu.Cpu;
import mv.excepciones.Excepciones;
import mv.instruction.Instruction;

public class In extends OtrasUnary{

	@Override
	public void execute(Cpu cpu) throws Excepciones {
		
		/*
		 * en execute se introduce el modo de entrada y el modo de salida. Con el modo de entrada
		 * si es FileInStrategy se le devolvera el entero que apilara en la pila
		 * y si es desde consola, es decir llega vacio, lo cogera desde consola*/

		cpu.apilar(cpu.in.read());
	}

	@Override
	protected Instruction tipoDeClase() {
		
		return new In();
	}
	@Override
	public String toString() {
		return "IN";
	}

}
