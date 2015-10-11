package chapter1.exercise;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class LargestNumberFinderTest {
	private Finder<Integer> findLagestNumber;
	
	@Before
	public void setUp(){}
	
	@Test
	public void test_with_default_sorter(){
		findLagestNumber = new LagestNumberFinder();
		final Integer expectedLargestNumber = 8;
		Integer largestNumber = (Integer) findLagestNumber.find(new Integer[]{1,2,3,4,5,6,8,7});
		assertEquals(expectedLargestNumber, largestNumber);
	}
	
	@Test
	public void test_large_input_with_default_sorter(){
		findLagestNumber = new LagestNumberFinder();
		final int inputSize = 1000000;
		Integer[] input = new Integer[inputSize];
		input[0] = new Integer(inputSize);
		Random random = new Random();
		for(int i = 1; i < inputSize; i++ ){
			input[i] = new Integer(random.nextInt(inputSize - 1));
		}
		
		long startTime = System.currentTimeMillis();
		Integer largestNumber = (Integer) findLagestNumber.find(input);
		System.out.println("time to find : " + (System.currentTimeMillis() - startTime) / 1000);
		assertEquals(input[0], largestNumber);
	}
	
	@Test
	public void test_with_merge_sorter(){
		findLagestNumber = new LagestNumberFinder(new MergeSorter());
		final Integer expectedLargestNumber = 8;
		Integer largestNumber = (Integer) findLagestNumber.find(new Integer[]{1,2,3,4,5,6,8,7});
		assertEquals(expectedLargestNumber, largestNumber);
	}
	
	@Test
	public void test_large_input_with_merge_sorter(){
		findLagestNumber = new LagestNumberFinder(new MergeSorter());
		final int inputSize = 1000000;
		Integer[] input = new Integer[inputSize];
		input[0] = new Integer(inputSize);
		Random random = new Random();
		for(int i = 1; i < inputSize; i++ ){
			input[i] = new Integer(random.nextInt(inputSize - 1));
		}
		
		long startTime = System.currentTimeMillis();
		Integer largestNumber = (Integer) findLagestNumber.find(input);
		System.out.println("time to find : " + (System.currentTimeMillis() - startTime) / 1000);
		assertEquals(input[0], largestNumber);
	}
}
