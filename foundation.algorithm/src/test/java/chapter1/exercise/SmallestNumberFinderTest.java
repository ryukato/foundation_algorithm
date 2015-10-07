package chapter1.exercise;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class SmallestNumberFinderTest {
	private SmallestNumberFinder smallestNumberFinder;
	
	@Before
	public void setUp(){}
	
	@Test
	public void test_with_default_soter(){
		smallestNumberFinder = new SmallestNumberFinder();
		final Integer expectedSmallestNumber = 1;
		Integer smallestNumber = (Integer) smallestNumberFinder.find(new Integer[]{1,2,3,4,5,6,8,7});
		assertEquals(expectedSmallestNumber, smallestNumber);
	}
	
	@Test
	public void test_large_input_with_default_soter(){
		smallestNumberFinder = new SmallestNumberFinder();
		final int inputSize = 1000000;
		Integer[] input = new Integer[inputSize];
		input[0] = new Integer(0);
		Random random = new Random();
		for(int i = 1; i < inputSize; i++ ){
			input[i] = new Integer(random.nextInt(inputSize - 1));
		}
		
		long startTime = System.currentTimeMillis();
		Integer smallestNumber = (Integer) smallestNumberFinder.find(input);
		System.out.println("time to find : " + (System.currentTimeMillis() - startTime) / 1000);
		assertEquals(input[0], smallestNumber);
	}
	
	@Test
	public void test_with_merge_soter(){
		smallestNumberFinder = new SmallestNumberFinder(new MergeSorter<Integer>());
		final Integer expectedSmallestNumber = 1;
		Integer smallestNumber = (Integer) smallestNumberFinder.find(new Integer[]{1,2,3,4,5,6,8,7});
		assertEquals(expectedSmallestNumber, smallestNumber);
	}
	
	@Test
	public void test_large_input_with_merge_soter(){
		smallestNumberFinder = new SmallestNumberFinder(new MergeSorter<Integer>());
		final int inputSize = 1000000;
		Integer[] input = new Integer[inputSize];
		input[0] = new Integer(0);
		Random random = new Random();
		for(int i = 1; i < inputSize; i++ ){
			input[i] = new Integer(random.nextInt(inputSize - 1));
		}
		
		long startTime = System.currentTimeMillis();
		Integer smallestNumber = (Integer) smallestNumberFinder.find(input);
		System.out.println("time to find : " + (System.currentTimeMillis() - startTime) / 1000);
		assertEquals(input[0], smallestNumber);
	}
}
