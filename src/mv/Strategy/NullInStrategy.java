package mv.Strategy;

public class NullInStrategy implements InStrategy {
	/**
	 * 
	 * @author Christian çlvarez y Luis Arroyo
	 * 
	 */
	
	public void open(){}
	public void close(){}
	public int read(){
		 return -1;
	}
	
	public StringBuilder construirBuilder() {
		StringBuilder texto = new StringBuilder();
		texto.append("");
		return texto;
	}

}
