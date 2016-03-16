package mv.main;
import java.io.FileNotFoundException;

import org.apache.commons.cli.ParseException;

import mv.Strategy.BatchMode;
import mv.Strategy.InteractiveMode;
import mv.Strategy.WindowMode;
import mv.cpu.Cpu;
import mv.excepciones.Excepciones;
/**
 * @Autor Christian Alvarez y Luis Arroyo
 * 
 *        Main, interfaz con el usuario(Lectura-Escritura) Dependiendo de los
 *        comandos introducidos elagira una estrategia diferente.
 */
public class Main {
	private static final int _BATCH_MODE = 0;
	private static final int _INTER_MODE = 1;
	private static final int _WINDOW_MODE = 2;
	private static int executionMode = _INTER_MODE;
	private static Cpu cpu;
	
	public static void main(String[] args) {

		cpu = new Cpu();
		
		try {
			new MyOptions(args);
			executionMode = MyOptions.getM();
			if (MyOptions.getH() != null) {
				switch(executionMode){
					case _BATCH_MODE: BatchMode.batch(cpu);break;
					case _INTER_MODE: InteractiveMode.interactive(cpu);break;
					case _WINDOW_MODE: WindowMode.windowMode(cpu);break;
				}
			}else MyOptions.usage();
			
		} catch (ParseException e) {
			System.err.println("Error: " + e.getMessage());
		} catch (Excepciones e) {
			System.err.println("Error: " + e.getMessage());
		} catch (FileNotFoundException e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
}