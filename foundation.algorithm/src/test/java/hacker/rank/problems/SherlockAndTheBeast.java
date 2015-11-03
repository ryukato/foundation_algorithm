package hacker.rank.problems;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SherlockAndTheBeast {

	@Test
	public void test_(){
		int n = 1;
		String result = getLargestNumber(n);
		System.out.println(result);
		n = 3;
		result = getLargestNumber(n);
		System.out.println(result);
		n = 5;
		result = getLargestNumber(n);
		System.out.println(result);
		n = 11;
		result = getLargestNumber(n);
		System.out.println(result);

	}

	private static String getLargestNumber(int n) {
		int pivot = getPivotPoint(n);
		if(pivot < 0){
			return "-1";
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < pivot; i++){
			sb.append("5");
		}
		for(int i = 0; i < n - pivot; i++){
			sb.append("3");
		}
		
		return sb.toString();
	}

	private static int getPivotPoint(int n) {
		int tmp = n;
		while(tmp > 0){
			if(tmp % 3 == 0){
				return tmp;
			}else{
				tmp -= 5;
			}
		}
		return tmp;
	}
	
	
}
