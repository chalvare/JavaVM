package mv.gui.swing;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import mv.Strategy.InStrategy;
import mv.Strategy.InStreamGUI;
import mv.controler.ControladorGUI;
import mv.cpu.CPUObserver;
import mv.cpu.Memory;
import mv.cpu.OperandStack;
import mv.cpu.ProgramaMv;
import mv.instruction.Instruction;

/**
 * @author Christian çlvarez y Luis Arroyo
 * Clase que se dibuja el panel de entrada. 
 */
@SuppressWarnings("serial")
public class InputPanel extends JPanel implements CPUObserver{

	private ControladorGUI guiCtrl;
	private JTextArea inputTextArea;
	private InStrategy inCurr;
	private InStrategy inNew;
	public InputPanel(ControladorGUI guiCtrl) {
		this.guiCtrl = guiCtrl;
		initGUI();
	}

	private void initGUI() {
		this.setLayout(new BorderLayout());
		this.setBorder(new TitledBorder("Input"));
		inputTextArea = new JTextArea(10, 10);
		inputTextArea.setFont(new Font("Courier", Font.PLAIN, 16));
		inputTextArea.setEditable(false);
		this.add(new JScrollPane(inputTextArea));
		inCurr = guiCtrl.getInStream();
		inNew = new InStreamGUI(inCurr, inputTextArea);
		guiCtrl.setInStream(inNew);
	}

	@Override
	public void onStartInstrExecution(Instruction instr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onEndInstrExecution(int pc, Memory<Integer> memoria, OperandStack<Integer>pila) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStartRun() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onEndRun(boolean isHaltPause) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onError(String msg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onHalt() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onReset(ProgramaMv program) {
		this.inNew = new InStreamGUI(inCurr, inputTextArea);
		guiCtrl.setInStream(inNew);
		
	}
}
