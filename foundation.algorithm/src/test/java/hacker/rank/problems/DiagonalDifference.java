package hacker.rank.problems;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class DiagonalDifference {
	
	@Test
	public void test_3_size_grid(){
		int[] source = new int[]{11, 2, 4, 4, 5, 6, 10, 8, -12};
		int t = 3;
		int sum = getDianonalDifference(t, source);
		
		assertEquals(15, Math.abs(sum));
	}

	private int getDianonalDifference(int t, int[] source) {
		int forwardSum = getForwardSum(t, source);
		int reverseSum = getReverseSum(t, source);
		return Math.abs(forwardSum - reverseSum);
	}

	private int getReverseSum(int t, int[] source) {
		int sum = 0;
		for(int j = t, i = 1; j > 0; j--, i++){
        	int index = getIndex(i, j, t);
        	sum += source[index];
        }
		return sum;
	}

	private int getForwardSum(int t, int[] source) {
		int sum = 0;
		for(int i = 1; i <= t; i++){
			int index = getIndex(i, i, t);
        	sum += source[index];
        }
		return sum;
	}
	
	@Test
	public void test_4_size_grid(){
		int[] source = new int[]{11, 2, 4, 4, 5, 6, 10, 8, -12, 4, 8, 10, 2, 4, 6, 1};
		int t = 4;
		int sum = getDianonalDifference(t, source);
		
		assertEquals(6, Math.abs(sum));
	}
	
	private int getIndex(int i, int j, int gridSize) {
		int index = ((i -1) * gridSize) + j - 1;
		return index;
	}
}
