package mv.Strategy;

import javax.swing.JTextArea;

public class InStreamGUI implements InStrategy {

	private JTextArea inputTextArea;
	private InStrategy old;
	StringBuilder content;
	int pos;

	public InStreamGUI(InStrategy old, JTextArea inputTextArea) {
		this.old = old;
		this.inputTextArea = inputTextArea;
		pos = 0;
		content = old.construirBuilder();
		inputTextArea.setText(content.toString());
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
	public int read() {

		int c = -1;
		if (pos == content.length()) {
			return c;
		} else if (content.charAt(pos) != 10 && content.charAt(pos) != 13) {
			c = content.charAt(pos);
			content.setCharAt(pos, '*');
			inputTextArea.setText(content.toString());
			pos++;
		}else{
			c = 10;
			pos++;
		}
		return c;
	}

	public StringBuilder construirBuilder() {
		return null;

	}

}
