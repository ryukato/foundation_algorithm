package search;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BinarySearchTest {
	private BinarySearch<Integer> binarySearch;
	
	@Before
	public void setUp(){
		this.binarySearch = new BinarySearch<Integer>();
	}
	
	@Test
	public void test_with_small_input(){
		Integer[] source = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8};
		Integer target = new Integer(3);
		int low = 0;
		int high = source.length - 1;
		int location = this.binarySearch.location(source, target,low, high);
		assertEquals(2, location);
		
		
		target = new Integer(4);
		location = this.binarySearch.location(source, target,low, high);
		assertEquals(3, location);
		
	}
	
	@Test
	public void test_with_one_size_input(){
		Integer[] source = new Integer[]{3};
		Integer target = new Integer(3);
		int low = 0;
		int high = source.length - 1;
		int location = this.binarySearch.location(source, target,low, high);
		assertEquals(0, location);
	}
	
	@Test
	public void test_with_not_exist_target_input(){
		Integer[] source = new Integer[]{1, 2, 3};
		Integer target = new Integer(4);
		int low = 0;
		int high = source.length - 1;
		int location = this.binarySearch.location(source, target,low, high);
		assertEquals(-1, location);
	}
	
}
