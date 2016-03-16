package mv.cpu;

import java.util.ArrayList;
import java.util.Stack;


import mv.excepciones.ErrorInst;
import mv.excepciones.Excepciones;

/**
 * @Autor Christian Alvarez y Luis Arroyo
 * 
 *        Pila de operandos de nuestra maquina virtual, en esta clase se
 *        almacenan los valores de nuestra pila
 */

public class OperandStack<T> implements Observable<StackObserver<T>>{
	private Stack<T> pila = new Stack<T>();
	private ArrayList<StackObserver<T>> observersStack;
	
	OperandStack() {
		observersStack = new ArrayList<StackObserver<T>>();
		this.pila = new Stack<T>();
	}

	public void apilar(T valor) {
		this.pila.push(valor);
		
		for (StackObserver<T> o : observersStack) {
			 o.onPush(valor);
		}
	}

	public T desapilar() throws Excepciones {
		if (pila.isEmpty()){
			
			throw new ErrorInst("Error ejecutando la instruccion. Faltan operandos en la pila");
		}else{
			for (StackObserver<T> o : observersStack) 
				 o.onPop();

			return pila.pop();
		}
	}

	public boolean vacia() {
		return pila.empty();
	}

	public String toString() {
		String cadenaPila = "";
		if (vacia()) {
			cadenaPila = "Pila de operandos: <vacia>";
		} else {

			cadenaPila = "Pila de operandos";
			for (int i = 0; i < getCima(); i++) {
				cadenaPila = cadenaPila + " " + pila.get(i) + " ";
			}
		}

		return cadenaPila;
	}

	public T pilaElem(int i) {
		return pila.get(i);
	}

	public int getCima() {
		return pila.size();
	}

	@Override
	public void addObserver(StackObserver<T> o) {
		observersStack.add(o);
	}

	@Override
	public void removeObserver(StackObserver<T> o) {
		observersStack.remove(o);
	}

}
