package mv.gui.swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.*;
import javax.swing.border.TitledBorder;

import mv.controler.ControladorGUI;
import mv.cpu.CPUObserver;
import mv.cpu.Memory;
import mv.cpu.Observable;
import mv.cpu.OperandStack;
import mv.cpu.ProgramaMv;
import mv.cpu.StackObserver;
import mv.instruction.Instruction;
/**
 * @author Christian çlvarez y Luis Arroyo
 * Clase que se dibuja el panel de la pila.
 * Contiene un campo y dos botones, push y pop que se pueden pulsar en cualquier momento de la ejecuci—n del programa. 
 */
@SuppressWarnings("serial")
public class StackPanel extends JPanel implements StackObserver<Integer>, CPUObserver {
	
	private ControladorGUI guiCtrl;
	private JList stackArea;
	private DefaultListModel model;
	private JPanel miPanel;
	private JButton botonPush;
	private JButton botonPop;
	private JLabel etiqValor;
	private JTextField fieldValor;
	
	
	
	StackPanel(ControladorGUI guiCtrl,Observable<StackObserver<Integer>> stack, Observable<CPUObserver> cpu) {
		this.guiCtrl = guiCtrl;
		initGUI();
		
	}

	private void initGUI() {
		model = new DefaultListModel();
		stackArea = new JList(model);
		miPanel = new JPanel(new BorderLayout());

		JPanel panelBotones = new JPanel();
		botonPush= new JButton("Push");
		botonPop = new JButton("Pop");
		etiqValor = new JLabel("Valor: ");
		fieldValor = new JTextField(5);

		panelBotones.add(etiqValor);
		panelBotones.add(fieldValor);
		panelBotones.add(botonPush);
		panelBotones.add(botonPop);

		this.setLayout(new BorderLayout());
		this.setBorder(new TitledBorder("Pila"));
		this.setPreferredSize(new Dimension(300, 200));
		JScrollPane scroll = new JScrollPane(stackArea);
		miPanel.add(scroll, BorderLayout.CENTER);
		miPanel.add(panelBotones, BorderLayout.PAGE_END);
		this.add(miPanel);

		botonPush.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String valor = fieldValor.getText();
				guiCtrl.push(valor);
				
			}
		});

		botonPop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guiCtrl.pop();
				
			}
		});

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
				botonPop.setEnabled(false);
				botonPush.setEnabled(false);
			}
			});
		
		
	}

	@Override
	public void onEndRun(boolean isHaltPause) {
		
		SwingUtilities.invokeLater( new Runnable() {

			@Override
			public void run() {
				botonPop.setEnabled(true);
				botonPush.setEnabled(true);
			}
			});
	}

	@Override
	public void onError(String msg) {
		SwingUtilities.invokeLater( new Runnable() {

			@Override
			public void run() {
				botonPop.setEnabled(true);
				botonPush.setEnabled(true);
			}
			});
		
		
	}

	@Override
	public void onHalt() {
		SwingUtilities.invokeLater( new Runnable() {

			@Override
			public void run() {
				botonPop.setEnabled(false);
				botonPush.setEnabled(false);
			}
			});
		

		
	}

	@Override
	public void onPush(final Integer value) {
		SwingUtilities.invokeLater( new Runnable() {

			@Override
			public void run() {
				model.add(0, value);	
			}
			});
			
	}

	@Override
	public void onPop() {
		SwingUtilities.invokeLater( new Runnable() {

			@Override
			public void run() {
				model.remove(0);
			}
			});
		
	}

	@Override
	public void onReset(ProgramaMv program) {
		SwingUtilities.invokeLater( new Runnable() {

			@Override
			public void run() {
				botonPush.setEnabled(true);
				botonPop.setEnabled(true);
			}
			});
		
	}

	@Override
	public void onStackReset() {
		SwingUtilities.invokeLater( new Runnable() {

			@Override
			public void run() {
				model.clear();
			}
			});
		
		
	}


}