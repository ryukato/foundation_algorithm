package sort;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class SelectionSortTest {
	private SelectionSort<Integer> selectionSorter;
	
	@Before
	public void setUp(){
		this.selectionSorter = new SelectionSort<>();
	}
	
	@Test
	public void test_selection_sort(){
		Integer[] source = new Integer[]{3,2,1};
		selectionSorter.sort(source);
		for(int i = 0; i < 3 ; i++){
			assertEquals(i + 1, source[i].intValue());
		}
	}
	
	@Test
	public void test_minMaxSort(){
		this.selectionSorter = new MinMaxSort<>();
		Integer[] source = new Integer[]{3,2,1};
		selectionSorter.sort(source);
		for(int i = 0; i < 3 ; i++){
			assertEquals(i + 1, source[i].intValue());
		}
	}
}
