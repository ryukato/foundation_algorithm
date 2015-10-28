package hacker.rank.problems;

import org.junit.Test;

public class Staircase {
	@Test
	public void test_(){
		int t = 6;
		StringBuilder spaces = new StringBuilder();
		StringBuilder sharps = new StringBuilder();
		for (int i = 1; i <= t; i++) {
			spaces.append(" ");
			sharps.append("#");
		}
		
		printStairCase(t, spaces, sharps);
	}

	private static void printStairCase(int t, StringBuilder spaces,
			StringBuilder sharps) {
		for(int i = 1; i <= t; i++){
			String tmp = spaces.toString();
			System.out.println(tmp.substring(0, t -i) + sharps.toString().substring(t -i));
		}
	}
}
