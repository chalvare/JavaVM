package mv.instruction.otrasUnary;
import mv.cpu.Cpu;
import mv.excepciones.Excepciones;
import mv.instruction.Instruction;

public class Out extends OtrasUnary {

	@Override
	public void execute(Cpu cpu) throws Excepciones {
		

			cpu.out.write(cpu.desapilar());
			
	}

	@Override
	public String toString() {
		return "OUT";
	}

	@Override
	protected Instruction tipoDeClase() {
		return new Out();
	}

}
