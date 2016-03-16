package mv.controler;

import mv.command.CommandInterpreter;
import mv.command.CommandParser;
import mv.cpu.Cpu;
import mv.cpu.Lectura;
import mv.excepciones.Excepciones;

public class InteractiveControler extends Controler{

	public InteractiveControler(Cpu cpu) {
		super(cpu);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void start() {
		
			do {
				try {
					
					System.out.println("dame un comando");
					System.out.print("> ");
					String instruccionPorTeclado = Lectura.LeerCadena();

					if (CommandParser.parseComando(instruccionPorTeclado) != null) {
						System.out.println();
						System.out.println("-----------------------------");
						System.out.println();
						System.out.println("Comienza el comando: "
								+ CommandParser.parseComando(
										instruccionPorTeclado).toString());

						CommandParser.parseComando(instruccionPorTeclado)
								.executeCommand(cpu);
					} else {
						System.out.println("Comando erroneo");
					}
				} catch (Excepciones e) {

					System.err.println(e.getMessage());
				}
					
				
			} while (!CommandInterpreter.isQuit()
					&& !cpu.isHalted()
					&& cpu.recuperarActualPc() < cpu
							.recuperarProgramInstrucciones()
					&& cpu.recuperarNextPc() < cpu
							.recuperarProgramInstrucciones());
		
	}
	

}
