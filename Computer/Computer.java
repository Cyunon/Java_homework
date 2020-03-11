package Computer;

public class Computer {

	public Computer() {
		// TODO Auto-generated constructor stub
		cpu = null;
		memory = null;
		mainboard = null;
		disk = null;
		price = 0.0;
		work = null;
	}
	
	public Computer(String name, CPU cpu, Memory memory, Mainboard mainboard, Disk disk) {
		price = cpu.getPrice() + memory.getPrice() + mainboard.getPrice() + disk.getPrice();
		work = cpu.getWork() +" "+ memory.getWork() +" "+ mainboard.getWork() +" "+ disk.getWork();
		this.Name = name;
		this.cpu = cpu;
		this.disk = disk;
		this.mainboard = mainboard;
		this.memory = memory;
	}
	
	private String Name;
	private double price;
	private CPU cpu;
	private Memory memory;
	private Mainboard mainboard;
	private Disk disk;
	private String work;
	public String getName() {
		return Name;
	}

	public double getPrice() {
		return price;
	}

	public String getWork() {
		return work;
	}

	public CPU getCpu() {
		return cpu;
	}

	public Memory getMemory() {
		return memory;
	}

	public Mainboard getMainboard() {
		return mainboard;
	}

	public Disk getDisk() {
		return disk;
	}
	
	

}
