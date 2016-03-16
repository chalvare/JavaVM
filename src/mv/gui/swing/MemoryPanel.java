package mv.gui.swing;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TreeMap;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;

import mv.controler.ControladorGUI;
import mv.cpu.CPUObserver;
import mv.cpu.Memory;
import mv.cpu.MemoryObserver;
import mv.cpu.Observable;
import mv.cpu.OperandStack;
import mv.cpu.ProgramaMv;
import mv.instruction.Instruction;

/**
 * @author Christian çlvarez y Luis Arroyo Clase que se dibuja el panel de la
 *         memoria. Contendra una tabla que muestra la posici—n y el dato
 *         almacenado Adem‡s tendra dos campos y un boton para introducir en
 *         cualquier momento un valor
 */
@SuppressWarnings("serial")
public class MemoryPanel extends JPanel implements MemoryObserver<Integer>,
		CPUObserver {

	private ControladorGUI guiCtrl;
	private TableModel model;

	private JTextField fieldPos;
	private JTextField fieldValor;
	private JButton botonWrite;

	public MemoryPanel(ControladorGUI guiCtrl,
			Observable<MemoryObserver<Integer>> memory,
			Observable<CPUObserver> cpu) {
		this.guiCtrl = guiCtrl;
		initGUI();
	}

	private void initGUI() {
		model = new TableModel();
		JTable table = new JTable(model);
		table.setPreferredScrollableViewportSize(new Dimension(500, 170));
		table.setFillsViewportHeight(true);

		JScrollPane scrollPane = new JScrollPane(table);

		add(scrollPane);

		JPanel miPanel = new JPanel(new BorderLayout());

		JPanel panelBotones = new JPanel();
		JLabel etiqPos = new JLabel("Pos: ");
		fieldPos = new JTextField(5);
		JLabel etiqValor = new JLabel("Val: ");
		fieldValor = new JTextField(5);

		table.setFont(new Font("Courier", Font.PLAIN, 16));
		botonWrite = new JButton("write");
		botonWrite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guiCtrl.memorySet(fieldPos.getText(), fieldValor.getText());
			}
		});

		panelBotones.add(etiqPos);
		panelBotones.add(fieldPos);
		panelBotones.add(etiqValor);
		panelBotones.add(fieldValor);
		panelBotones.add(botonWrite);

		this.setLayout(new BorderLayout());
		this.setBorder(new TitledBorder("Memoria"));
		miPanel.add(panelBotones, BorderLayout.PAGE_END);
		JScrollPane scroll = new JScrollPane(table);
		miPanel.add(scroll, BorderLayout.CENTER);
		this.add(miPanel);

	}


	/*********************** TABLEMODEL **************************/
	private class TableModel extends AbstractTableModel {

		TreeMap<Integer, Integer> content;
		private String[] columnNames = { "Posici—n", "Valor" };
		//private int[][] memTable = new int[10][2];

		public TableModel() {
			content = new TreeMap<Integer, Integer>();
		}

		
		public void setValue(int index, int valor) {
			
			content.put(index, valor);	
			fireTableStructureChanged();
		}

		
		public void reset() {
			content.clear();
			model.fireTableStructureChanged();

			
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			Object []aux = content.keySet().toArray();
			
			if(columnIndex==0)
				return aux[rowIndex];
			else return content.get(aux[rowIndex]);
			
		}
		
		@Override
		public int getColumnCount() {
			return columnNames.length;
		}

		@Override
		public int getRowCount() {
			return content.size();
		}

		public String getColumnName(int col) {
			return columnNames[col];
		}
	}

	@Override
	public void onStartInstrExecution(Instruction instr) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onEndInstrExecution(int pc, Memory<Integer> memoria, OperandStack<Integer>pila) {

	}

	@Override
	public void onStartRun() {
		
		SwingUtilities.invokeLater( new Runnable() {

			@Override
			public void run() {
				botonWrite.setEnabled(false);
				fieldPos.setEnabled(false);
				fieldValor.setEnabled(false);
			}
			});
	}

	@Override
	public void onEndRun(boolean isHaltPause) {
		
		SwingUtilities.invokeLater( new Runnable() {

			@Override
			public void run() {
				botonWrite.setEnabled(true);
				fieldPos.setEnabled(true);
				fieldValor.setEnabled(true);
			}
			});
		

	}

	@Override
	public void onError(String msg) {
		
		
		SwingUtilities.invokeLater( new Runnable() {

			@Override
			public void run() {
				botonWrite.setEnabled(true);
				fieldPos.setEnabled(true);
				fieldValor.setEnabled(true);
			}
			});
	}

	@Override
	public void onHalt() {
		
		SwingUtilities.invokeLater( new Runnable() {

			@Override
			public void run() {
				botonWrite.setEnabled(false);
			}
			});

	}

	@Override
	public void onWrite(final int index, final Integer value) {
		 //model.refresh();
		
		SwingUtilities.invokeLater( new Runnable() {

			@Override
			public void run() {
				model.setValue(index, value);
			}
			});
	}

	@Override
	public void onReset(ProgramaMv program) {
		
		SwingUtilities.invokeLater( new Runnable() {

			@Override
			public void run() {
				botonWrite.setEnabled(true);
			}
			});
	}

	@Override
	public void onMemReset() {
		SwingUtilities.invokeLater( new Runnable() {

			@Override
			public void run() {
				model.reset();
			}
			});
		

	}
}
