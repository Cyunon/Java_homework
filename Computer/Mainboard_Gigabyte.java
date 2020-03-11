package Computer;

public class Mainboard_Gigabyte extends Mainboard {

	public Mainboard_Gigabyte() {
		// TODO Auto-generated constructor stub
	}
	
	public Mainboard_Gigabyte(String name, int speed, double price) {
		this.Name = name;
		this.speed = speed;
		this.price = price;
	}
	
	private String Name;
	private int speed;
	private double price;
	private String work = "Mainboard work";
	
	public String getWork() {
		return work;
	}
	public String getName() {
		return Name;
	}
	public int getSpeed() {
		return speed;
	}
	public double getPrice() {
		return price;
	}


}
