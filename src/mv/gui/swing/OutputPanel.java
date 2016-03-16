package mv.gui.swing;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import mv.Strategy.OutStrategy;
import mv.Strategy.OutStreamGUI;
import mv.controler.ControladorGUI;
import mv.cpu.CPUObserver;
import mv.cpu.Memory;
import mv.cpu.OperandStack;
import mv.cpu.ProgramaMv;
import mv.instruction.Instruction;
/**
 * @author Christian çlvarez y Luis Arroyo
 * Clase que se dibuja el panel de salida. 
 */
@SuppressWarnings("serial")
public class OutputPanel extends JPanel implements CPUObserver {
	
	private ControladorGUI guiCtrl;
	private JTextArea outputTextArea;
	private OutStrategy outCurr;
	private OutStrategy outNew;
	public OutputPanel(ControladorGUI guiCtrl) {
		this.guiCtrl = guiCtrl;
		initGUI();
	}

	private void initGUI() {
		this.setLayout(new BorderLayout());
		this.setBorder(new TitledBorder("Output"));
		outputTextArea = new JTextArea(0, 10);
		outputTextArea.setFont(new Font("Courier", Font.PLAIN, 16));
		outputTextArea.setEditable(false);
		this.add(new JScrollPane(outputTextArea));
		outCurr = guiCtrl.getOutStream();
		outNew = new OutStreamGUI(outCurr, outputTextArea);
		guiCtrl.setOutStream(outNew);
	}

	@Override
	public void onStartInstrExecution(Instruction instr) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onEndInstrExecution(int pc, Memory<Integer> memoria, OperandStack<Integer>pila){
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
		
		SwingUtilities.invokeLater( new Runnable() {

			@Override
			public void run() {
				outputTextArea.setText("");
			}
			});
		
		outCurr.close();
		outCurr.open();
		this.outCurr = guiCtrl.getOutStream();
		this.outNew = new OutStreamGUI(outCurr, outputTextArea);
		guiCtrl.setOutStream(outNew);
		
	}

}
