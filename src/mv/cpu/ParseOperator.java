package mv.cpu;

import mv.instruction.Instruction;
import mv.instruction.aritmeticas.Add;
import mv.instruction.aritmeticas.Div;
import mv.instruction.aritmeticas.Mul;
import mv.instruction.aritmeticas.Sub;
import mv.instruction.booleanas.And;
import mv.instruction.booleanas.Not;
import mv.instruction.booleanas.Or;
import mv.instruction.comparacion.EQ;
import mv.instruction.comparacion.GT;
import mv.instruction.comparacion.LE;
import mv.instruction.comparacion.LT;
import mv.instruction.otrasBinary.Load;
import mv.instruction.otrasBinary.Push;
import mv.instruction.otrasBinary.Store;
import mv.instruction.otrasUnary.Dup;
import mv.instruction.otrasUnary.Flip;
import mv.instruction.otrasUnary.Halt;
import mv.instruction.otrasUnary.In;
import mv.instruction.otrasUnary.Jumpind;
import mv.instruction.otrasUnary.Loadind;
import mv.instruction.otrasUnary.Neg;
import mv.instruction.otrasUnary.Out;
import mv.instruction.otrasUnary.Pop;
import mv.instruction.otrasUnary.Storeind;
import mv.instruction.salto.Bf;
import mv.instruction.salto.Bt;
import mv.instruction.salto.Jump;
import mv.instruction.salto.Rbf;
import mv.instruction.salto.Rbt;
import mv.instruction.salto.Rjump;

/** 
 * @Autor Christian Alvarez y Luis Arroyo
 * 
 * Clase encargada de parsear las instrucciones
 */

public class ParseOperator {

	private static Instruction[] operaciones = { new Add(), new Sub(),
			new Mul(), new Div(), new Neg(), new Push(0), new Pop(),
			new Flip(), new Dup(), new Load(0), new Store(0), new Out(),
			new Halt(), new EQ(), new GT(), new LE(), new LT(), new And(),
			new Or(), new Not(), new Jump(0), new Bt(0), new Bf(0), 
			new Rjump(0), new Rbf(0), new Rbt(0), new In(), new Jumpind(),
			new Storeind(), new Loadind()};

	public static Instruction parse(String line) {
		for (Instruction op : operaciones) {
			Instruction operacion = op.parseOp(line);

			if (operacion != null) {
				return operacion;
			}
		}
		return null;
	}

}