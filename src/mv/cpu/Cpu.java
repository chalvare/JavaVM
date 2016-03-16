package mv.cpu;

import java.util.ArrayList;

import mv.Strategy.InStrategy;
import mv.Strategy.OutStrategy;
import mv.cpu.Memory.MemCell;
import mv.excepciones.Excepciones;
import mv.excepciones.ErrorMV;
import mv.instruction.Instruction;


/**
 * @Autor Christian Alvarez y Luis Arroyo
 * 
 *        Clase encargada de ejecutar las instrucciones
 */

// implementa la interfazObservable que la cargamos con observadores de la CPU
public class Cpu implements Observable<CPUObserver> {

	private static Memory<Integer> memoria = new Memory<Integer>();
	private static OperandStack<Integer> pila = new OperandStack<Integer>();
	private ProgramaMv programa;
	private int actualPc;
	private int nextPc;
	private boolean halt;
	
	private boolean haltPause =false;
	
	public InStrategy in;
	public OutStrategy out;
	
	private int delay=0;

	
	public static String SALTO = System.getProperty("line.separator");

	// Array que contendra los observadores. Sus metodos est‡n abajo del todo.
	private ArrayList<CPUObserver> observers;

	public Cpu() {
		observers = new ArrayList<CPUObserver>();

		this.actualPc = 0;
		this.nextPc = 0;
	}

	public void run() throws Excepciones {
		haltPause=false;
		for (CPUObserver o : observers)
			o.onStartRun();
		
		while (recuperarNextPc() < recuperarProgramInstrucciones()
				&& !isHalted() && !haltPause) {
			
				step();
				
					try {
						Thread.sleep(getDelay());
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						//e.getMessage();
					}
					
		}
		
		if (recuperarNextPc() < recuperarProgramInstrucciones() && !isHalted())
			for (CPUObserver o : observers){
				o.onEndRun(isHaltPause());
			}
		
		
	}

	

	/**
	 * Desde este metodo ejecutaremos las instrucciones Mientras nextPc sea
	 * mayor que 0 y menos que la posicion de la ultima instruccion si no cambia
	 * el halt a true y sale de la ejecuci—n del programa se carga la
	 * instruccion siguiente y la ejecuta. Si resulta correcta y si es diferente
	 * a las de salto incrementa los contadores en 1 si son las instrucciones de
	 * salto ser‡n estas las que se ocuparan de la gesti—n de los actualPc y
	 * nextPc.
	 * 
	 * @return false: Nos devolvera false en el caso que hubiese un fallo ya sea
	 *         a la hora de ejecutar una instruccion o en el contador del
	 *         programa
	 * @return true: Devolvera true en el caso que la instruccion se haya
	 *         ejecutado favorablemente
	 * @throws Excepciones
	 */

	public void step() throws Excepciones {

		// - avisar que la ejecuci—n de la instrucci—n ha empezado
		if (nextPc >= 0 && nextPc < programa.contadorInstr()) {
			Instruction instr = programa.instruccion(nextPc);

			for (CPUObserver o : observers)
				o.onStartInstrExecution(instr);

			try {

				instr.execute(this); // suponiendo que instr es la instrucci—n a
										// ejecutar
				String cadena[] = instr.toString().split(" ");

				if (!cadena[0].equalsIgnoreCase("JUMP")
						&& !cadena[0].equalsIgnoreCase("BT")
						&& !cadena[0].equalsIgnoreCase("BF")
						&& !cadena[0].equalsIgnoreCase("RJUMP")
						&& !cadena[0].equalsIgnoreCase("RBT")
						&& !cadena[0].equalsIgnoreCase("RBF")) {

					this.nextPc++;
					this.actualizarActualPc(this.nextPc);
				}
			} catch (Excepciones e) {
				// -- avisar a los oyentes que ha ocurrido un error
					for (CPUObserver o : observers)
						o.onError(">>> " + e.toString());
					
				throw e; // lanzar la excepci—n otra vez
			}

			for (CPUObserver o : observers)
				o.onEndInstrExecution(actualPc, getMemoria(), getOperandStack());

		}

		// - avisar que la ejecuci—n ha acabado
		// - avisar si la ejecuci—n del programa ha terminado
		if (nextPc >= programa.contadorInstr())
			for (CPUObserver o : observers)
				o.onHalt();
	}

	/**
	 * Auxiliares que manejan los atributos de CPU
	 */
	public InStrategy getIn() {
		return in;
	}

	public void setIn(InStrategy in) throws Excepciones {
		if (in == null)
			throw new ErrorMV("No se puede poner la entrada a in");
		else
			this.in = in;
	}

	public OutStrategy getOut() {
		return out;
	}

	public void setOut(OutStrategy out) throws Excepciones {
		if (out == null)
			throw new ErrorMV("No se puede poner la salida a out");
		else
			this.out = out;
		
	}

	public boolean isHalted() {
		return halt;
	}

	public boolean isHaltPause() {
		return haltPause;
	}

	public void setHaltPause(boolean haltPause) {
		this.haltPause = haltPause;
	}

	public void modificatHalt(boolean halt) {
		this.halt = halt;
	}

	public int recuperarActualPc() {
		return actualPc;
	}

	public void actualizarActualPc(int actualPc) {
		this.actualPc = actualPc;
	}

	public int recuperarNextPc() {
		return nextPc;
	}

	public void actualizarNextPc(int nextPc) {
		this.nextPc = nextPc;
	}

	public ProgramaMv getPrograma() {
		return programa;
	}

	public OperandStack<Integer> getOperandStack() {
		return pila;
	}

	public void loadProgram(ProgramaMv programa) {
		this.programa = programa;
	}

	public int recuperarProgramInstrucciones() {
		return this.programa.contadorInstr();
	}

	public Instruction recuperarInstruccion(int valor) {
		return this.programa.instruccion(valor);
	}

	/**
	 * Auxiliares que manejan la pila y la memoria desde cpu.
	 */

	public int desapilar() throws Excepciones {
		//try {
			return pila.desapilar();
//		} catch (Excepciones e) {
//			if(MyOptions.getM()==2){
//				for (CPUObserver o : observers)
//					o.onError(e.getMessage());
//				}
//			throw e;
//		}

	}

	public void apilar(int valor) {
		pila.apilar(valor);
	}

	public int mostrarCima() {
		return pila.getCima();
	}

	public boolean pilaVacia() {
		return pila.vacia();
	}

	public Integer load(int pos) {
		return memoria.loadMemory(pos);
	}

	public void store(int pos, int valor) throws Excepciones {
		try {
			memoria.store(pos, valor);
		} catch (Excepciones e) {
			for (CPUObserver o : observers)
				o.onError(e.getMessage());
			throw e;
		}

	}

	public static ArrayList<MemCell<Integer>> getArray() {
		return memoria.getArray();
	}

	public Memory<Integer> getMemoria() {
		return memoria;
	}

	public static void setMemoria(Memory<Integer> memoria) {
		Cpu.memoria = memoria;
	}

	public String toString() {
		return pila.toString() + SALTO + memoria.toString();
	}

	@Override
	public void addObserver(CPUObserver o) {
		observers.add(o);
	}

	@Override
	public void removeObserver(CPUObserver o) {
		observers.remove(o);

	}

	public void pause(){
		haltPause = true;
	}
	public void reset() {
		modificatHalt(false);
		actualizarActualPc(0);
		actualizarNextPc(0);
		//modificatHalt(true);
		
		for (CPUObserver o : observers)
			o.onReset(programa);
	}
	public int getDelay() {
		return delay;
	}

	public void setDelay(int delay) {
		this.delay = delay;
	}
}
