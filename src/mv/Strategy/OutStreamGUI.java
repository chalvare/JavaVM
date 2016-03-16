package mv.Strategy;

import javax.swing.JTextArea;

public class OutStreamGUI implements OutStrategy {

	private JTextArea outputTextArea;
	private OutStrategy old;
	private StringBuilder content;

	public OutStreamGUI(OutStrategy old, JTextArea outputTextArea) {
		this.old = old;
		this.outputTextArea = outputTextArea;
		content = new StringBuilder();
	}

	@Override
	public void open() {
		// TODO Auto-generated method stub
	}

	@Override
	public void close() {
		old.close();
	}

	@Override
	public void write(int x) {
		
		//if (x == 10)old.write(10);
	 old.write(x);
		
		content.append((char) x);
		outputTextArea.setText(content.toString());
	}

}
