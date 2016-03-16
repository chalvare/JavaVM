package mv.cpu;

import mv.instruction.Instruction;

public interface CPUObserver {
	public void onStartInstrExecution(Instruction instr);
	public void onEndInstrExecution(int pc, Memory<Integer> memoria, OperandStack<Integer>pila);
	public void onStartRun();
	public void onEndRun(boolean isHaltPause);
	public void onError(String msg);
	public void onHalt();
	public void onReset(ProgramaMv program); 
}

