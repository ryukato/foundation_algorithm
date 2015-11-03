package sort;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class InsertionSortTest {
	
	@Test
	public void test_(){
		Integer[] source = new Integer[]{3, 2, 1};
		new InsetionSort<Integer>().sort(source);
		for(int i = 0; i < 3 ; i++){
			assertEquals(i + 1, source[i].intValue());
		}
	}
}
