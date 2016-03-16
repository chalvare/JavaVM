package mv.cpu;

public interface StackObserver<T> {
	public void onPush(T value);
	public void onPop();
	public void onStackReset(); 

}
