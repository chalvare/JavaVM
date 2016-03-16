package mv.gui.swing;

import mv.cpu.CPUObserver;
import mv.cpu.Memory;
import mv.cpu.Observable;
import mv.cpu.OperandStack;
import mv.cpu.ProgramaMv;
import mv.instruction.Instruction;

public class InteractiveView implements CPUObserver {

	public static String SALTO = System.getProperty("line.separator");

	public InteractiveView(Observable<CPUObserver> cpu) {
		cpu.addObserver(this);
	}

	@Override
	public void onStartInstrExecution(Instruction instr) {
		String imprimir = SALTO + "Comienza la ejecucion del: " + instr;
		System.out.println(imprimir);

	}

	@Override
	public void onEndInstrExecution(int pc, Memory<Integer>memoria, OperandStack<Integer>pila) {
		
		System.out.println(memoria.toString());
		System.out.println(pila.toString());
		System.out.println("-----------------------------");
		
	}

	@Override
	public void onStartRun() {
		// solo para batch

	}

	@Override
	public void onEndRun(boolean isHaltPause) {
		// solo para batch

	}

	@Override
	public void onError(String msg) {
		System.err.println("Error: " + msg);

	}

	@Override
	public void onHalt() {
		System.out.println("\nFin de ejecucion del programa Interactive");
	}

	@Override
	public void onReset(ProgramaMv program) {
		// TODO Auto-generated method stub
		
	}

}
