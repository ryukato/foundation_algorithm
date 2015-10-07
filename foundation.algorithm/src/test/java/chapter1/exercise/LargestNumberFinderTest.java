package chapter1.exercise;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class LargestNumberFinderTest {
	private LagestNumberFinder findLagestNumber;
	
	@Before
	public void setUp(){
		findLagestNumber = new LagestNumberFinder();
	}
	
	
	@Test
	public void test(){
		final int expectedLargestNumber = 8;
		int largestNumber = findLagestNumber.find(new int[]{1,2,3,4,5,6,8,7});
		assertEquals(expectedLargestNumber, largestNumber);
	}
	
	@Test
	public void test_large_input(){
		int[] input = new int[100000];
		input[0] = 100000;
		Random random = new Random();
		for(int i = 1; i < 100000; i++ ){
			random.nextInt(99999);
		}
		long startTime = System.currentTimeMillis();
		int largestNumber = findLagestNumber.find(input);
		System.out.println("time to find : " + (System.currentTimeMillis() - startTime) / 1000);
		assertEquals(100000, largestNumber);
	}
}
