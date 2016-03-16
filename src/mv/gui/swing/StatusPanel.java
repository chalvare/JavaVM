package mv.gui.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import mv.cpu.CPUObserver;
import mv.cpu.Memory;
import mv.cpu.MemoryObserver;
import mv.cpu.Observable;
import mv.cpu.OperandStack;
import mv.cpu.ProgramaMv;
import mv.cpu.StackObserver;
import mv.instruction.Instruction;

@SuppressWarnings("serial")
public class StatusPanel extends JPanel implements StackObserver<Integer>, MemoryObserver<Integer>, CPUObserver {

	private JPanel miPanel;
	private JLabel contador;
	private JCheckBox memoriaBox;
	private JCheckBox pilaBox;
	private JLabel pause;
	private int contadorInstrucciones=0;
	public StatusPanel(Observable<StackObserver<Integer>> pila,
			Observable<MemoryObserver<Integer>> memoria,
			Observable<CPUObserver> cpu) {
		
		initGUI();
	}

	private void initGUI() {
		pause = new JLabel();
		contador = new JLabel();
		memoriaBox = new JCheckBox();
		pilaBox = new JCheckBox();
		contador.setText("" + contadorInstrucciones);
		
		memoriaBox.setEnabled(false);
		pilaBox.setEnabled(false);
		
		
		miPanel = new JPanel();
		pause.setForeground(Color.RED);
		Font boldFont = new Font(getName(), Font.BOLD,12);
		pause.setFont(boldFont);
		
		miPanel.add(pause);
		miPanel.add(new JLabel("Num. Instruones ejecutadas"));
		miPanel.add(contador);
		miPanel.add(memoriaBox);
		miPanel.add(new JLabel("Memodia Modificada"));
		miPanel.add(pilaBox);
		miPanel.add(new JLabel("Pila Modificada"));
		
		this.add(miPanel, BorderLayout.CENTER);

	}

	@Override
	public void onStartInstrExecution(Instruction instr) {
		
		SwingUtilities.invokeLater( new Runnable() {

			@Override
			public void run() {
				memoriaBox.setSelected(false);
				pilaBox.setSelected(false);
			}
			});
	}

	@Override
	public void onEndInstrExecution(int pc, Memory<Integer> memoria, OperandStack<Integer>pila) {
		++contadorInstrucciones;
		
		SwingUtilities.invokeLater( new Runnable() {

			@Override
			public void run() {
				contador.setText("" + contadorInstrucciones);
				pause.setText("       ");
			}
			});
	}

	@Override
	public void onStartRun() {
		pause.setText("       ");
		
	}

	@Override
	public void onEndRun(final boolean isHaltPause) {
		SwingUtilities.invokeLater( new Runnable() {

			@Override
			public void run() {
				if(isHaltPause)pause.setText("Maquina Parada       ");
				else pause.setText("       ");
			}
			});
		
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
	public void onWrite(int index, Integer value) {
		
		SwingUtilities.invokeLater( new Runnable() {

			@Override
			public void run() {
				memoriaBox.setSelected(true);
			}
			});
		
	}

	@Override
	public void onPush(Integer value) {
		
		
		SwingUtilities.invokeLater( new Runnable() {

			@Override
			public void run() {
				pilaBox.setSelected(true);
			}
			});
		
	}

	@Override
	public void onPop() {
		SwingUtilities.invokeLater( new Runnable() {

			@Override
			public void run() {
				pilaBox.setSelected(true);
			}
			});
		
		
	}

	@Override
	public void onReset(ProgramaMv program) {
		
		contadorInstrucciones=0;
		contador.setText("" + contadorInstrucciones);
		SwingUtilities.invokeLater( new Runnable() {

			@Override
			public void run() {
				memoriaBox.setSelected(false);
				pilaBox.setSelected(false);
			}
			});
		pause.setText("       ");
		
	}

	@Override
	public void onMemReset() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStackReset() {
		// TODO Auto-generated method stub
		
	}

}
