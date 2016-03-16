package mv.gui.swing;

import mv.cpu.CPUObserver;
import mv.cpu.Memory;
import mv.cpu.Observable;
import mv.cpu.OperandStack;
import mv.cpu.ProgramaMv;
import mv.instruction.Instruction;

public class BatchView implements CPUObserver{

	public BatchView(Observable<CPUObserver> cpu) {
		cpu.addObserver(this);
	}
	
	@Override
	public void onStartInstrExecution(Instruction instr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onEndInstrExecution(int pc, Memory<Integer> memoria, OperandStack<Integer>pila){

		
	}

	@Override
	public void onStartRun() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onEndRun(boolean isHaltPause ) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onError(String msg) {
		System.err.println(msg);
	}

	@Override
	public void onHalt() {
		// TODO Auto-generated method stub
	}

	@Override
	public void onReset(ProgramaMv program) {
		// TODO Auto-generated method stub
		
	}

}
