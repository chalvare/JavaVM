package mv.Strategy;

import java.io.FileNotFoundException;

import mv.controler.BatchControler;
import mv.cpu.Cpu;
import mv.cpu.ProgramaMv;
import mv.excepciones.Excepciones;
import mv.gui.swing.BatchView;
import mv.main.MyOptions;

public class BatchMode {
	public static void batch(Cpu cpu) throws Excepciones, FileNotFoundException {
		try {
			ProgramaMv programa = ProgramaMv.read_program(MyOptions.getA());
			cpu.loadProgram(programa);

			if (MyOptions.getI() != null)
				cpu.setIn(new FileInStrategy(MyOptions.getI()));
			else
				cpu.setIn(new ConsoleInStrategy());

			if (MyOptions.getO() != null)
				cpu.setOut(new FileOutStrategy(MyOptions.getO()));
			else
				cpu.setOut(new ConsoleOutStrategy());

			cpu.in.open();
			cpu.out.open();

			BatchControler ctrl = new BatchControler(cpu);
			@SuppressWarnings("unused")
			BatchView view = new BatchView(cpu);
			ctrl.start();
			ctrl.quit();
		} catch (Excepciones e) {
			System.err.println(e.getMessage());
		}
	}

}
