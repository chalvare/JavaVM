package mv.gui.swing;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import mv.controler.ControladorGUI;
import mv.cpu.CPUObserver;
import mv.cpu.Memory;
import mv.cpu.Observable;
import mv.cpu.OperandStack;
import mv.cpu.ProgramaMv;
import mv.instruction.Instruction;

/**
 * @author Christian çlvarez y Luis Arroyo Clase que se dibuja el panel del
 *         programa.
 */
@SuppressWarnings("serial")
public class ProgramPanel extends JPanel implements CPUObserver {

	public static String SALTO = System.getProperty("line.separator");
	private ControladorGUI guiCtrl;
	private JTextArea programTextArea;
	private ProgramaMv programa;
	private int pc;

	public ProgramPanel(ControladorGUI guiCtrl, Observable<CPUObserver> cpu) {
		this.guiCtrl = guiCtrl;
		initGUI();
	}

	private void initGUI() {
		this.setLayout(new BorderLayout());
		this.setBorder(new TitledBorder("Program"));
		programTextArea = new JTextArea(10, 15);
		programTextArea.setFont(new Font("Courier", Font.PLAIN, 16));
		programTextArea.setEditable(false);
		this.add(new JScrollPane(programTextArea));

		programa = guiCtrl.getProgram();
		pc = 0;
		showProgram(pc);

	}

	private void showProgram(int pc) {
		programTextArea.setText("");
		for (int i = 0; programa.instruccion(i) != null; i++) {
			if (i == pc){
				programTextArea.append("* " + i + ": "
						+ programa.instruccion(i) + "\n");
			}else{
				programTextArea.append(i + ": " + programa.instruccion(i)+ "\n");
			}
		}
	}

	@Override
	public void onStartInstrExecution(Instruction instr) {
		

	}

	@Override
	public void onEndInstrExecution(final int pc, Memory<Integer> memoria, OperandStack<Integer>pila) {
		SwingUtilities.invokeLater( new Runnable() {

			@Override
			public void run() {
				showProgram(pc);
			}
			});
		
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
		this.pc=0;
		SwingUtilities.invokeLater( new Runnable() {

			@Override
			public void run() {
				showProgram(pc);
			}
			});
		
		
		
	}


}
