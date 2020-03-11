package Computer;

public class Disk_WestDigitals extends Disk {

	public Disk_WestDigitals() {
		// TODO Auto-generated constructor stub
	}
	
	public Disk_WestDigitals(String name, int volume, double price) {
		this.Name = name;
		this.volume = volume;
		this.price = price;
	}
	
	private String Name;
	private int volume;
	private double price;
	private String work = "Disk work";
	
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
