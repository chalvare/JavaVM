package mv.gui.swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import mv.controler.ControladorGUI;
import mv.cpu.CPUObserver;
import mv.cpu.Memory;
import mv.cpu.Observable;
import mv.cpu.OperandStack;
import mv.cpu.ProgramaMv;
import mv.instruction.Instruction;

/**
 * @author Christian çlvarez y Luis Arroyo Clase que se dibuja el panel de los
 *         botones de comando step run y quit.
 */
@SuppressWarnings("serial")
public class ToolBarPanel extends JPanel implements CPUObserver {

	private ControladorGUI guiCtrl;
	private JButton stepButton = new JButton();
	private JButton runButton = new JButton();
	private JButton quitButton = new JButton();
	private JButton pauseButton = new JButton();
	private JButton resetButton = new JButton();

	public ToolBarPanel(ControladorGUI guiCtrl, Observable<CPUObserver> cpu) {
		this.guiCtrl = guiCtrl;
		initGUI();
	}

	public ToolBarPanel(ControladorGUI guiCtrl) {
		this.guiCtrl = guiCtrl;
		initGUI();
	}

	private void initGUI() {

		stepButton.setIcon(createImageIcon("step.png"));
		stepButton.setToolTipText("Step");
		this.add(stepButton);
		stepButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				guiCtrl.step();
			}
		});

		runButton.setIcon(createImageIcon("run.png"));
		runButton.setToolTipText("Run");
		this.add(runButton);
		runButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				new Thread() {
					public void run() {
						guiCtrl.run();
					}
				}.start();
				
			}
		});

		pauseButton.setIcon(createImageIcon("pause.png"));
		pauseButton.setToolTipText("Pause");
		this.add(pauseButton);
		pauseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guiCtrl.pause();
			}
		});

		resetButton.setIcon(createImageIcon("reset.png"));
		resetButton.setToolTipText("Reset");
		this.add(resetButton);
		resetButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guiCtrl.reset();
			}
		});

		quitButton.setIcon(createImageIcon("exit.png"));
		quitButton.setToolTipText("Exit");
		this.add(quitButton);
		quitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// guiCtrl.quit();
				JFrame frame = new JFrame();
				int opcion = JOptionPane.showOptionDialog(frame,
						"ÀEsta seguro de que quiere cerrar la aplicacion?",
						"Saliendo del programa...",
						JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE, null, null, null);
				if (opcion == JOptionPane.YES_OPTION) {
					guiCtrl.quit();
					
				}
			}
		});
	}


	private static ImageIcon createImageIcon(String path) {
		java.net.URL imgURL = MainWindow.class.getResource(path);
		if (imgURL != null)
			return new ImageIcon(imgURL);
		return null;
	}

	@Override
	public void onStartInstrExecution(Instruction instr) {

	}

	@Override
	public void onEndInstrExecution(int pc, Memory<Integer> memoria, OperandStack<Integer>pila){

	}

	@Override
	public void onStartRun() {
		SwingUtilities.invokeLater( new Runnable() {

			@Override
			public void run() {
				stepButton.setEnabled(false);
				runButton.setEnabled(false);
				resetButton.setEnabled(false);
			}
			});
		
	}

	@Override
	public void onEndRun(boolean isHaltPause) {
		SwingUtilities.invokeLater( new Runnable() {

			@Override
			public void run() {
				stepButton.setEnabled(true);
				runButton.setEnabled(true);
				pauseButton.setEnabled(true);
				resetButton.setEnabled(true);
			}
			});
		

	}

	@Override
	public void onError(String msg) {
		SwingUtilities.invokeLater( new Runnable() {

			@Override
			public void run() {
				stepButton.setEnabled(true);
				runButton.setEnabled(true);
				resetButton.setEnabled(true);

			}
			});
		
	}

	@Override
	public void onHalt() {
		SwingUtilities.invokeLater( new Runnable() {

			@Override
			public void run() {
				stepButton.setEnabled(false);
				runButton.setEnabled(false);
				pauseButton.setEnabled(false);
				resetButton.setEnabled(true);
			}
			});
		
	}

	@Override
	public void onReset(ProgramaMv program) {
		SwingUtilities.invokeLater( new Runnable() {

			@Override
			public void run() {
				stepButton.setEnabled(true);
				runButton.setEnabled(true);
				pauseButton.setEnabled(true);
			}
			});
		
		

	}

}
