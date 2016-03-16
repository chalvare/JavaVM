package mv.instruction.otrasBinary;

import mv.instruction.Instruction;

public abstract class OtrasBinary implements Instruction {


	public abstract String toStringAux();

	protected abstract Instruction tipoDeClase(int valor);

	protected int operando;

	OtrasBinary(int operando) {

		this.operando = operando;
	}
	/**
	 * Parsea la cadena pasada como instrucci—n y mira si la instruccion tiene dos elementos. 
	 * Despues buscara en todos los toString de sus clases hijas para ver si coincide con el nombre de la instruccion 
	 * que hemos introducido. Comprobara tambiŽn si el segundo elemento del vector es un entero.
	 * @return Devuelve un objeto de la instruccion introducida y le pasamos el operando a ejecutar por esa instruccion
	 */
	public Instruction parseOp(String cadena) {
		String instruccion[] = cadena.split(" ");

		if (instruccion.length == 2 && esNumerico(instruccion[1])) {
			if (instruccion[0].equalsIgnoreCase(this.toStringAux())) {
				this.operando = Integer.parseInt(instruccion[1]);
				return tipoDeClase(this.operando);
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	public String toString() {
		return toStringAux() + " " + this.operando;
	}

	protected static boolean esNumerico(String cad) {
		boolean esNumerico = true;
		int i = 0;
		if (cad.charAt(0) == '-' && cad.length() > 1) {
			i++;
		}
		for (; i < cad.length(); i++) {
			if (!Character.isDigit(cad.charAt(i))) {
				esNumerico = false;
			}
		}
		return esNumerico;
	}
}
