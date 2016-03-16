package mv.controler;

import mv.Strategy.InStrategy;
import mv.Strategy.OutStrategy;
import mv.cpu.Cpu;
import mv.cpu.Memory;
import mv.cpu.ProgramaMv;
import mv.excepciones.Excepciones;

public abstract class Controler implements Runnable{
	protected Cpu cpu;
	public Controler(Cpu cpu) {
		this.cpu = cpu;
	}

	public abstract void start();

	public void memorySet(String posicion, String value) {
		try {
			int pos = Integer.parseInt(posicion);
			int valor = Integer.parseInt(value);
			cpu.store(pos, valor);

		} catch (NumberFormatException e) {

		} catch (Excepciones e) {

		}
	}

	
	public void push(String valor) {
		try {
			int valorEntero = Integer.parseInt(valor);
			cpu.getOperandStack().apilar(valorEntero);
		} catch (NumberFormatException e) {
			
		}
	}

	public void pop() {
		try {
			cpu.desapilar();
		} catch (Excepciones e) {
			
		}
	}

	public void step() {
		try {

			cpu.step();

		} catch (Excepciones e) {
			
		}
	}

	public void pause() {
		cpu.pause();
	}

	public void run() {
		
		try {
			
			cpu.run();
			

		} catch (Excepciones e) {

			
		}
	
	}

	public void quit() {
		cpu.modificatHalt(true);
		cpu.in.close();
		cpu.out.close();
		System.exit(0);

	}

	public Memory<Integer> getMemoria() {
		return cpu.getMemoria();
	}

	public ProgramaMv getProgram() {
		return cpu.getPrograma();
	}

	public InStrategy getInStream() {
		return cpu.getIn();
	}

	public void setInStream(InStrategy in) {
		try {
			cpu.setIn(in);
		} catch (Excepciones e) {
			e.printStackTrace();
		}
	}

	public OutStrategy getOutStream() {
		return cpu.getOut();
	}

	public void setOutStream(OutStrategy out) {
		try {
			cpu.setOut(out);
		} catch (Excepciones e) {
			e.printStackTrace();
		}
	}


	public void reset() {
		cpu.reset();
	}
	

}
