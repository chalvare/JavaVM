package mv.gui.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.*;

import mv.controler.ControladorGUI;
import mv.cpu.CPUObserver;
import mv.cpu.Memory;
import mv.cpu.MemoryObserver;
import mv.cpu.Observable;
import mv.cpu.OperandStack;
import mv.cpu.ProgramaMv;
import mv.cpu.StackObserver;
import mv.instruction.Instruction;

/**
 * @author Christian çlvarez y Luis Arroyo Clase que se dibuja la ventana
 *         principal que contendra todos los paneles y actualiza todos los
 *         paneles.
 */
@SuppressWarnings("serial")
public class MainWindow extends JFrame implements CPUObserver {

	public static String SALTO = System.getProperty("line.separator");

	private ToolBarPanel toolBar;
	private ProgramPanel programPanel;
	private StackPanel stackPanel;
	private JPanel panelCentral;
	private MemoryPanel memoriaPanel;
	private InputPanel inputPanel;
	private OutputPanel outputPanel;
	private StatusPanel statusBar;
	
	
	
	private ControladorGUI ctrl;
	private Observable<CPUObserver> cpu;
	private Observable<StackObserver<Integer>> pila;
	private Observable<MemoryObserver<Integer>> memoria;

	public MainWindow(ControladorGUI ctrl, Observable<CPUObserver> cpu,
			Observable<StackObserver<Integer>> pila,
			Observable<MemoryObserver<Integer>> memoria) {
		super("Virtual Machine");
		this.cpu = cpu;
		this.memoria = memoria;
		this.pila = pila;
		this.ctrl = ctrl;

		initGUI();
		cpu.addObserver(this);
		pila.addObserver(stackPanel);
		pila.addObserver(statusBar);
		memoria.addObserver(memoriaPanel);
		memoria.addObserver(statusBar);
		
		
	}

	// metodo que crea la interfaz de inicio
	private void initGUI() {

		/************** PRINCIPAL ************/
		JPanel mainPanel = new JPanel(new BorderLayout(5, 5));
		this.setContentPane(mainPanel);
		this.setMinimumSize(new Dimension(900, 650));
		this.setPreferredSize(new Dimension(900, 650));
		/**********************************/

		

		programPanel = new ProgramPanel(ctrl, cpu);
		stackPanel = new StackPanel(ctrl, pila, cpu);
		memoriaPanel = new MemoryPanel(ctrl, memoria, cpu);
		inputPanel = new InputPanel(ctrl);
		outputPanel = new OutputPanel(ctrl);
		statusBar = new StatusPanel(pila, memoria, cpu);
		toolBar = new ToolBarPanel(ctrl, cpu);
		
		
		/********************************************* CENTRO *******************************************/
		panelCentral = new JPanel(new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 0.1;
		c.weighty = 0.4;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.BOTH;
		panelCentral.add(stackPanel, c);

		c.gridx = 1;
		c.gridy = 0;
		c.weightx = 0.1;
		c.weighty = 0.4;
		c.gridwidth = 1;
		c.gridheight = 1;
		c.fill = GridBagConstraints.BOTH;
		panelCentral.add(memoriaPanel, c);

		c.gridx = 0;
		c.gridy = 1;
		c.weightx = 0.4;
		c.weighty = 0.2;
		c.gridwidth = 2;
		c.gridheight = 1;
		c.fill = GridBagConstraints.BOTH;
		panelCentral.add(inputPanel, c);

		c.gridx = 0;
		c.gridy = 2;
		c.weightx = 0.4;
		c.weighty = 0.2;
		c.gridwidth = 2;
		c.gridheight = 1;
		c.fill = GridBagConstraints.BOTH;
		panelCentral.add(outputPanel, c);

		mainPanel.add(panelCentral, BorderLayout.CENTER);
		/******************************************* FIN**CENTRO *******************************************/

		Border b = BorderFactory.createLineBorder(Color.GRAY, 1);
		toolBar.setBorder(BorderFactory.createTitledBorder(b, "Acciones",
				TitledBorder.LEFT, TitledBorder.TOP));
		
		
		mainPanel.add(toolBar, BorderLayout.PAGE_START);
		mainPanel.add(programPanel, BorderLayout.LINE_START);
		
		mainPanel.add(statusBar, BorderLayout.PAGE_END);
		
		/*************************************/

		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				JFrame frame = new JFrame();
				int n = JOptionPane.showOptionDialog(frame,
						"ÀEsta seguro de que quiere cerrar la aplicacion?",
						"Salida", JOptionPane.YES_NO_CANCEL_OPTION,
						JOptionPane.QUESTION_MESSAGE, null, null, null);

				if (n == 0) {
					ctrl.quit();
				}
			}
		});
		
		this.pack();
		mainPanel.setOpaque(true);
		this.setVisible(true);

	}

	

	@Override
	public void onStartInstrExecution(Instruction instr) {
		statusBar.onStartInstrExecution(instr);
	}

	@Override
	public void onEndInstrExecution(int pc, Memory<Integer> memoria, OperandStack<Integer>pila) {
		programPanel.onEndInstrExecution(pc, memoria, pila);
		statusBar.onEndInstrExecution(pc, memoria, pila);
	}

	@Override
	public void onStartRun() {
		toolBar.onStartRun();
		// TODO Auto-generated method stub
		statusBar.onStartRun();
	}

	@Override
	public void onEndRun(boolean isHaltPause) {
		toolBar.onEndRun(isHaltPause);
		stackPanel.onEndRun(isHaltPause);
		memoriaPanel.onEndRun(isHaltPause);
		statusBar.onEndRun(isHaltPause);

	}

	@Override
	public void onError(String msg) {
		JFrame frame = new JFrame();
		JOptionPane.showMessageDialog(frame,
				msg, "Error en la instruccion", JOptionPane.ERROR_MESSAGE);
		
		toolBar.onError(msg);
		stackPanel.onError(msg);
		memoriaPanel.onError(msg);
	}

	@Override
	public void onHalt() {
		stackPanel.onHalt();
		toolBar.onHalt();
		memoriaPanel.onHalt();
	}

	@Override
	public void onReset(ProgramaMv program) {
		inputPanel.onReset(program);
		outputPanel.onReset(program);
		stackPanel.onStackReset();
		stackPanel.onReset(program);
		memoriaPanel.onReset(program);
		memoriaPanel.onMemReset();
		programPanel.onReset(program);
		statusBar.onReset(program);
		toolBar.onReset(program);
		
	}
}
