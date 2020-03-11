package Computer;

public class Memory_Kingston extends Memory {

	public Memory_Kingston() {
		// TODO Auto-generated constructor stub
	}
	
	public Memory_Kingston(String name, int volume, double price) {
		this.Name = name;
		this.volume = volume;
		this.price = price;
	}
	
	private String Name;
	private int volume;
	private double price;
	private String work = "Memory work";
	
	public String getWork() {
		return work;
	}
	public String getName() {
		return Name;
	}
	public int getVolume() {
		return volume;
	}
	public double getPrice() {
		return price;
	}

}
