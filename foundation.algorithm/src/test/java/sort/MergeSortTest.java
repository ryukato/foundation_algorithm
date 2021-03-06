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
		Integer[] source = new Integer[]{27, 10, 12, 20, 25, 13, 15, 22};
		Integer[] expected = new Integer[]{10, 12, 13, 15, 20, 22, 25, 27};
		int low = 0;
		int high = source.length - 1;
		this.mergeSort.sort(source, low, high);
		
		for(int i= 0; i < expected.length; i++){
			assertEquals(expected[i], source[i]);
		}
	}
	
}	
