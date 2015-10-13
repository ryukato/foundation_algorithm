package sort;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MergeSortTest {
	private MergeSort<Integer> mergeSort;
	
	@Before
	public void setUp(){
		this.mergeSort = new MergeSort<Integer>();
	}
	
	@Test
	public void test_(){
		Integer[] source = new Integer[]{1, 2, 3, 8, 6, 5, 4, 7};
		Integer[] expected = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8};
		int low = 0;
		int high = source.length - 1;
		this.mergeSort.sort(source, low, high);
		
		for(int i= 0; i < expected.length; i++){
			assertEquals(expected[i], source[i]);
		}
	}
	
}	
