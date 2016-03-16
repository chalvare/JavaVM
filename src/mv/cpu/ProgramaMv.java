package mv.cpu;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import mv.excepciones.ErrorInstrFichero;
import mv.excepciones.Excepciones;
import mv.instruction.Instruction;

/**
 * @Autor Christian Alvarez y Luis Arroyo
 * 
 *        En esta clase almacenamos todas nuestras instrucciones validas
 */

public class ProgramaMv {

	// ATRIBUTOS
	private Instruction todasInstrucciones[];
	private int contadorDeInstrucciones;

	// CONSTRUCTOR
	public ProgramaMv() {
		this.todasInstrucciones = new Instruction[100];
		this.contadorDeInstrucciones = 0;
	}

	// METODOS
	public void addInstruction(Instruction instruccion) {
		this.todasInstrucciones[this.contadorDeInstrucciones] = instruccion;
		this.contadorDeInstrucciones++;
	}

	public static ProgramaMv read_program() {
		String instruccionPorTeclado = "";
		ProgramaMv programa = new ProgramaMv();

		System.out.println("Introduce un programa fuente: ");
		do {
			System.out.print("> ");
			instruccionPorTeclado = Lectura.LeerCadena();
			if (ParseOperator.parse(instruccionPorTeclado) != null) {
				programa.addInstruction(ParseOperator
						.parse(instruccionPorTeclado));
			} else if (!instruccionPorTeclado.equalsIgnoreCase("end")) {
				System.out.println("Instruccion erronea");
			}
		} while (!instruccionPorTeclado.equalsIgnoreCase("end"));

		return programa;
	}

	public static ProgramaMv read_program(String fname) throws FileNotFoundException, Excepciones {

		FileReader fichero = null;
		ArrayList<String> cad = new ArrayList<String>();
		String cadenas[];
		ProgramaMv programa = new ProgramaMv();

			fichero = new FileReader(fname);
			Scanner s = new Scanner(fichero);
			String cadena;
			while (s.hasNext()) {
				cadena = s.nextLine();
				cadenas = cadena.split(";");
				if (cadenas.length > 0 && !cadenas[0].equalsIgnoreCase("")) {
					cadenas[0].trim();
					cad.add(cadenas[0]);
				}
			}
		
			try {
				fichero.close();
			} catch (IOException e) {
				e.getMessage();
			}
			
		cadenas = new String[cad.size()];
		cadenas = cad.toArray(cadenas);
		
		for (int i = 0; i < cadenas.length; i++) {
			if (ParseOperator.parse(cadenas[i]) != null) {
				programa.addInstruction(ParseOperator.parse(cadenas[i]));
			}else{
				throw new ErrorInstrFichero("Instruccion leida desde fichero no v‡lida: "+ cadenas[i]);
			}
		}
		return programa;	
	}

	// METODOS AUXILIARES
	public Instruction instruccion(int currentPc) {
		return this.todasInstrucciones[currentPc];
	}

	public int contadorInstr() {
		return this.contadorDeInstrucciones;
	}

	// SE PODRIA USAR COMO TOSTRING
	public String toString() {
		String programa = "";
		for (int i = 0; i < todasInstrucciones.length
				&& todasInstrucciones[i] != null; i++) {
			programa = programa + "\n" + i + ": " + todasInstrucciones[i];
		}
		return programa;
	}

}