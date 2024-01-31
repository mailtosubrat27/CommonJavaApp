import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharOccurance {

	public static void main(String[] args) {
		String str = "abbcxyzaaa";
		char[] charArray = str.toCharArray();
		List<String> chatStr = new ArrayList<String>();
		for (char c : charArray) {
			chatStr.add(c+"");
		
		}
		Map<String, Long> map = chatStr.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(map);
		String cahr = "";
		Long occ = 0L;
		for (String key : map.keySet()) {
			if(occ < map.get(key)) {
				cahr = key;
				occ = map.get(key);
			}
		}
		
		System.out.println(cahr);
		
		
		
		
		
		
		////////
		
//		Input : {1,2,3,4,5,6,7,8}
//		Output : {1,8,2,7,3,6,4,5}
		
		List<Integer> noList = Arrays.asList(1,2,3,4,5,6,7,8);
		int v = noList.size() ;
		int n1 = 0;
		int inc = 0;
		noList.add(2, 66);
		System.out.println(noList);
	/*	
		for (int i=0; i < v; i += 2) {
			inc++;
			int a = noList.get(i);
			int b = noList.get(--v);
			int x = 0;
			if(n1 ==0 ) {
//				noList.add(inc,b)
			} else {
				x = n1;
			}
			n1 = noList.get(inc);
			
			noList.add(i, a);
			noList.add(inc,b);
			
			if(inc <noList.size())
				break;
		}*/
		
		
		
		
		

	}

}