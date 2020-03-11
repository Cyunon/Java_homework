package Computer;

public class CPU_Intel extends CPU {

	public CPU_Intel() {
		// TODO Auto-generated constructor stub
	}
	
	public CPU_Intel(String name, int coreNum, double price) {
		this.Name = name;
		this.coreNum = coreNum;
		this.price = price;	
	}
	
	private String Name;
	private int coreNum;
	private double price;
	private String work = "CPU work";
	
	public String getWork() {
		return work;
	}
	public String getName() {
		return Name;
	}
	public int getCoreNum() {
		return coreNum;
	}
	public double getPrice() {
		return price;
	}

}
