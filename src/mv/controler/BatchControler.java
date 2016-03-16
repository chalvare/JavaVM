package mv.controler;

import mv.cpu.Cpu;

public class BatchControler extends Controler{

	public BatchControler(Cpu cpu) {
		super(cpu);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void start(){
		run();
	}
}
