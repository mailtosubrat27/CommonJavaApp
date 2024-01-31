import java.util.HashMap;
import java.util.Map;

public class ParseString {

	public static void main(String[] args) {
		System.out.println("------------");
		
		String str = "india";
		char ch [] = str.toCharArray();
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < ch.length; i++) {
			char c = ch[i];
			if(!map.isEmpty() ) {
				 Integer n = map.get(c+"");
				 if(n != null)
					 map.put(c+"", ++n);
				 else {
					 map.put(c+"", 1);
				}
				 
			}else 
			map.put(c+"", 1);
			
		}
//		System.out.println(map);
		for (String s : map.keySet()) {
			if(map.get(s) < 2)
			{
				System.out.println(s);
				
			}
		}	
	}

}
