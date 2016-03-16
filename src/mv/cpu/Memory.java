package mv.cpu;

import java.util.ArrayList;
import java.util.Vector;

import mv.excepciones.ErrorMemoria;
import mv.excepciones.Excepciones;

/**
 * @param <T>
 * @Autor Christian Alvarez y Luis Arroyo
 * 
 *        Memoria de nuestra maquina virtual, desde esta clase se gestiona y
 *        administran, las direcciones y datos de nuestra memoria
 */

public class Memory<T> implements Observable<MemoryObserver<T>>{

	private Vector<T> memoria;
	private ArrayList<MemoryObserver<T>> observersMemory;
	
	public Memory(){
		 memoria = new Vector<T>(100);
		 observersMemory = new ArrayList<MemoryObserver<T>>();
	}
	
	/****************************/
	public static class MemCell<T> {
		int pos;
		T value;

		public MemCell(int pos, T value) {
			this.pos = pos;
			this.value = value;
		}

		public int getPos() {
			return pos;
		}

		public T getValue() {
			return value;
		}
	}

	public ArrayList<MemCell<T>> getArray() {
		ArrayList<MemCell<T>> lista = new ArrayList<MemCell<T>>();

		for (int i = 0; i < memoria.size(); i++) {
			if (memoria.elementAt(i) != null) {
				lista.add(new MemCell<T>(i, memoria.elementAt(i)));
			}
		}

		return lista;
	}

	/**************************/
	public T loadMemory(int posicion) {
		T valor = null;
		if (posicion < memoria.size()) {
			if (memoria.elementAt(posicion) != null) {
				valor = memoria.elementAt(posicion);
			}
		}
		return valor;
	}

	public void store(int pos, T valor) throws Excepciones{
		if (pos > memoria.size() - 1) 
			memoria.setSize(pos+1);
		
		if(pos<0)
			throw new ErrorMemoria("Error ejecutando la instruccion. Faltan operandos en la pila");
		else{
			memoria.setElementAt(valor, pos);
			
		for(MemoryObserver<T>o: observersMemory)
			o.onWrite(pos, valor);
		
		}
	}

	public String toString() {
		String cadenaMemoria = "Memoria:";
		boolean memoriaVacia = true;
		for (int i = 0; i < memoria.size(); i++) {
			if (getMemoria().get(i) != null) {
				cadenaMemoria = cadenaMemoria + " " + "[" + i + "]" + " "
						+ memoria.get(i) + " ";
				memoriaVacia = false;
			}
		}
		if (memoriaVacia) {
			cadenaMemoria = "Memoria: <vacia>";
		}
		return cadenaMemoria;
	}

	private Vector<T> getMemoria() {
		return memoria;
	}

	@Override
	public void addObserver(MemoryObserver<T>o) {
		observersMemory.add(o);
		
	}

	@Override
	public void removeObserver(MemoryObserver<T>o) {
		observersMemory.remove(o);
		
	}

}
