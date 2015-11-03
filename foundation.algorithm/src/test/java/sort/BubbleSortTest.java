package sort;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BubbleSortTest {
	
	@Test
	public void test_(){
		Integer [] source = new Integer[]{2, 3, 1};
		int swapCount = new BubbleSort<Integer>().sort(source);
		for(int i = 0; i < 3 ; i++){
			assertEquals(i + 1, source[i].intValue());
		}
		
		assertEquals(2, swapCount);
	}
	@Test
	public void test_already_sorted(){
		Integer [] source = new Integer[]{1, 2, 3};
		int swapCount = new BubbleSort<Integer>().sort(source);
		for(int i = 0; i < 3 ; i++){
			assertEquals(i + 1, source[i].intValue());
		}
		
		assertEquals(0, swapCount);
	}
}
