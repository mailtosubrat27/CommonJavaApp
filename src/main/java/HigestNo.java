import java.util.Arrays;
import java.util.List;

public class HigestNo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> listNo = Arrays.asList(12,43,31,322,18,35);
		List sort = listNo.stream().sorted().toList();
		System.out.println(sort);
	}

}
