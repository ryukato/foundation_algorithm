package sort;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ShellSortTest {
	
	@Test
	public void test_shell_sort(){
		Integer[] source = new Integer[]{3, 2, 1, 4, 6, 5, 8, 9, 7, 0};
		new ShellSort<Integer>().sort(source);
		for(int i = 0; i < 10 ; i++){
			assertEquals(i, source[i].intValue());
		}
	}
}
