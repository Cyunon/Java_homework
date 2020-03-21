package Count;

import java.util.HashMap;
import java.util.Map;

public class Count {
	public static void main(String[] args) {
		Map<String,Integer> count = new HashMap<>();
		for(int i=0;i<args.length;i++) {
			if(count.containsKey(args[i])) {
				int temp = count.get(args[i])+1;
				count.put(args[i], temp);
			}
			else {
				count.put(args[i], 1);
			}
		}
		for(Map.Entry<String, Integer> entry:count.entrySet()){  
		    System.out.println(entry.getKey() + "=" + entry.getValue());  
		}  	
	}	
}
