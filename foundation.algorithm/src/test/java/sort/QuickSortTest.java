package sort;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class QuickSortTest {
	
	@Before
	public void setUp(){
	}
	
	@Test
	public void test_quick_sort(){
		Integer[] source = new Integer[]{15, 22, 13, 27, 12, 10, 20, 25};
		Integer[] expected = new Integer[]{10, 12, 13, 15, 20, 22, 25, 27};
		int low = 0;
		int high = source.length - 1;
		new QuickSort<Integer>().sort(source, low, high);
		
		for(int i= 0; i < expected.length; i++){
			assertEquals(expected[i], source[i]);
		}
	}
	
	@Test
	public void test_quick_sort2(){
		Integer[] source = new Integer[]{16, 4, 2, 38, 21, 5, 20, 27};
		Integer[] expected = new Integer[]{2, 4, 5, 16, 20, 21, 27, 38};
		int low = 0;
		int high = source.length - 1;
		new QuickSort2<Integer>().sort(source, low, high);
		
		for(int i= 0; i < expected.length; i++){
			assertEquals(expected[i], source[i]);
		}
	}
	
	@Test
	public void test_quick_sort3(){
		Integer[] source = new Integer[]{16, 4, 2, 38, 21, 5, 20, 27};
		Integer[] expected = new Integer[]{2, 4, 5, 16, 20, 21, 27, 38};
		int low = 0;
		int high = source.length - 1;
		new QuickSort3<Integer>().sort(source, low, high);
		
		for(int i= 0; i < expected.length; i++){
			assertEquals(expected[i], source[i]);
		}
	}
}
