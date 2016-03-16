package mv.Strategy;

import java.io.FileNotFoundException;

import mv.controler.ControladorGUI;
import mv.cpu.Cpu;
import mv.cpu.ProgramaMv;
import mv.excepciones.Excepciones;
import mv.gui.swing.MainWindow;
import mv.main.MyOptions;

public class WindowMode {

	public static void windowMode(Cpu cpu) throws Excepciones {

		if (MyOptions.getI() != null)
			cpu.setIn(new FileInStrategy(MyOptions.getI()));
		else
			cpu.setIn(new NullInStrategy());
	
		if (MyOptions.getO() != null)
			cpu.setOut(new FileOutStrategy(MyOptions.getO()));
		else
			cpu.setOut(new NullOutStrategy());

		try {
			cpu.in.open();
			cpu.out.open();
			ProgramaMv program = ProgramaMv.read_program(MyOptions.getA());
			cpu.loadProgram(program);
			
			ControladorGUI ctrl = new ControladorGUI(cpu);
			@SuppressWarnings("unused")
			MainWindow view = new MainWindow(ctrl,cpu,cpu.getOperandStack(),cpu.getMemoria());
			cpu.setDelay(10);
			ctrl.start(); 
			
		}catch (FileNotFoundException e) {
			System.err.println("Archivo no encontrado. Comprueba que el fichero existe.");
		}catch(Excepciones e){
			System.err.println(e.getMessage());
		}

		
	}
}
