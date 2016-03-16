package mv.Strategy;

public class NullInStrategy implements InStrategy {
	/**
	 * 
	 * @author Christian �lvarez y Luis Arroyo
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
