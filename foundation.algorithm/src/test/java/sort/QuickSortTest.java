package sort;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class QuickSortTest {
private QuickSort<Integer> quickSort;
	
	@Before
	public void setUp(){
		this.quickSort = new QuickSort<Integer>();
	}
	
	@Test
	public void test_(){
		Integer[] source = new Integer[]{15, 22, 13, 27, 12, 10, 20, 25};
		Integer[] expected = new Integer[]{10, 12, 13, 15, 20, 22, 25, 27};
		int low = 0;
		int high = source.length - 1;
		this.quickSort.sort(source, low, high);
		
		for(int i= 0; i < expected.length; i++){
			assertEquals(expected[i], source[i]);
		}
	}
}
