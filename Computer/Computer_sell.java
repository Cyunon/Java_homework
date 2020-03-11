package Computer;

public class Computer_sell {

	public Computer_sell() {
		// TODO Auto-generated constructor stub
	}
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CPU_Intel intel = new CPU_Intel("i7-8750H", 6, 2500.0);
	    CPU_AMD amd = new CPU_AMD("Ryzen-7-3800X", 8, 2799.0);
	    Memory_Kingston kingston = new Memory_Kingston("kingston", 8, 200.0);
	    Memory_Samsung samsung = new Memory_Samsung("samsung", 16, 400.0);
	    Disk_Seagate seagate = new Disk_Seagate("seagate", 250, 200.0);
	    Disk_WestDigitals westdigitals = new Disk_WestDigitals("westdigitals", 500, 350.0);
	    Mainboard_Asus asus = new Mainboard_Asus("asus", 2400, 800.0);
	    Mainboard_Gigabyte gigabyte = new Mainboard_Gigabyte("gigabyte", 3600, 1100.0);
	    
	    Computer pc1 = new Computer("pc1", intel, kingston, asus, westdigitals);
	    Computer pc2 = new Computer("pc2", intel, samsung, asus, seagate);
	    Computer pc3 = new Computer("pc3", amd, samsung, gigabyte, seagate);
	    Computer [] pc = {pc1, pc2, pc3};
	    
	    System.out.printf("%-5s","Name");
	    System.out.printf("%-7s","Price");
	    System.out.printf("%-14s","CPU");
	    System.out.printf("%-9s","Memory");
	    System.out.printf("%-10s","Mainboard");
	    System.out.printf("%-13s","Disk");
	    System.out.println("Work");
	    
		for(int i=0; i<pc.length; i++) {
			System.out.printf("%-5s",pc[i].getName());
			System.out.printf("%-7s",pc[i].getPrice());
			System.out.printf("%-14s",pc[i].getCpu().getName());
			System.out.printf("%-9s",pc[i].getMemory().getName());
			System.out.printf("%-10s",pc[i].getMainboard().getName());
			System.out.printf("%-13s",pc[i].getDisk().getName());
			System.out.println(pc[i].getWork());
		}
		

	}

}
