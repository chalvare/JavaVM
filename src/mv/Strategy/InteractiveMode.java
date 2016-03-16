package mv.Strategy;

import java.io.IOException;

import mv.controler.InteractiveControler;
import mv.cpu.Cpu;
import mv.cpu.ProgramaMv;
import mv.excepciones.Excepciones;
import mv.gui.swing.InteractiveView;
import mv.main.MyOptions;

/**
 * 
 * @author Christian çlvarez y Luis Arroyo Modos de ejecuci—n de la aplicaci—n
 *         Batch: El programa se ejecuta entero sin la interacci—n del usuario
 *         Interactive: El programa se ejecuta paso a paso con la interacci—n
 *         del usuario ParseFichero: Lee un fichero asm, lo parsea y lo
 *         introduce como programa. InteractiveProgram: Lee desde teclado un
 *         programa introducido por el usuario
 */
public class InteractiveMode {
	public static void interactive(Cpu cpu) throws Excepciones {
		try {

			if (MyOptions.getI() != null)
				cpu.setIn(new FileInStrategy(MyOptions.getI()));
			else
				cpu.setIn(new NullInStrategy());

			if (MyOptions.getO() != null)
				cpu.setOut(new FileOutStrategy(MyOptions.getO()));
			else
				cpu.setOut(new ConsoleOutStrategy());

			cpu.in.open();
			cpu.out.open();
			
				try {
					ProgramaMv programa;
					if (MyOptions.getA() != null) {
						programa = ProgramaMv.read_program(MyOptions.getA());
						System.out.println(programa);
						cpu.loadProgram(programa);
					} else {
						programa = ProgramaMv.read_program();
						cpu.loadProgram(programa);

						if (programa.contadorInstr() > 0) {
							System.out.print("El programa introducido es: ");
							System.out.println(programa);
						} else {
							System.out.println("No se ha introducido ninguna instruccion");
						}
					}

					
				} catch (Excepciones e) {

					System.err.println(e.getMessage());
				}
					
			

		} catch (IOException e) {
			System.err
					.println("Archivo no encontrado. Comprueba que el fichero existe");
		} catch (NullPointerException e) {
			System.err
					.println("Archivo no encontrado. Comprueba que el fichero existe");
		}
		
		InteractiveControler ctrl = new InteractiveControler(cpu);
		@SuppressWarnings("unused")
		InteractiveView view = new InteractiveView(cpu);
		ctrl.start();
		ctrl.quit();
	}
		
}
