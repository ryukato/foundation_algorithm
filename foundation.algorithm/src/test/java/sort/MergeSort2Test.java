package sort;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MergeSort2Test {

	private MergeSort2<Integer> mergeSort;
	
	@Before
	public void setUp(){
		this.mergeSort = new MergeSort2<Integer>();
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
	
	@Test
	public void test_string(){
		String[] source   = new String[]{"M", "E", "R", "G", "E", "S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
		String[] expected = new String[]{"A", "E", "E", "E", "E", "G", "L", "M", "M", "O", "P", "R", "R", "S", "T", "X"};
		int low = 0;
		int high = source.length - 1;
		new MergeSort2<String>().sort(source, low, high);
		
		for(int i= 0; i < expected.length; i++){
			assertEquals(expected[i], source[i]);
		}
	}
	


}
