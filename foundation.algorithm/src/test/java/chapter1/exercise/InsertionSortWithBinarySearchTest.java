package chapter1.exercise;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Random;

import org.junit.Test;

public class InsertionSortWithBinarySearchTest{
	private Sorter sorter = new InsertionSortWithBinarySearch();
	
	@SuppressWarnings({ "rawtypes"})
	@Test
	public void test_sort_with_binary_insertion_sort(){
		Comparable[] numbers = new Integer[]{2, 1, 6, 5, 4, 3};
		Comparable[] sorted = sorter.sort(numbers);
		Comparable[] expected = new Integer[]{1, 2, 3, 4, 5, 6};
		assertEquals(Arrays.asList(expected), Arrays.asList(sorted));
	}
	
	@SuppressWarnings({ "rawtypes"})
	@Test
	public void test_sort_with_binary_insertion_sort_with_many(){
		final int sizeOfInput = 100000;
		Comparable[] numbers = new Integer[sizeOfInput];
		Comparable[] expected = new Integer[sizeOfInput];
		Random random = new Random();
		for(int i = 0; i< sizeOfInput; i++){
			numbers[i] = random.nextInt(sizeOfInput);
			expected[i] = numbers[i];
		}
		
		Comparable[] sorted = sorter.sort(numbers);
		
		Arrays.sort(expected);
		assertEquals(Arrays.asList(expected), Arrays.asList(sorted));
	}
	
	
	
	@SuppressWarnings({ "rawtypes"})
	@Test
	public void test_sort_normal_insertion_sorrt(){
		Comparable[] numbers = new Integer[]{2, 1, 6, 5, 4, 3};
		Comparable[] sorted = new InsertionSorter().sort(numbers);
		
		
		Comparable[] expected = new Integer[]{1, 2, 3, 4, 5, 6};
		assertEquals(Arrays.asList(expected), Arrays.asList(sorted));
	}
	
	
	@SuppressWarnings({ "rawtypes" })
	@Test
	public void test_sort_normal_insertion_sorrt_with_many(){
		final int sizeOfInput = 100000;
		Comparable[] numbers = new Integer[sizeOfInput];
		Comparable[] expected = new Integer[sizeOfInput];
		Random random = new Random();
		for(int i = 0; i< sizeOfInput; i++){
			numbers[i] = random.nextInt(sizeOfInput);
			expected[i] = numbers[i];
		}
		
		Comparable[] sorted = new InsertionSorter().sort(numbers);
		
		Arrays.sort(expected);
		assertEquals(Arrays.asList(expected), Arrays.asList(sorted));
	}
	
}
